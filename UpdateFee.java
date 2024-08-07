package Akshay;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateFee {
    public static void updateFee(JLabel idInput, JLabel nameInput, JLabel classInput, JLabel phoneInput, JTextField idField, JComboBox<String> monthComboBox, JTextField submissionField, JTextField amountField, DefaultTableModel tableModel) {
        String id = idField.getText().trim();
        String month = (String) monthComboBox.getSelectedItem();
        String date = submissionField.getText().trim();
        String paid = amountField.getText().trim();

        if (id.isEmpty()&& month.isEmpty() && date.isEmpty() && paid.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter all required details", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection connection = Db.getConnection();
            PreparedStatement preparedStatement  = connection.prepareStatement("UPDATE fee SET Submission_Date =?, Amount_Paid= ? WHERE ID=? AND Fee_Month =? ");
            preparedStatement.setString(1,date);
            preparedStatement.setString(4,month);
            preparedStatement.setString(2,paid);
            preparedStatement.setString(3,id);

            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();

            PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT ID, Student_Name, Class, Phone_Number FROM student WHERE ID=?");
            preparedStatement2.setString(1,id);
            ResultSet resultSet2= preparedStatement2.executeQuery();
            while (resultSet2.next()) {
                String setidInput = resultSet2.getString("ID");
                String setNameInput = resultSet2.getString("Student_Name");
                String setClassInput = resultSet2.getString("Class");
                String setPhoneInput = resultSet2.getString("Phone_Number");
                idInput.setText(setidInput);
                nameInput.setText(setNameInput);
                classInput.setText(setClassInput);
                phoneInput.setText(setPhoneInput);
            }
            resultSet2.close();
            preparedStatement2.close();
            connection.close();

            if (rowsAffected == 0) {
                JOptionPane.showMessageDialog(null, "No matching record found for the provided ID or phone number.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Db.loadTableData2(tableModel,id);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
