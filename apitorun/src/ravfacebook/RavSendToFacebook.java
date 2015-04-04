package ravfacebook;
import com.google.code.facebookapi.*;
import org.apache.commons.httpclient.HttpException;
public class RavSendToFacebook
{
    String message,sess;
    public String rav(String a,String session) 
    {
        String p="";
        try
        {
            message=a;
            sess=session;
            RavSendToFacebook sfb=new RavSendToFacebook();
            p=sfb.send();
        }catch(FacebookException ex)
        {
            System.out.println("Rav Facebook Exception : "+ex);
        }
        catch(HttpException ex1)
        {
            System.out.println("Rav HttpException : "+ex1);
        }
            if(p.equalsIgnoreCase("y"))
            {
                return "y";
            }
            return "";
    }

    public String send()throws FacebookException, HttpException
    {
        String FB_APP_API_KEY ="bf1dc101af67d6055b1555d5e8f9d505";  //Application api key
        String FB_APP_SECRET = "d80bb51d4e86e782f392bf65be2a9e50"; //Application api secret
        // String FB_SESSION_KEY = new String("504b1aec36f9c3cb72127987-724135591");
        String FB_SESSION_KEY="";
        FB_SESSION_KEY=sess;
        System.out.println("Rav Given Session ID "+ FB_SESSION_KEY);
        FacebookJsonRestClient facebook = new FacebookJsonRestClient( FB_APP_API_KEY, FB_APP_SECRET, FB_SESSION_KEY );
        //FacebookJsonRestClient facebookClient2 = (FacebookJsonRestClient)facebook.getFacebookRestClient();
        FacebookJsonRestClient facebookClient = (FacebookJsonRestClient)facebook;
        facebookClient.stream_publish(message, null, null, null, null);
        return "y";
    }
}
