import java.awt.EventQueue;
import java.io.File;
import javax.swing.UIManager;

public class Main implements FileDetails
{
    public static boolean preprocess()
    {
        return new CheckFirstTime().find();
    }

    public static void main(String ar[])
    {
        look();
        if(preprocess())
        {
            File f = new File(contacts);
            if(f.exists())
            {

            }
            else
            {
                EventQueue.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        new VerificationFrame().setVisible(true);
                    }
                });
            }
        }
        else
        {
            EventQueue.invokeLater(new Runnable()
            {
                public void run()
                {
                    new InstallationFrame().setVisible(true);
                }
            });
        }
    }

    public static void look()
    {
         try
         {
             UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
         }catch(Exception e){}
    }
}
