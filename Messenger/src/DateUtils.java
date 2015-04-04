import java.util.Calendar;
import java.text.SimpleDateFormat;

public class DateUtils
{
  public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

  public static String now()
  {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
    String a = sdf.format(cal.getTime());
    a= a.replaceAll("-", "");
    a= a.replaceAll(":", "");
    a= a.replaceAll(" ", "");
    return (a);

  }
}