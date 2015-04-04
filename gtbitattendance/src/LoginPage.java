import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class LoginPage extends JFrame
{
    JButton jButton1;
    JButton jButton2;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JPasswordField jPasswordField1;
    JTextField jTextField1;

    String uname;
    String password;

    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    public final static String bg="Bin\\img1\\bg.jpeg";
    private DialogEarthquakeCenter dec;

    public LoginPage()
    {
        String temp=loaduserinfo();
        if(temp.equalsIgnoreCase("no"))
        {
            try
            {
                BufferedWriter b = new BufferedWriter(new FileWriter("Bin/Data/UserInfo/userinfo.ravs"));
                b.append(new Base64Encoder(new Base64Encoder("admin").get()).get());
                b.newLine();
                b.append(new Base64Encoder(new Base64Encoder("balrav").get()).get());
                b.close();
            }catch(Exception as){}
            uname="admin";
            password="balrav";
        }
        else
        {
            StringTokenizer t = new StringTokenizer(temp,",");
            uname=new Base64Decoder(new Base64Decoder(t.nextToken().trim()).get().trim()).get().trim();
            password=new Base64Decoder(new Base64Decoder(t.nextToken().trim()).get().trim()).get().trim();
        }
        initComponents();
    }

    public String loaduserinfo()
    {
        File f = new File("Bin/Data/UserInfo/userinfo.ravs");
        if(f.exists())
        {
            try
            {
                String u;
                String p;
                BufferedReader b = new BufferedReader(new FileReader("Bin/Data/UserInfo/userinfo.ravs"));
                u=b.readLine();
                p=b.readLine();
                if(u.length()<=0)
                {
                    return "no";
                }
                if(p.length()<=0)
                {
                    return "no";
                }
                return u+","+p;
            }catch(Exception as){}
        }
        return "no";
    }

    private void initComponents()
    {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jTextField1 = new JTextField();
        jPasswordField1 = new JPasswordField();
        jLabel4 = new JLabel();

        dec = new DialogEarthquakeCenter (this);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(390,317));
        setMaximumSize(new Dimension(390,317));
        setMinimumSize(new Dimension(390,317));
        getContentPane().setLayout(null);

        jLabel1.setFont(new Font("Zapfino", 1, 14));
        jLabel1.setText("GTBIT Informer");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 20, 149, 48);

        jLabel2.setText("Admin ID");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 110, 59, 16);

        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 170, 59, 16);

        jButton1.setText("Submit");
        getContentPane().add(jButton1);
        jButton1.setBounds(90, 240, 88, 29);
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            int a=-1;
                                            int b=-1;
                                            if(jTextField1.getText().trim().equalsIgnoreCase(""))
                                            {
                                                a=1;
                                            }
                                            if(jPasswordField1.getText().equalsIgnoreCase(""))
                                            {
                                                b=1;
                                            }
                                            if((a==1)&&(b==1))
                                            {
                                                JOptionPane.showMessageDialog(null,"Please Enter the ID and Password","Error", JOptionPane.ERROR_MESSAGE);
                                            }
                                            else
                                            if(a==1)
                                            {
                                                JOptionPane.showMessageDialog(null,"Please Enter the ID","Error", JOptionPane.ERROR_MESSAGE);
                                            }
                                            else
                                                if(b==1)
                                                {
                                                    JOptionPane.showMessageDialog(null,"Please Enter the Password","Error", JOptionPane.ERROR_MESSAGE);
                                                }
                                            else
                                            {
                                                if((jTextField1.getText().trim().equalsIgnoreCase(uname))&&(jPasswordField1.getText().trim().equalsIgnoreCase(password)))
                                                {
                                                    dispose();
                                                    EventQueue.invokeLater(new Runnable()
                                                    {
                                                        public void run()
                                                        {
                                                            new AdminPage(password).setVisible(true);
                                                        }
                                                    });
                                                }
                                                else
                                                {
                                                    dec.startShake();
                                                    jTextField1.setText("");
                                                    jPasswordField1.setText("");//JOptionPane.showMessageDialog(null,"OOPS Wrong ID or Password","Error", JOptionPane.ERROR_MESSAGE);
                                                }
                                            }

                                        }
                                    });

        jButton2.setText("Reset");
        getContentPane().add(jButton2);
        jButton2.setBounds(200, 240, 78, 29);
        jButton2.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            jTextField1.setText("");
                                            jPasswordField1.setText("");
                                        }
                                    });

        getContentPane().add(jTextField1);
        jTextField1.setBounds(200, 100, 134, 28);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(200, 160, 134, 28);

        jLabel4.setIcon(new ImageIcon(bg));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, -180, 390, 600);

        setResizable(false);
        pack();
        setLocation(h/2,w/7);
    }
}
