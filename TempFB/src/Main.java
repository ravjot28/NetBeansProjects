
import com.google.code.facebookapi.FacebookException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.httpclient.HttpException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rav
 */
public class Main
{
    String s;
    public static void main(String r[]) throws FacebookException, HttpException, IOException
    {
        new Main();
    }

    Main()
    {
        try {
           s= new Login().login("bf1dc101af67d6055b1555d5e8f9d505", "d80bb51d4e86e782f392bf65be2a9e50", "ravjot28@gmail.com", "ravjotsingh71");
        } catch (FacebookException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HttpException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(s);
    }

}
