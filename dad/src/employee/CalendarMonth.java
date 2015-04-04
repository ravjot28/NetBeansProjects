package employee;
import java.util.Calendar;

public class CalendarMonth
{
    public String name()
    {
        Calendar cal = Calendar.getInstance();
        return ""+cal.get(Calendar.MONTH);
    }
}
