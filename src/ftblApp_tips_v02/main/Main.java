package ftblApp_tips_v02.main;

import javax.swing.*;
import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("aw hello");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,2));
        frame.add(new JButton("jBTN1"));
        frame.add(new JLabel("hey"));
        frame.setLocationRelativeTo(null);
        frame.setSize(700,700);
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);
    }
}