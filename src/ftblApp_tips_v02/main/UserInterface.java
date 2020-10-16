package ftblApp_tips_v02.main;

import ftblApp_tips_v02.excel.Writer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInterface extends JPanel
{
    public static void main(String[] args)
    {
        new UserInterface();
    }

    JButton btn_1, btn_2, btn_3;
    JTextField txtf_date, txtf_admin, txtf_champ;
    JLabel lbl_date, lbl_admin, lbl_champ;

    public UserInterface()
    {
        Listener handler = new Listener();
        JFrame mainFrame = new JFrame("football tips");
        mainFrame.setResizable(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(20,2));
        mainFrame.setSize(1000,1000);
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);

        /* Элементы, которые будут отображаться на форме. Их далее нужно отдельно добавить на саму форму */
        lbl_date = new JLabel("Дата:");
        txtf_date = new JTextField("EmptyDate");

        lbl_champ = new JLabel("Администратор:");
        txtf_champ = new JTextField("EmptyAdmin");

        lbl_admin = new JLabel("Администратор:");
        txtf_admin = new JTextField("EmptyAdmin");

        btn_1 = new JButton("Сохранить");
        btn_2 = new JButton("Проверить");
        btn_3 = new JButton("Выход?");

        /* Заполнение формы элементами */
        mainFrame.add(lbl_date);
        mainFrame.add(txtf_date);
        mainFrame.add(lbl_admin);
        mainFrame.add(btn_1);
        mainFrame.add(btn_3);

        /* ActionListener на кнопки */
        btn_1.addActionListener(handler);
        btn_2.addActionListener(handler);
        btn_3.addActionListener(handler);

        /* Валидация всех жлементов, которые должны быть на форме. По факту - позволяет отобразить все, что должно быть на форме */
        mainFrame.revalidate();
        //mainFrame.pack(); //Собирает форму, в том числе подгоняет размер формы под содержимое (игнор mainFrame.setSize())


    }

    public class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == btn_1)
                {


                    JOptionPane.showMessageDialog(null, txtf_date.getText());
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                    String requiredDate = df.format(new Date());
                    Writer.writeToExcel(txtf_date.getText(), txtf_date.getText()+"2", txtf_date.getText()+"3", requiredDate);
                    JOptionPane.showMessageDialog(null,"button 1 pressed");
                    System.out.println("DEBUG | button 1 pressed");
                }
                if (e.getSource() == btn_3)
                {
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
                    String requiredDate = df.format(new Date());
                    JOptionPane.showMessageDialog(null,requiredDate);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,e.getActionCommand()+"\nError");
            }

        }
    }

}

