import java.io.File;
import java.io.FileInputStream;
import javax.sound.sampled.*;
import javax.swing.*;

public class AppWithSound extends JFrame {

  private static final long serialVersionUID = 1L;

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
       public void run() {
         AppWithSound app = new AppWithSound();
          app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          app.startApp();
       }
    });
 }

 public AppWithSound() {
    initGUI();
 }

 private void startApp() {
    playStartupSound();
    setVisible(true);
 }

 private void endApp() {
    System.exit(0);
 }

 private void playStartupSound() {
    Runnable soundPlayer = new Runnable() {
       public void run() {
          try {
             // use one of the WAV of Windows installation
             File tadaSound = new File(System.getenv("windir") + "/" +
                              "media/tada.wav");
             AudioInputStream audioInputStream = AudioSystem
                   .getAudioInputStream(new FileInputStream(tadaSound));
             AudioFormat audioFormat = audioInputStream
                   .getFormat();
             DataLine.Info dataLineInfo = new DataLine.Info(
                   Clip.class, audioFormat);
             Clip clip = (Clip) AudioSystem
                   .getLine(dataLineInfo);
             clip.open(audioInputStream);
             clip.start();
          } catch (Exception e) {
             e.printStackTrace();
          }
       }
    };
    Thread soundPlayingThread = new Thread(soundPlayer);
    soundPlayingThread.start();
 }

 private void initGUI() {
    setSize(300, 200);
  }
}