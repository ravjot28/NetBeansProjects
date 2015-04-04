

package mediaplayer;



import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {
        String list[][];
       File f=new File("Bin"+System.getProperty("file.separator")+"playlist"+System.getProperty("file.separator")+"list.tan");
           if(f.exists())
           {
            try

            {
                BufferedReader b = new BufferedReader(new FileReader("Bin"+System.getProperty("file.separator")+"playlist"+System.getProperty("file.separator")+"list.tan"));
                String data = b.readLine();
                ArrayList<String> a = new ArrayList<String>();
                while(data!=null)
                {
                    a.add(data);
                    data = b.readLine();
                }

                list = new String[a.size()][1];

                for(int i=0;i<a.size();i++)
                    list[i][0] = a.get(i);
                b.close();
                 new MainFrame11(list);
            }catch(Exception sd){}
        }
        else
        {
           String list1[][] ={{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""}};
            new MainFrame11(list1);
        }
 //   songplay();

    }
}
