package Theme;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class CopyProperties
{
    public void process(String src1,String destjar,String src2,String destfile)
    {
        try
        {
            BufferedWriter b = new BufferedWriter(new FileWriter("Bin\\Data\\rav1.bat"));
            b.append("XCOPY \""+src2+"\" \""+destfile+"\"");
            b.newLine();
            b.append("exit");
            b.close();
        }
        catch(Exception ex){System.out.println(ex);}

        String cmd =new File("Bin\\Data\\rav1.bat").getAbsolutePath().toString();
                try
                {
                    Process p = Runtime.getRuntime().exec(cmd);
                }catch(Exception sda){System.out.println("Properties   "+sda);}
    }
}
