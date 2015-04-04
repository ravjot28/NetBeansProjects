/*
 *  Takes the list of drives of the system and call the class that deals with background process
 */

package BackgroundApplication;

import BackSupport.OS;
import Interfaces.FirstRunInterface;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ActivateSystemTrayIndicator implements FirstRunInterface
{
    static String FileSeprator;

    ArrayList<String> dirs = new ArrayList();

    private void setFileSeprator()      //Selects the File Seprator for the current OS of the user. "\" for Windows and "/" for Mac or Linux or Unix
    {
        OS os = new OS();

        String osName = os.getOS();

        if(osName.equalsIgnoreCase("win"))
            this.FileSeprator = "\\";
        else
            if(osName.equalsIgnoreCase("mac") || osName.equalsIgnoreCase("linux"))
                this.FileSeprator = "/";

    }
    
    public ActivateSystemTrayIndicator()        //Gets the main drives of the user's system
    {
        this.setFileSeprator();

        try
        {
            BufferedReader b = new BufferedReader(new FileReader("Bin"+FileSeprator+"Data"+FileSeprator+dirFileName));
            String data = b.readLine().trim();
            while(data!=null)
            {
                dirs.add(data);
                data=b.readLine().trim();
            }
        }catch(Exception e)
        {     }
    }

    public void process()
    {
        EnableSystemTray est = new EnableSystemTray(dirs);      //Creates the object of the class that will execute the process of background module
        Thread th = new Thread(est);
        th.start();                                             //Executes the thread
    }
}
