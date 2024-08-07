package Akshay;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.Color.*;
import java.awt.*;
import static java.awt.Color.*;
public class Test {

    public Test() {
        JFrame frame = new JFrame("SMS");
        frame.setSize(1280,720);
        frame.getContentPane().setLayout(null);

        JLabel mainLabel = new JLabel("Student Management System");
        mainLabel.setFont(new Font("Comic Sans MS",1,48));
        mainLabel.setForeground(white);
        mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED,white,white));
        mainLabel.setBounds(20,10,1240,96);
        frame.getContentPane().add(mainLabel);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(0,110,1280,540);
        tabbedPane.addTab("Student Info", Test_Tab1.createTab());
        tabbedPane.add("Fee Info", Test_Tab2.createTab());
        frame.getContentPane().add(tabbedPane);

        JLabel background = new JLabel();
        background.setIcon(new ImageIcon("C:/Users/abhit/Downloads/Untitled design (1).png"));
        background.setBounds(0,0,1280,700);
        frame.getContentPane().add(background);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();
            }
        });
    }
}