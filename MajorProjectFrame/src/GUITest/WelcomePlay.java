package GUITest;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.awt.BorderLayout;
import java.awt.Component;
import java.net.URL;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.Player;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;
import ravrun.Rav;


public class WelcomePlay
{
    String Path;

    JFrame welcomeFrame;
   
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension d = kit.getScreenSize();

    public WelcomePlay(String p)
    {
        this.Path = p;
    }


    public void process()
    {
        URL mediaURL = null;

        try
        {
            mediaURL = new File(Path).toURL();
        }

        catch ( Exception malformedURLException )
        {
            System.err.println( "Could not create URL for the file" );
        }


        if ( mediaURL != null )
        {
            welcomeFrame = new JFrame( "Welcome" );
            welcomeFrame.setIconImage(new ImageIcon("Bin\\img\\logo.png").getImage());
            welcomeFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );


            welcomeFrame.setUndecorated(true);
            
            MediaPanel mediaPanel = new MediaPanel( mediaURL );
            welcomeFrame.add( mediaPanel );
            
            int w = 640;
            int h = 480;
            int x = (d.width-w)/2;
            int y = (d.height-h)/2;

            
            welcomeFrame.setResizable(false);

            welcomeFrame.pack();
            welcomeFrame.setBounds(x, y,w,h);
            welcomeFrame.setVisible( true );
        }
    }
    
    class MediaPanel extends JPanel
    {

        Player mediaPlayer;

        public MediaPanel( URL mediaURL )
        {
            setLayout( new BorderLayout() );
            Manager.setHint( Manager.CACHING, true );

            try
            {
                mediaPlayer = Manager.createRealizedPlayer( mediaURL );

                mediaPlayer.addControllerListener(new ControllerListener() {

                    public void controllerUpdate(ControllerEvent ce) {
                        if (ce instanceof EndOfMediaEvent)
                        {
                            mediaPlayer.stop();
                            welcomeFrame.dispose();

                            Main1 m = new Main1();

                            new Rav("Bin\\Note\\WelcomeSpeech\\WelcomeSpeech.jar").execute();
                            m.Process();
                        }
                    }
                });

                Component video = mediaPlayer.getVisualComponent();

                if ( video != null )
                    add( video, BorderLayout.CENTER );

               

                mediaPlayer.start();
            }
            catch ( Exception noPlayerException )
            {
                System.err.println( "No media player found" );
            }            
        }       
    }
    
} 
