package ftblApp_tips_v02.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInterface extends JPanel
{


    JButton btn_1, btn_2, btn_3;
    JTextField txtf_1;
    JLabel lbl_1, lbl_2;

    public void UserInterface()
    {
        Listener handler = new Listener();
        JFrame mainFrame = new JFrame("football tips");
        mainFrame.setResizable(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(10,2));
        mainFrame.setSize(500,200);
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);



        lbl_1 = new JLabel("label 1:");
        lbl_2 = new JLabel("label 2:");
        btn_1 = new JButton("btn 1");
        btn_2 = new JButton("btn 2");
        btn_3 = new JButton("btn 3");
        txtf_1 = new JTextField("");

        mainFrame.add(lbl_1);
        mainFrame.add(txtf_1);
        mainFrame.add(lbl_2);
        mainFrame.add(btn_1);

        btn_1.addActionListener(handler);

        mainFrame.revalidate();
        //mainFrame.pack();


    }

    public class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == btn_1) {

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error");
            }

        }
    }

    public static void main(String[] args)
    {
        new UserInterface();
    }






}

