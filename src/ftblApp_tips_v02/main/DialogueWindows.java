package ftblApp_tips_v02.main;

import ftblApp_tips_v02.localization.Messages;

import javax.swing.*;

public class DialogueWindows
{
    public static boolean _confirm()
    {
        int confirmValue = JOptionPane.showConfirmDialog(null, Messages.textInfoConfirmSave, Messages.textFrameConfirmSave, JOptionPane.YES_NO_OPTION);
        return confirmValue == 0;
    }
    public static boolean _confirmExit()
    {
        int confirmValue = JOptionPane.showConfirmDialog(null, Messages.textInfoConfirmExit, Messages.textFrameConfirmExit, JOptionPane.YES_NO_OPTION);
        return confirmValue == 0;
    }
}