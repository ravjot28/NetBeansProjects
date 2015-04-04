package Main;

import javax.swing.UIManager;
import login.Login;

public class Main
{
    public static void look()
    {
        try
        {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        }catch(Exception e){}
    }

    public static void main(String s[])
    {
        look();
        new Tray();
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
