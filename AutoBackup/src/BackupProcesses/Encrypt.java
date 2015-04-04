package BackupProcesses;

import BackSupport.OS;
import Log.LogInput;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import sun.misc.BASE64Encoder;

public class Encrypt
{
    static String fileName;
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

    public Encrypt(String fname)
    {
        setFileSeprator();
        this.fileName = fname;
    }

    public void process()
    {
        try
        {
            BASE64Encoder encoder = new BASE64Encoder();
            encoder.encode(
                            new FileInputStream(this.fileName),
                            new FileOutputStream("Bin"+FileSeprator+"Backup.rbackup")
                            );
        }catch(Exception ae)
        {
            LogInput li = new LogInput();           //If System Tray can not be created then OS details stored in the log file
            li.input("Encrypting Files: "+this.fileName+", "+"Bin"+FileSeprator+"Backup.rbackup Error:"+ae.toString());
            JOptionPane.showMessageDialog(null,"Encountered Error while creating backup","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
