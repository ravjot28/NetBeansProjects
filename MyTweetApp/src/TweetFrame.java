import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;
import ravrun.Rav;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.http.AccessToken;
import java.io.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.net.MalformedURLException;
import java.net.URL;

public class TweetFrame extends JFrame implements Runnable
{

    JButton jButton1;
    JButton jButton2;
    JButton jButton3;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JScrollPane jScrollPane1;
    JTextArea jTextArea1;

    String uname;
    ImageIcon img;
    String status;
    JFrame frame ;
    TaskPaneExample1 task;

    private InfiniteProgressPanel glassPane;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    int width;
    static int rav=0;

     public final static String del="img/delete.png";
     URL dele=getClass().getClassLoader().getResource(del);

     public final static String bg="img/bg.png";
     URL bg1=getClass().getClassLoader().getResource(bg);
     
     public final static String tweetlogo="img/tweetlogo.png";
     URL logo=getClass().getClassLoader().getResource(tweetlogo);

     public final static String l="img/r.gif";
    URL ll=getClass().getClassLoader().getResource(l);

    Thread thread = new Thread(this);
    TwitterFactory factory = new TwitterFactory();
    Twitter twitter = factory.getInstance();
    String netprob="api.twitter.comTwitterException{exceptionCode=[15bb6564-00e4d62e 15bb6564-00e4d603], statusCode=-1, retryAfter=0, rateLimitStatus=null, version=2.1.6";

    final Image cursorImage = new ImageIcon(logo).getImage();
    final Point hotspot = new Point(0, 0);
    final String name = "My Cursor";


