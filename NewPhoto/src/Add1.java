
import java.io.File;


public class Add1
{
    String source;
    Add1(String na)
    {

         FolderChooser panel = new FolderChooser();
         source=panel.go();
         System.out.println("Add1 source="+source);
         Main1 ss=new Main1();
         ss.visitAllDirs(na,new File(source));
    }

}
