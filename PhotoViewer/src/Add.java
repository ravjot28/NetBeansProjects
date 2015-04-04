
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import javax.swing.JOptionPane;
public class Add
{
    String source;
    String fname="Temp/Pic.txt";
    String na;
    Add(String name)
    {
        na=name;
         FolderChooser panel = new FolderChooser();
         source=panel.go();
         if(source.equalsIgnoreCase("no"))
         {
             JOptionPane.showMessageDialog(null,"Select the desired folder","Alert",JOptionPane.INFORMATION_MESSAGE);
         }
         else
         {
             File directory = new File(source);
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
    }
     class Filter implements FileFilter
    {
        public boolean accept(File file)
        {
            if(file.getName().endsWith("jpg"))
            {
                return file.getName().endsWith("jpg");
            }
            else
                if(file.getName().endsWith("bmp"))
                {
                    return file.getName().endsWith("bmp");
                }
                else
                    if(file.getName().endsWith("png"))
                    {
                        return file.getName().endsWith("png");
                    }
                    else
                        if(file.getName().endsWith("ico"))
                        {
                            return file.getName().endsWith("ico");
                        }
                        else
                            if(file.getName().endsWith("jpeg"))
                            {
                                return file.getName().endsWith("jpeg");
                            }
            return file.getName().endsWith("");
            
        }
    }

}
