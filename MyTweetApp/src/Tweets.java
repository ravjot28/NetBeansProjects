import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.http.AccessToken;

class Tweets extends JPanel
{
    public Tweets() throws TwitterException, MalformedURLException
    {
        initComponents();
    }

    private void initComponents() 
    {
        try {
            TwitterFactory factory = new TwitterFactory();
            Twitter twitter = factory.getInstance();
            twitter.setOAuthConsumer("M5M678z6ZsD7C7l0dmA", "TBedi2OaAuUXPNPaliBbYj3KPsDA1V6Fpe1BrXu29E");
            AccessToken accessToken = loadAccessToken(1);
            twitter.setOAuthAccessToken(accessToken);
            User u = twitter.showUser(twitter.verifyCredentials().getId());
            String temp = u.getStatus().toString();
            String displayName = u.getName();
            String temp1 = temp.substring(temp.indexOf("text='"));
            String currentStatus = temp1.substring(0, temp1.indexOf("',"));
            String location = u.getLocation();
            int friendCount = u.getFriendsCount();
            List<Status> statuses = twitter.getHomeTimeline();
            Tweet[] p = new Tweet[statuses.size()];
            System.out.println(statuses.size());
            setLayout(new GridLayout(statuses.size(), 0, 0, 2));
            int i = 0;
            for (Status status1 : statuses) {
                String image = status1.getUser().getProfileImageURL().toString();
                String uname = status1.getUser().getName();
                String st = status1.getText().trim();
                URL where = new URL(image);
                ImageIcon anotherIcon = new ImageIcon(where);
                p[i] = new Tweet(anotherIcon, uname, st);
                add(p[i]);
                i++;
            }
        } catch (Exception ex) {
           System.out.println("Tweets "+ex);
        }
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
