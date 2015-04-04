package BackupProcesses;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressFiles
{
    public CompressFiles(String a,String b)
    {
        process(a,b);
    }

   public void process(String filename,String zipfilename) {
        try {
            byte[] buf = new byte[1024];
            FileInputStream fis = new FileInputStream(filename);
            fis.read(buf,0,buf.length);

            CRC32 crc = new CRC32();
            ZipOutputStream s = new ZipOutputStream(
                    (OutputStream)new FileOutputStream(zipfilename));

            s.setLevel(6);

            ZipEntry entry = new ZipEntry(filename);
            entry.setSize((long)buf.length);
            crc.reset();
            crc.update(buf);
            entry.setCrc( crc.getValue());
            s.putNextEntry(entry);
            s.write(buf, 0, buf.length);
            s.finish();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
