import java.io.*;
public class FileeOutputMail
{
    String name;
    String rav="";
    public FileeOutputMail(String FileName)
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
            System.out.println(result);
        }catch(Exception edads){}
        Base64DecoderMail base64decoder= new Base64DecoderMail(result);
        rav=base64decoder.get();
    }
    public String gett()
    {
        return rav;
    }

}
