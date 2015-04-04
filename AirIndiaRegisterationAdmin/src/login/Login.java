package login;

import RavCustomizedProgressBar.InfiniteProgressPanel;
import customizedtextfields.IntegerField;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import process.GetAdmin;
import support.CheckInternetConnection;

public class Login extends javax.swing.JFrame implements Runnable
{
    Thread th;

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;

    InfiniteProgressPanel ipp;
    
    public Login()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new IntegerField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        ipp = new InfiniteProgressPanel("Checking Admin List.Please Wait.....");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BSAEIA Admin Registeration");
        setResizable(false);

        setIconImage(new ImageIcon("img"+System.getProperty("file.separator")+"rav.gif").getImage());

        setGlassPane(ipp);


        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BSAEIA Admin Login");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon("img"+System.getProperty("file.separator")+"logo.png")); // NOI18N

        jLabel3.setText("Staff No");

        jLabel4.setText("Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPasswordField1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jButton1.setText("Submit");
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            if(!jTextField1.getText().trim().equals(""))
                                            {
                                                if(!jPasswordField1.getText().trim().equals(""))
                                                {
                                                    if(new CheckInternetConnection().process())
                                                    {
                                                        process();
                                                    }
                                                    else
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Oops!! Please Enter the Staff no.","Error",JOptionPane.ERROR_MESSAGE);
                                                    }
                                                }
                                                else
                                                {
                                                    JOptionPane.showMessageDialog(null,"Oops!! Please Enter the Password","Error",JOptionPane.ERROR_MESSAGE);
                                                }
                                            }
                                            else
                                            {
                                                JOptionPane.showMessageDialog(null,"Oops!! Please Enter the Staff no.","Error",JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    });

        jButton2.setText("Forgot Password");
        jButton2.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            JOptionPane.showMessageDialog(null,"Enter the password that was sent to you via email or else contact BSAEIA","Information",JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();

        int frame_x = getSize().height;
        int frame_y = getSize().width;


        setLocation((d.width - frame_y)/2,(d.height - frame_x)/2);
    }

    public void process()
    {
        th = new Thread(this);
        th.start();
    }

    public boolean check_admin(String[] s)
    {
        for(String temp:s)
            if(temp.trim().equals(jTextField1.getText().trim()))
                return true;
        return false;
    }

    public void run()
    {
        ipp.start();
        String admin_list[] = new GetAdmin().process();

        if(admin_list == null)
        {
            JOptionPane.showMessageDialog(null,"Oops !!No Admin Found","Error",JOptionPane.ERROR_MESSAGE);
            ipp.stop();
        }
        else
        {
            StringTokenizer s1 = new StringTokenizer(admin_list[0],",");
            String admin[] = new String[s1.countTokens()];
            int i=0;
            while(s1.hasMoreTokens())
            {
                admin[i] = s1.nextToken();
                System.out.println(admin[i].toString());
                i++;
            }
            if(check_admin(admin))
            {
                if(jPasswordField1.getText().trim().equals("BSAEIA"))
                {
                    //admin page
                    dispose();
                    java.awt.EventQueue.invokeLater(new Runnable()
                    {
                        public void run()
                        {
                            new Options().setVisible(true);
                        }
                    });
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Oops !! Incorrect Details Entered","Error",JOptionPane.ERROR_MESSAGE);
                    ipp.stop();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Oops !! Incorrect Details Entered","Error",JOptionPane.ERROR_MESSAGE);
                ipp.stop();
            }
        }
    }
}
