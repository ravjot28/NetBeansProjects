package BackupProcesses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressFolders
{
  
    public void zipDir(String zipFileName, String dir)
    {
        ZipOutputStream out = null;
        try {
            File dirObj = new File(dir);
            out = new ZipOutputStream(new FileOutputStream(zipFileName));
            addDir(dirObj, out);
            out.close();
        } catch (IOException ex) {

        }
    }


    public void addDir(File dirObj, ZipOutputStream out)
    {

        File[] files = dirObj.listFiles();

        byte[] tmpBuf = new byte[1024];
        for (int i = 0; i < files.length; i++)
        {
            FileInputStream in = null;
            try {
                if (files[i].isDirectory()) {
                    addDir(files[i], out);
                    continue;
                }
                in = new FileInputStream(files[i].getAbsolutePath());
                out.putNextEntry(new ZipEntry(files[i].getAbsolutePath()));
                int len;
                while ((len = in.read(tmpBuf)) > 0) {
                    out.write(tmpBuf, 0, len);
                }
                out.closeEntry();
                in.close();
            } catch (IOException ex) {
            }
        }
    }
    
}