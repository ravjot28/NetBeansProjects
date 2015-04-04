import java.io.IOException;
import com.google.code.facebookapi.Attachment;
import com.google.code.facebookapi.AttachmentMediaImage;
import com.google.code.facebookapi.FacebookException;
import com.google.code.facebookapi.FacebookJsonRestClient;
import org.apache.commons.httpclient.HttpException;

public class SendtoFacebook1
{

	
	public void send(String message)throws FacebookException, HttpException, IOException
        {
                String url=message;
                String img=new youtubethumbnail().thumb(url);
		String FB_APP_API_KEY ="bf1dc101af67d6055b1555d5e8f9d505";
		String FB_APP_SECRET ="d80bb51d4e86e782f392bf65be2a9e50";
		String FB_SESSION_KEY ="699c554835e50f771834b038-724135591";//new Login().login("bf1dc101af67d6055b1555d5e8f9d505","d80bb51d4e86e782f392bf65be2a9e50", "ravjot28@gmail.com", "ravjotsingh71");
                System.out.println(FB_SESSION_KEY);
		FacebookJsonRestClient facebook = new FacebookJsonRestClient( FB_APP_API_KEY, FB_APP_SECRET, FB_SESSION_KEY );
		//FacebookJsonRestClient facebookClient2 = (FacebookJsonRestClient)facebook.getFacebookRestClient();
		FacebookJsonRestClient facebookClient = (FacebookJsonRestClient)facebook;
		Attachment attachment = new Attachment();
		attachment.setCaption("Youtube");
		attachment.setDescription("Youtube");
		attachment.setHref(url);
		attachment.setName(";)");

		AttachmentMediaImage  attach_media = new AttachmentMediaImage(img,url);

		attachment.setMedia(attach_media);

		facebookClient.stream_publish("", attachment, null, null, null);

			System.out.println("successfully updated");
	}
}