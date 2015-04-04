
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

    public String getLanguage()
    {
        try
        {
            BufferedReader b = new BufferedReader(new FileReader("Bin\\Data\\Lang.ravs"));
            String temp = b.readLine().trim();
            b.close();
            return temp;
        }catch(Exception sd){}
        return null;
    }

    Start()
    {
        look();
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                if(new File("Bin\\Data\\Lang.ravs").exists())
                    new OpeningPage(getLanguage()).setVisible(true);
                else
                    new OpeningPage("gurmukhi").setVisible(true);
            }
        });
    }

    public static void main(String s[])
    {
        new Start();
    }
}
