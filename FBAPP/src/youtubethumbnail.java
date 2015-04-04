
import java.io.IOException;

public class youtubethumbnail
{
    public String thumb(String url) throws IOException
    {
        String v;
        String v1;
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

