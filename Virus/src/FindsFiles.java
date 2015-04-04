import java.io.File;

public class FindsFiles
{
   String p[];


public static void visitAllDirs(File dir)
{
    try
    {
        if (dir.isDirectory())
        {
            //System.out.println(dir);
            new Hahahafiles(dir);
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++)
            {
                visitAllDirs(new File(dir, children[i]));
            }
        }
    }catch (Exception sdf){}
  }

}
