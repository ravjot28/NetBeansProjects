import java.io.*;
public class FileeOutputtwitter
{
    String name;
    String rav="";
    public FileeOutputtwitter(String FileName)
    {
        String data;
        String result="";
        name=FileName;
        try
        {
            BufferedReader b=new BufferedReader(new FileReader(name));
            data=b.readLine();
            while(data!=null)
            {
                result=result+data;
                data=b.readLine();
            }
            b.close();
        }catch(Exception edads){}
        Base64Decodertwitter base64decoder= new Base64Decodertwitter(result);
        rav=base64decoder.get();
    }
    public String gett()
    {
        return rav;
    }

}
