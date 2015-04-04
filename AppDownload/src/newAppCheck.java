import java.io.BufferedReader;
import java.io.FileReader;

public class newAppCheck
{
    public boolean check()
    {
        try
        {
            BufferedReader b = new BufferedReader(new FileReader("Bin\\Data\\totalapps.ravs"));
        }catch(Exception e){}
        return true;
    }
}
