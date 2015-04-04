import com.google.code.facebookapi.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.apache.commons.httpclient.HttpException;
public class SendtoFacebook {
    String m;
    public void rav(String a,String email,String pass) throws FacebookException, HttpException, IOException
    {
        m=a;
        System.out.println(m);
        SendtoFacebook sfb=new SendtoFacebook();
        sfb.send(m,email,pass);
    }

    public void rav(String a) throws FacebookException, HttpException, IOException
    {
        m=a;
        System.out.println(m);
        SendtoFacebook sfb=new SendtoFacebook();
        sfb.send(m,"","");
    }

    public void send(String message,String email,String pass)throws FacebookException, HttpException, IOException
    {
        String FB_APP_API_KEY ="bf1dc101af67d6055b1555d5e8f9d505";  //Application api key
        String FB_APP_SECRET = "d80bb51d4e86e782f392bf65be2a9e50"; //Application api secret
        // String FB_SESSION_KEY = new String("504b1aec36f9c3cb72127987-724135591");
        String FB_SESSION_KEY="";
        File p=new File("Bin\\AppID\\id.ravs");
        if(!p.exists())
        {
          FB_SESSION_KEY=new Login().login(FB_APP_API_KEY,FB_APP_SECRET, email,pass);
          System.out.println(FB_SESSION_KEY);
          try
          {
            BufferedWriter b=new BufferedWriter(new FileWriter("Bin\\AppID\\id.ravs"));
            b.append(FB_SESSION_KEY);
            b.close();
        }catch(Exception sd){}
        }
        else
        {
            String rav="";
            BufferedReader f=new BufferedReader(new FileReader("Bin\\AppID\\id.ravs"));
            try
            {
                rav=f.readLine();
            }catch(Exception asd){}
            FB_SESSION_KEY=rav;
        }

        FacebookJsonRestClient facebook = new FacebookJsonRestClient( FB_APP_API_KEY, FB_APP_SECRET, FB_SESSION_KEY );

        //FacebookJsonRestClient facebookClient2 = (FacebookJsonRestClient)facebook.getFacebookRestClient();
        FacebookJsonRestClient facebookClient = (FacebookJsonRestClient)facebook;
        facebookClient.stream_publish(message, null, null, null, null);
            JOptionPane.showMessageDialog(null,"successfully updated","Information",JOptionPane.INFORMATION_MESSAGE);
    }
}
