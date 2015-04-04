/*
 *  Sotres all the errors occured during the project running in the format below
 *  <date and time> <error caused on which file or statement> <error that occured>
 */

package Log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LogInput       //Class used to store the exception occured during execution of the software
{
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";     //This will be the date and time format



    public void input(String s)     //Stores the log details
    {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

        try
        {
            BufferedWriter b = new BufferedWriter(new FileWriter("Log.ravs",true));

            b.append("Date & Time: "+sdf.format(Calendar.getInstance().getTime())+" "+s);   //Stores the message and date & time in the log (Called when exception occured so that it is easy for programmer to track the bug in the software)
            b.newLine();
            b.close();
        }catch(Exception ae)
         {
            System.out.println("Issue in LogInput's input method");
         }
    }
}
