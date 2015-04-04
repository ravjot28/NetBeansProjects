import java.io.*;
import java.util.*;
public class FileeInputtwitter
{
    String name;
    String d;
    Scanner ss;
    FileeInputtwitter(String fname,String data)
    {
        name=fname;
        d=data;
        Base64Encodertwitter base64encoder= new Base64Encodertwitter(d);
        String rav=base64encoder.get();
        try
        {
            BufferedWriter b=new BufferedWriter(new FileWriter(name,true));
            b.append(rav);
            b.newLine();
            b.close();
        }catch(Exception erew){}
    }

}
