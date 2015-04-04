
import java.io.IOException;
import java.util.StringTokenizer;


public class wiki
{
    String l;

    wiki(String lin) throws IOException
    {
        l=lin;
        String result="";
        StringTokenizer s=new StringTokenizer(lin," ");
        while(s.hasMoreTokens())
        {
            result=result+s.nextToken()+"+";
        }
        result=result.substring(0,result.length()-1);

        System.out.println(result);
        String link="http://www.google.co.in/#sclient=psy&hl=en&site=&source=hp&q="+result+"&aq=f&aqi=g5&aql=&oq=&pbx=1&fp=1e96ebb05fbca34f";
                //"http://en.wikipedia.org/wiki/Special:Search?search="+result+"&go=Go";
        String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler" + " " + link;
        Process p = Runtime.getRuntime().exec(cmd);

    }

}
