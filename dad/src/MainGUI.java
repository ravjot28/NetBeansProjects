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
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.WindowConstants;


public class MainGUI extends JFrame
{
    public final static String resetimage="img/reset.png";
    public final static String okimage="img/ok.png";
    public final static String frameimage="img/r.gif";
    JLabel head;
    JPasswordField password;
    JLabel passwordt;
    JTextField username;
    JLabel usernamet;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    public MainGUI()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        look();
        username = new JTextField();
        head = new JLabel();
        usernamet = new JLabel();
        passwordt = new JLabel();
        password = new JPasswordField();
        URL reseturl=getClass().getClassLoader().getResource(resetimage);
        URL okurl=getClass().getClassLoader().getResource(okimage);
        URL frameurl=getClass().getClassLoader().getResource(frameimage);
        System.out.println(reseturl+" "+okurl+" "+frameurl);
        XrButton reset=new XrButton(new ImageIcon(reseturl));
        XrButton submit=new XrButton(new ImageIcon(okurl));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        head.setFont(new Font("Verdana", 1, 18)); 
        head.setText("Admin Login");

        usernamet.setFont(new Font("SansSerif", 1, 14));
        usernamet.setText("User Name");

        passwordt.setFont(new Font("SansSerif", 1, 14));
        passwordt.setText("Password");

        submit.addActionListener(new ActionListener()
                                  {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        if(username.getText().equalsIgnoreCase(""))
                                        {
                                             if(password.getText().equalsIgnoreCase(""))
                                             {
                                                JOptionPane.showMessageDialog(null,"Oops Please enter the username and password","Error",JOptionPane.ERROR_MESSAGE);
                                             }
                                             else
                                             {
                                                JOptionPane.showMessageDialog(null,"Oops Please enter the username","Error",JOptionPane.ERROR_MESSAGE);
                                             }
                                        }
                                        else
                                        if(password.getText().equalsIgnoreCase(""))
                                        {
                                            JOptionPane.showMessageDialog(null,"Oops Please enter the password","Error",JOptionPane.ERROR_MESSAGE);
                                        }
                                        else
                                        {
                                            if(username.getText().equals("admin"))
                                            {
                                                if(checklogin(password.getText().trim()))
                                                {
                                                    dispose();
                                                    //System.out.println("Success");
                                                     java.awt.EventQueue.invokeLater(new Runnable()
                                                                                        {
                                                                                            public void run()
                                                                                            {
                                                                                                new Option1().setVisible(true);
                                                                                            }
                                                                                         });
                                                }
                                                else
                                                {
                                                    JOptionPane.showMessageDialog(null,"Oops Wrong password entered","Error",JOptionPane.ERROR_MESSAGE);
                                                }
                                            }
                                            else
                                            {
                                                JOptionPane.showMessageDialog(null,"Oops Wrong Username entered","Error",JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                       
                                    }
                                  });

        reset.addActionListener(new ActionListener()
                                  {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        username.setText("");
                                        password.setText("");
                                    }
                                  });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(head)
                .addContainerGap(141, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(usernamet)
                    .addComponent(passwordt))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(password)
                    .addComponent(username,GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)   //94, 94, 94
                .addComponent(submit)
                .addGap(18, 18, 18)
                .addComponent(reset)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(head)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(usernamet)
                    .addComponent(username,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordt)
                    .addComponent(password,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(reset))
                .addGap(42, 42, 42))   //42, 42, 42
        );
        setTitle("Admin Page");
        setIconImage(Toolkit.getDefaultToolkit().getImage(frameurl));
        setLocation(h-h/2,w/7);
        setResizable(false);
        pack();
    }

    public boolean checklogin(String pswd)
    {
        String fname="Bin/Info/appid.ravs";
        File f=new File(fname);
        if(f.exists())
        {
            try
            {
                BufferedReader b=new BufferedReader(new FileReader(fname));
                String temp=new Base64Decoder(new Base64Decoder(new Base64Decoder(b.readLine()).get()).get()).get();
                b.close();
                System.out.println(temp+"    "+pswd);
                if(temp.trim().equals(pswd.trim()))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }catch(Exception sdf){return false;}
        }
        else
        {
            try
            {
                BufferedWriter b=new BufferedWriter(new FileWriter(fname));
                b.append(new Base64Encoder(new Base64Encoder(new Base64Encoder("ravjot").get()).get()).get());
                b.close();
            }catch(Exception sd){return false;}
            if(pswd.equals("ravjot"))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public void look()
    {
         try
         {
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
             //UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
              //UIManager.setLookAndFeel("com.easynth.lookandfeel.EaSynthLookAndFeel");
             //UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
             /*System.setProperty("Quaqua.tabLayoutPolicy","wrap");
             UIManager.setLookAndFeel(
                  ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel()
              );*/
         }catch(Exception e){}
    }
    
    public static void main(String args[])
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainGUI().setVisible(true);
            }
        });
    }
}
