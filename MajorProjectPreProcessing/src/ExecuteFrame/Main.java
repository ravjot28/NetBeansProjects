package ExecuteFrame;

import Interface.LAFFile;
import Interface.SwingProperties;
import Locations.GetJavaHome;
import OS.GetOSType;
import Theme.Copy;
import Theme.CopyProperties;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import javax.swing.JOptionPane;

public class Main implements Runnable,SwingProperties,LAFFile
{
    Thread th = new Thread(this);

    GetOSType gos = new GetOSType();
    String OS = gos.getOS().trim();

    static GetJavaHome gjh = new GetJavaHome();

    static String destfile = null;
    static String destjar = null;

    public static void main(String asp[])
    {
        new Main();
    }

    Main()
    {
        File f = new File("Bin/Data/rav.ravs");
        if(f.exists())
        {
            System.out.println("Copied already");
            th.start();
        }
        else
        {

        if(OS.equalsIgnoreCase("win"))
            {
                String src1 = new File(lafFile1).getAbsolutePath();
                String src3 = new File(filename).getAbsolutePath();

                destfile=gjh.getLocation()+"\\lib\\";
                destjar=gjh.getLocation()+"\\lib\\ext";

                Copy c = new Copy();
                c.process(new File(lafFile1).getAbsoluteFile().toString().trim(),destjar,new File(filename).getAbsoluteFile().toString().trim(),destfile);
                
                CopyProperties cp = new CopyProperties();
                cp.process(new File(lafFile1).getAbsoluteFile().toString().trim(),destjar,new File(filename).getAbsoluteFile().toString().trim(),destfile);
                
            }
            else
                if(OS.equalsIgnoreCase("mac"))
                {
                    destfile="/lib/";
                    destjar="/lib/ext";
                }
                    else
                        if(OS.equalsIgnoreCase("linux"))
                        {
                            destfile="/lib/";
                            destjar="/lib/ext";
                        }
                            else
                            {
                                 JOptionPane.showMessageDialog(null,"Oops!! This OS is not Supported.","Error",JOptionPane.ERROR_MESSAGE);
                                 System.exit(0);
                            }
            try
            {
                BufferedWriter b = null;
                if(OS.equalsIgnoreCase("win"))
                {
                    b= new BufferedWriter(new FileWriter("Bin\\Data\\rav.ravs"));
                }
                else
                if(OS.equalsIgnoreCase("mac"))
                {
                    b= new BufferedWriter(new FileWriter("Bin/Data/rav.ravs"));
                }
                    else
                        if(OS.equalsIgnoreCase("linux"))
                        {
                            b= new BufferedWriter(new FileWriter("Bin/Data/rav.ravs"));
                        }
                b.append("Done");
                b.close();
            }catch(Exception sad){}
        th.start();
        }
    }

    public void run()
    {
            String cmd = "cmd /c"+" javaw -Dswing.defaultlaf=net.sourceforge.napkinlaf.NapkinLookAndFeel -jar  Rav.jar";
            
            try
            {
                Process p = Runtime.getRuntime().exec(cmd);
            }catch(Exception sda){}
    }
}
