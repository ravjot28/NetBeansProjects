import java.io.*;
import java.util.*;
public class FileeInput
{
    String name;
    String d;
    Scanner ss;
    FileeInput(String fname,String data)
    {
        name=fname;
        d=data;
        Base64Encoder base64encoder= new Base64Encoder(d);
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
