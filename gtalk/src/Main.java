
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.XMPPException;


public class Main
{
    public static void main(String arp[]) throws XMPPException
    {
        File f = new File("Bin/Data/UserInfo/userinfo.ravs");
        if(f.exists())
        {
              String email="";
            String pswd="";
            try
            {
                BufferedReader bb = new BufferedReader(new FileReader("Bin/Data/UserInfo/userinfo.ravs"));
                email = new Base64Decoder(new Base64Decoder(new Base64Decoder(bb.readLine()).get()).get()).get();
                pswd = new Base64Decoder(new Base64Decoder(new Base64Decoder(bb.readLine()).get()).get()).get();
                bb.close();
            }catch(Exception ex){}
                new ChatClient().begin(email.trim(),pswd.trim());
        }
        else
        {
            new Login();
        }
    }
}
