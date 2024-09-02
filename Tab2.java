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

import static java.awt.Color.*;

public class Tab2 {
    public static JPanel createTab() {
        JPanel secondtabPanel = new JPanel(null);
        secondtabPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, white, white));
        secondtabPanel.setOpaque(false);

        JPanel inputPanel2 = new JPanel(null);
        inputPanel2.setBorder(new LineBorder(white, 4, true));
        inputPanel2.setOpaque(false);
        inputPanel2.setBounds(10, 10, 320, 260);

        //Details Label & Text Field
        JLabel addDetails = new JLabel("Add Details", JLabel.CENTER);
        addDetails.setFont(new Font("Comic Sans MS", 1, 15));
        addDetails.setForeground(white);
        addDetails.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, white, white));
        addDetails.setBounds(10, 10, 300, 30);
        inputPanel2.add(addDetails);

        JLabel idLabel = new JLabel("ID");
        idLabel.setOpaque(true);
        idLabel.setBorder(new LineBorder(white, 2, true));
        idLabel.setBounds(10, 60, 110, 20);
        inputPanel2.add(idLabel);

        JTextField idField = new JTextField("");
        idField.setBounds(160, 60, 110, 20);
        inputPanel2.add(idField);

        JLabel dateLabel = new JLabel("Submission Date");
        dateLabel.setBorder(new LineBorder(white, 2, true));
        dateLabel.setOpaque(true);
        dateLabel.setBounds(10, 110, 110, 20);
        inputPanel2.add(dateLabel);

        JTextField dateField = new JTextField("");
        dateField.setBounds(160, 110, 110, 20);
        inputPanel2.add(dateField);

        JLabel monthLabel = new JLabel("Select Month");
        monthLabel.setBorder(new LineBorder(white, 2, true));
        monthLabel.setOpaque(true);
        monthLabel.setBounds(10, 160, 110, 20);
        inputPanel2.add(monthLabel);

        String[] months = {
                "",
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"};

        JComboBox<String> monthComboBox = new JComboBox<>(months);
        monthComboBox.setBounds(160, 160, 110, 20);
        inputPanel2.add(monthComboBox);

        JLabel amountLabel = new JLabel("Amount");
        amountLabel.setBorder(new LineBorder(white,2,true));
        amountLabel.setOpaque(true);
        amountLabel.setBounds(10,210,110,20);
        inputPanel2.add(amountLabel);

        JTextField amountField = new JTextField("");
        amountField.setBounds(160,210,110,20);
        inputPanel2.add(amountField);

        secondtabPanel.add(inputPanel2);

        //Details Panel
        JPanel detailsPanel = new JPanel(null);
        detailsPanel.setBorder(new LineBorder(white,4, true));
        detailsPanel.setBounds(340,10,920,150);
        detailsPanel.setOpaque(false);

        //Information Labels and information fetchers
        JLabel infoLabel = new JLabel("Info Tab",JLabel.CENTER);
        infoLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED,white,white));
        infoLabel.setFont(new Font("Comic Sans MS",1,18));
        infoLabel.setForeground(white);
        infoLabel.setBounds(11,5,900,40);
        detailsPanel.add(infoLabel);

        JLabel idInfoLabel = new JLabel("ID");
        idInfoLabel.setBorder(new LineBorder(white,1,true));
        idInfoLabel.setOpaque(true);
        idInfoLabel.setBounds(10,60,110,20);
        detailsPanel.add(idInfoLabel);

        JLabel getIDLabel = new JLabel();
        getIDLabel.setBorder(new LineBorder(white,1, true));
        getIDLabel.setOpaque(true);
        getIDLabel.setBounds(130,60,110,20);
        detailsPanel.add(getIDLabel);

        JLabel fatherLabel = new JLabel("Father's Name");
        fatherLabel.setBorder(new LineBorder(white,1, true));
        fatherLabel.setOpaque(true);
        fatherLabel.setBounds(10,110,110,20);
        detailsPanel.add(fatherLabel);

        JLabel getfatherLabel = new JLabel();
        getfatherLabel.setBorder(new LineBorder(white,1,true));
        getfatherLabel.setOpaque(true);
        getfatherLabel.setBounds(130,110,110,20);
        detailsPanel.add(getfatherLabel);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBorder(new LineBorder(white,1,true));
        nameLabel.setOpaque(true);
        nameLabel.setBounds(560,60,110,20);
        detailsPanel.add(nameLabel);

        JLabel getNameLabel = new JLabel();
        getNameLabel.setBorder(new LineBorder(white,1, true));
        getNameLabel.setOpaque(true);
        getNameLabel.setBounds(730,60,110,20);
        detailsPanel.add(getNameLabel);

        JLabel classLabel = new JLabel("Class");
        classLabel.setBorder(new LineBorder(white,1,true));
        classLabel.setOpaque(true);
        classLabel.setBounds(560,110,110,20);
        detailsPanel.add(classLabel);

        JLabel getClassLabel = new JLabel();
        getClassLabel.setBorder(new LineBorder(white,1, true));
        getClassLabel.setOpaque(true);
        getClassLabel.setBounds(730,110,110,20);
        detailsPanel.add(getClassLabel);

        secondtabPanel.add(detailsPanel);

        JPanel tablePanel = new JPanel(null);
        tablePanel.setBounds(340,170,920,230);

        JTable outputtable = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Month");
        tableModel.addColumn("Submission Date");
        tableModel.addColumn("Tution Fee");
        tableModel.addColumn("Amount Paid");
        tableModel.addColumn("Pending");
        outputtable.setModel(tableModel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(outputtable);
        scrollPane.setBounds(0,0,920,220);
        tablePanel.add(scrollPane);
        secondtabPanel.add(tablePanel);

        //Buttons

        JButton searchButton= new JButton("Search");
        searchButton.setBounds(60,440,170,30);
        secondtabPanel.add(searchButton);

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(60,380,170,30);
        secondtabPanel.add(updateButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(60,320,170,30);
        secondtabPanel.add(exitButton);


        //Adding task to buttons
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchFee.searchFee(getIDLabel,getNameLabel,getfatherLabel,getClassLabel,idField,monthComboBox,dateField,amountField,tableModel);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Todo Work
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Background

        JLabel background = new JLabel();
        background.setIcon(new ImageIcon("E:/New folder/Student_Management_System/src/SMS/A.gif"));
        secondtabPanel.add(background);
        background.setBounds(0,0,1280,540);

        return secondtabPanel;
    }
}

