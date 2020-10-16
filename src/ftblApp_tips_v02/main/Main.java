package ftblApp_tips_v02.main;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame
{
    public static void main(String[] args)
    {
        JFrame GUI = new JFrame("aw hello");
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setLocationRelativeTo(null);
        GUI.setSize(700,700);
        GUI.setResizable(true);
        GUI.pack();
        GUI.setVisible(true);
    }
    public Main()
    {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(2,2));
        JButton button = new JButton("button 1");
        pane.add(button);
        button = new JButton("button 2");
        pane.add(button);
        JLabel label = new JLabel("label 1");
        pane.add(label);
        button = new JButton("button 3");
        pane.add(button);
    }
}