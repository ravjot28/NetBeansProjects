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
import javax.swing.WindowConstants;

public class StudentPage extends JFrame implements Runnable
{
    JButton jButton1;
    JButton jButton2;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;

    String enroll;
    String email;
    String password;

    Thread th=new Thread(this);

    private InfiniteProgressPanel glassPane;

    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    public final static String bg="Bin\\img\\bg.jpeg";

    public final static String bt="Bin\\img\\setting.png";


    public StudentPage()
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
        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();

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
        jLabel1.setBounds(108, 20, 191, 61);

        jLabel2.setText("Get attendance & marks detail");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(31, 168, 189, 16);

        jButton1.setText("Go");
        getContentPane().add(jButton1);
        jButton1.setBounds(255, 163, 75, 29);
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            th.start();
                                        }
                                    });

        jButton2.setIcon(new ImageIcon(bt));
        jButton2.setBorderPainted(false);
        getContentPane().add(jButton2);
        jButton2.setBounds(350, 250, 40, 36);
        jButton2.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ar)
                                        {
                                            new StudentSetting(enroll,email,password).setVisible(true);
                                        }
                                    });

        jLabel3.setText("Welcome "+enroll);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(31, 104, 345, 16);

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
        String to[] = {"gtbitinfo@gmail.com"};
        sending s = new sending("gtbitinfo1@gmail.com","",enroll+"##"+email,to,"docomo3401");
        String check = s.send();
        if(check.equalsIgnoreCase("caught"))
        {
            glassPane.stop();
            JOptionPane.showMessageDialog(null,"OOps Encountered Connection Failure","Error",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            new InboxReader(enroll);
            glassPane.stop();
            //JOptionPane.showMessageDialog(null,"Your Password is sent to "+email,"Confirmation",JOptionPane.INFORMATION_MESSAGE);
        }
        dispose();
        //new StudentPage().setVisible(true);
    }
}
