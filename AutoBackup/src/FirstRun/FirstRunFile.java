/*
 *  Checks the need for the First Run process
 *  If yes, then creates indicators and then collects the drives info and store them
 *  Else execute the background application
 */

package FirstRun;

import BackSupport.OS;
import Interfaces.FirstRunInterface;
import Log.LogInput;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FirstRunFile implements FirstRunInterface      //This class is executed to execute the process of First Run
{
    static String FileSeprator;

    private void setFileSeprator()      //Selects the File Seprator for the current OS of the user. "\" for Windows and "/" for Mac or Linux or Unix
    {
        OS os = new OS();

        String osName = os.getOS();

        if(osName.equalsIgnoreCase("win"))
            FileSeprator = "\\";
        else
            if(osName.equalsIgnoreCase("mac") || osName.equalsIgnoreCase("linux"))
                FileSeprator = "/";

    }

    public boolean process(boolean t)
    {
        setFileSeprator();      //Sets the file seprator
        
        if(check())             //Checks the DirList.ravs and ABackUp.ravs exists or not
        {
            return true;
        }
        else
        {
            if(createFile(t))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    private boolean createFile(boolean t)   //Create the DirList.ravs file first and then creates ABackup.ravs file
    {
        DirList dl = new DirList();

        if(!dl.process(t))      //Creates DirList.ravs file
            return false;
        
        try     //Creates ABackUp.ravs file in the user's home directory C:\Users\<User Name>
        {
            BufferedWriter b = new BufferedWriter(new FileWriter(System.getProperty("user.home")+FileSeprator+fileName));
            b.close();
            return true;
        }catch(Exception ae)
         {
            LogInput li = new LogInput();
            li.input("File:"+System.getProperty("user.home")+FileSeprator+fileName+" Error:"+ae);       //Stores the error in the log file
         }
        return false;
    }

    private boolean check()     //Checks whether DirLists.ravs and ABackUp.ravs exist or not
    {
        return new File(System.getProperty("user.home")+FileSeprator+fileName).exists() && new File("Bin"+FileSeprator+"Data"+FileSeprator+dirFileName).exists();
    }
}
