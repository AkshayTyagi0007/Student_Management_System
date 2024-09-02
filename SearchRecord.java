package SMS;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class SearchRecord {
    public static void searchRecord(JTextField nameField, JTextField fatherField, JTextField motherField, JTextField dobField, JTextField classField, JTextField phoneField, JTextField idField, DefaultTableModel tableModel) {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String fatherName = fatherField.getText().trim();
        String motherName = motherField.getText().trim();
        String dob = dobField.getText().trim();
        String className = classField.getText().trim();
        String phoneNumber = phoneField.getText().trim();

        try {
            Connection connection = DB.getConnection();
            StringBuilder queryBuilder = new StringBuilder("SELECT * FROM student WHERE 1=1 ");
            if (!id.isEmpty()) queryBuilder.append("AND ID = ? ");
            if (!name.isEmpty()) queryBuilder.append("AND Student_Name = ? ");
            if (!fatherName.isEmpty()) queryBuilder.append("AND Father_Name = ? ");
            if (!motherName.isEmpty()) queryBuilder.append("AND Mother_Name = ? ");
            if (!dob.isEmpty()) queryBuilder.append("AND DOB= ? ");
            if (!className.isEmpty()) queryBuilder.append("AND Class = ? ");
            if (!phoneNumber.isEmpty()) queryBuilder.append("AND Phone_Number = ? ");
            PreparedStatement preparedStatement = connection.prepareStatement(queryBuilder.toString());
            int parameterIndex = 1;
            if (!id.isEmpty()) preparedStatement.setString(parameterIndex++, id);
            if (!name.isEmpty()) preparedStatement.setString(parameterIndex++, name);
            if (!fatherName.isEmpty()) preparedStatement.setString(parameterIndex++, fatherName);
            if (!motherName.isEmpty()) preparedStatement.setString(parameterIndex++, motherName);
            if (!dob.isEmpty()) preparedStatement.setString(parameterIndex++,dob);
            if (!className.isEmpty()) preparedStatement.setString(parameterIndex++, className);
            if (!phoneNumber.isEmpty()) preparedStatement.setString(parameterIndex++, phoneNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            tableModel.setRowCount(0);
            boolean found = false;
            while (resultSet.next()) {
                found = true;
                Vector<String> row = new Vector<>();
                row.add(resultSet.getString("ID"));
                row.add(resultSet.getString("Student_Name"));
                row.add(resultSet.getString("Father_Name"));
                row.add(resultSet.getString("Mother_Name"));
                row.add(resultSet.getString("DOB"));
                row.add(resultSet.getString("Class"));
                row.add(resultSet.getString("Phone_Number"));
                tableModel.addRow(row);}

            if (!found) { JOptionPane.showMessageDialog(null, "No records found.", "Search Result", JOptionPane.INFORMATION_MESSAGE);}
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }}}
