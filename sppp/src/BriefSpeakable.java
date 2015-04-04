import javax.speech.synthesis.Speakable;

/**
 * Simple Speakable
 *  Returns marked-up text to be spoken
 */
public class BriefSpeakable implements Speakable {

    /**
     * Returns marked-up text.  The markup is used to help the vice engine.
     */
    public String getJSMLText() {
        return "Bye Bye take care keep smiling";
    }

    /**
     * Implemented so the listener can print out the source
     */
    public String toString() {
        return getJSMLText();
    }

}