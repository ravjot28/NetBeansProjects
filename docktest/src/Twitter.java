import sun.misc.BASE64Encoder;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.net.URLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.swing.JOptionPane;

public class Twitter {

public void send(String uname,String ps,String status) throws Exception
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
    {    }
    in.close();
    JOptionPane.showMessageDialog(null,"Successfully updated","Information",JOptionPane.INFORMATION_MESSAGE);
}

}