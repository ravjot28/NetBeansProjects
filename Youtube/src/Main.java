
import java.awt.EventQueue;
import java.io.File;

public class Main
{
    public static void main(String pp[])
    {
        File f = new File("Bin/Data/UserInfo/userinfo.ravs");

        if((f.exists())&&(f.length()!=0))
        {
            EventQueue.invokeLater(new Runnable()
            {
                public void run()
                {
                    new Uploader().setVisible(true);
                }
            });
        }
        else
        {
            EventQueue.invokeLater(new Runnable()
            {
                public void run()
                {
                    new Login().setVisible(true);
                }
            });
        }
    }
}
