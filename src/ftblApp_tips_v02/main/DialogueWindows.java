package ftblApp_tips_v02.main;

import javax.swing.*;

public class DialogueWindows
{
    public static boolean confirm ()
    {
        int confirmValue = JOptionPane.showConfirmDialog(null, "Подтверждаете сохранение данных?", "Сохранить", JOptionPane.YES_NO_OPTION);

        if (confirmValue == 0) {
            return true;
        } else {
            return false;
        }
    }
}