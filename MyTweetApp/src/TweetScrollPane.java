
import java.awt.Color;
import java.net.MalformedURLException;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import twitter4j.TwitterException;

public class TweetScrollPane extends JPanel
{
    JScrollPane jScrollPane1;
    public TweetScrollPane() throws TwitterException, MalformedURLException
    {
        jScrollPane1 = new javax.swing.JScrollPane();

        jScrollPane1.setMaximumSize(new java.awt.Dimension(500, 350));
        jScrollPane1.setMinimumSize((new java.awt.Dimension(500, 350)));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 350));
        jScrollPane1.setBorder(BorderFactory.createLineBorder(Color.black));
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // set leftPane as the scrollable component
        Tweets t = new Tweets();
        jScrollPane1.setViewportView(t);
        t.revalidate();
        add(jScrollPane1);
    }
}
