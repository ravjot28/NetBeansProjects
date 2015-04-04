import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;


public class GTBITWebsiteEvents
{
        static String URL;

	public GTBITWebsiteEvents(String url)
        {
            this.URL = url;
	}

        public String getPage()
        {
            String temp="";
            try
            {
                URL google = new URL(this.URL);
                URLConnection yc = google.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                {
                    String t = inputLine.replaceAll("\\<.*?\\>", "");
                    if(t.trim().equalsIgnoreCase("Latest Events"))
                    {
                        while ((inputLine = in.readLine()) != null)
                        {
                            String t1 = inputLine.replaceAll("\\<.*?\\>", "");
                            if(t1.trim().equalsIgnoreCase("&nbsp;"))
                            {
                                return temp;
                            }
                            else
                            {
                                temp = temp + inputLine +"\n";
                            }
                        }
                    }

                }
                in.close();
                return temp;
            } catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null, "Oops!! Internet Connection Problem.", "Error",JOptionPane.ERROR_MESSAGE);

                    return temp;
            }


        }

        public String[] getEvents()
        {
            GTBITWebsiteEvents gw = new GTBITWebsiteEvents("http://www.gtbit.org");
            String page = gw.getPage();
            StringTokenizer st = new StringTokenizer(page,"\n");
            String t = st.nextToken();
            String main = st.nextToken();
            String newString = main.replaceAll("<div align=right><i>", "\n");
            newString = newString.replaceAll("\\<.*?\\>", "");
            StringTokenizer ss = new StringTokenizer(newString,"\n");
            String news[] = new String[ss.countTokens()];
            int i=0;
            while(ss.hasMoreTokens())
            {
                news[i] = ss.nextToken();
                i++;
            }
            return news;
        }

}