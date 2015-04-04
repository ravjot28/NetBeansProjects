import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Calendar;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;
import javax.swing.Timer;
public class NewClass
{
    Player p=null;
    int ss=60;
    int timee=20;
    int i=0;
    public static void main(String args[]) throws FileNotFoundException, JavaLayerException
    {
        new NewClass().TextClock1();
        new NewClass().play();
    }

    void play() throws JavaLayerException, FileNotFoundException
    {
        p=new Player(new FileInputStream("D:\\Multimedia\\Music\\Songs\\Fun\\Tu Jane na.mp3"));
        p.play();
        p.close();
    }
     public void TextClock1()
    {
        javax.swing.Timer t = new Timer(1000, new ClockListener());
        t.start();
    }
      class ClockListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
        {
           
            i++;
            if(timee==10)
            {
                p.close();
            }
            System.out.println(i);
            

    	}
    }

}

