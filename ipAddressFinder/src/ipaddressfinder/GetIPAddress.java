package ipaddressfinder;

import java.io.*;
import java.net.URL;

public class GetIPAddress
{
    public static BufferedReader read(String url) throws Exception
    {
        return new BufferedReader(new InputStreamReader(new URL(url).openStream()));
    }

    public String process()
    {
        BufferedReader reader = null;
        String ipadd = null ;
        try
        {
            reader = read("http://whatismyipaddress.com/");
            String line = reader.readLine();
            while (line != null) 
            {
                if(line.trim().indexOf("IP Information:") >= 0)
                {
                    line = reader.readLine();
                    ipadd= (line.replaceAll("\\<.*?>", "").trim());
                    break;
                }
                line = reader.readLine();
            }
        } catch (Exception ex)
        {
            
        }

        return (ipadd);
   }
}

