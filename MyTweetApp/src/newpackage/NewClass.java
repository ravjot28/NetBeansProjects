package newpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import javax.swing.ImageIcon;
import twitter4j.PagableResponseList;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.http.AccessToken;
import twitter4j.http.RequestToken;

public class NewClass
{
   /* public static void main(String args[]) throws Exception
    {
        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer("M5M678z6ZsD7C7l0dmA", "TBedi2OaAuUXPNPaliBbYj3KPsDA1V6Fpe1BrXu29E");
        RequestToken requestToken = twitter.getOAuthRequestToken();
        AccessToken accessToken = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (null == accessToken)
        {
            System.out.println("Open the following URL and grant access to your account:");
            System.out.println(requestToken.getAuthorizationURL());
            System.out.print("Enter the PIN(if aviailable) or just hit enter.[PIN]:");
            String pin = br.readLine();
            try
            {
                if(pin.length() > 0)
                {
                    accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                }
                else
                {
                    accessToken = twitter.getOAuthAccessToken();
                }
            } catch (TwitterException te)
              {
                if(401 == te.getStatusCode())
                {
                    System.out.println("Unable to get the access token.");
                }
                else
                {
                    te.printStackTrace();
                }
              }
        }

        System.out.println(accessToken.getToken()+","+accessToken.getTokenSecret());
        //persist to the accessToken for future reference.
        storeAccessToken(accessToken);
        twitter4j.Status status =twitter.updateStatus("Ravjot Testing time :)");
        //    System.out.println("Successfully updated the status to [" + status.getText() + "].");
        System.exit(0);
  }

  private static void storeAccessToken(AccessToken accessToken)
  {
        String token= accessToken.getToken();
        String secretToken = accessToken.getTokenSecret();
        
  }*/


  
    public static void main(String args[]) throws Exception
    {
    // The factory instance is re-useable and thread safe.
    TwitterFactory factory = new TwitterFactory();
    Twitter twitter = factory.getInstance();
    twitter.setOAuthConsumer("M5M678z6ZsD7C7l0dmA", "TBedi2OaAuUXPNPaliBbYj3KPsDA1V6Fpe1BrXu29E");
    AccessToken accessToken = loadAccessToken(1);
    twitter.setOAuthAccessToken(accessToken);
    //twitter4j.Status status = twitter.updateStatus("Testing Radsfasdfdsafasdfsadfav");
    //System.out.println("Successfully updated the status to [" + status.getText() + "].");
    User u = twitter.showUser(twitter.verifyCredentials().getId());
    String temp = u.getStatus().toString();;
    String displayName = u.getName();
    String temp1 = temp.substring(temp.indexOf("text='"));
    String currentStatus = temp1.substring(0,temp1.indexOf("',"));
    String location = u.getLocation();
    int friendCount = u.getFriendsCount();
    System.out.println("Profile pic "+u.getProfileBackgroundImageUrl());
   /* String image = u.getProfileImageURL().toString();
    URL where = new URL(image);
    ImageIcon anotherIcon = new ImageIcon(where);*/
    System.out.println("Display Name "+displayName);
    System.out.println("No. Of Friends "+friendCount);
    System.out.println("Location "+location);
    System.out.println("Current Status"+ currentStatus.replaceAll("'","") );
    List<Status> statuses = twitter.getHomeTimeline();
    for(Status status1: statuses)
    {
        System.out.println(status1.getUser().getProfileImageURL()+status1.getUser().getName()+" --> "+ status1.getText());
    }
    System.exit(0);
  }
   private static AccessToken loadAccessToken(int useId)
    {
        String token = null;
        String tokenSecret = null;
        try
        {
              BufferedReader b = new BufferedReader(new FileReader("Bin/Data/User_Para/UserInfo.ravs"));
              token = b.readLine();
              tokenSecret = b.readLine();
            b.close();
        }catch(Exception e){}
        if((token.equalsIgnoreCase(null))&&(tokenSecret.equalsIgnoreCase(null)))
        {
              return null;
        }
        return new AccessToken(token, tokenSecret);
    }
   

}
