package ftblApp_tips_v02.main;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame
{
    public GUI()
    {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(2,2));
        JButton button = new JButton("button 1");
        pane.add(button);
        button = new JButton("button 2");
        JLabel label = new JLabel("label 1");
    }

}