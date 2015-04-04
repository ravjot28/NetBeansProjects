package gtbitnews;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class WebsiteReader
{
    public static BufferedReader read(String url)
    {
        try
        {
            return new BufferedReader(new InputStreamReader(new URL(url).openStream()));
        }catch(Exception as)
        {
            return null;
        }
    }
}
