import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class JLayerPlayer implements Runnable
{
    Thread thread=new Thread(this);
    Object lock = new Object();
    volatile boolean paused = false;
    String songname;

    public void userPressedPause()
    {
        paused = true;
    }

    public void stop()
    {
        thread.stop();
    }

    public void userPressedPlay()
    {
        synchronized(lock)
        {
            paused = false;
            lock.notifyAll();
        }
    }

        JLayerPlayer(String song)
        {
            songname=song;
            thread.start();
            
        }

        public static void main(String asd[])
        {
            String s="/Volumes/Rav World/My World/Music/Songs/Fun/lamhaa04(www.songs.pk).mp3";
            JLayerPlayer p;
            p=new JLayerPlayer(s);
        }


    public void run()
    {

         AudioInputStream din = null;
		try {
			File file = new File(songname);
                        System.out.println(songname+"  "+file);
			AudioInputStream in = AudioSystem.getAudioInputStream(file);
			AudioFormat baseFormat = in.getFormat();
			AudioFormat decodedFormat = new AudioFormat(
					AudioFormat.Encoding.PCM_SIGNED,
					baseFormat.getSampleRate(), 16, baseFormat.getChannels(),
					baseFormat.getChannels() * 2, baseFormat.getSampleRate(),
					false);
			din = AudioSystem.getAudioInputStream(decodedFormat, in);
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, decodedFormat);
			SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
			if(line != null) {
				line.open(decodedFormat);
				byte[] data = new byte[4096];

				int nBytesRead;
				synchronized (lock) {
	while ((nBytesRead = din.read(data, 0, data.length)) != -1) {
		while (paused) {
			if(line.isRunning()) {
				line.stop();
			}
			try {
				lock.wait();
			}
			catch(InterruptedException e) {System.out.println(e);
			}
		}

		if(!line.isRunning()) {
			line.start();

		}
		line.write(data, 0, nBytesRead);
	}
}
				// Stop
				line.drain();
				line.stop();
				line.close();
				din.close();
			}

		}
		catch(Exception e) {
			e.printStackTrace();System.out.println(e);
		}
		finally {
			if(din != null) {
				try { din.close(); } catch(IOException e) {System.out.println(e); }
			}
		}
        
    }

}
