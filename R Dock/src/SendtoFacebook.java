import com.google.code.facebookapi.*;
import javax.swing.JOptionPane;
public class SendtoFacebook {
    String m;
    public void rav(String a) throws FacebookException
    {
        m=a;
        System.out.println(m);
    SendtoFacebook sfb=new SendtoFacebook();
    sfb.send(m);
    }
    public void send(String message)throws FacebookException{
        String FB_APP_API_KEY = new String("bf1dc101af67d6055b1555d5e8f9d505");
        String FB_APP_SECRET = new String("d80bb51d4e86e782f392bf65be2a9e50");
        String FB_SESSION_KEY = new String("504b1aec36f9c3cb72127987-724135591");
        FacebookJsonRestClient facebook = new FacebookJsonRestClient( FB_APP_API_KEY, FB_APP_SECRET, FB_SESSION_KEY );

        //FacebookJsonRestClient facebookClient2 = (FacebookJsonRestClient)facebook.getFacebookRestClient();
        FacebookJsonRestClient facebookClient = (FacebookJsonRestClient)facebook;
facebookClient.stream_publish(message, null, null, null, null);
            JOptionPane.showMessageDialog(null,"successfully updated","Information",JOptionPane.INFORMATION_MESSAGE);
    }
}
