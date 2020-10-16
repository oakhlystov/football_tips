package ftblApp_tips_v02.main;

import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
        UserInterface ui = new UserInterface("Tips (v0.2)");
        ui.setVisible(true);
        ui.setSize(600,600);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setResizable(true);
        ui.setLocationRelativeTo(null);
    }
}