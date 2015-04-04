import java.io.BufferedReader;
import java.io.FileReader;

public class desg
{
    public String getdesg(String a)
    {
        String result="";
        try
        {
            BufferedReader b=new BufferedReader(new FileReader("Bin\\Data\\desg.txt"));
            String data=b.readLine();
            while(data!=null)
            {
                if(data.substring(2,9).equalsIgnoreCase(a))
                {
                    result=data.substring(37).trim();
                }

                      ;
                data=b.readLine();
            }
        }catch(Exception asdsd){}
        return result;
    }
}
