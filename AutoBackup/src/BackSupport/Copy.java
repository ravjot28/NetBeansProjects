package BackSupport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Copy
{
    public Copy(String a,String b)
    {
        copyfile(a,b);
    }

    private static void copyfile(String srFile, String dtFile)
    {
        try
        {
            System.out.println("Source File: "+srFile);
            System.out.println("Destination File: "+dtFile);
            File f1 = new File(srFile);
            File f2 = new File(dtFile);
            InputStream in = new FileInputStream(f1);

            OutputStream out = new FileOutputStream(f2);    //For Overwrite the file.

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0)
            {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }
        catch(Exception ex){System.out.println(ex);}
    }
}
