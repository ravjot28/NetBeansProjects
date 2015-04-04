import com.google.gdata.client.youtube.YouTubeService;
import com.google.gdata.util.AuthenticationException;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class Login extends JFrame implements Runnable
{
    Thread th = new Thread(this);

    JButton jButton1;
    JButton jButton2;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JLabel jLabel5;
    JPasswordField jPasswordField1;
    JTextField jTextField1;

    String uname;
    String pname;

    private InfiniteProgressPanel glassPane;

    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    public final static String bg="Bin/Data/img/bg.jpeg";

    public final static String lg="Bin/Data/img/logo.gif";

    public Login()
    {
        initComponents();
    }

    private void initComponents()
    {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jPasswordField1 = new JPasswordField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();

        this.glassPane = new InfiniteProgressPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(380, 320));
        setMinimumSize(new Dimension(380, 320));
        setPreferredSize(new Dimension(380, 320));
        getContentPane().setLayout(null);
        setGlassPane(glassPane);

        jLabel1.setFont(new Font("Zapfino", 1, 18));
        jLabel1.setText("YouTube Uploader");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 20, 201, 61);

        jLabel2.setText("YouTube Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(39, 122, 121, 16);

        jLabel3.setText("YouTube Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(39, 185, 118, 16);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(178, 116, 156, 28);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(178, 179, 156, 28);

        jButton1.setText("Login");
        getContentPane().add(jButton1);
        jButton1.setBounds(102, 241, 79, 29);
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent are)
                                        {
                                            if(jTextField1.getText().trim().equalsIgnoreCase(""))
                                            {
                                                JOptionPane.showMessageDialog(null,"OOPs Please Enter the YouTube/Gmail ID","Error",JOptionPane.ERROR_MESSAGE);
                                            }
                                            else
                                                if(jPasswordField1.getText().trim().equalsIgnoreCase(""))
                                                {
                                                    JOptionPane.showMessageDialog(null,"OOPs Please Enter the YouTube/Gmail Password","Error",JOptionPane.ERROR_MESSAGE);
                                                }
                                            else
                                            {
                                                uname = jTextField1.getText().trim();
                                                pname=jPasswordField1.getText().trim();
                                                th.start();
                                            }
                                        }
                                    });

        jButton2.setText("Reset");
        getContentPane().add(jButton2);
        jButton2.setBounds(212, 241, 78, 29);
        jButton2.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent are)
                                        {
                                            jTextField1.setText("");
                                            jPasswordField1.setText("");
                                        }
                                    });

        jLabel4.setIcon(new ImageIcon(lg));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 10, 50, 50);

        jLabel5.setIcon(new ImageIcon(bg));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 380, 310);

        setResizable(false);
        pack();
        setLocation(h/2,w/7);
    }

    public void run()
    {
        glassPane.start();
        YouTubeService service = new YouTubeService("RavSofts", "AI39si4TqWxCGARTlgkBiKnmx7s_0cEIoM9XxWqjX1fdzqgNH4u-LCXGvJOUd-I3rKITK-hgmE2EVA0Zn9CbEcmJQLsJjXrtIw");
        try
        {
            service.setUserCredentials(uname, pname);
            try
            {
                BufferedWriter b = new BufferedWriter(new FileWriter("Bin/Data/UserInfo/userinfo.ravs"));
                b.append(new Base64Encoder(uname).get());
                b.newLine();
                b.append(new Base64Encoder(pname).get());
                b.close();
            }catch(Exception as){}
            glassPane.stop();
            dispose();
            EventQueue.invokeLater(new Runnable()
            {
                public void run()
                {
                    new Uploader().setVisible(true);
                }
            });
        } catch (AuthenticationException ex)
        {
            glassPane.stop();
            JOptionPane.showMessageDialog(null,"OOPs Incorrect ID or Password","Error",JOptionPane.ERROR_MESSAGE);
            dispose();
            new Login().setVisible(true);
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
