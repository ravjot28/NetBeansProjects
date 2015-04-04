package Theme;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Copy
{
    public void process(String src1,String destjar,String src2,String destfile)
    {
        try
        {
            BufferedWriter b = new BufferedWriter(new FileWriter("Bin\\Data\\rav.bat"));
            b.append("XCOPY \""+src1+"\" \""+destjar+"\"");
            b.newLine();
            b.append("exit");
            //b.newLine();
            b.close();
        }
        catch(Exception ex){System.out.println(ex);}

        String cmd =new File("Bin\\Data\\rav.bat").getAbsolutePath().toString();
                try
                {
                    Process p = Runtime.getRuntime().exec(cmd);
                    p.waitFor();

                }catch(Exception sda){System.out.println("Jar   "+sda);}
    }
}
