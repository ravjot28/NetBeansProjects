
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main implements ServerList
{
    public boolean checkDir(String dir)
    {
        if(new File(dir).exists())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void call()
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainFrame().setVisible(true);
            }
        });
    }


    public boolean mk(String strManyDirectories)
    {
        boolean success = (new File(strManyDirectories)).mkdirs();
        if(success)
        {
            return true;
        }

        return false;
    }

    public void start()
    {
        if(checkDir("lib\\RavMail.jar") && checkDir("lib\\RavTheme.jar"))
        {
            if(checkDir(dir))
            {
                look();
                call();
            }
            else
            {
                if(mk(dir))
                {
                    look();
                    call();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"No Permission. Check the admin Permissions", "Error", JOptionPane.ERROR_MESSAGE);
                }        
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"File(s) Missing or Corrupted. Reinstall Please", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void look()
    {
         try
         {
             UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
         }catch(Exception e){}
    }

    public static void main(String asdp[])
    {
        Main m = new Main();
        m.start();
    }
}
