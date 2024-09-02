package SMS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchFee {
    public static void searchFee (JLabel getIDLabel , JLabel getName,JLabel getFatherName ,JLabel getClass, JTextField idField, JComboBox<String> monthCombo,JTextField submissionField,  JTextField amountField, DefaultTableModel tableModel){
        String id = idField.getText().trim();
        String month = (String)monthCombo.getSelectedItem();
        String date = submissionField.getText().trim();
        String amount= amountField.getText().trim();

        boolean otherField = month.isEmpty() && date.isEmpty() && amount.isEmpty();

        if (id.isEmpty()){
            JOptionPane.showMessageDialog(null,"Please enter an ID","Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!otherField){
            JOptionPane.showMessageDialog(null,"Pease clear all other fields before searching","Invalid Input",JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection connection = DB.getConnection();
            DB.loadTableData2(tableModel,id);

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ID, Student_Name, Father_Name, Class FROM student WHERE ID =?");
            preparedStatement.setString(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String setIDInput = resultSet.getString("ID");
                String setNameInput = resultSet.getString("Student_Name");
                String setFatherInput = resultSet.getString("Father_Name");
                String setClassInput = resultSet.getString("Class");

                getIDLabel.setText(setIDInput);
                getName.setText(setNameInput);
                getFatherName.setText(setFatherInput);
                getClass.setText(setClassInput);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();

        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error:"+ex.getMessage(),"Database Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
