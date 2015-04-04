package BackupProcesses;

import BackSupport.OS;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import sun.misc.BASE64Decoder;


public class Decrypt
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

    public Decrypt(String fname)
    {
        setFileSeprator();
        this.fileName = fname;
    }

    public void process(String d)
    {
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            decoder.decodeBuffer(new FileInputStream(this.fileName), new FileOutputStream(d+FileSeprator+"Backup.zip"));
        } catch (IOException ex) {
        }
    }
}
