package ftblApp_tips_v02.main;

import javax.swing.*;
import java.awt.event.*;

public class UserInterface extends JFrame
{
    JButton btnTEST;


    eHandler handler = new eHandler();

    public UserInterface (String s)
    {
        super(s);

        

        pack();
    }



    public class eHandler implements ActionListener {                                                                //действие при нажатии на вещицу
        public void actionPerformed(ActionEvent e) {
            //if (b == "0"){t1.setText("");} else if (b==null) {t1.setText("");}
            System.out.println(e.getActionCommand());
            try
            {
                //123123@TODO-1
                if (e.getSource() == btnTEST) {
                    System.out.println("Hello");}
                //123123@TODO-1
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }
}