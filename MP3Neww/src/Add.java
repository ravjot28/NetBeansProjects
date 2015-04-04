
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
public class Add
{
    Add(String name,String source)
    {
         if(!source.equalsIgnoreCase("no"))
         {
             File directory = new File(source);
             File[] files = directory.listFiles(new Filter());
             for (int index = 0; index < files.length; index++)
             {
                //Print out the name of files in the directory
                 try
                 {
                    BufferedWriter pw=new BufferedWriter(new FileWriter(name,true));
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
            return file.getName().endsWith("mp3");
        }
    }

}
