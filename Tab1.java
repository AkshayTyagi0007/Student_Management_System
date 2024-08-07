package Akshay;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
public class Tab1 {
    public static JPanel createTab() {
        JPanel firstTabPanel = new JPanel(new BorderLayout());


        JPanel inputPanel = new JPanel(new GridLayout(7, 2, 5, 5));
        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel nameLabel = new JLabel("Student Name:");
        JTextField nameField = new JTextField();
        JLabel fatherLabel = new JLabel("Father Name:");
        JTextField fatherField = new JTextField();
        JLabel motherLabel = new JLabel("Mother Name:");
        JTextField motherField = new JTextField();
        JLabel dobLabel = new JLabel("DOB:");
        JTextField dobField = new JTextField();
        JLabel classLabel = new JLabel("Class:");
        JTextField classField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneField = new JTextField();
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(fatherLabel);
        inputPanel.add(fatherField);
        inputPanel.add(motherLabel);
        inputPanel.add(motherField);
        inputPanel.add(dobLabel);
        inputPanel.add(dobField);
        inputPanel.add(classLabel);
        inputPanel.add(classField);
        inputPanel.add(phoneLabel);
        inputPanel.add(phoneField);



        JPanel outputPanel = new JPanel(new BorderLayout());
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField(10);
        idPanel.add(idLabel);
        idPanel.add(idField);

        JTable outputTable = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Student Name");
        tableModel.addColumn("Father Name");
        tableModel.addColumn("Mother Name");
        tableModel.addColumn("DOB");
        tableModel.addColumn("Class");
        tableModel.addColumn("Phone Number");
        outputTable.setModel(tableModel);
        outputPanel.add(idPanel, BorderLayout.NORTH);
        outputPanel.add(new JScrollPane(outputTable), BorderLayout.CENTER);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, inputPanel, outputPanel);
        splitPane.setResizeWeight(0.2);
        firstTabPanel.add(splitPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton addinfo = new JButton("Add Info");
        JButton searchinfo = new JButton("Search");
        JButton update = new JButton("Update");
        JButton exit = new JButton("Exit");
        JButton delete = new JButton("Delete");
        buttonPanel.add(addinfo);
        buttonPanel.add(update);
        buttonPanel.add(searchinfo);
        buttonPanel.add(delete);
        buttonPanel.add(exit);
        firstTabPanel.add(buttonPanel,BorderLayout.SOUTH);

            addinfo.addActionListener(_ -> AddRecord.addRecord(nameField, fatherField, motherField, dobField,  classField,  phoneField, idField, tableModel));
            delete.addActionListener(_ -> DeleteRecord.deleteRecord(nameField, fatherField, motherField, dobField,  classField,  phoneField, idField, tableModel));
            searchinfo.addActionListener(_ -> SearchRecord.searchRecord(nameField, fatherField, motherField, dobField,  classField,  phoneField, idField, tableModel));
            update.addActionListener(_ ->UpdateRecord.updateRecord(nameField, fatherField, motherField, dobField,  classField,  phoneField, idField, tableModel));
        exit.addActionListener(_ -> System.exit(0));
        return firstTabPanel;}}