package GUITest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Begin
{    
    public Begin()
    {
        doIt();
        Main main = new Main();
        boolean b = main.process1();
        boolean b1 = main.process1();
        if(b1 && b)
        {
            if(check())
            {
                WelcomePlay wp = new WelcomePlay("Bin\\img\\ShortWelcome.mpg");
                wp.process();
            }
            else
            {
                try
                {
                    BufferedWriter b2 = new BufferedWriter(new FileWriter("Bin\\Data\\Welcome.ravs"));
                    b2.close();
                }catch(Exception ae){}
                WelcomePlay wp = new WelcomePlay("Bin\\img\\Welcome.mpg");
                wp.process();
            }
        }
    }

    public void doIt()
    {
        File ff = new File("Bin\\Downloads\\");
        File f1[] = ff.listFiles();
        for(int i=0;i<f1.length;i++)
            f1[i].delete();
    }

    public static void main(String ar[])
    {
        Begin bb = new Begin();
    }

    public boolean check()
    {
        return new File("Bin\\Data\\Welcome.ravs").exists();
    }
}
