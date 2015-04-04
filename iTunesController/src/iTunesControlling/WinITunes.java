package iTunesControlling;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import jtunes.*;

public class WinITunes implements ActionListener
{
    JLabel l2=new JLabel("");
    JLabel l3=new JLabel("");
    JLabel l4=new JLabel("");

    static
    {
        System.loadLibrary("com4j");                  
    }

    public static void main(String[] args)
    {
                    
        new WinITunes();
    }

    WinITunes()
    {
        JFrame frame = new JFrame("Win iTunes Hack");
	JButton button = new JButton("Play/Pause");
        frame.setLayout(new GridLayout(4,1));
        //frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
	button.addActionListener(this);//;new WinITunes());
	frame.add(button);
        frame.addWindowListener(new WindowAdapter()
                                {
                                    public void windowClosing(WindowEvent e)
                                    {
                                        System.exit(0);
                                    }
                                });
	frame.pack();
	frame.setVisible(true);
     }

     public void actionPerformed(ActionEvent evt)
     {
         try
         {
            IiTunes itunes;
            itunes = ClassFactory.createiTunesApp();
            itunes.playPause();
            //itunes.createPlaylist("Rav");
            //System.out.println(itunes.soundVolumeControlEnabled());
            //itunes.soundVolume(50);
           // System.out.println(itunes.playerPosition());
            //itunes.backTrack();
            //itunes.playerPosition(10);
            //itunes.stop();
            //itunes.quit();
            //itunes.rewind();
            //itunes.nextTrack();
            //itunes.previousTrack();
          //  IITTrack track;
          //  track = itunes.currentTrack();
          //  int track_number = track.trackNumber();
            //int track_count = track.trackCount();
           // String track_name = track.name();
           // String album_name = track.album();
           // String artist_name = track.artist();
            //l1.setText(""+track_number);
            //l2.setText(track_name);
           // l3.setText(album_name);
            //l4.setText(artist_name);
	  } catch (Exception ex) {System.out.println("exception : " + ex.getMessage()); ex.printStackTrace();}
        }
}



