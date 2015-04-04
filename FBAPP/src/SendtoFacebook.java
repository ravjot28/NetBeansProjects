import com.google.code.facebookapi.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.httpclient.HttpException;
import org.json.JSONArray;
import org.json.JSONException;
public class SendtoFacebook
{
    String m;
    public String rav(String a) throws FacebookException, HttpException, IOException, JSONException
    {
        m=a;
        SendtoFacebook sfb=new SendtoFacebook();
        String p=sfb.send(m);
        if(p.equalsIgnoreCase("y"))
        {
            return "y";
        }
        return "";
    }

    public String send(String message)throws FacebookException, HttpException, IOException, JSONException
    {
        String FB_APP_API_KEY ="143485692403919";  //Application api key
        String FB_APP_SECRET = "d7fa471e7d7b5e2b16e6d2cd1bfd7d5d"; //Application api secret
        // String FB_SESSION_KEY = new String("504b1aec36f9c3cb72127987-724135591");
        String FB_SESSION_KEY="";
        File p=new File("Bin/AppID/id.ravs");
       
            String rav="";
            BufferedReader f=new BufferedReader(new FileReader("Bin/AppID/id.ravs"));
            try
            {
                rav=f.readLine();
            }catch(Exception asd){}
             //Base64Decoder bbb= new Base64Decoder(rav);
             //Base64Decoder bbb1= new Base64Decoder(bbb.get());
             //Base64Decoder bbb2= new Base64Decoder(bbb1.get());
             //String rav1=bbb2.get();
             System.out.println(rav);
            FB_SESSION_KEY=rav;
            System.out.println( FB_SESSION_KEY);

        

        FacebookJsonRestClient facebook = new FacebookJsonRestClient( FB_APP_API_KEY, FB_APP_SECRET, FB_SESSION_KEY );

        //FacebookJsonRestClient facebookClient2 = (FacebookJsonRestClient)facebook.getFacebookRestClient();
        FacebookJsonRestClient facebookClient = (FacebookJsonRestClient)facebook;
        facebookClient.stream_publish(message, null, null, null, null);
        //JSONArray a = facebookClient.friends_getLists();
        //System.out.println("Printing friend list");
        //for(int i=0;i<a.length();i++)
        //{
            //System.out.println(""+(i+1)+" "+a.getString(i));
        //}
            return "y";
    }
}
