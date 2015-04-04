package ravtwitter;

import sun.misc.BASE64Encoder;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.net.URLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class RavTwitter
{
    public String Ravsend(String uname,String ps,String status)
    {
        try
        {
            URL url = new URL("https://twitter.com/statuses/update.xml");
            URLConnection connection = url.openConnection();
            String crendetials = uname + ":" + ps;
            BASE64Encoder encoder = new BASE64Encoder();
            String encodedCredentials = new String(encoder.encodeBuffer(crendetials.getBytes())).trim();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setRequestProperty("Authorization", "Basic " + encodedCredentials);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write("status=" + URLEncoder.encode(status, "UTF-8"));
            out.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response;
            while ((response = in.readLine()) != null)
            {

            }
            in.close();
        }catch(Exception r)
            {
                System.out.println("Rav Twitter Exception : "+r);
            }
        return "y";
    }
}