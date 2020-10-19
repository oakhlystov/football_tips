package ftblApp_tips_v02.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Maths
{
    public String currentDateTime()
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        return df.format(new Date());
    }

    public String currentDate()
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }

    public String createGuid()
    {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}