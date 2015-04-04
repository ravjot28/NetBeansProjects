import com.google.gdata.client.youtube.YouTubeService;
import com.google.gdata.data.media.MediaFileSource;
import com.google.gdata.data.media.mediarss.MediaCategory;
import com.google.gdata.data.media.mediarss.MediaDescription;
import com.google.gdata.data.media.mediarss.MediaKeywords;
import com.google.gdata.data.media.mediarss.MediaTitle;
import com.google.gdata.data.youtube.VideoEntry;
import com.google.gdata.data.youtube.YouTubeMediaGroup;
import com.google.gdata.data.youtube.YouTubeNamespace;
import com.google.gdata.util.ServiceException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileFilter;



public class Uploader extends JFrame implements Runnable
{
    Thread th = new Thread(this);

    JButton jButton1;
    JButton jButton2;
    JButton jButton3;
    JCheckBox jCheckBox1;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JLabel jLabel5;
    JLabel jLabel6;
    JScrollPane jScrollPane1;
    JTextArea jTextArea1;
    JTextField jTextField1;
    JTextField jTextField2;
    JTextField jTextField3;

    String uname;
    String pname;
    String path;

    private InfiniteProgressPanel glassPane;

    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    public final static String bg="Bin/Data/img/bg.jpeg";

    public final static String lg="Bin/Data/img/logo.gif";

    public final static String log="Bin/Data/img/logout.png";

    public Uploader()
    {
        try
        {
            BufferedReader b = new BufferedReader(new FileReader("Bin/Data/UserInfo/userinfo.ravs"));
            uname = new Base64Decoder(b.readLine()).get();
            pname  = new Base64Decoder(b.readLine()).get();
            b.close();
        }catch(Exception as){}
        initComponents();
    }

    private void initComponents()
    {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jLabel4 = new JLabel();
        jTextField2 = new JTextField();
        jButton1 = new JButton();
        jTextField3 = new JTextField();
        jLabel5 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jCheckBox1 = new JCheckBox();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jLabel6 = new JLabel();

         this.glassPane = new InfiniteProgressPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(435, 490));
        setMinimumSize(new Dimension(435, 490));
        setPreferredSize(new Dimension(435, 490));
        getContentPane().setLayout(null);
        setGlassPane(glassPane);

        jLabel1.setFont(new Font("Zapfino", 1, 18));
        jLabel1.setText("YouTube Uploader");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(141, 20, 201, 61);

