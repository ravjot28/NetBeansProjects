package BackSupport;

import java.io.File;

public class Cleaner
{
    static String FileSeprator;

    private static void setFileSeprator()      //Selects the File Seprator for the current OS of the user. "\" for Windows and "/" for Mac or Linux or Unix
    {
        OS os = new OS();

        String osName = os.getOS();

        if(osName.equalsIgnoreCase("win"))
            FileSeprator = "\\";
        else
            if(osName.equalsIgnoreCase("mac") || osName.equalsIgnoreCase("linux"))
                FileSeprator = "/";

    }

    public static void clean()
    {
        setFileSeprator();
        
        if(new File("Bin"+FileSeprator+"RBackup.zip").exists())
        {
            File f = new File("Bin"+FileSeprator+"RBackup.zip");
            f.delete();
        }
        if(new File("Bin"+FileSeprator+"Backup.rbackup").exists())
        {
            File f = new File("Bin"+FileSeprator+"Backup.rbackup");
            f.delete();
        }
        if(new File("Bin"+FileSeprator+"Temp").exists())
        {
            File f[] = new File("Bin"+FileSeprator+"Temp"+FileSeprator).listFiles();

            for(File f1:f)
            {
                f1.delete();
            }
        }
    }
}
