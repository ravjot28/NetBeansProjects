import java.io.File;


public class Begins
{
    Begins(String na)
    {
         FindsFiles ss=new FindsFiles();
         ss.visitAllDirs(new File(na));
    }

}
