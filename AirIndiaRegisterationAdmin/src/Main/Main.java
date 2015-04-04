package Main;

import java.io.File;
import javax.swing.UIManager;
import login.Login;
import registeration.AdminRegisteration;

public class Main
{
    public static void look()
    {
        try
        {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        }catch(Exception e){}
    }

    public static void main(String sap[])
    {
        look();

        new Tray();

        if(check())
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
            if(!new File(System.getProperty("user.home")+System.getProperty("file.separator")+"RavSoftsData"+System.getProperty("file.separator")).exists())
            {
                File f = new File(System.getProperty("user.home")+System.getProperty("file.separator")+"RavSoftsData"+System.getProperty("file.separator"));
                f.mkdir();
            }
            java.awt.EventQueue.invokeLater(new Runnable()
            {
                public void run()
                {
                    new AdminRegisteration().setVisible(true);
                }
            });
        }
    }

    public static boolean check()
    {
        String dir = System.getProperty("user.home")+System.getProperty("file.separator")+"RavSoftsData"+System.getProperty("file.separator")+"Admin.admin";
        return new File(dir).exists();
    }

}
