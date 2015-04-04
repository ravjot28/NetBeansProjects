/*
 *  Collects the drive list and store them
 */

package FirstRun;

import BackSupport.OS;
import EntryPoint.Main;
import Interfaces.FirstRunInterface;
import Log.LogInput;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class DirList implements FirstRunInterface       //Class used to store the list of drives which are fixed
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

        if(t)
            pushNotification();     //Notifies user to remove all external hard disk and pen drives before we collect the list of drives

        return setDirList();        //returns true of the process is successfully executed
    }

    private void pushNotification()     //Notification Dialog Box
    {
        JOptionPane.showMessageDialog(null, "Please remove all Pen Drives and External Hard disk","Alert", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean setDirList()     //This functions get the list of drives attached to the user's system
    {
      	FileSystemView fsv = FileSystemView.getFileSystemView();

      	File[] f = File.listRoots();

	for (int i = 0; i < f.length; i++)
      	{
            if(fsv.isDrive(f[i]) && f[i].canRead() && f[i].canWrite())  //if the directory is Drive, can read and write then we save the directory to the file
            {
                if(!storeDrive(f[i].toString()))    //Stores the Drive name
                {
                    return false;
                }
            }
      	}

        return true;
    }

    public boolean storeDrive(String s)     //Stores the drive in the file Bin\Data\DirList.ravs
    {
        try
        {
            BufferedWriter b = new BufferedWriter(new FileWriter("Bin"+FileSeprator+"Data"+FileSeprator+dirFileName,true));
            b.append(s);
            b.newLine();
            b.close();
            return true;
        }catch(FileNotFoundException ae)
            {
                LogInput li = new LogInput();
                li.input("File:"+"Bin"+FileSeprator+"Data"+FileSeprator+dirFileName+" Error:"+ae);
                File f = new File("Bin"+FileSeprator+"Data"+FileSeprator);      //Stores the error in the log file
                f.mkdirs();                     //Creates the directory if it is missing Bin\Data\ (Auto Resolve the issue)
                Main m = new Main(false);
            }
            catch(Exception ae)
            {
                LogInput li = new LogInput();
                li.input("File:"+"Bin"+FileSeprator+"Data"+FileSeprator+dirFileName+" Error:"+ae);
            }
        return false;
    }
}
    

