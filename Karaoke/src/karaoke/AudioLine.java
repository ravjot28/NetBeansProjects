/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package karaoke;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import static karaoke.Constants.*;

/**
 *
 * @author pc
 */
public class AudioLine {
    
  public AudioFormat audioFormat;
  public static TargetDataLine targetDataLine = null;
  public AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
  public File audioFile = null;
  public static DataLine.Info dataLineInfo = null;
  public static AudioLine audio = null;
  
  private AudioLine(){
      try {
          //Get things set up for capture
          audioFile = new File(SAVE_FILE_MP3);
          audioFormat = getAudioFormat();
          dataLineInfo =
                  new DataLine.Info(
                  TargetDataLine.class,
                  audioFormat);
      } catch (Exception e) {
          e.printStackTrace();
          System.exit(0);
      }
  }
  
  private static void initDataLine(){
      try {
          targetDataLine = (TargetDataLine)AudioSystem.getLine(dataLineInfo);
      } catch (LineUnavailableException ex) {
          Logger.getLogger(AudioLine.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  
    private AudioFormat getAudioFormat() throws UnsupportedAudioFileException, IOException {
        File file = new File(MEDIA_URL);
        AudioInputStream in = AudioSystem.getAudioInputStream(file);
        AudioFormat baseFormat = in.getFormat();
        AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                baseFormat.getSampleRate(),
                16,
                baseFormat.getChannels(),
                baseFormat.getChannels()*2,
                baseFormat.getSampleRate(),
                false);
        in.close();
        /*float sampleRate = 8000.0F;
         //8000,11025,16000,22050,44100
         int sampleSizeInBits = 16;
         //8,16
         int channels = 1;
         //1,2
         boolean signed = true;
         //true,false
         boolean bigEndian = false;
         //true,false
         return new AudioFormat(sampleRate,
         sampleSizeInBits,
         channels,
         signed,
         bigEndian);*/
        return decodedFormat;
    }//end getAudioFormat
  
  public static synchronized AudioLine getInstance(){
      if(null == audio){
          audio = new AudioLine();
      }
      if(null == targetDataLine){
          initDataLine();
      }
      return audio;
  }
}
