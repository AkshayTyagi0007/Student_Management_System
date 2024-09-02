package SMS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class UpdateRecord {
    public static void updateRecord(JTextField nameField, JTextField fatherField, JTextField motherField, JTextField dobField, JTextField classField, JTextField phoneField, JTextField idField, DefaultTableModel tableModel) {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String fatherName = fatherField.getText().trim();
        String motherName = motherField.getText().trim();
        String dob = dobField.getText().trim();
        String className = classField.getText().trim();
        String phoneNumber = phoneField.getText().trim();
        int parameterIndex = 1;

        if (id.isEmpty() && phoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter either an ID or a phone number.", "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection connection = DB.getConnection();
            PreparedStatement preparedStatement;
            StringBuilder updateQuery = new StringBuilder("UPDATE student SET");
            if (!name.isEmpty()) {
                updateQuery.append(" Student_Name = ?,");
            }

            if (!fatherName.isEmpty()) {
                updateQuery.append(" Father_Name = ?,");
            }

            if (!motherName.isEmpty()) {
                updateQuery.append(" Mother_Name = ?,");
            }

            if (!dob.isEmpty()) {
                updateQuery.append(" DOB = ?,");
            }

            if (!className.isEmpty()) {
                updateQuery.append(" Class = ?,");
            }

            if (!phoneNumber.isEmpty()) {
                updateQuery.append(" Phone_Number = ?,");
            }

            updateQuery.deleteCharAt(updateQuery.length() - 1);

            // Append WHERE clause based on ID or phone number
            if (!id.isEmpty()) {
                updateQuery.append(" WHERE ID = ?");
            } else {
                updateQuery.append(" WHERE Phone_Number = ?");
            }

            // Execute the update query
            preparedStatement = connection.prepareStatement(updateQuery.toString());

            if (!name.isEmpty()) {
                preparedStatement.setString(parameterIndex++, name);
            }

            if (!fatherName.isEmpty()) {
                preparedStatement.setString(parameterIndex++, fatherName);
            }

            if (!motherName.isEmpty()) {
                preparedStatement.setString(parameterIndex++, motherName);
            }

            if (!dob.isEmpty()) {
                preparedStatement.setString(parameterIndex++, dob);
            }

            if (!className.isEmpty()) {
                preparedStatement.setString(parameterIndex++, className);
            }

            if (!phoneNumber.isEmpty()) {
                preparedStatement.setString(parameterIndex++, phoneNumber);
            }

            preparedStatement.setString(parameterIndex, id.isEmpty() ? phoneNumber : id);

            int rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            if (rowsAffected == 0) {
                JOptionPane.showMessageDialog(null, "No matching record found for the provided ID or phone number.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            DB.loadTableData1(tableModel);
            JOptionPane.showMessageDialog(null, STR."\{rowsAffected} record(s) updated successfully.", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,STR."Error:\{ex.getMessage()}","Database Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
