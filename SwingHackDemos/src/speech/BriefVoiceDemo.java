package speech;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.speech.Central;
import javax.speech.EngineList;
import javax.speech.synthesis.Speakable;
import javax.speech.synthesis.SpeakableListener;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.Voice;

public class BriefVoiceDemo
{
    Synthesizer synthesizer;

    public static void main(String[] args)
    {
        copyfile("Bin/Files/speech.properties",System.getProperty("user.home")+"/speech.properties");
        copyfile("Bin/Files/speech.properties",System.getProperty("java.home")+"/speech.properties");
        //default synthesizer values
        SynthesizerModeDesc modeDesc = new SynthesizerModeDesc(
                null,       // engine name
                "general",  // mode name use 'general' or 'time'
                Locale.US,  // locale, see MBROLA Project for i18n examples
                null,       // prefer a running synthesizer (Boolean)
                null);      // preload these voices (Voice[])

        //default voice values
        Voice voice = new Voice(
                "kevin16",              //name for this voice
                 Voice.AGE_NEUTRAL,   //age for this voice
                 Voice.GENDER_MALE,//Voice.GENDER_DONT_CARE,//gender for this voice
                 null);                 //prefer a running voice (Boolean)

        boolean error=false;

        BriefVoiceDemo briefExample = new BriefVoiceDemo();
        //briefExample.listAllVoices();
        /*if (error) {
           System.out.println("BriefVoiceDemo -E<ENGINENAME> " +
                "-M<time|general> -V<VOICENAME> -GF -GM");
           //list all the available voices for the user
           briefExample.listAllVoices();
           System.exit(1);
        }*/

        //select synthesizer by the required parameters
        briefExample.createSynthesizer(modeDesc);
        //print the details of the selected synthesizer
        //briefExample.printSelectedSynthesizerModeDesc();

        //allocate all the resources needed by the synthesizer
        briefExample.allocateSynthesizer();

        //change the synthesisers state from PAUSED to RESUME
        briefExample.resumeSynthesizer();

        //set the voice
        briefExample.selectVoice(voice);
        //print the details of the selected voice
//        briefExample.printSelectedVoice();

        //create a listener to be notified of speech events.
        SpeakableListener optionalListener= new BriefListener();
        //The Date and Time can be spoken by any of the selected voices
        //SimpleDateFormat formatter = new SimpleDateFormat("h mm");

        String dateText = " Welcome To Gizmo , Store.";

        if(getTime().endsWith("AM"))
        {
            dateText="Good Morning. "+dateText;
        }
        else
        {
            int a = Integer.parseInt(getTime().substring(0,2));
            if(a>16)
            {
                dateText="Good Evening. "+dateText;
            }
            else
            {
                dateText="Good Afternoon. "+dateText;
            }
        }
    
       // System.out.println(formatter.format(new Date()));
        //String dateText = "The time is now " + formatter.format(new Date());
        briefExample.speakTextSynchronously(dateText, optionalListener);
        try{new Thread().sleep(50);}catch(Exception asd){}
        //General text like this can only be spoken by general voices
        if (briefExample.isModeGeneral())
        {
            //speak plain text
            

        }
     briefExample.deallocateSynthesizer();
    }

    private void selectVoice(Voice voice) {
        try {
            synthesizer.getSynthesizerProperties().setVoice(voice);
        } catch (Exception e) {}
    }

    private void resumeSynthesizer() {
        try {
            //leave the PAUSED state, see state diagram
            synthesizer.resume();
        } catch (Exception e) {  exit(e);        }
    }

    private void pauseSynthesizer() {
        try {
            //leave the PAUSED state, see state diagram
            synthesizer.pause();
        } catch (Exception e) {  exit(e);        }
    }
    private void allocateSynthesizer() {
        //ensure that we only do this when in the DEALLOCATED state
        if ((synthesizer.getEngineState()&Synthesizer.DEALLOCATED)!=0)
        {
            try {
                //this call may take significant time

                synthesizer.getEngineState();
                synthesizer.allocate();
            } catch (Exception e) {}
        }
    }

