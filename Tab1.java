package SMS;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.white;

public class Tab1 {
    public static JPanel createTab(){
        JPanel firsttabPanel = new JPanel(null);
        firsttabPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, white, white));
        firsttabPanel.setOpaque(false);

        JPanel inputPanel= new JPanel(null);
        inputPanel.setBorder(new LineBorder(white, 4, true));
        inputPanel.setBounds(10,10,320,350);
        inputPanel.setOpaque(false);

        // Input Panel Heading
        JLabel basicLabel = new JLabel("Add Student Info", JLabel.CENTER);
        basicLabel.setFont(new Font("Comic Sans MS",1,15));
        basicLabel.setForeground(white);
        basicLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, white, white));
        inputPanel.add(basicLabel);
        basicLabel.setBounds(10,10,300,30);

        //Label and TextField

        JLabel nameLabel = new JLabel("Student Name");
        nameLabel.setBorder(new LineBorder(white,1,true));
        nameLabel.setBounds(10,60,110,20);
        nameLabel.setOpaque(true);
        inputPanel.add(nameLabel);

        JTextField nameField = new JTextField("");
        nameField.setBounds(160,60,110,20);
        inputPanel.add(nameField);

        JLabel fatherLabel = new JLabel("Father's Name");
        fatherLabel.setBorder(new LineBorder(white,1, true));
        fatherLabel.setBounds(10,110,110,20);
        fatherLabel.setOpaque(true);

        JTextField fatherField = new JTextField("");
        fatherField.setBounds(160,110,110,20);

        inputPanel.add(fatherLabel);
        inputPanel.add(fatherField);

        JLabel motherLabel = new JLabel("Mother's Name");
        motherLabel.setBorder(new LineBorder(white, 1, true));
        motherLabel.setBounds(10,160,110,20);
        motherLabel.setOpaque(true);

        JTextField motherField = new JTextField("");
        motherField.setBounds(160,160,110,20);

        inputPanel.add(motherLabel);
        inputPanel.add(motherField);

        JLabel classLabel = new JLabel("Class");
        classLabel.setBorder(new LineBorder(white, 1, true));
        classLabel.setBounds(10,210,110,20);
        classLabel.setOpaque(true);

        JTextField classField = new JTextField("");
        classField.setBounds(160,210,110,20);

        inputPanel.add(classLabel);
        inputPanel.add(classField);

        JLabel dobLabel = new JLabel("Date of Birth");
        dobLabel.setBorder(new LineBorder(white, 1, true));
        dobLabel.setBounds(10,260,110,20);
        dobLabel.setOpaque(true);

        JTextField dobField = new JTextField("");
        dobField.setBounds(160,260,110,20);

        inputPanel.add(dobLabel);
        inputPanel.add(dobField);

        JLabel phoneLabel = new JLabel("Phone Number");
        phoneLabel.setBorder(new LineBorder(white,1, true));
        phoneLabel.setBounds(10,310,110,20);
        phoneLabel.setOpaque(true);

        JTextField phoneField = new JTextField("");
        phoneField.setBounds(160,310,110,20);

        inputPanel.add(phoneLabel);
        inputPanel.add(phoneField);

        firsttabPanel.add(inputPanel);

        JPanel leftPanel = new JPanel(null);
        leftPanel.setBorder(new LineBorder(white,4, true));
        leftPanel.setOpaque(false);
        leftPanel.setBounds(340,10,920,100);

        //ID Label and Textfield

        JLabel leftLabel = new JLabel("Enter ID details",JLabel.CENTER);
        leftLabel.setFont(new Font("Comic Sans MS",1,15));
        leftLabel.setForeground(white);
        leftLabel.setBorder(new LineBorder(white,2 ,true));
        leftLabel.setBounds(11,5,900,40);
        leftPanel.add(leftLabel);

        JLabel idLabel = new JLabel("ID");
        idLabel.setBorder(new LineBorder(white,1,true));
        idLabel.setOpaque(true);
        idLabel.setBounds(10,60,110,20);
        leftPanel.add(idLabel);

        JTextField idField =  new JTextField("");
        idField.setBounds(170,60,110,20);
        leftPanel.add(idField);

        firsttabPanel.add(leftPanel);

        JPanel tablePanel = new JPanel(null);
        tablePanel.setBounds(340,120,930,240);

        JTable table = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Father Name");
        tableModel.addColumn("Mother Name");
        tableModel.addColumn("DOB");
        tableModel.addColumn("Class");
        tableModel.addColumn("Phone Number");

        table.setModel(tableModel);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        scrollPane.setBounds(0,0,930,240);
        tablePanel.add(scrollPane);

        firsttabPanel.add(tablePanel);


        //Adding Buttons
        JButton addButton = new JButton("Add Info");
        addButton.setBounds(40,440,110,30);
        firsttabPanel.add(addButton);

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(330,440,110,30);
        firsttabPanel.add(updateButton);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(630,440,110,30);
        firsttabPanel.add(searchButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(880,440,110,30);
        firsttabPanel.add(deleteButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(1150,440,110,30);
        firsttabPanel.add(exitButton);

        //Assigning Task to Button

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddRecord.addRecord(nameField,fatherField,motherField,dobField,classField,phoneField,idField,tableModel);
            }
        });


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchRecord.searchRecord(nameField,fatherField,motherField,dobField,classField,phoneField,idField,tableModel);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateRecord.updateRecord(nameField,fatherField,motherField,dobField,classField,phoneField,idField,tableModel);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteRecord.deleteRecord(nameField,fatherField,motherField,dobField,classField,phoneField,idField,tableModel);
            }
        });


        //Background

        JLabel background = new JLabel();
        background.setIcon(new ImageIcon("E:/New folder/Student_Management_System/src/SMS/A.gif"));
        firsttabPanel.add(background);
        background.setBounds(0,0,1280,540);
        return  firsttabPanel;


    }
}
