import java.util.Calendar;

public class Calendar1
{
    public String getdate()
    {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        return(day+"/"+month+"/"+year);
    }
}