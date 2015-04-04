package getlyrics;

import java.io.*;
import java.net.URL;
import javax.swing.*;
import java.awt.*;

public class RavGetLyrics
{
    String song="";

    Thread th;

    String songLink;
    static RavGetLyrics w;
    Frame frame;
    JFrame f;

    static boolean showing = false;



    private static BufferedReader read(String url) throws Exception
    {
        return new BufferedReader(new InputStreamReader(new URL(url).openStream()));
    }



    private void doIt(String link)
    {
        this.songLink = link;
    }



    private String process()
    {
        song="";
        BufferedReader reader = null;
        try {
            reader = read(this.songLink);
            String line = reader.readLine();
            while (line != null) {
                if (!line.contains("&nbsp")) {
                    if (line.contains("Ringtone")) {
                        String temp = reader.readLine();
                        while (!temp.contains("<a href")) {
                            song += (temp.replaceAll("\\<.*?>", "").trim() + "\n");
                            temp = reader.readLine();
                        }
                    }
                }
                line = reader.readLine();
            }


        } catch (Exception ex)
        {
            song = "Can't Find the lyrics";
        }
        return song;
    }


    public String getSong(String gn,String gkn)
    {
        String ganaName  = gn;
        String gayakName  =gkn;
        ganaName = ganaName.trim().replace(" ", "+");
        gayakName = gayakName.trim().replace(" ","+");
        String link = "http://www.lyricsreg.com/lyrics/"+gayakName+"/"+ganaName+"/";
        doIt(link);
        return process();
    }
}

