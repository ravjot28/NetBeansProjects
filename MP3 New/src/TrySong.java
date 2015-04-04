import javazoom.jl.player.Player;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.FactoryRegistry;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackListener;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.decoder.JavaLayerException;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrySong extends JFrame implements Runnable
{
	private AdvancedPlayer player;
	private AudioDevice device;
    private int position = 0;

	private JPanel pnlButton = new JPanel(new FlowLayout());

    private JButton btnPlay = new JButton("Play");
    private JButton btnPause = new JButton("Pause");
    private JButton btnStop = new JButton("Stop");

    private Thread thread = null;

	public TrySong()
	{
		super("Try Song");

		btnPlay.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			  btnPlay_actionPerformed(e);
			}
		});

		btnPause.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			  btnPause_actionPerformed(e);
			}
		});

		btnStop.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			  btnStop_actionPerformed(e);
			}
		});

		pnlButton.add(btnPlay);
		pnlButton.add(btnPause);
		pnlButton.add(btnStop);

		this.add(pnlButton, "South");

		this.setSize(400,400);
		this.setVisible(true);
	}

	public static void main(String [] args)
	{
		new TrySong();
	}
	public void play()
	{
		  try
		  {
			 InputStream is = new BufferedInputStream(new FileInputStream("D:\\Multimedia\\Music\\Songs\\Fun\\Tere Liye unplugged.mp3"));

			 FactoryRegistry r = FactoryRegistry.systemRegistry();
			 device = r.createAudioDevice();
			 player = new AdvancedPlayer(is, device);
			 player.setPlayBackListener(new PlaybackListener()
			 {
				public void playbackStarted(PlaybackEvent playbackEvent)
				{
				   //vmech().onMessage("Playback started..");
				   System.out.println("Playback started..");
		//		   thread.resume();
				}

				public void playbackFinished(PlaybackEvent playbackEvent)
				{
				   //vmech().onMessage("Playback finished..");
				   System.out.println("Playback finished..");
				}
			 });

			 thread = new Thread(this);
			 thread.start();
		  }
		  catch (JavaLayerException e)
		  {
			 e.printStackTrace();
		  }
		  catch (FileNotFoundException e)
		  {
			 e.printStackTrace();
		  }

	}

	public void pause()
	{
		int positionInMillis = device.getPosition();
		position = positionInMillis / 26;

		System.out.println("Pause : " + position);
		//thread.suspend();
        player.stop();
	}

	public void stop()
	{
		player.stop();
		ResetPosition();
	}

	public void ResetPosition()
	{
	      position = 0;
   	}

   	public void run()
   	{
		try
		{
			System.out.println("Play : " + position+"  End "+Integer.MAX_VALUE );
			player.play(position+10, Integer.MAX_VALUE);
			//System.out.println("Playback finished..");
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
	}

   	private void btnPlay_actionPerformed(ActionEvent e)
   	{
		play();
	}

	private void btnPause_actionPerformed(ActionEvent e)
	{
		pause();
	}

	private void btnStop_actionPerformed(ActionEvent e)
	{
		stop();
	}
}