        jLabel2.setIcon(new ImageIcon(lg));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 20, 50, 50);

        jLabel3.setText("Video Title");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(42, 103, 67, 16);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(127, 97, 268, 28);

        jLabel4.setText("Tags");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(42, 254, 30, 16);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(51, 309, 211, 28);

        jButton1.setText("File Location");
        getContentPane().add(jButton1);
        jButton1.setBounds(271, 310, 124, 29);
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            int retVal;
                                            JFileChooser fc = new JFileChooser();
                                            fc.addChoosableFileFilter(new TextFilter());
                                            fc.setMultiSelectionEnabled(true);
                                            retVal = fc.showOpenDialog(fc);
                                            if (retVal == JFileChooser.APPROVE_OPTION)
                                            {
                                                path=fc.getSelectedFile().toString();
                                                jTextField2.setText(path);
                                            }
                                        }
                                    });

        jTextField2.setEditable(false);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(129, 248, 266, 28);

        jLabel5.setText("Description");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(42, 143, 73, 16);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(129, 143, 266, 73);

        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(42, 370, 174, 23);
        jCheckBox1.setText("Make Video Private");

        jButton2.setText("Upload");
        getContentPane().add(jButton2);
        jButton2.setBounds(174, 422, 88, 29);
         jButton2.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            if(jTextField2.getText().trim().equalsIgnoreCase(""))
                                            {
                                                JOptionPane.showMessageDialog(null,"OOps Choose the video","Error",JOptionPane.ERROR_MESSAGE);
                                            }
                                            else
                                            {
                                                th.start();
                                            }
                                        }
                                    });

        jButton3.setIcon(new ImageIcon(log));
        jButton3.setBorderPainted(false);
        getContentPane().add(jButton3);
        jButton3.setBounds(360, 10, 97, 29);
        jButton3.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ar)
                                        {
                                            int answer = JOptionPane.showConfirmDialog(null, "You want to delete the current account?", "Delete Account", JOptionPane.YES_NO_OPTION);

                                            if (answer == JOptionPane.YES_OPTION)
                                            {
                                                try
                                                {
                                                    BufferedWriter b = new BufferedWriter(new FileWriter("Bin/Data/UserInfo/userinfo.ravs"));
                                                    b.append("");
                                                    b.close();
                                                    dispose();
                                                    new Login().setVisible(true);
                                                }catch(Exception sd){}
                                            }
                                        }
                                    });

        jLabel6.setIcon(new ImageIcon(bg));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 440, 470);

        setResizable(false);
        pack();
        setLocation(h/2,w/7);
    }
    
    public void run()
    {
        glassPane.start();
        String keyword1 = jTextField3.getText().trim();
        StringTokenizer keyword2 = new StringTokenizer(keyword1,",");
        String keyword[] = new String[keyword2.countTokens()];
        int a=0;
        while(keyword2.hasMoreElements())
        {
            keyword[a]=keyword2.nextToken();
            a++;
        }
        YouTubeService service = new YouTubeService("RavSofts", "AI39si4TqWxCGARTlgkBiKnmx7s_0cEIoM9XxWqjX1fdzqgNH4u-LCXGvJOUd-I3rKITK-hgmE2EVA0Zn9CbEcmJQLsJjXrtIw");
        try
        {
            service.setUserCredentials(uname, pname);
            VideoEntry newEntry = new VideoEntry();

            YouTubeMediaGroup mg = newEntry.getOrCreateMediaGroup();
            mg.setTitle(new MediaTitle());
            mg.getTitle().setPlainTextContent(jTextField1.getText().trim());
            mg.addCategory(new MediaCategory(YouTubeNamespace.CATEGORY_SCHEME, "Autos"));
            mg.setKeywords(new MediaKeywords());
            for(int i=0;i<keyword.length;i++)
            {
                mg.getKeywords().addKeyword(keyword[i]);
            }
            mg.setDescription(new MediaDescription());
            mg.getDescription().setPlainTextContent(jTextArea1.getText().trim());
            mg.setPrivate(jCheckBox1.isSelected());

            for(int i=0;i<keyword.length;i++)
            {
                mg.addCategory(new MediaCategory(YouTubeNamespace.DEVELOPER_TAG_SCHEME, keyword[i]));
            }
            VideoEntry createdEntry=new VideoEntry();
            //newEntry.setGeoCoordinates(createdEntry.getGeoCoordinates());

            MediaFileSource ms = new MediaFileSource(new File(jTextField2.getText().trim()), "video/quicktime");
            newEntry.setMediaSource(ms);

            String uploadUrl ="http://uploads.gdata.youtube.com/feeds/api/users/default/uploads";

            createdEntry = service.insert(new URL(uploadUrl), newEntry);
            glassPane.stop();
            JOptionPane.showMessageDialog(null,"Video Uploaded","Confirmation",JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex1)
            {
                glassPane.stop();
                JOptionPane.showMessageDialog(null,"OOps Can not read the video","Error",JOptionPane.ERROR_MESSAGE);
            }
            catch (ServiceException ex)
            {
                glassPane.stop();
                JOptionPane.showMessageDialog(null,"OOps Encountered Net Connection Problem","Error",JOptionPane.ERROR_MESSAGE);
            }
        dispose();
        new Uploader().setVisible(true);
    }

    class TextFilter extends FileFilter
    {

        public boolean accept(File f)
        {
            if (f.isDirectory())
            {
                return true;
            }
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if (i > 0 && i < s.length() - 1)
            {
                if (s.substring(i + 1).toLowerCase().equals("mp4"))
                {
                    return true;
                }
                else
                if (s.substring(i + 1).toLowerCase().equals("mov"))
                {
                    return true;
                }
                else
                if (s.substring(i + 1).toLowerCase().equals("flv"))
                {
                    return true;
                }
                else
                if (s.substring(i + 1).toLowerCase().equals("avi"))
                {
                    return true;
                }
                else
                if (s.substring(i + 1).toLowerCase().equals("mpg"))
                {
                    return true;
                }
                else
                if (s.substring(i + 1).toLowerCase().equals("mpeg"))
                {
                    return true;
                }
                else
                if (s.substring(i + 1).toLowerCase().equals("wmv"))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            return false;
        }

        public String getDescription()
        {
            return "Accepts only avi,flv,mp4,mov,wmv,mpg,mpeg files.";
        }
    }

    public void look()
    {
         try
         {
             //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
             UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
              //UIManager.setLookAndFeel("com.easynth.lookandfeel.EaSynthLookAndFeel");
             //UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
             /*System.setProperty("Quaqua.tabLayoutPolicy","wrap");
             UIManager.setLookAndFeel(
                  ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel()
              );*/
         }catch(Exception e){}
    }
}

