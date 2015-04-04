import java.io.*;
public class FileeOutput
{
    String name;
    String rav="";
    public FileeOutput(String FileName)
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
        Base64Decoder base64decoder= new Base64Decoder(result);
        rav=base64decoder.get();
    }
    public String gett()
    {
        return rav;
    }

}
