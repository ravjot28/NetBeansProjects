package BackupProcesses;

import BackSupport.OS;
import Log.LogInput;
import java.io.File;
import javax.swing.JOptionPane;

public class Start
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
    
    public String process()
    {
        setFileSeprator();

        GetFolders gf = new GetFolders();
        
        String files[] = gf.process();

        if(files!=null)
        {
            int i=0;

            if(!new File("Bin"+FileSeprator+"Temp").exists())
            {
                File f = new File("Bin"+FileSeprator+"Temp"+FileSeprator);      //Stores the error in the log file
                f.mkdirs();
            }

            for(String f:files)
            {
                try
                {
                    if(new File(f).isDirectory())
                    {
                        CompressFolders c = new CompressFolders();
                        c.zipDir("Bin"+FileSeprator+"Temp"+FileSeprator+(i+1)+".zip" , new File(f).getAbsolutePath());
                    }
                    else
                    {
                        CompressFiles c = new CompressFiles(new File(f).getAbsolutePath(),"Bin"+FileSeprator+"Temp"+FileSeprator+(i+1)+".zip" );
                    }
                } catch (Exception ex)
                {
                    LogInput li = new LogInput();           //If the mark file is not created
                    li.input("File:"+"Bin"+FileSeprator+"Temp"+FileSeprator+"Compressed to "+"Bin"+FileSeprator+"Temp"+FileSeprator+(i+1)+".zip" +" Error:"+ex);
                    JOptionPane.showMessageDialog(null,"Encountered an Error. Please Contact the developers at ravjot28@gmail.com","Error",JOptionPane.ERROR_MESSAGE);
                }
                i++;
            }

            CompressFolders c = new CompressFolders();
            c.zipDir("Bin"+FileSeprator+"RBackup"+".zip" , new File("Bin"+FileSeprator+"Temp"+FileSeprator).getAbsolutePath());

            Encrypt cp = new Encrypt("Bin"+FileSeprator+"RBackup.zip");
            cp.process();
            return "Backup.rbackup";
         }
        return null;
    }
}
