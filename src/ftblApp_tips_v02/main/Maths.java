package ftblApp_tips_v02.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Maths
{
    public static String currentDateTime()
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String requiredDate;
        return requiredDate = df.format(new Date());
    }
}