/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package karaoke;

import javafx.concurrent.Task;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import static karaoke.Constants.*;

/**
 *
 * @author pc
 */
class RecordTask extends Task<String> {

    public RecordTask() {
    }

    @Override
    protected String call() throws Exception {
        return RECORDING;
    }
    
    @Override
    public void run(){
        try {
            AudioLine obj = AudioLine.getInstance();
            obj.targetDataLine.open(obj.audioFormat);
            obj.targetDataLine.start();
            AudioSystem.write(
                    new AudioInputStream(obj.targetDataLine),
                    obj.fileType,
                    obj.audioFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
