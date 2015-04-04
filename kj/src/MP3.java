import java.util.ArrayList;
import ravmp3.Mp3;


class MP3 implements Runnable
{
    Thread th = new Thread(this);
    Mp3 player = new Mp3();
    ArrayList<String> songs;
    int i =0;
    boolean change =true;

    public void play(ArrayList<String> s)
    {
        th = new Thread(this);
        songs = s;
        th.suspend();
        th.start();
    }

    public void stop()
    {
        player.stopSong();
        th.suspend();
    }

    public boolean isComplete()
    {
        return player.isSongComplete();
    }

    public void run()
    {
        player.playSong(songs.get(i));
        do
        {
            if(!player.isSongComplete())
            {
                change = false;
            }
            else
            {
                change = true;
            }
            if(i == songs.size()-1)
            {
                i=0;
            }
            if(change)
            {
                player.playSong(songs.get(++i));
            }
        }while(true);
    }
}