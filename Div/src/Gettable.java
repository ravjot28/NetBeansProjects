import java.io.*;
import java.util.StringTokenizer;

public class Gettable
{
    String s[]=new String[5];
    
    public String[] getdata()
    {
        try
        {
            BufferedReader b=new BufferedReader(new FileReader("time.txt"));
            String data=b.readLine();
            int i=0;
            while(data!=null)
            {
                s[i]=data;
                data=b.readLine();
                i++;
            }
        }catch(Exception e){}
        return s;
    }
    
    public int getperino()
    {
        int a=0;
        try
        {
            BufferedReader b=new BufferedReader(new FileReader("no.txt"));
            a=Integer.parseInt(b.readLine());
        }catch(Exception as){}
        return a;
    }

    public String[] getper(String pe)
    {
        String p[]=new String[getperino()];
        StringTokenizer t=new StringTokenizer(pe,",");
        int i=0;
         while(t.hasMoreTokens())
         {
            p[i]=t.nextElement().toString();
            i++;
         }
        return p;
    }
}
