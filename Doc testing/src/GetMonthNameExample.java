import java.util.Calendar;

public class GetMonthNameExample
{
    public String name()
    {
        String[] monthName = {"January", "February",
            "March", "April", "May", "June", "July",
            "August", "September", "October", "November",
            "December"};

        Calendar cal = Calendar.getInstance();
        String month = monthName[cal.get(Calendar.MONTH)];

        return (month);
    }
}
