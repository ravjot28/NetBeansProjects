package support;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class CheckInternetConnection
{
    public boolean process()
    {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new URL("http://www.google.com").openStream()));
            return true;
        } catch (Exception ex)
        {
            return false;
        }
    }
}
