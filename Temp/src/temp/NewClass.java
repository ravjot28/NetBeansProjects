
package temp;

import java.io.File;
import java.io.IOException;

public class NewClass
{
    public static void main(String args[]) throws IOException
    {
        File f=new File("C:\\Users\\Rav\\Desktop\\02 teri yaad jab aati hai .mp3 - Shortcut");

       System.out.println( f.getCanonicalFile()+"  "+f.getCanonicalPath());
    }

}
