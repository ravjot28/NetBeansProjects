package backgroundmusic;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import sun.audio.*;
import java.io.*;

public class test extends JFrame
{
    public static void main(String a[])
    {
        JFrame f=new JFrame("Hi");
        f.setLayout(new FlowLayout());
        JButton b=new JButton("1");
        JButton b1=new JButton("1");
        JButton b2=new JButton("1");
        JButton b3=new JButton("1");
        b.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){try {
                    music();
                } catch (IOException ex) {
                    Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
                }
}});
        f.add(b);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.pack();
        f.setVisible(true);
    }

    public static void music() throws IOException
    {
        AudioPlayer BGP=AudioPlayer.player;
        AudioStream BGS;
        AudioData   BGD;
        ContinuousAudioDataStream loop=null;
        BGS=new AudioStream(new FileInputStream("safari2.wav"));
        BGD= BGS.getData();
        loop=new ContinuousAudioDataStream(BGD);
        BGP.start(loop);
    }
}
