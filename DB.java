package SMS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class DB {
    public static final String DB_URL    ="jdbc:mysql://localhost:3306/sms";
    public static final String USER = "root";
    public static final String PASSWORD = "admin";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public static void  loadTableData1(DefaultTableModel tableModel1){
        try{
            Connection connection1 = getConnection();
            Statement statement1 = connection1.createStatement();
            ResultSet resultSet1 = statement1.executeQuery("SELECT * FROM student");
            tableModel1.setRowCount(0);
            while (resultSet1.next()){
                Object[] rowData = {
                        resultSet1.getString("ID"),
                        resultSet1.getString("Student_Name"),
                        resultSet1.getString("Father_Name"),
                        resultSet1.getString("Mother_Name"),
                        resultSet1.getString("DOB"),
                        resultSet1.getString("Class"),
                        resultSet1.getString("Phone_Number")
                };
                tableModel1.addRow(rowData);
            }
            resultSet1.close();
            statement1.close();
            connection1.close();

        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error:"+ex.getMessage(),"Database Error",JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void loadTableData2(DefaultTableModel tableModel2, String id){
        try {
            Connection connection2 = getConnection();
            PreparedStatement statement2 = connection2.prepareStatement("SELECT * FROM fee WHERE ID=?");
            statement2.setString(1,id);
            ResultSet resultSet2 = statement2.executeQuery();

            tableModel2.setRowCount(0);
            while (resultSet2.next()){
                Object[] rowData = {
                        resultSet2.getString("Fee_Month"),
                        resultSet2.getString("Submission_Date"),
                        resultSet2.getString("Tution_Fee"),
                        resultSet2.getString("Amount_Paid"),
                        resultSet2.getString("Pending")
                };
                tableModel2.addRow(rowData);
            }
            resultSet2.close();
            statement2.close();
            connection2.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error:"+ex.getMessage(),"Database Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
