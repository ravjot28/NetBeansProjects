import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;
import java.io.*;
public class MP3
{
    public static void main(String args[]) throws FileNotFoundException, JavaLayerException
    {
        do
        {
        FileInputStream s=new FileInputStream("D:\\Multimedia\\Music\\Songs\\Fun\\Tu Jane Na.mp3");
        Player p=new Player(s);
        p.play();
        if(p.isComplete())
        {
            new MP3();
        }
        }while(true);
    }
}
