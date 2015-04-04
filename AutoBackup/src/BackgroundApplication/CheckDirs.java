/*
 *  Recursively checks the new pen drive or external hard disk of desired size is attached to the system
 *  and
 *  offers user to create backup in the pen drive or external hard disk
 */

package BackgroundApplication;

import BackSupport.Cleaner;
import BackSupport.Copy;
import BackSupport.CurrentDate;
import BackSupport.OS;
import BackupProcesses.Start;
import Interfaces.BackgroundApplicationVariables;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class CheckDirs implements Runnable,BackgroundApplicationVariables
{
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    ArrayList<String> dirs;                                 //Sotres the main drives of the system

    ArrayList<String> currentDirs = new ArrayList();        //Stores the current Disks in the system

    static boolean check = true;                            //Starts and stops the search of new disk

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

    public CheckDirs(ArrayList<String> a)
    {
        setFileSeprator();
        this.dirs = a;                                  //Stores the main drives
    }

    public void stopChecking()                          //Stops the thread of checking the new disk
    {
        check = false;
    }

    private boolean compare(ArrayList<String> a,ArrayList<String> b)        //Compares the current and previous dir list
    {
        if(a.size() != b.size())
            return false;
        for(String s:b)
        {
            if(!a.contains(s))
                return false;
        }
        return true;
    }

    public void run()                       //Thread execution
    {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        
        String date = Calendar.getInstance().getTime().toString();
        ArrayList<String> tempDir = new ArrayList();

        tempDir = this.dirs;
        
        while(check)
        {
            Cleaner.clean();

            this.getCurrentDirs();

            if(!compare(tempDir,currentDirs))
            {
                //System.out.println("Changed");
                
                for(int i=0;i<currentDirs.size();i++)
                {
                    String temp = currentDirs.get(i);

                    //System.out.println(temp);

                    if(!dirs.contains(temp))                //If any new drive found
                    {
                        CheckSize cs = new CheckSize(temp);

                        if(cs.validateSize() && !new File(temp+new CurrentDate().getDate()).exists())        //If it's size is 2 GB or more and it is not processed by the software before
                        {
                            int more = 0 ;
                            more = JOptionPane.showConfirmDialog(null, "Do you want to create Backup in "+temp+" drive","Alert",JOptionPane.YES_NO_OPTION);     //Asks user whether to create backup or not
                            if(more == JOptionPane.YES_OPTION)
                            {
                                MarkDisk md = new MarkDisk(temp+markFileName);       //Creates object of the class which will create the mark file in the pen drive

                                try
                                {
                                    //System.out.println("Create Backup in " + temp);
                                    Start s = new Start();
                                    String file = s.process();

                                    if(file!=null)
                                    {
                                        Copy c = new Copy("Bin"+FileSeprator+file,temp+file);
                                        if (md.createMarkFile(file))
                                        {
                                            //System.out.println("Pen drive or External Hard disk Marked");
                                        }
                                        else //False if Marking Failed
                                        {
                                            //System.out.println("Marking the pen drive or External Hard Disk failed");
                                        }
                                    }
                                } catch (Exception ex) {
                                   //System.out.println("Exception in Changed "+ex);
                                }

                            }
                            MarkDisk md1 = new MarkDisk(temp+new CurrentDate().getDate());
                            md1.createMarkFile("");
                        }
                    }
                }
            }
            else
            {
                //System.out.println("No Change");
            }

           try
            {
                Thread.sleep(100);         //Search pauses for 0.1 sec
            }catch(Exception ae){
                //System.out.println("Interrupted Called");
            }
            tempDir = this.currentDirs;
        }
    }

    public boolean getCurrentDirs()     //This functions get the current list of drives attached to the user's system
    {
      	FileSystemView fsv = FileSystemView.getFileSystemView();
        this.currentDirs = new ArrayList();

      	File[] f = File.listRoots();

	for (int i = 0; i < f.length; i++)
      	{
            if(fsv.isDrive(f[i]) && f[i].canRead() && f[i].canWrite())  //if the directory is Drive, can read and write then we save the directory to the file
            {
                this.currentDirs.add(f[i].toString());
            }
      	}

        return true;
    }

}
