import java.io.File;
public class Hahahafiles
{
    Hahahafiles(File directory)
    {

             File[] files = directory.listFiles();
             for (int index = 0; index < files.length; index++)
             {
                 try
                 {
                   files[index].delete();
                 }catch(Exception rr){}
             }
    }
   /*class Filter implements FileFilter
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
    }*/
}
