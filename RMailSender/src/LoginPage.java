import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class LoginPage
{
    JFrame f;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    private InfiniteProgressPanel glassPane;
    
    public LoginPage()
    {
        f = new JFrame("R Mail Sender");
        glassPane = new InfiniteProgressPanel();
        f.setGlassPane(glassPane);
        LoginPagePanle p = new LoginPagePanle();
        f.add(p);
        f.pack();
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter()
                                {
                                    public void windowClosing(WindowEvent e)
                                    {
                                        System.exit(0);
                                    }
                                });
        f.setLocation(h/2,w/7);
        f.setResizable(false);
        f.pack();
    }

    

public class LoginPagePanle extends JPanel implements Runnable
{
    Thread th = new Thread(this);
    ButtonGroup buttonGroup1;
    JButton jButton1;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JPasswordField jPasswordField1;
    JRadioButton jRadioButton1;
    JRadioButton jRadioButton2;
    JTextField jTextField1;
    
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    public LoginPagePanle()
    {
        initComponents();
    }

    private void initComponents()
    {
        buttonGroup1 = new ButtonGroup();
        jRadioButton1 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        jLabel2 = new JLabel();
        jPasswordField1 = new JPasswordField();
        jButton1 = new JButton();
        jLabel3 = new JLabel();

        setBackground(new Color(255, 255, 255));
        

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("<html><img src=file:"+"Bin/Img/gmail.png"+"/></html>");
        jRadioButton1.setToolTipText("GMail");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("<html><img src=file:"+"Bin/Img/yahoo.png"+"/></html>");
        jRadioButton2.setToolTipText("YMail");

        jLabel1.setFont(new Font("American Typewriter", 1, 14));
        jLabel1.setText("Email");

        jTextField1.setFont(new Font("Krungthep", 0, 13));

        jLabel2.setFont(new Font("American Typewriter", 1, 14));
        jLabel2.setText("Password");

        jPasswordField1.setFont(new Font("Krungthep", 0, 13));

        jButton1.setText("Submit");

        jLabel3.setFont(new Font("Zapfino", 1, 18));
        jLabel3.setText("R Mail Sender");

        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ar)
                                        {
                                            if(jRadioButton2.isSelected())
                                            {
                                                int a=0;
                                                String message="";
                                                if((jPasswordField1.getText().equalsIgnoreCase(""))&&(jTextField1.getText().equalsIgnoreCase("")))
                                                {
                                                    a=3;
                                                    message="Please Fill the email id and the password";
                                                }
                                                else
                                                if(jPasswordField1.getText().equalsIgnoreCase(""))
                                                {
                                                    a=1;
                                                    message="Please Fill the password";
                                                }
                                                else
                                                    if(jTextField1.getText().equalsIgnoreCase(""))
                                                    {
                                                        a=2;
                                                        message="Please Fill the email id";
                                                    }
                                                    if(a!=0)
                                                    {
                                                        JOptionPane.showMessageDialog(null,message,"Error",JOptionPane.ERROR_MESSAGE);
                                                    }
                                                    else
                                                    {
                                                        if(jTextField1.getText().contains("@yahoo."))
                                                        {
                                                            //f.setVisible(false);
                                                            jButton1.setEnabled(false);
                                                            glassPane.start();
                                                            th.start();
                                                        }
                                                        else
                                                        {
                                                            JOptionPane.showMessageDialog(null,"Authentication Failed. Please check the email id and password (Also check Internet Connection)","Error",JOptionPane.ERROR_MESSAGE);
                                                            f.setVisible(true);
                                                        }
                                                    }
                                            }
                                            else
                                            if(jRadioButton1.isSelected())
                                            {
                                                int a=0;
                                                String message="";
                                                if((jPasswordField1.getText().equalsIgnoreCase(""))&&(jTextField1.getText().equalsIgnoreCase("")))
                                                {
                                                    a=3;
                                                    message="Please Fill the email id and the password";
                                                }
                                                else
                                                if(jPasswordField1.getText().equalsIgnoreCase(""))
                                                {
                                                    a=1;
                                                    message="Please Fill the password";
                                                }
                                                else
                                                    if(jTextField1.getText().equalsIgnoreCase(""))
                                                    {
                                                        a=2;
                                                        message="Please Fill the email id";
                                                    }
                                                    if(a!=0)
                                                    {
                                                        JOptionPane.showMessageDialog(null,message,"Error",JOptionPane.ERROR_MESSAGE);
                                                    }
                                                    else
                                                    {
                                                        if(jTextField1.getText().contains("@gmail.com"))
                                                        {
                                                            //f.setVisible(false);
                                                            jButton1.setEnabled(false);
                                                            glassPane.start();
                                                            create();
                                                            th.start();
                                                        }
                                                        else
                                                        {
                                                            JOptionPane.showMessageDialog(null,"Authentication Failed. Please check the email id and password (Also check Internet Connection)","Error",JOptionPane.ERROR_MESSAGE);
                                                            f.setVisible(true);
                                                        }
                                                    }

                                            }
                                            else
                                            {
                                                JOptionPane.showMessageDialog(null,"Please Select the Mail Service Provider","Error",JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(44, 44, 44))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(jPasswordField1, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel3)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jButton1)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jRadioButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jRadioButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(252, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(26, 26, 26))
        );
    }

    public void create()
    {
        //th.stop();
        th=null;
        th = new Thread(this);
    }

    public void run()
    {
        if(jRadioButton1.isSelected())
        {
            String email = jTextField1.getText().trim();
            String pswd = jPasswordField1.getText().trim();
            //System.out.println(email.trim()+" "+pswd.trim());
            String to[] = {"airindiapayroll@gmail.com"};
            sendinggmail check = new sendinggmail(email.trim(),"","",to,pswd.trim());
            if(check.send().equalsIgnoreCase("caught"))
            {
                glassPane.stop();
                jButton1.setEnabled(true);
                JOptionPane.showMessageDialog(null,"Authentication Failed. Please check the email id and password (Also check Internet Connection)","Error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);//f.setVisible(true);
            }
            else
            {
                glassPane.stop();
                jButton1.setEnabled(true);
                JOptionPane.showMessageDialog(null,"Authentication Success","Success",JOptionPane.INFORMATION_MESSAGE);
                f.dispose();
                new DataStoring(email.trim(),pswd.trim());
            }
        }
        else
        {
            String email = jTextField1.getText().trim();
            String pswd = jPasswordField1.getText().trim();
            //System.out.println(email.trim()+" "+pswd.trim());
            String to[] = {"airindiapayroll@gmail.com"};
            sendingyahoo check = new sendingyahoo(email.trim(),"","",to,pswd.trim());
            if(check.send().equalsIgnoreCase("caught"))
            {
                glassPane.stop();
                jButton1.setEnabled(true);
                JOptionPane.showMessageDialog(null,"Authentication Failed. Please check the email id and password (Also check Internet Connection)","Error",JOptionPane.ERROR_MESSAGE);
                System.exit(0);//f.setVisible(true);
            }
            else
            {
                glassPane.stop();
                jButton1.setEnabled(true);
                JOptionPane.showMessageDialog(null,"Authentication Success","Success",JOptionPane.INFORMATION_MESSAGE);
                f.dispose();
                new DataStoring(email.trim(),pswd.trim());
            }
        }
    }
}

}
