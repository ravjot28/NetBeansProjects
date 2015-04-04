package Main;

import airindiaregisteration.Membership_Form;
import editmode.Membership_Form_Edit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.UIManager;

public class Main
{
    static String information[] = new String[10];
    static ArrayList<String> nominations = new ArrayList();

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
        if(check())
        {
            String dir = System.getProperty("user.home")+System.getProperty("file.separator")+"RavSoftsData";
            String s[] = new File(dir).list();
            String fname = null;
            for(String p:s)
                if(p.indexOf(".ravs")>0)
                    fname=p;

            
            if(fname == null)
            {
                java.awt.EventQueue.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        new Membership_Form().setVisible(true);
                    }
                });
            }
            else
            {
                try
                {
                    BufferedReader b = new BufferedReader(new FileReader(dir+System.getProperty("file.separator")+fname));
                    String data = b.readLine();
                    b.close();
                    StringTokenizer s1 = new StringTokenizer(data,"$$$");
                    String info = s1.nextToken();
                    String nomi = s1.nextToken();

                    StringTokenizer s2 = new StringTokenizer(info,"^");
                    int i=0;
                    while(s2.hasMoreTokens())
                    {
                        information[i] = s2.nextToken();
                        i++;
                    }
                    StringTokenizer s3 = new StringTokenizer(nomi,"^");
                    while(s3.hasMoreTokens())
                    {
                        nominations.add(s3.nextToken());
                    }
                    java.awt.EventQueue.invokeLater(new Runnable()
                    {
                        public void run()
                        {
                            new Membership_Form_Edit(information,nominations).setVisible(true);
                        }
                    });
                }catch(Exception as)
                {
                    java.awt.EventQueue.invokeLater(new Runnable()
                    {
                        public void run()
                        {
                            new Membership_Form().setVisible(true);
                        }
                    });
                }
            }
        }
        else
        {
            java.awt.EventQueue.invokeLater(new Runnable()
            {
                public void run()
                {
                    new Membership_Form().setVisible(true);
                }
            });
        }
    }

    public static boolean check()
    {
        String dir = System.getProperty("user.home")+System.getProperty("file.separator")+"RavSoftsData";
        return new File(dir).exists();
    }
}
