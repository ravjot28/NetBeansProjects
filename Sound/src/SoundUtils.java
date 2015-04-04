import javax.sound.sampled.*;
import java.util.Random;

public class SoundUtils {

  public static float SAMPLE_RATE = 8000f;

  public static void laser(int repeat)
    throws LineUnavailableException, InterruptedException
  {
    AudioFormat af =
      new AudioFormat(
          SAMPLE_RATE, // sampleRate
          8,           // sampleSizeInBits
          1,           // channels
          true,        // signed
          false);      // bigEndian
    SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
    sdl.open(af);
    sdl.start();

    byte[] buf = new byte[1];
    int step;

    for (int j=0; j < repeat; j++) {
      step = 10;
      for(int i=0; i < 2000; i++) {
        buf[0] = ((i%step > 0) ? 32 : (byte)0);

        if(i%250 == 0) step += 2;
        sdl.write(buf,0,1);
      }
      Thread.sleep(200);
    }
    sdl.drain();
    sdl.stop();
    sdl.close();
  }

  public static void warp(int repeat)
    throws LineUnavailableException, InterruptedException
  {
    AudioFormat af =
      new AudioFormat(
          SAMPLE_RATE, // sampleRate
          8,           // sampleSizeInBits
          1,           // channels
          true,        // signed
          false);      // bigEndian
    SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
    sdl.open(af);
    sdl.start();

    byte[] buf = new byte[1];
    int step;

    for (int j=0; j < repeat; j++) {
      step = 25;
      for(int i=0; i < 2000; i++) {
        if(i < 500) {
          buf[0] = ((i%step > 0) ? 32 : (byte)0);
          if(i%25 == 0) step--;
        }
        else {
          buf[0] = ((i%step > 0) ? 16 : (byte)0);
          if(i%50 == 0) step++;
        }
        sdl.write(buf,0,1);
      }
    }
    sdl.drain();
    sdl.stop();
    sdl.close();
  }

  public static void bang()
    throws LineUnavailableException, InterruptedException
  {
    AudioFormat af =
      new AudioFormat(
          SAMPLE_RATE, // sampleRate
          8,           // sampleSizeInBits
          1,           // channels
          true,        // signed
          false);      // bigEndian
    SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
    sdl.open(af);
    sdl.start();

    byte[] buf = new byte[1];
    Random r = new Random();
    boolean silence = true;
    for (int i=0 ; i < 8000 ; i++) {
      while(r.nextInt() % 10 != 0) {
          buf[0] =
            silence ? 0 :
              (byte)Math.abs(r.nextInt() %
                  (int)(1. + 63. * (1. + Math.cos(((double)i)
                      * Math.PI / 8000.))));
          i++;
          sdl.write(buf,0,1);
      }
      silence = !silence;
  }
    sdl.drain();
    sdl.stop();
    sdl.close();
  }

  public static void main(String[] args) throws Exception {
    SoundUtils.laser(5);
    Thread.sleep(1000);
    SoundUtils.warp(10);
    Thread.sleep(1000);
    SoundUtils.bang();
  }
}