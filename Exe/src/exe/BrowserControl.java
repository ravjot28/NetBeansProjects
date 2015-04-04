package exe;
import java.io.IOException;

public class BrowserControl
{

    void displayURL(String url) {
        String cmd = null;
        try {
                // cmd = 'rundll32 url.dll,FileProtocolHandler http://...'
                cmd = "rundll32" + " " + "url.dll,FileProtocolHandler" + " " + url;
                Process p = Runtime.getRuntime().exec(cmd);
            
        } catch(IOException x) {
            // couldn't exec browser
            System.err.println("Could not invoke browser, command=" + cmd);
            System.err.println("Caught: " + x);
        }
    }
    public static void main(String args[])
    {
        BrowserControl p=new BrowserControl();
        p.displayURL("www.google.com");
    }

    
}