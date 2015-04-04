
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main
{
    public static void main(String as[])
    {
        File f = new File("Bin/Data/UserInfo.ravs");
        //System.out.println("Size "+f.length());
        if((f.exists())&&(f.length()!=0))
        {
            //System.out.println("in if");
            String email="";
            String pswd="";
            try
            {
                BufferedReader bb = new BufferedReader(new FileReader("Bin/Data/UserInfo.ravs"));
                email = new Base64Decoder(new Base64Decoder(new Base64Decoder(bb.readLine()).get()).get()).get();
                pswd = new Base64Decoder(new Base64Decoder(new Base64Decoder(bb.readLine()).get()).get()).get();
                bb.close();
            }catch(Exception ex){}
            new MailSender(email,pswd);
        }
        else
        {
            new LoginPage();
        }
    }
}
