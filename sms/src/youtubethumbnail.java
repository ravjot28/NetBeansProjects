
import java.io.IOException;

public class youtubethumbnail
{
    public String thumb(String url) throws IOException
    {
        String v;
        String v1;
        //String url="http://www.youtube.com/watch?v=ptbcZPUUozk&feature=topvideos";
        //String url="http://www.youtube.com/watch?v=aemXgP-2xyg";
        //String url="http://www.youtube.com/watch?v=J61PCcJVbRI";
        //String url="http://www.youtube.com/watch?v=f1WyyvNo1Sc&feature=player_embedded";
        //String url="http://www.youtube.com/watch?v=dugXl4O6lyY";
        try
        {
            v=url.substring(url.lastIndexOf("?v=")+3,url.lastIndexOf("&"));
            v1="http://img.youtube.com/vi/"+v+"/3.jpg";
        }catch(Exception asd){v=url.substring(url.lastIndexOf("?v=")+3);
                                v1="http://img.youtube.com/vi/"+v+"/3.jpg";
                                   }
       return v1;
    }
}
    
