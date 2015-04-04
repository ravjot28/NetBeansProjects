package Main;

import java.awt.EventQueue;
import java.io.File;
import javax.swing.UIManager;

public class Start
{
    public void look()
    {
         try
         {
             UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
         }catch(Exception e){}
    }

    public void process()
    {
        File f = new File("Bin\\Data\\Temp");
            String files[] = f.list();
            for(int i=0;i<files.length;i++)
            {
                f= new File("Bin\\Data\\Temp\\"+files[i]);
                f.delete();
            }
            f = new File("Bin\\Data\\temp.zip");
            f.delete();
    }
    Start()
    {
        look();
        process();
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainFrame().setVisible(true);
            }
        });
    }

    public static void main(String s[])
    {
        new Start();
    }
}
