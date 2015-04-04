import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Main extends JFrame implements ActionListener
{
    JLayerPlayer p;
    JFrame f;
    JButton b,b1,b2;
    JLabel l;
    //String s="D:\\Music\\Songs\\Fun\\limca_ad_full_song_high_quality.mp3";
    String s="/My World/My Data/Music/Songs/English Songs/Elvis_Presley_-_Wooden_heart_.mp3";
    public static void main(String as[])
    {
        new Main();
    }

    Main()
    {
        f=new JFrame("Hu");
        b=new JButton("play");
        b1=new JButton("pause");
        b2=new JButton("resume");
        String p1[]=new ID3Test().gettag(s);
        l=new JLabel(p1[0].substring(13,p1[0].lastIndexOf("Artist")-2));
        b.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        JPanel p=new JPanel();
        p.add(b);
        p.add(b1);
        p.add(b2);
        b2.setEnabled(false);
        p.add(l);
        f.add(p);
        f.pack();
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("play"))
        {
            b.setEnabled(false);
            p=new JLayerPlayer(s);
            
        }
 else
     if(e.getActionCommand().equalsIgnoreCase("pause"))
     {
         if(!b.isEnabled())
         {
             b1.setEnabled(false);
             b2.setEnabled(true);
             p.userPressedPause();
         }
     }
 else
     if(e.getActionCommand().equalsIgnoreCase("resume"))
     {
         if(!b1.isEnabled())
         {
            b1.setEnabled(true) ;
            b2.setEnabled(false);
            p.userPressedPlay();
         }
 else
         {
             b2.setEnabled(false);
 }
     }
    }

}
