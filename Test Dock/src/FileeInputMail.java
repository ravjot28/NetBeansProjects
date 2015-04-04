import java.io.*;
import java.util.*;
public class FileeInputMail
{
    String name;
    String d;
    Scanner ss;
    FileeInputMail(String fname,String data)
    {
        name=fname;
        d=data;
        Base64EncoderMail base64encoder= new Base64EncoderMail(d);
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
