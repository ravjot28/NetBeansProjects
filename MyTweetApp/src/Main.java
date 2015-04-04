import java.awt.EventQueue;
import java.io.File;

public class Main
{
    public static void main(String asp[])
    {
        new Main();
    }

    Main()
    {
        File f = new File("Bin/Data/User_Para/UserInfo.ravs");
        if((f.exists())&&(f.length()>0))
        {
            EventQueue.invokeLater(new Runnable()
            {
                public void run()
                {
                    new TweetFrame().setVisible(true);
                }
            });
        }
        else
        {
             EventQueue.invokeLater(new Runnable()
             {
                public void run()
                {
                    new FirstLogin().setVisible(true);
                }
            });
        }
    }
}
