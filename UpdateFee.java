package SMS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateFee {
    public static void updateFee(JLabel getIDLabel , JLabel getnameLabel, JLabel getFatherLabel, JLabel getClassLabel, JTextField idField, JComboBox<String> monthcombo, JTextField submissionField, JTextField amountField, DefaultTableModel tableModel){
        String id = idField.getText().trim();
        String month = (String)monthcombo.getSelectedItem();
        String date = submissionField.getText().trim();
        String amount = amountField.getText().trim();

        if (id.isEmpty() && month.isEmpty() && date.isEmpty() && amount.isEmpty()){
            JOptionPane.showMessageDialog(null,"Please enter all the required details.","Invalid Input",JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection connection = DB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE fee SET Submission_Date = ?, Amount_Paid =? WHERE ID=? AND Fee_Month =?");
            preparedStatement.setString(1,date);
            preparedStatement.setString(2,amount);
            preparedStatement.setString(3,id);
            preparedStatement.setString(4,month);

            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();


            PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT ID,Student_Name, Father_Name, Class FROM student WHERE ID= ?");
            preparedStatement2.setString(1,id);


            ResultSet resultSet = preparedStatement2.executeQuery();
            while (resultSet.next()){
                String setIDInput = resultSet.getString("ID");
                String setNameInput = resultSet.getString("Student_Name");
                String setFatherInput = resultSet.getString("Father_Name");
                String setClassInput = resultSet.getString("Class");


                getIDLabel.setText(setIDInput);
                getnameLabel.setText(setNameInput);
                getFatherLabel.setText(setFatherInput);
                getClassLabel.setText(setClassInput);


            }

            resultSet.close();
            preparedStatement2.close();
            connection.close();

            if (rowsAffected ==0){
                JOptionPane.showMessageDialog(null,"No matching record found for the provided ID","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            DB.loadTableData2(tableModel,id);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error"+ex.getMessage(),"Database Error",JOptionPane.ERROR_MESSAGE);

        }
    }

}
