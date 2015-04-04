
import javax.speech.synthesis.SpeakableEvent;
import javax.speech.synthesis.SpeakableListener;

/**
 * Simple SpeakableListener
 *   Prints event type and the source object's toString()
 */
public class BriefListener implements SpeakableListener {

    private String formatEvent(SpeakableEvent event) {
        return event.paramString()+": "+event.getSource();
    }

    public void markerReached(SpeakableEvent event) {
      //  System.out.println(formatEvent(event));
    }

    public void speakableCancelled(SpeakableEvent event) {
       // System.out.println(formatEvent(event));
    }

    public void speakableEnded(SpeakableEvent event) {
       // System.out.println(formatEvent(event));
    }

    public void speakablePaused(SpeakableEvent event) {
       // System.out.println(formatEvent(event));
    }

    public void speakableResumed(SpeakableEvent event) {
      //  System.out.println(formatEvent(event));
    }

    public void speakableStarted(SpeakableEvent event) {
       // System.out.println(formatEvent(event));
    }

    public void topOfQueue(SpeakableEvent event) {
        //System.out.println(formatEvent(event));
    }

    public void wordStarted(SpeakableEvent event) {
       // System.out.println(formatEvent(event));
    }
}