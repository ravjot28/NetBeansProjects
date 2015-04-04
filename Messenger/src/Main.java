
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Main
{

    static String name;
    
    public static void main(String asp[])
    {
        String fname = "Bin/Data/UserInfo/userinfo.ravs";
        File f = new File(fname);
        if((f.exists())&&(f.length()!=0))
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Option().setVisible(true);
            }
        });
        }
        else
        {
            new First().setVisible(true);
        }
    }
}
