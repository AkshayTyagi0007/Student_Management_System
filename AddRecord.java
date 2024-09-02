package SMS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddRecord {
    public static void addRecord(JTextField nameField, JTextField fatherField, JTextField motherField, JTextField dobField, JTextField classField, JTextField phoneField, JTextField idField, DefaultTableModel tableModel){
        String name = nameField.getText();
        String fatherName  = fatherField.getText();
        String motherName = motherField.getText();
        String dob = dobField.getText();
        String className = classField.getText();
        String phoneNumber  = phoneField.getText();

        if (!idField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"ID Field must be empty for adding a new record.","Invalid Input", JOptionPane.ERROR_MESSAGE);
           return;
        }

        if (name.isEmpty()|| fatherName.isEmpty()|| motherName.isEmpty()|| dob.isEmpty()|| className.isEmpty()|| phoneNumber.isEmpty()){
            JOptionPane.showMessageDialog(null,"Please full out all required fields.","Invalid Input",JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection connection = DB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student(Student_Name,Father_Name,Mother_Name, DOB, Class, Phone_Number) VALUES(?,?,?,?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, fatherName);
            preparedStatement.setString(3,motherName);
            preparedStatement.setString(4,dob);
            preparedStatement.setString(5,className);
            preparedStatement.setString(6,phoneNumber);

            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            DB.loadTableData1(tableModel);
            JOptionPane.showMessageDialog(null,rowsAffected+"record(s) added successfully.", "Success",JOptionPane.INFORMATION_MESSAGE);

        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error:"+ex.getMessage(),"Database Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
