package ftblApp_tips_v02.main;

import ftblApp_tips_v02.excel.Writer;
import ftblApp_tips_v02.localization.Labels;
import ftblApp_tips_v02.localization.Messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserInterface extends JFrame
{
    public static void main(String[] args)
    {
        /* Open (call) frame UserInterface */
        new UserInterface();
    }

    JButton btn_saveNewInfo, btn_validateFormInfo, btn_exit;
    JTextField txtf_date, txtf_admin, txtf_champ, txtf_federation, txtf_games;
    JLabel lbl_date, lbl_federation, lbl_champ, lbl_admin, lbl_info_status, lbl_info_status_content, lbl_games;

    public UserInterface()
    {
        /* Constructor */
        Listener handler = new Listener();
        JFrame mainFrame = new JFrame("football tips");
        mainFrame.setResizable(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(20, 1));
        mainFrame.setSize(500, 500);
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);

        /* Элементы, которые будут отображаться на форме. Их далее нужно отдельно добавить на саму форму */
        lbl_date = new JLabel("Дата:",null,SwingConstants.LEFT);
        txtf_date = new JTextField("---");

        /* Federation */
        lbl_federation = new JLabel("Федерация:",null,SwingConstants.LEFT);
        txtf_federation = new JTextField("---");

        /* Championship */
        lbl_champ = new JLabel("Чемпионат:",null,SwingConstants.LEFT);
        txtf_champ = new JTextField("---");

        /* Administrator */
        lbl_admin = new JLabel("Администратор:",null,SwingConstants.LEFT);
        txtf_admin = new JTextField("---");

        /* Games */
        lbl_games = new JLabel(Labels.textLabelGamesQntt,null,SwingConstants.LEFT);
        txtf_games = new JTextField("---");

        /* Buttons */
        btn_saveNewInfo = new JButton("Сохранить как новую запись");
        btn_validateFormInfo = new JButton("Проверить правильность данных"); // @TODO in work
        btn_exit = new JButton("Выход");

        /* Labels */
        lbl_info_status = new JLabel("",null,SwingConstants.LEFT);
        lbl_info_status_content = new JLabel("",null,SwingConstants.LEFT);

        /* Заполнение формы элементами */
        mainFrame.add(lbl_date);
        mainFrame.add(txtf_date);
        mainFrame.add(lbl_federation);
        mainFrame.add(txtf_federation);
        mainFrame.add(lbl_champ);
        mainFrame.add(txtf_champ);
        mainFrame.add(lbl_admin);
        mainFrame.add(txtf_admin);
        mainFrame.add(lbl_games);
        mainFrame.add(txtf_games);
        mainFrame.add(btn_validateFormInfo);
        mainFrame.add(btn_saveNewInfo);
        mainFrame.add(btn_exit);
        mainFrame.add(lbl_info_status); // @TODO поставить в самый низ
        mainFrame.add(lbl_info_status_content); // @TODO поставить в самый низ

        /* ActionListener на кнопки */
        btn_saveNewInfo.addActionListener(handler);
        btn_validateFormInfo.addActionListener(handler);
        btn_exit.addActionListener(handler);

        /* Валидация всех элементов, которые должны быть на форме. По факту - позволяет отобразить все, что должно быть на форме */
        mainFrame.validate();
        /*Собирает форму, в том числе подгоняет размер формы под содержимое (игнор mainFrame.setSize())*/
        //mainFrame.pack();
    }

    public class Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                if (e.getSource() == btn_saveNewInfo)
                {
                    boolean confirm = DialogueWindows.confirm();
                    if (confirm)
                    {
                        Writer.writeToExcel(txtf_date.getText(), txtf_federation.getText(), txtf_champ.getText(), txtf_admin.getText());
                    } else
                    {
                        lbl_info_status.setText(Messages.textInfoConfirmSaveCancel);
                    }
                }
                if (e.getSource() == btn_validateFormInfo)
                {
                    JOptionPane.showMessageDialog(null,e.getActionCommand()+" button pressed. In work");
                    System.out.println(e.getActionCommand()+" button pressed. In work");
                }
                if (e.getSource() == btn_exit)
                {
                    boolean confirm = DialogueWindows.confirmExit();
                    if (confirm)
                    {
                        closeMainFrame();
                        //System.exit(1);
                    } else
                    {
                        lbl_info_status.setText(Messages.textInfoConfirmExitCancel);
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, e.getActionCommand() + " ~~~ \nError");
                System.out.println("Error in try/catch in ActionListener => ActionPerformed: \n" + System.err);
            }
        }
        void closeMainFrame()
        {
            System.exit(1);
        }
    }
}