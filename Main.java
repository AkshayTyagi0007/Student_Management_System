package SMS;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class Main {
    public Main(){
        JFrame frame = new JFrame("Student Management System ");
        frame.setSize(1280,720);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Heading

        JLabel headlabel = new JLabel("Student Management System");
        headlabel.setFont(new Font("Comic Sans MS",1, 48));
        headlabel.setForeground(Color.white);
        headlabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.white,Color.white));
        headlabel.setHorizontalAlignment(SwingConstants.CENTER);
        headlabel.setBounds(20,10,1240,96);
        frame.getContentPane().add(headlabel);

        //Adding Tabs
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(0,110,1280,540);
        tabbedPane.addTab("Student Info", Tab1.createTab());
        tabbedPane.addTab("Fee Info",Tab2.createTab());
        frame.getContentPane().add(tabbedPane);

        //Background
        JLabel background = new JLabel();
        background.setIcon(new ImageIcon("E:/New folder/Student_Management_System/src/SMS/A.gif"));
        background.setBounds(0,0,1280,700);
        frame.getContentPane().add(background);


    }

    public static void  main(String[] args){
        System.out.println("Hello Guys");
        SwingUtilities.invokeLater(Main::new);
    }
}