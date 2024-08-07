package Akshay;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;
public class SearchFee {


    public static void searchFee(JLabel idInput, JLabel nameInput, JLabel classInput , JLabel phoneInput, JTextField idField, JComboBox<String> monthComboBox, JTextField submissionField, JTextField amountField, DefaultTableModel tableModel){
        String id = idField.getText().trim();
        String month = (String) monthComboBox.getSelectedItem();
        String date= submissionField.getText().trim();
        String paid = amountField.getText().trim();
        boolean otherFieldsEmpty = month.isEmpty() && date.isEmpty() && paid.isEmpty();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter either an ID.", "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!otherFieldsEmpty) {
            JOptionPane.showMessageDialog(null, "Please clear all other fields before deleting.", "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Connection connection = Db.getConnection();
            Db.loadTableData2(tableModel,id);

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
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
