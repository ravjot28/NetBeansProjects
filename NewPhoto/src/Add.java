
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import javax.swing.JOptionPane;
public class Add
{
    String fname="Temp/Pic.txt";
    Add(String name,File directory)
    {
         
             File[] files = directory.listFiles(new Filter());
             for (int index = 0; index < files.length; index++)
             {
                 try
                 {
                    BufferedWriter pw=new BufferedWriter(new FileWriter(fname,true));
                    pw.append( files[index].toString());
                    pw.newLine();
                    pw.close();
                 }catch(Exception rr){}
             }
         
    }
     class Filter implements FileFilter
    {
        public boolean accept(File file)
        {
            if(file.getName().endsWith("png"))
            {
                return file.getName().endsWith("png");
            }else
                if(file.getName().endsWith("gif"))
            {
                return file.getName().endsWith("gif");
            }
            else
                if(file.getName().endsWith("jpeg"))
            {
                return file.getName().endsWith("jpeg");
            }
                return file.getName().endsWith("jpg");
            
            
        }
    }

}
