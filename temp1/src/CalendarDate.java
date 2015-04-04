import java.util.Calendar;

public class CalendarDate
{
    public String name()
    {
        Calendar cal = Calendar.getInstance();
        return ""+cal.get(Calendar.DATE);
    }
}
