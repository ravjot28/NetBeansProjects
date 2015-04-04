import java.io.*;
import org.blinkenlights.jid3.*;

public class ID3Test
{
    public String[] gettag(String song)
    {
        try
        {
        File oSourceFile = new File(song);
        MediaFile om = new MP3File(oSourceFile);
        ID3Tag[] t;
        t = om.getTags();
        String tag[]=new String[t.length];
            for (int i = 0; i < t.length; i++)
            {
                tag[i]=(t[i]).toString();
            }

        return tag;
        } catch (ID3Exception ex) {       }
        return null;
    }
}
