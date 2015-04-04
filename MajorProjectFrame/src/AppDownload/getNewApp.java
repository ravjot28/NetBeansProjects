package AppDownload;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class getNewApp
{
    String serverApps[];
    String apps[];
    ArrayList<String> array;
    String[] currentApps;

    public getNewApp()
    {
        array = new ArrayList();
        serverApps = getFromServer();
        currentApps = getFromLocal();
    }

    public boolean check()
    {
        if(serverApps[0].equalsIgnoreCase("no"))
            return false;
        
        return true;
    }

    public String[] getFromServer()
    {
        ReadRequest rr = new ReadRequest("rapplicationstore@gmail.com","docomo3401");
        return rr.startreading();
    }

    public String[] getFromLocal()
    {
        String capp[] = new String[getNumberOfLines("Bin\\Data\\totalapps.ravs")];
        try
        {
            BufferedReader b = new BufferedReader(new FileReader("Bin\\Data\\totalapps.ravs"));
            for(int i=0;i<capp.length;i++)
            {
                capp[i] = b.readLine();
            }
            b.close();
            return capp;
        }catch(Exception ae){}
        return null;
    }

    public String[] getApp()
    {
        for(int i=0;i<serverApps.length;i++)
        {
            StringTokenizer st = new StringTokenizer(serverApps[i],"!!");
            String appDetails = st.nextToken();
            StringTokenizer st1 = new StringTokenizer(appDetails,"**");
            appDetails = st1.nextToken()+"##"+st1.nextToken();
            String appDownloadLink = st.nextToken();

            if(check(appDetails))
            {
                array.add(appDetails+"!!"+appDownloadLink);
            }
        }
        apps = new String[array.size()];

        for(int j=0;j<apps.length;j++)
            apps[j] = array.get(j);

        return apps;
    }

    public boolean check(String s)
    {
        for(int i=0;i<currentApps.length;i++)
        {
            if(currentApps[i].equals(s))
                return false;
        }
        return true;
    }

     public int getNumberOfLines(String name)
     {
	int numberOfLines = 0;
	LineNumberReader lineCounter = null;
	try
        {
            lineCounter = new LineNumberReader(new FileReader(name));
            while ((lineCounter.readLine()) != null)
            {
                continue;
            }
            numberOfLines = lineCounter.getLineNumber();
	} catch (IOException e)
           {}
	return numberOfLines;
     }

     public void print()
     {
        for(int i=0;i<apps.length;i++)
            System.out.println(apps[i]);
     }
}
