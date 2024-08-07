package Akshay;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {

        // Creating the main frame
        JFrame frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);





        // Creating the main label
        JLabel mainLabel = new JLabel("Student Management System", JLabel.CENTER);
        mainLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        // Add label customization here

        frame.add(mainLabel, BorderLayout.NORTH);

        // Creating the tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();
        frame.add(tabbedPane, BorderLayout.CENTER);

        // Adding tabs
        tabbedPane.addTab("Student Info", Tab1.createTab());
        tabbedPane.addTab("Fee",Tab2.createTab2());

      //  tabbedPane.addTab("Fees", Tab2.createTab());

        // Display the frame
        frame.setVisible(true);
    }
}
