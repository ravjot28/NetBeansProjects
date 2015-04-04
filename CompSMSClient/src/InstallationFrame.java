import Encrytp.Base64Encoder;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;


public class InstallationFrame extends JFrame implements FileDetails,Runnable
{
    JButton Disagree;
    JButton Agreement;
    JButton Agree;
    JComboBox locationbox;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JLabel jLabel5;
    JLabel jLabel6;
    JLabel jLabel7;
    JPanel jPanel1;
    JTextField jTextField1;
    JTextField jTextField2;
    JTextField jTextField3;
    JTextField jTextField4;
    JTextField jTextField5;
    JTextField jTextField6;

    InfiniteProgressPanel glasspane;

    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    String fname;
    String lname;
    String mname;
    String email;
    String phno;
    String location;

    static int choice=0;

    Thread th = new Thread(this);
    
    public InstallationFrame()
    {
        initComponents();
    }

    private void initComponents()
    {
        jTextField3 = new JTextField();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField4 = new JTextField();
        jTextField5 = new JTextField();
        jTextField6 = new JTextField();
        locationbox = new JComboBox();
        Disagree = new JButton();
        Agreement = new JButton();
        Agree = new JButton();
        glasspane = new InfiniteProgressPanel("Connecting Server. Please Wait...");
        jTextField3.setFont(new Font("Tahoma", 0, 14));

        setTitle("Rav SMS Service");
        setIconImage(new ImageIcon(imageicon).getImage());

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setGlassPane(glasspane);

        jPanel1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

        jLabel1.setFont(new Font("Georgia", 1, 24)); // NOI18N
        jLabel1.setText("Rav SMS Service SignUp");

        jLabel2.setFont(new Font("Times New Roman", 1, 18));
        jLabel2.setText("First Name *");

        jLabel3.setFont(new Font("Times New Roman", 1, 18));
        jLabel3.setText("Last Name *");

        jLabel4.setFont(new Font("Times New Roman", 1, 18));
        jLabel4.setText("Father Name *");

        jLabel5.setFont(new Font("Times New Roman", 1, 18));
        jLabel5.setText("Email ID ");

        jLabel6.setFont(new Font("Times New Roman", 1, 18));
        jLabel6.setText("Mobile Number ");

        jLabel7.setFont(new Font("Times New Roman", 1, 18));
        jLabel7.setText("Location *");

        jTextField1.setFont(new Font("Tahoma", 0, 14));

        jTextField2.setFont(new Font("Tahoma", 0, 14));

        jTextField4.setFont(new Font("Tahoma", 0, 14));

        jTextField5.setFont(new Font("Tahoma", 0, 14));

        jTextField6.setFont(new Font("Tahoma", 0, 14));

        //jComboBox1.setBackground(new Color(0, 0, 0));
        locationbox.setFont(new Font("Tahoma", 0, 12));
        locationbox.setModel(new DefaultComboBoxModel(new String[] { "Select Location", "J&K", "HIMACHAL", "PUNJAB", "UTTARANCHAL", "HARYANA", "DELHI", "RAJASTHAN", "UP", "ARUNACHAL", "ASSAM", "NAGALAND", "MANIPUR", "MIROZAM", "MEGHALAYA", "BIHAR", "JHARKHAND", "WESTBENGAL", "GUJARAT", "MP", "CHHATTISGARH", "MAHARASHTRA", "KERALA", "TAMIL", "KARNATAKA", "AP", "GOA", "ORISSA" }));

        Disagree.setFont(new Font("Arial", 1, 12));
        Disagree.setText("Disagree");
        Disagree.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent evt)
                                        {
                                            DisagreeActionPerformed(evt);
                                        }
                                    });

        Agreement.setFont(new Font("Arial", 1, 11));
        Agreement.setText("Agreement");
        Agreement.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent evt)
                                        {
                                            AgreementActionPerformed(evt);
                                        }
                                    });

        Agree.setFont(new Font("Arial", 1, 12));
        Agree.setText("Agree  ");
        Agree.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent evt)
                                        {
                                            AgreeActionPerformed(evt);
                                        }
                                    });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(locationbox, 0, 173, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField6, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addComponent(jTextField5, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addComponent(jTextField4, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addComponent(jTextField2, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addComponent(jTextField1, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Agree)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                        .addComponent(Disagree)
                        .addContainerGap())
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Agreement)
                        .addGap(148, 148, 148))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(locationbox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(Agreement)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(Disagree)
                    .addComponent(Agree))
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        setLocation(h/2,w/7);
        setResizable(false);
        pack();
    }

    private void DisagreeActionPerformed(ActionEvent evt)
    {
        int response;
        response = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit registeration process?");
        if(response==0)
        {
            dispose();
        }
    }

    private void AgreementActionPerformed(ActionEvent evt)
    {
        glasspane.start();
        glasspane.setText("Sending Mail..");
    }

    private void AgreeActionPerformed(ActionEvent evt)
    {
        fname = jTextField1.getText();
        lname = jTextField2.getText();
        mname = jTextField4.getText();
        email = jTextField5.getText();
        phno = jTextField6.getText();
        location = locationbox.getSelectedItem().toString();
        boolean check = true;
        if(fname.equalsIgnoreCase(""))
        {
            check = false;
            JOptionPane.showMessageDialog(null, "Please enter the First Name","Error",JOptionPane.ERROR_MESSAGE);
        }
        else
            if(lname.equalsIgnoreCase(""))
            {
                check = false;
                JOptionPane.showMessageDialog(null, "Please enter the Last Name","Error",JOptionPane.ERROR_MESSAGE);
            }
        else
            if(mname.equalsIgnoreCase(""))
            {
                check = false;
                JOptionPane.showMessageDialog(null, "Please enter the Father Name","Error",JOptionPane.ERROR_MESSAGE);
            }
        else
            if(email.equalsIgnoreCase("")&&(phno.equalsIgnoreCase("")))
            {
                check = false;
                JOptionPane.showMessageDialog(null, "Please enter the Email ID or Mobile Number or both","Error",JOptionPane.ERROR_MESSAGE);
            }
        else
            if(location.equalsIgnoreCase("Select Location"))
            {
                check = false;
                JOptionPane.showMessageDialog(null, "Please select the location","Error",JOptionPane.ERROR_MESSAGE);
            }
        if(check)
        {
            if(email.equalsIgnoreCase(""))
            {
                email="ravjot28@gmail.com";
                choice=1;
            }
            if(phno.equalsIgnoreCase(""))
            {
                phno="9540140052";
                choice=2;
            }
            th.start();
        }

    }

    public void run()
    {
        glasspane.start();
        String to[] = {adminemail};
        sending s1 = new sending(to[0],"",fname+","+mname+","+lname+","+email+"##"+phno+","+location, to,adminpassword );
        glasspane.setText("Sending Details To Server. Please Wait..");
        String result = s1.send();

        if(result.equalsIgnoreCase("yes"))
        {
            glasspane.setText("Saving Information...");
            try
            {
                BufferedWriter b = new BufferedWriter(new FileWriter(dirpath+filename));
                String data = fname+"##"+mname+"##"+lname+"##"+email+"##"+phno+"##"+location+"##";
                data = new Base64Encoder(data).get();
                b.append(data);
                b.close();
            }catch(Exception as){}
            switch(choice)
            {
                case 1:
                        glasspane.stop();
                        JOptionPane.showMessageDialog(null, "Kindly login with Secret Code and Contact Number messaged you at "+phno, "Alert", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    break;
                case 2:
                        glasspane.stop();
                        JOptionPane.showMessageDialog(null, "Kindly login with Secret Code and Contact Number mailed you at "+email, "Alert", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        launch();
                    break;
                case 0:
                        glasspane.stop();
                        JOptionPane.showMessageDialog(null, "Kindly login with Secret Code and Contact Number mailed you at "+email, "Alert", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        launch();
                    break;
            }
            EventQueue.invokeLater(new Runnable()
            {
                public void run()
                {
                    new VerificationFrame().setVisible(true);
                }
            });
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Oops Internet Connection Issue. Please Check you internet and try again", "Error", JOptionPane.ERROR_MESSAGE);
            glasspane.stop();
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
            locationbox.setSelectedIndex(0);
        }
    }

    void launch()
    {
        String t[]={email};
        if(t[0].endsWith("gmail.com"))
        {
            String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler http://www.gmail.com";
            try
            {
                Process p = Runtime.getRuntime().exec(cmd);
            }catch(Exception sda){}
        }
        else
            if((t[0].endsWith("yahoo.com"))||(t[0].endsWith("yahoo.co.in"))||(t[0].endsWith("yahoo.in")))
            {
                String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler http://www.ymail.com";
                try
                {
                    Process p = Runtime.getRuntime().exec(cmd);
                }catch(Exception sda){}
            }
            else
                if(t[0].endsWith("rediffmail.com"))
                {
                    String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler http://www.rediffmail.com";
                    try
                    {
                        Process p = Runtime.getRuntime().exec(cmd);
                    }catch(Exception sda){}
                }
                else
                    if(t[0].endsWith("hotmail.com"))
                    {
                        String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler http://www.hotmail.com";
                        try
                        {
                            Process p = Runtime.getRuntime().exec(cmd);
                        }catch(Exception sda){}
                    }
                    else
                    {
                        String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler http://www.google.com";
                        try
                        {
                            Process p = Runtime.getRuntime().exec(cmd);
                        }catch(Exception sda){}
                    }
    }
}
