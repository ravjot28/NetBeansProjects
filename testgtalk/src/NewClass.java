
import java.io.IOException;
import org.jivesoftware.smack.XMPPException;

public class NewClass {

    public static void main(String asp[]) throws IOException
    {
        try {
            new JabberSmackAPI().begin("ravjot28@gmail.com", "docomo3401","airindiapayroll@gmail.com");
        } catch (XMPPException ex) {
           System.out.println( ex);
        }
    }

}
