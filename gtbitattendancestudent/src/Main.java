
import java.io.File;
import javax.swing.UIManager;


public class Main
{

     public static void look()
    {
         try
         {
             UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
         }catch(Exception e){}
    }
    public static void main(String asp[])
    {
        look();
        File f = new File("Bin\\Data\\UserInfo1\\userinfo.ravs");
        if(f.exists())
        {
            java.awt.EventQueue.invokeLater(new Runnable()
            {
                public void run()
                {
                    new Login().setVisible(true);
                }
            });
        }
        else
        {
            java.awt.EventQueue.invokeLater(new Runnable()
            {
                public void run()
                {
                    new LoginPage().setVisible(true);
                }
            });
        }
    }
}
