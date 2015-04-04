import java.io.*;
import java.util.zip.*;

public class Zip
{
  public static void main(String arg[]) throws IOException 
  {
      String args[]=new String[1];
      args[0]="D://greetn.docx";
    byte b[] = new byte[512];
    ZipOutputStream zout = new ZipOutputStream(System.out);
    for(int i = 0; i < args.length; i ++) {
      InputStream in = new FileInputStream(args[i]);
      ZipEntry e = new ZipEntry(args[i].replace(File.separatorChar,'/'));
      zout.putNextEntry(e);
      int len=0;
      while((len=in.read(b)) != -1) {
        zout.write(b,0,len);
        }
      zout.closeEntry();
      print(e);
      }
    zout.close();
    }

  public static void print(ZipEntry e){
    PrintStream err = System.err;
    err.print("added " + e.getName());
    if (e.getMethod() == ZipEntry.DEFLATED) {
      long size = e.getSize();
      if (size > 0) {
        long csize = e.getCompressedSize();
        long ratio = ((size-csize)*100) / size;
        err.println(" (deflated " + ratio + "%)");
        }
      else {
        err.println(" (deflated 0%)");
        }
      }
    else {
      err.println(" (stored 0%)");
      }
    }
}