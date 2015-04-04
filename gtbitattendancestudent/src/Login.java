import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Login extends JFrame implements Runnable
{
    JButton jButton1;
    JButton jButton2;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JPasswordField jPasswordField1;
    JTextField jTextField1;
    String password;
    String enroll;
    String email;
    
    Thread th=new Thread(this);

    private InfiniteProgressPanel glassPane;

    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    public final static String bg="Bin\\img\\bg.jpeg";
    private DialogEarthquakeCenter dec;

    public Login()
    {
        try
        {
            BufferedReader b = new BufferedReader(new FileReader("Bin\\Data\\UserInfo1\\userinfo.ravs"));
            enroll=new Base64Decoder(new Base64Decoder(b.readLine().trim()).get().trim()).get().trim();
            email=new Base64Decoder(new Base64Decoder(b.readLine().trim()).get().trim()).get().trim();
            password=new Base64Decoder(new Base64Decoder(b.readLine().trim()).get().trim()).get().trim();
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
        jPasswordField1 = new JPasswordField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel4 = new JLabel();

        dec = new DialogEarthquakeCenter (this);

        this.glassPane = new InfiniteProgressPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(400, 312));
        setMinimumSize(new Dimension(400, 312));
        setPreferredSize(new Dimension(400, 312));
        getContentPane().setLayout(null);
        setGlassPane(glassPane);

        jLabel1.setFont(new Font("Zapfino", 1, 18));
        jLabel1.setText("GTBIT Informer");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(92, 20, 191, 61);

        jLabel2.setText("Enroll. No.");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(46, 115, 66, 16);

        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(46, 180, 59, 16);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(156, 109, 181, 28);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(156, 174, 181, 28);

        jButton1.setText("Submit");
        getContentPane().add(jButton1);
        jButton1.setBounds(75, 240, 88, 29);
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ar)
                                        {
                                            if(jTextField1.getText().trim().equalsIgnoreCase(""))
                                            {
                                                JOptionPane.showMessageDialog(null,"OOps Please Enter the Enroll. No.","Error",JOptionPane.ERROR_MESSAGE);
                                            }
                                            else
                                                if(jPasswordField1.getText().trim().equalsIgnoreCase(""))
                                                {
                                                    JOptionPane.showMessageDialog(null,"OOps Enter the password","Error",JOptionPane.ERROR_MESSAGE);
                                                }
                                            else
                                            {
                                                if((jTextField1.getText().trim().equalsIgnoreCase(enroll))&&(jPasswordField1.getText().trim().equalsIgnoreCase(password)))
                                                {
                                                    dispose();
                                                    java.awt.EventQueue.invokeLater(new Runnable()
                                                    {
                                                        public void run()
                                                        {
                                                            new StudentPage().setVisible(true);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    dec.startShake();
                                                    jTextField1.setText("");
                                                    jPasswordField1.setText("");
                                                    //JOptionPane.showMessageDialog(null,"OOps Incorrect Password or Enroll. No.","Error",JOptionPane.ERROR_MESSAGE);
                                                }
                                            }
                                        }
                                    });

        jButton2.setText("Forgot Password");
        getContentPane().add(jButton2);
        jButton2.setBounds(189, 240, 148, 29);
        jButton2.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ar)
                                        {
                                            th.start();
                                        }
                                    });

        jLabel4.setIcon(new ImageIcon(bg));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 400, 300);
        setResizable(false);
        pack();
        setLocation(h/2,w/7);
    }

    public void run()
    {
        glassPane.start();
        String to[] = {email};
        sending s = new sending("gtbitinfo1@gmail.com","Your Password is "+password,"GTBIT Informer Auto Reply Password Recovery",to,"docomo3401");
        String check = s.send();
        if(check.equalsIgnoreCase("caught"))
        {
            glassPane.stop();
            JOptionPane.showMessageDialog(null,"OOps Encountered Connection Failure","Error",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            glassPane.stop();
            JOptionPane.showMessageDialog(null,"Your Password is sent to "+email,"Confirmation",JOptionPane.INFORMATION_MESSAGE);
        }
        dispose();
        new Login().setVisible(true);
    }
}
