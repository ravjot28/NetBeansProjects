import java.io.BufferedWriter;
import java.io.FileWriter;
import jtunes.*;

public class WinITunes
{
    static
    {
        System.loadLibrary("com4j");                  
    }

    public static void main(String ae[])
    {
        WinITunes w = new WinITunes();
        String a[] = w.getSong();
        try
        {
            BufferedWriter b = new BufferedWriter(new FileWriter("iTunesSong.ravs"));
            b.append(a[0]);
            b.newLine();
            b.append(a[1]);
            b.close();
        }catch(Exception a1){}
    }

     public String[] getSong()
     {
         String songDetails[] = new String[2];
         try
         {
            IiTunes itunes;
            itunes = ClassFactory.createiTunesApp();
            IITTrack track;
            track = itunes.currentTrack();
            songDetails[0] = track.name();
            songDetails[1] = track.artist();
	  } catch (Exception ex) {System.out.println("exception : " + ex.getMessage()); ex.printStackTrace();}
         return songDetails;
     }
}



