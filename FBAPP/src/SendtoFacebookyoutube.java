import java.io.IOException;
import com.google.code.facebookapi.Attachment;
import com.google.code.facebookapi.AttachmentMediaImage;
import com.google.code.facebookapi.FacebookException;
import com.google.code.facebookapi.FacebookJsonRestClient;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.commons.httpclient.HttpException;

public class SendtoFacebookyoutube
{
	public String send(String message,String url)throws FacebookException, HttpException, IOException
        {
                String img=new youtubethumbnail().thumb(url);
		String FB_APP_API_KEY ="bf1dc101af67d6055b1555d5e8f9d505";
		String FB_APP_SECRET ="d7fa471e7d7b5e2b16e6d2cd1bfd7d5d";
                String FB_SESSION_KEY="";
		 File p=new File("Bin/AppID/id.ravs");

            String rav="";
            BufferedReader f=new BufferedReader(new FileReader("Bin/AppID/id.ravs"));
            try
            {
                rav=f.readLine();
            }catch(Exception asd){}
             System.out.println(rav);
            FB_SESSION_KEY=rav;
            System.out.println( FB_SESSION_KEY);

		FacebookJsonRestClient facebook = new FacebookJsonRestClient( FB_APP_API_KEY, FB_APP_SECRET, FB_SESSION_KEY );
		//FacebookJsonRestClient facebookClient2 = (FacebookJsonRestClient)facebook.getFacebookRestClient();
		FacebookJsonRestClient facebookClient = (FacebookJsonRestClient)facebook;
		Attachment attachment = new Attachment();
		attachment.setCaption("Youtube");
		attachment.setDescription("Published from Rav Facebook App");
		attachment.setHref(url);
		attachment.setName("Rav Youtube App");

		AttachmentMediaImage  attach_media = new AttachmentMediaImage(img,url);

		attachment.setMedia(attach_media);

		facebookClient.stream_publish(message, attachment, null, null, null);

			return "successfully updated";
	}
}