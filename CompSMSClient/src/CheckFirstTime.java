import java.io.File;

public class CheckFirstTime implements FileDetails
{
    public boolean find()
    {
        File f = new File(dirpath+filename);
        if(f.exists())
        {
            return true;
        }
        else
        {
            if(mk(dirpath))
            {
                System.out.println(dirpath+" Created");
            }
            else
            {
                System.err.println(dirpath+" Not Created");
            }
            return false;
        }
    }

   public boolean mk(String strManyDirectories)
   {
       boolean success = (new File(strManyDirectories)).mkdirs();
       return success;
   }
}
