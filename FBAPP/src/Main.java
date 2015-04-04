import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import ravrun.Rav;
public class Main
{
    String url="rundll32" + " " + "url.dll,FileProtocolHandler" + " " +"http://www.facebook.com/login.php?api_key=bf1dc101af67d6055b1555d5e8f9d505&connect_display=popup&v=1.0&next=http://www.facebook.com/connect/login_success.html&cancel_url=http://www.facebook.com/connect/login_failure.html&fbconnect=true&return_session=true&session_key_only=true&req_perms=read_stream,publish_stream,offline_access";
    String FB_APP_API_KEY ="260049054006110";  //Application api key
    String FB_APP_SECRET = "a6c681e4a634a836d704c1991a338799"; //Application api secret
    String email="";
    String pass="";
    public static void main(String asd[])
    {
        new Main();
    }

    public Main()
    {
        LookAndFeel lf = UIManager.getLookAndFeel();
               try
               {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception e) {
                    }
        File f=new File("Bin/AppID/id.ravs");
        if((f.exists())&&(f.length()>0))
        {
            java.awt.EventQueue.invokeLater(new Runnable()
            {
                public void run()
                {
                    new GUIFB().setVisible(true);
                }
            });
        }
        else
        {
            JOptionPane.showMessageDialog(null,"After this message a facebook website will open in your default browser sign in and give permission to Rav S application on facebook","Alert",JOptionPane.INFORMATION_MESSAGE);
            try {
                new Rav("http://www.facebook.com/login.php?api_key="+FB_APP_API_KEY+"&connect_display=popup&v=1.0&next=http://www.facebook.com/connect/login_success.html&cancel_url=http://www.facebook.com/connect/login_failure.html&fbconnect=true&return_session=true&session_key_only=true&req_perms=read_stream,publish_stream,offline_access").execute();

                //new Rav("https://www.facebook.com/dialog/oauth?client_id="+FB_APP_API_KEY+"&redirect_uri=https://www.facebook.com/connect/login_success.html").execute();
                
            } catch (Exception ex) {  }
            java.awt.EventQueue.invokeLater(new Runnable()
            {
            public void run() {
                new LoginPage().setVisible(true);
            }
            });
            
        }
    }
}

