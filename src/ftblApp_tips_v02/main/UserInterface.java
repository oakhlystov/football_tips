package ftblApp_tips_v02.main;

import ftblApp_tips_v02.excel.Writer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInterface extends JPanel {
    public static void main(String[] args) {
        new UserInterface();
    }

    JButton btn_saveNewInfo, btn_validateFormInfo, btn_exit;
    JTextField txtf_date, txtf_admin, txtf_champ, txtf_federation;
    JLabel lbl_date, lbl_admin, lbl_champ, lbl_federation;

    public UserInterface() {
        Listener handler = new Listener();
        JFrame mainFrame = new JFrame("football tips");
        mainFrame.setResizable(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(20, 5));
        mainFrame.setSize(1000, 1000);
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);

        /* Элементы, которые будут отображаться на форме. Их далее нужно отдельно добавить на саму форму */
        lbl_date = new JLabel("Дата:");
        txtf_date = new JTextField("EmptyDate");

        lbl_federation = new JLabel("Федерация:");
        txtf_federation = new JTextField("EmptyFederation");

        lbl_champ = new JLabel("Чемпионат:");
        txtf_champ = new JTextField("EmptyChamp");

        lbl_admin = new JLabel("Администратор:");
        txtf_admin = new JTextField("EmptyAdmin");

        btn_saveNewInfo = new JButton("Сохранить как новую запись");
        btn_validateFormInfo = new JButton("Проверить правильность данных");
        btn_exit = new JButton("Выход?");

        /* Заполнение формы элементами */
        mainFrame.add(lbl_date);
        mainFrame.add(txtf_date);
        mainFrame.add(lbl_champ);
        mainFrame.add(txtf_champ);
        mainFrame.add(lbl_admin);
        mainFrame.add(txtf_admin);
        mainFrame.add(btn_saveNewInfo);
        mainFrame.add(btn_exit);

        /* ActionListener на кнопки */
        btn_saveNewInfo.addActionListener(handler);
        btn_validateFormInfo.addActionListener(handler);
        btn_exit.addActionListener(handler);

        /* Валидация всех элементов, которые должны быть на форме. По факту - позволяет отобразить все, что должно быть на форме */
        mainFrame.validate();
        //mainFrame.pack(); //Собирает форму, в том числе подгоняет размер формы под содержимое (игнор mainFrame.setSize())


    }

    public class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == btn_saveNewInfo)
                {
                    JOptionPane.showMessageDialog(null, "button 1 pressed");
                    System.out.println("DEBUG | button 1 pressed");
                    /*
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                    String requiredDate = df.format(new Date());
                    */
                    boolean confirm = DialogueWindows.confirm();
                    if (confirm == true)
                    {
                        Writer.writeToExcel(txtf_date.getText(), txtf_federation.getText(), txtf_date.getText() + "3");
                    } else
                    {

                    }


                }
                if (e.getSource() == btn_exit) {
                    /* Тестовые данные для проверки работы нажатия по кнопке*/
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
                    String requiredDate = df.format(new Date());
                    JOptionPane.showMessageDialog(null, requiredDate);
                    /* Конец тестовых данных */
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, e.getActionCommand() + " ~~~ \nError");
                System.out.println("Error in try/catch in ActionListener => ActionPerformed: \n" + System.err);
            }

        }
    }

}

