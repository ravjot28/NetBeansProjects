import java.io.File;

public class Main1
{
   String p[];


public static void visitAllDirs(String na,File dir)
{
    try
    {
        if (dir.isDirectory())
        {
      //System.out.println(dir);
            new Add(na,dir);
      String[] children = dir.list();
      for (int i = 0; i < children.length; i++)
      {
        visitAllDirs(na,new File(dir, children[i]));
      }
    }
    }catch (Exception sdf){}
  }

}
