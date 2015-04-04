import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import ravrun.Rav;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.http.AccessToken;
import twitter4j.http.RequestToken;


public class FirstLogin extends JFrame implements Runnable
{
    Thread th = new Thread(this);

    JButton jButton1;
    JButton jButton2;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JTextField jTextField1;
    String mess="";

    public final static String del="img/signUpBg.png";
    URL dele=getClass().getClassLoader().getResource(del);

    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    private InfiniteProgressPanel glassPane;

    public final static String tweetlogo="img/tweetlogo.png";
    URL logo=getClass().getClassLoader().getResource(tweetlogo);

    public final static String l="img/r.gif";
    URL ll=getClass().getClassLoader().getResource(l);

    final Image cursorImage = new ImageIcon(logo).getImage();
    final Point hotspot = new Point(0, 0);
    final String name = "My Cursor";
    
    Twitter twitter = new TwitterFactory().getInstance();
    RequestToken requestToken = null;
    AccessToken accessToken = null;
    final String netprob="api.twitter.comTwitterException{exceptionCode=[68a00bf1-d29b9461 68a00bf1-d29b9436], statusCode=-1, retryAfter=0, rateLimitStatus=null, version=2.1.6";
    final String netprob1="No route to hostTwitterException{exceptionCode=[fa54b184-3c00ee2e fa54b184-3c00ee03], statusCode=-1, retryAfter=0, rateLimitStatus=null, version=2.1.6";

    public FirstLogin()
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(ll));
        try
        {
            twitter.setOAuthConsumer("M5M678z6ZsD7C7l0dmA", "TBedi2OaAuUXPNPaliBbYj3KPsDA1V6Fpe1BrXu29E");
            requestToken = twitter.getOAuthRequestToken();
        }catch(Exception ae)
            {
                if(ae.toString().contains(netprob))
                {
                    JOptionPane.showMessageDialog(null,"OOPS!! there is problem in your net connection.","Erro",JOptionPane.ERROR_MESSAGE);
                }
            }
        initComponents();
    }
    
    private void initComponents()
    {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jButton1 = new JButton();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jButton2 = new JButton();
        jLabel4 = new JLabel();

        this.glassPane = new InfiniteProgressPanel();
        setCursor(getToolkit().createCustomCursor(cursorImage, hotspot, name));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(520, 432));
        setMinimumSize(new Dimension(520, 432));
        setPreferredSize(new Dimension(520, 432));
        getContentPane().setLayout(null);
        setGlassPane(glassPane);

        jLabel1.setFont(new Font("Zapfino", 1, 24));
        jLabel1.setText("R Tweet");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 10, 140, 82);

        jLabel2.setFont(new Font("American Typewriter", 1, 16));
        jLabel2.setText("Get PIN");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(240, 140, 64, 21);

        jButton1.setText("@ URL");
        getContentPane().add(jButton1);
        jButton1.setBounds(310, 160, 83, 29);
        jButton1.addActionListener(new ActionListener()
                                            {
                                                public void actionPerformed(ActionEvent ae)
                                                {
                                                    Rav r = new Rav(requestToken.getAuthorizationURL());
                                                    r.execute();
                                                }
                                            });

        jLabel3.setFont(new Font("American Typewriter", 1, 16));
        jLabel3.setText("Enter PIN");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(188, 300, 90, 21);

        jTextField1.setFont(new Font("Comic Sans MS", 1, 16));
        getContentPane().add(jTextField1);
        jTextField1.setBounds(290, 290, 143, 30);
        jTextField1.addKeyListener(new KeyAdapter()
                    {
                        public void keyTyped(KeyEvent e)
                        {
                            String text = jTextField1.getText();
                            int length = text.length();
                            if(length>0)
                            {
                                jButton2.setVisible(true);
                            }
                            else
                            {
                                jButton2.setVisible(false);
                            }
                        }
                    });

        jButton2.setText("Verify");
        jButton2.setVisible(false);
        getContentPane().add(jButton2);
        jButton2.setBounds(350, 330, 80, 29);
        jButton2.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent ae)
                                            {
                                                glassPane.start();
                                                if(true)
                                                {
                                                    String pin = jTextField1.getText().trim();
                                                    try
                                                    {
                                                        if(pin.length() > 0)
                                                        {

                                                            th.start();
                                                            accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                                                        }
                                                        else
                                                        {

                                                            th.start();
                                                            accessToken = twitter.getOAuthAccessToken();
                                                        }
                                                        storeAccessToken(accessToken);
                                                         glassPane.stop();
                                                    } catch (TwitterException te)
                                                      {
                                                        if(401 == te.getStatusCode())
                                                        {
                                                            glassPane.stop();
                                                            JOptionPane.showMessageDialog(null,"Unable to get the access token. Take new PIN","Error",JOptionPane.ERROR_MESSAGE);
                                                        }
                                                        else
                                                        {
                                                            mess=te.toString();
                                                            JOptionPane.showMessageDialog(null,"Sending Report to the developers. Please Wait..","Error",JOptionPane.ERROR_MESSAGE);
                                                        }
                                                      }
                                                    }
                                                    else
                                                    {
                                                        JOptionPane.showMessageDialog(null,"OOPS!! there is problem in your net connection.","Erro",JOptionPane.ERROR_MESSAGE);
                                                        jTextField1.setText("");
                                                        jButton2.setVisible(false);
                                                    }
                                                }
                                            });

        jLabel4.setIcon(new ImageIcon(dele));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 520, 410);

        setLocation(h/2,w/7);
        setResizable(false);
        pack();
    }

    void storeAccessToken(AccessToken accessToken)
    {
        String token= accessToken.getToken();
        String secretToken = accessToken.getTokenSecret();

        try
        {
            BufferedWriter b = new BufferedWriter(new FileWriter("Bin/Data/User_Para/UserInfo.ravs"));
            b.append(token);
            b.newLine();
            b.append(secretToken);
            b.close();
        }catch(Exception s)
         {   }
        dispose();
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new TweetFrame().setVisible(true);
            }
        });
    }

    public void run()
    {
        Rav r = new Rav("Splash.jar");
        r.execute();
    }
}