    private void deallocateSynthesizer() {
        //ensure that we only do this when in the ALLOCATED state
        if ((synthesizer.getEngineState()&Synthesizer.ALLOCATED)!=0)
        {
            try {
                //free all the resources used by the synthesizer
                synthesizer.deallocate();
            } catch (Exception e) {}
        }
    }

    private void exit(Exception e) {
        e.printStackTrace();
        deallocateSynthesizer();
        System.exit(1);
    }
    private void createSynthesizer(SynthesizerModeDesc modeDesc) {
        try {
            //Create a Synthesizer with specified required properties.
            //if none can be found null is returned.
            synthesizer = Central.createSynthesizer(modeDesc);
        }
        catch (Exception e1) {}

        if (synthesizer==null)
        {
            System.out.println("Unable to create synthesizer with " +
                                "the required properties");
            System.out.println();
            System.out.println("Be sure to check that the \"speech.properties\"" +
                               " file is in one of these locations:");
            System.out.println("  user.home     : "+System.getProperty("user.home"));
            System.out.println("  java.home/lib : "+System.getProperty("java.home")
                                +File.separator+"lib");
            System.out.println();
            System.exit(1);
        }
    }
    private boolean isModeGeneral()
    {
        String mode=this.synthesizer.getEngineModeDesc().getModeName();
        return "general".equals(mode);
    }
    private void speakSpeakableSynchronously(
                                    Speakable speakable,
                                    SpeakableListener optionalListener) {

        try {
            this.synthesizer.speak(speakable, optionalListener);
        } catch (Exception e) {
            exit(e);
        }

        try {
            //wait for the queue to empty
            this.synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

        } catch (Exception e) {}
    }
    private void speakTextSynchronously(String plainText,SpeakableListener optionalListener)
    {
        this.synthesizer.speakPlainText(plainText, optionalListener);
        try {
            //wait for the queue to empty
            this.synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

        } catch (Exception e) {}
    }

    private String genderToString(int gender) {
        switch (gender) {
        case Voice.GENDER_FEMALE:
            return "Female";
        case Voice.GENDER_MALE:
            return "Male";
        case Voice.GENDER_NEUTRAL:
            return "Neutral";
        case Voice.GENDER_DONT_CARE:
        default:
            return "Unknown";
        }
    }

   
    public void listAllVoices() {
        System.out.println();
        System.out.println("All available JSAPI Synthesizers and Voices:");

        //Do not set any properties so all the synthesizers will be returned
        SynthesizerModeDesc emptyDesc = new SynthesizerModeDesc();
        EngineList engineList = Central.availableSynthesizers(emptyDesc);
        //loop over all the synthesizers
        for (int e = 0; e < engineList.size(); e++) {
            SynthesizerModeDesc desc = (SynthesizerModeDesc) engineList.get(e);
            //loop over all the voices for this synthesizer
            Voice[] voices = desc.getVoices();
            for (int v = 0; v < voices.length; v++) {
                System.out.println(
                        desc.getEngineName()+
                        "  Voice:"+voices[v].getName()+
                        " Gender:"+genderToString(voices[v].getGender()));
            }
        }
        System.out.println();
    }

    private static void copyfile(String srFile, String dtFile){
    try{
      File f1 = new File(srFile);
      File f2 = new File(dtFile);
      InputStream in = new FileInputStream(f1);

      //For Append the file.
//      OutputStream out = new FileOutputStream(f2,true);

      //For Overwrite the file.
      OutputStream out = new FileOutputStream(f2);

      byte[] buf = new byte[1024];
      int len;
      while ((len = in.read(buf)) > 0){
        out.write(buf, 0, len);
      }
      in.close();
      out.close();
    }
    catch(Exception ex){}
  }


    public static String getTime()
        {
            Date date = new Date();
            String strDateFormat = "HH:mm:ss a";

            SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);

            return sdf.format(date);
        }

}
