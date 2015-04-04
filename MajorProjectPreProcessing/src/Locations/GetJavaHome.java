package Locations;

import OS.GetOSType;
import java.io.File;
import java.util.StringTokenizer;

public class GetJavaHome
{
    public String getLocation()
    {
        String javaHome = System.getProperty("java.home");
        GetOSType g = new GetOSType();
        String OS = g.getOS();

        if(OS.equalsIgnoreCase("win"))
        {
            StringTokenizer s = new StringTokenizer(javaHome,"\\");
            String temp="";
            while(s.hasMoreElements())
            {
                String token = s.nextToken();
                if(token.contains("jdk"))
                {
                    break;
                }
                temp+=token+"\\";
            }
            File list = new File(temp);
            String l[] = list.list();
            for(int i=0;i<l.length;i++)
            {
                if(new File(temp+l[i]).isDirectory())
                {
                    if(l[i].contains("jre"))
                    {
                        temp+=l[i];
                    }
                }
            }
            return temp;
        }

        return(javaHome);
    }
}
