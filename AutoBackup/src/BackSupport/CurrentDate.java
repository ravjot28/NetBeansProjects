package BackSupport;

import java.util.*;

public class CurrentDate
{

    public String getDate()
    {

        Calendar cal = new GregorianCalendar();

        int month = cal.get(Calendar.MONTH);

        int year = cal.get(Calendar.YEAR);

        int day = cal.get(Calendar.DAY_OF_MONTH);

        return( day+""+ (month + 1)+""+ year);
  }
}