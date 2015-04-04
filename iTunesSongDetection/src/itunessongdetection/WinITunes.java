package itunessongdetection;

import java.io.BufferedWriter;
import java.io.FileWriter;
import jtunes.*;

public class WinITunes
{
    static
    {
        System.loadLibrary("com4j");
    }

    public static void main(String[] args)
    {

        new WinITunes().getSong();
    }
    public void getSong()
    {
            IiTunes itunes;
            itunes = ClassFactory.createiTunesApp();
            
            IITTrack track;
            track = itunes.currentTrack();
            String track_name = track.name();
            //String album_name = track.album();
            String artist_name = track.artist();
            try
            {
                BufferedWriter b = new BufferedWriter(new FileWriter("iTunesSong.ravs"));
                b.append(track_name);
                b.newLine();
                b.append(artist_name);
                b.close();
            }catch(Exception ae){}
     }
}
