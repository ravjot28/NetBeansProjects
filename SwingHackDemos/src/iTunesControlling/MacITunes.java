package iTunesControlling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MacITunes implements ActionListener
{

    public static void main(String[] args)
    {
        new MacITunes();
    }


    MacITunes()
    {
        JFrame frame = new JFrame("Mac iTunes Hack");
	JButton button = new JButton("Play/Pause");
	button.addActionListener(this);
	frame.getContentPane().add(button);
        frame.addWindowListener(new WindowAdapter()
                                {
                                    public void windowClosing(WindowEvent e)
                                    {
                                        System.exit(0);
                                    }
                                 }
                                );
        frame.pack();
	frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt)
    {
        try
        {
            Runtime rt = Runtime.getRuntime();
            String[] args = { "osascript",
                              "-e",
                              //"tell app \"iTunes\" to play"//"tell app \"iTunes\" to pause"//"tell app \"iTunes\" to set sound volume to 100"//"tell app \"iTunes\" to set sound volume to sound volume - 5"//"tell app \"iTunes\" to set sound volume to sound volume + 5"//"tell app \"iTunes\" to previous track"//"tell app \"iTunes\" to next track"
                              "tell app \"iTunes\" to playpause"
                            };
            Process proc = rt.exec(args);
	} catch (IOException ex)
                {
                    System.out.println("exception : " + ex.getMessage());
                    ex.printStackTrace();
		}
    }
}