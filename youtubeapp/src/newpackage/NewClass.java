package newpackage;
import com.google.gdata.client.youtube.*;
import com.google.gdata.data.geo.impl.*;
import com.google.gdata.data.media.*;
import com.google.gdata.data.media.mediarss.*;
import com.google.gdata.data.youtube.*;
import com.google.gdata.util.*;
import java.io.IOException;
import java.io.File;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewClass implements Runnable
{
    VideoEntry createdEntry;
    boolean finsih=false;
    Thread th=new Thread(this);

    NewClass(String uname,String pswd,String title,String[] keyword,String description,String url,String publ )
    {
        YouTubeService service = new YouTubeService("RavSofts", "AI39si4TqWxCGARTlgkBiKnmx7s_0cEIoM9XxWqjX1fdzqgNH4u-LCXGvJOUd-I3rKITK-hgmE2EVA0Zn9CbEcmJQLsJjXrtIw");
        try {
            service.setUserCredentials(uname, pswd);
        } catch (AuthenticationException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        VideoEntry newEntry = new VideoEntry();

        YouTubeMediaGroup mg = newEntry.getOrCreateMediaGroup();
        mg.setTitle(new MediaTitle());
        mg.getTitle().setPlainTextContent(title);
        mg.addCategory(new MediaCategory(YouTubeNamespace.CATEGORY_SCHEME, "Autos"));
        mg.setKeywords(new MediaKeywords());
        for(int i=0;i<keyword.length;i++)
        {
            mg.getKeywords().addKeyword(keyword[i]);
        }
        mg.setDescription(new MediaDescription());
        mg.getDescription().setPlainTextContent(description);
        if(publ.equalsIgnoreCase("private"))
        {
            mg.setPrivate(true);
        }
        else
        {
            mg.setPrivate(false);
        }
        
        mg.addCategory(new MediaCategory(YouTubeNamespace.DEVELOPER_TAG_SCHEME, "mydevtag"));
        mg.addCategory(new MediaCategory(YouTubeNamespace.DEVELOPER_TAG_SCHEME, "anotherdevtag"));

        newEntry.setGeoCoordinates(new GeoRssWhere(37.0,-122.0));
        // alternatively, one could specify just a descriptive string
        // newEntry.setLocation("Mountain View, CA");

        MediaFileSource ms = new MediaFileSource(new File(url), "video/quicktime");
        newEntry.setMediaSource(ms);

        String uploadUrl ="http://uploads.gdata.youtube.com/feeds/api/users/default/uploads";
        createdEntry=new VideoEntry();
        try {
            createdEntry = service.insert(new URL(uploadUrl), newEntry);
        } catch (IOException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServiceException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
    }

    public void run()
    {
        try
        {
            Thread.sleep(1000);
            System.out.println("Sleep");
        }catch(Exception as){}
        while(true)
        {
            System.out.println("while");
        if(createdEntry.isDraft())
        {
            System.out.println("Video is not live");
            YtPublicationState pubState = createdEntry.getPublicationState();
            if(pubState.getState() == YtPublicationState.State.PROCESSING)
            {
                System.out.println("Video is still being processed.");
            }
            else
                if(pubState.getState() == YtPublicationState.State.REJECTED)
                {
                    System.out.print("Video has been rejected because: ");
                    System.out.println(pubState.getDescription());
                    System.out.print("For help visit: ");
                    System.out.println(pubState.getHelpUrl());
                    finsih=true;
                }
                else
                    if(pubState.getState() == YtPublicationState.State.FAILED)
                    {
                        System.out.print("Video failed uploading because: ");
                        System.out.println(pubState.getDescription());
                        System.out.print("For help visit: ");
                        System.out.println(pubState.getHelpUrl());
                        finsih=true;
                    }
                    else
                    {
                        System.out.println("DOing");
                    }
            }
        }
    }
}