    public TweetFrame()
    {
        Rav r = new Rav("Splash.jar");
        r.execute();
        twitter.setOAuthConsumer("M5M678z6ZsD7C7l0dmA", "TBedi2OaAuUXPNPaliBbYj3KPsDA1V6Fpe1BrXu29E");
        initComponents();
    }

    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        this.glassPane = new InfiniteProgressPanel();
        setIconImage(Toolkit.getDefaultToolkit().getImage(ll));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(480, 320));
        setMinimumSize(new Dimension(480, 320));
        setPreferredSize(new Dimension(480, 320));
        getContentPane().setLayout(null);
        setGlassPane(glassPane);
        setResizable(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setLineWrap(true);
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea1.setCursor(getToolkit().createCustomCursor(cursorImage, hotspot, name));
        jScrollPane1.setCursor(getToolkit().createCustomCursor(cursorImage, hotspot, name));
        jScrollPane1.setBorder(null);
        jTextArea1.addKeyListener(new KeyAdapter()
                    {
                        public void keyTyped(KeyEvent e)
                        {
                            String text = jTextArea1.getText();
                            int length = text.length();
                            if (length == 140)
                            {
                                e.consume();
                                jLabel3.setText("0");
                            }
                            else
                            if (length > 140)
                            {
                                jTextArea1.setText(text.substring(0, 141));
                                jLabel3.setText("0");
                            }
                            jLabel3.setText(""+(140-length));
                        }
                    });

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 60, 410, 90);

        jButton1.setText("Tweet");
        getContentPane().add(jButton1);
        jButton1.setBounds(390, 10, 81, 29);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 0, 0);
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent as)
                                        {
                                            if(jTextArea1.getText().length()<=0)
                                            {
                                                JOptionPane.showMessageDialog(null,"OOPS!! Empty Tweet","Erro",JOptionPane.ERROR_MESSAGE);
                                            }
                                            else
                                            {
                                                thread.start();
                                            }
                                        }
                                    });


        jLabel2.setFont(new java.awt.Font("Zapfino", 1, 18));
        jLabel2.setText("R Tweet");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(190, 0, 100, 61);

        jLabel3.setFont(new java.awt.Font("American Typewriter", 1, 13));
        jLabel3.setText("140");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(390, 170, 27, 17);

        jButton2.setText("Profile");
        getContentPane().add(jButton2);
        jButton2.setVisible(false);
        jButton2.setBounds(370, 250, 84, 29);
        jButton2.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            rav=2608;
                                            thread.start();
                                        }
                                    });

        
        setCursor(getToolkit().createCustomCursor(cursorImage, hotspot, name));
        ImageIcon image1 = new ImageIcon(dele);
        jButton3.setIcon(image1); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        getContentPane().add(jButton3);
        jButton3.setBounds(-10, 0, 60, 30);
        jButton3.setToolTipText("Delete Account");
        jButton3.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent as)
                                        {
                                            int answer = JOptionPane.showConfirmDialog(null, "You want to delete the current account?", "Delete Account", JOptionPane.YES_NO_OPTION);

                                            if (answer == JOptionPane.YES_OPTION)
                                            {
                                                try
                                                {
                                                    BufferedWriter b = new BufferedWriter(new FileWriter("Bin/Data/User_Para/UserInfo.ravs"));
                                                    b.append("");
                                                    b.close();
                                                    dispose();
                                                    new Main();
                                                    if(task.checkclose())
                                                    {
                                                        frame.dispose();
                                                    }
                                                }catch(Exception sd){}
                                            }
                                        }
                                    });
        ImageIcon image = new ImageIcon(bg1);
        jLabel4.setIcon(image); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 480, 320);

        setLocation(h/4,w/7);
        width=getWidth();
        pack();
        try
        {
            System.out.println("call");
            task=new TaskPaneExample1();
            System.out.println("called");
        } catch (Exception ex) {     System.out.println("Exception "+ex);               }
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

    public void create()
    {
        thread = new Thread(this);
    }

    public void run()
    {
        if(rav==2608)
        {
            glassPane.start();
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jTextArea1.setEnabled(false);
            try
            {
                task=new TaskPaneExample1();
            } catch (Exception ex) {

            }
            jButton2.setVisible(false);
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            jTextArea1.setEnabled(true);
            glassPane.stop();
            rav=0;
            create();
        }
 else
        {
        glassPane.start();
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jTextArea1.setEnabled(false);
        try
        {
            AccessToken accessToken = loadAccessToken(1);
            twitter.setOAuthAccessToken(accessToken);
            twitter4j.Status status = twitter.updateStatus(jTextArea1.getText().trim());

            JOptionPane.showMessageDialog(null,"Status Updated","Notification",JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
            try
        {
            task=new TaskPaneExample1();
        } catch (Exception ex) {                    }
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            jTextArea1.setEnabled(true);
            glassPane.stop();
        }catch(Exception sd)
            {
                if(sd.toString().contains(netprob))
                {
                    jButton1.setEnabled(true);
                    jButton2.setEnabled(true);
                    jTextArea1.setEnabled(true);
                    glassPane.stop();
                    JOptionPane.showMessageDialog(null,"OOPS!! there is problem in your net connection.","Erro",JOptionPane.ERROR_MESSAGE);
                }
                else
                if(sd.toString().contains("java.lang.NullPointerException"))
                {
                    glassPane.stop();
                    dispose();
                    JOptionPane.showMessageDialog(null,"OOPS!! Token expired or is corrupted kindly re login","Erro",JOptionPane.ERROR_MESSAGE);
                    new FirstLogin();
                }
            }
        jTextArea1.setText("");
        jLabel3.setText("140");
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jTextArea1.setEnabled(true);
        glassPane.stop();
        create();
        }
    }

    class TaskPaneExample1
    {


        public TaskPaneExample1() throws TwitterException, MalformedURLException
        {
            getDetails();
            frame = new JFrame(uname);
            frame.setBackground(Color.white);
            frame.add(doInit());
            int hh =h/4;
            int ww = w/7;
            frame.setLocation(hh+width+25,ww);
            frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ll));
            frame.setCursor(getToolkit().createCustomCursor(cursorImage, hotspot, name));
            frame.pack();
            frame.addWindowListener(new WindowAdapter()
                                    {
                                        public void windowClosing(WindowEvent e)
                                        {
                                            jButton2.setVisible(true);
                                            frame.dispose();
                                    }
                                });
            frame.setVisible(true);
        }

        public boolean checkclose()
        {
            return frame.isShowing();
        }

        public void close()
        {
            frame.dispose();
        }

        private Component doInit() throws TwitterException, MalformedURLException
        {
            JXPanel panel = new JXPanel();
            //panel.setLayout(new BorderLayout());

            JXTaskPaneContainer taskpanecontainer = new JXTaskPaneContainer();

            // create a taskpane, and set it's title and icon
            JXTaskPane taskpane = new JXTaskPane();
            taskpane.setTitle(status);
            taskpane.setToolTipText(uname);
            taskpane.setIcon(img);
            TweetScrollPane t = new TweetScrollPane();
            taskpane.add(t);

            taskpanecontainer.add(taskpane);

            panel.add(taskpanecontainer);//, BorderLayout.CENTER);

            return panel;
        }

        public void getDetails() throws MalformedURLException
        {
            try
            {
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
                uname=displayName;
                String image = u.getProfileImageURL().toString();
                String uname = u.getName();
                URL where = new URL(image);
                img = new ImageIcon(where);
                status = currentStatus.replaceAll("'", "").replaceAll("text=","");
                if(status.length()>60)
                {
                    status = status.substring(0, 60)+"..";
                }
                else
                {
                    status = currentStatus.replaceAll("'", "").replaceAll("text=","");
                }
            } catch (Exception ex) {       }
        }
    }

}
