package ftblApp_tips_v02.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Maths
{
    public String _currentDateTime()
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        return df.format(new Date());
    }

    public String _currentDate()
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }

    public String _createGuid()
    {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}