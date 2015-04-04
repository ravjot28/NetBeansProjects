import java.util.Calendar;

public class CalendarYear
{
    public String name()
    {
        Calendar cal = Calendar.getInstance();
        return ""+cal.get(Calendar.YEAR);
    }
}
