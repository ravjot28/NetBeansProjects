/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package karaoke;

import javafx.concurrent.Task;
import static karaoke.Constants.*;

/**
 *
 * @author pc
 */
class SaveRecordTask extends Task<String> {

    @Override
    protected String call() throws Exception {
        return NONE;
    }

    @Override
    public void run() {
        try {
            AudioLine obj = AudioLine.getInstance();
            obj.targetDataLine.stop();
            obj.targetDataLine.close();
            obj.targetDataLine = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
