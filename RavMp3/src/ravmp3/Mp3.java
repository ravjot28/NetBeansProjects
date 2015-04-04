package ravmp3;

import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class Mp3
{
    Player p;

    public boolean playSong(String name)
    {
        try
        {
            FileInputStream s=new FileInputStream(name);
            p=new Player(s);
            p.play();
            return true;
        }catch(Exception as){return false;}
    }

    public void stopSong()
    {
        p.close();
    }

    public boolean isSongComplete()
    {
        return p.isComplete();
    }
}
