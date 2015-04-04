import java.util.Calendar;
import java.text.DateFormatSymbols;

public class GetDayName
{
    public String name()
    {
      String dayNames[] = new DateFormatSymbols().getWeekdays();
      Calendar date2 = Calendar.getInstance();
      return dayNames[date2.get(Calendar.DAY_OF_WEEK)];
    }
}