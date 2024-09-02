package SMS;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import static java.lang.StringTemplate.STR;

public class DeleteRecord {
   public static void deleteRecord(JTextField nameField, JTextField fatherField, JTextField motherField, JTextField dobField, JTextField classField, JTextField phoneField, JTextField idField, DefaultTableModel tableModel) {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String fatherName = fatherField.getText().trim();
        String motherName = motherField.getText().trim();
        String dob = dobField.getText().trim();
        String className = classField.getText().trim();
        String phoneNumber = phoneField.getText().trim();
        boolean otherFieldsEmpty = name.isEmpty() && fatherName.isEmpty() && motherName.isEmpty() &&  dob.isEmpty() &&  className.isEmpty();
        if (id.isEmpty() && phoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter either an ID or a phone number.", "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
            return;}
        if (!otherFieldsEmpty) {
            JOptionPane.showMessageDialog(null, "Please clear all other fields before deleting.", "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
            return;}
        try {
            Connection connection = DB.getConnection();
            PreparedStatement preparedStatement;
            if (!id.isEmpty() && !phoneNumber.isEmpty()) {
                preparedStatement = connection.prepareStatement(
                        "DELETE FROM student WHERE id = ? OR phone_number = ?");
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, phoneNumber);
            } else if (!id.isEmpty()) {
                preparedStatement = connection.prepareStatement(
                        "DELETE FROM student WHERE id = ?");
                preparedStatement.setString(1, id);}
            else {
                preparedStatement = connection.prepareStatement(
                        "DELETE FROM student WHERE phone_number = ?");
                preparedStatement.setString(1, phoneNumber);}
            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            DB.loadTableData1(tableModel);

            JOptionPane.showMessageDialog(null, STR."\{rowsAffected} record(s) deleted successfully.", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, STR."Error: \{ex.getMessage()}", "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }}}