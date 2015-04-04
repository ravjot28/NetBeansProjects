package newpackage;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class dob
{
    public String[] getdate()
    {
        try
        {
        String dt = "1948-01-01";  // Start date
        String[] date=new String[21900];
        for(int i=0;i<21900;i++)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(dt));
            c.add(Calendar.DATE, 1);  // number of days to add
            dt = sdf.format(c.getTime());
            date[i]=dt;
        }
        SecureRandom wheel = null;
            wheel = SecureRandom.getInstance("SHA1PRNG");
            String dob[]=new String[3684];
            for (int i = 0; i < 3684; i++)
                {
                    int random = wheel.nextInt(date.length);
                    dob[i]=date[random].replaceAll("-"," ");
                }
        return dob;
        

        }catch(Exception sd){}
        return null;
    }
}
