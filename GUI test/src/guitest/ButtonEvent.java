package guitest;
import java.io.*;
public class ButtonEvent
{
    public static void main(String ar[])
    {
        try
        {
            BufferedWriter b=new BufferedWriter(new FileWriter("rav.txt"));
            b.write('a');
            b.close();
            File f=new File("rav.txt");
            f.renameTo(new File("ravs.txt"));
        }catch(Exception e){}
    }
    
   
}
