import java.util.Calendar;

public class CalendarExample
{
    public String name()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        return (""+year);
    }
}
