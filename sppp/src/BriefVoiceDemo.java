import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
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
        
        SynthesizerModeDesc modeDesc = new SynthesizerModeDesc(
                null,       
                "general",  
                Locale.US,  
                null,       
                null);      

        
        Voice voice = new Voice(
                "kevin16",              
                 Voice.AGE_NEUTRAL,   
                 Voice.GENDER_MALE,
                 null);            

        boolean error=false;

        BriefVoiceDemo briefExample = new BriefVoiceDemo();
        
        briefExample.createSynthesizer(modeDesc);
        
        briefExample.allocateSynthesizer();

        
        briefExample.resumeSynthesizer();

        
        briefExample.selectVoice(voice);

        SpeakableListener optionalListener= new BriefListener();

         String strDateFormat = "HH:mm:ss a";
     SimpleDateFormat formatter = new SimpleDateFormat(strDateFormat);
     String p=formatter.format(new Date()).toString();

     
     String dateText="";
     if(p.substring(p.lastIndexOf(" ")).trim().equalsIgnoreCase("am"))
     {
         dateText="Good Morning";
     }
 else
     {
        dateText="Good Afternoon";
    }

     
        briefExample.speakTextSynchronously(dateText, optionalListener);
        try{new Thread().sleep(50);}catch(Exception asd){}
        
        if (briefExample.isModeGeneral())
        {
            
            try
            {
                BufferedReader b=new BufferedReader(new FileReader("speech.ravs"));
                String data=b.readLine();
                while(data!=null)
                {
                    String plainText =data;
                    
                    briefExample.speakTextSynchronously(plainText, optionalListener);
                    try{new Thread().sleep(50);}catch(Exception asd){}
                    data=b.readLine();
                }
                }catch(Exception asd){}
            
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
            
            synthesizer.resume();
        } catch (Exception e) {  exit(e);        }
    }

    private void pauseSynthesizer() {
        try {
            
            synthesizer.pause();
        } catch (Exception e) {  exit(e);        }
    }


    private void allocateSynthesizer() {
        
        if ((synthesizer.getEngineState()&Synthesizer.DEALLOCATED)!=0)
        {
            try {
                

                synthesizer.getEngineState();
                synthesizer.allocate();
            } catch (Exception e) {}
        }
    }

    private void deallocateSynthesizer() {
        
        if ((synthesizer.getEngineState()&Synthesizer.ALLOCATED)!=0)
        {
            try {
                
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

        
        SynthesizerModeDesc emptyDesc = new SynthesizerModeDesc();
        EngineList engineList = Central.availableSynthesizers(emptyDesc);
        
        for (int e = 0; e < engineList.size(); e++) {
            SynthesizerModeDesc desc = (SynthesizerModeDesc) engineList.get(e);


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
}
