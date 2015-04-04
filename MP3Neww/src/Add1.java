import java.io.File;
import javax.swing.JFrame;

public class Add1
{
    String source;
    JFrame fplz;
    
    Add1(String na)
    {

         FolderChooser panel = new FolderChooser();
         source=panel.go();
         Main ss=new Main();
         ss.visitAllDirs(na,new File(source));
    }
}
