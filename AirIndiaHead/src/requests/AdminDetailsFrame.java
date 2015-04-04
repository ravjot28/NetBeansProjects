package Requests;

import RavCustomizedProgressBar.InfiniteProgressPanel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import process.ModifyAdmin;
import process.markAdminRequest;
import sendnrecievedata.SendAdmin;
import sendnrecievedata.sending;
import support.CheckInternetConnection;




public class AdminDetailsFrame extends javax.swing.JFrame implements Runnable
{
    private javax.swing.JTextField DOB;
    private javax.swing.JTextField FullName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    String staffno="";
    String emailid="";
    String dob="";
    int messageno;

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();

    Thread th;
    InfiniteProgressPanel ipp;

    boolean accept = false;
    String memno="";

    public AdminDetailsFrame(String s,String em,String d,int m)
    {
        this.messageno = m;
        this.dob = d;
        this.emailid = em;
        this.staffno = s;
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        FullName = new javax.swing.JTextField();
        DOB = new javax.swing.JTextField();

        ipp = new InfiniteProgressPanel("Processing request");

        setGlassPane(ipp);
        setIconImage(new ImageIcon("img"+System.getProperty("file.separator")+"rav.gif").getImage());
        setTitle("Staff No."+this.staffno);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setText("Accept");
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            if(new CheckInternetConnection().process())
                                            {
                                                process1();
                                            }
                                            else
                                            {
                                                JOptionPane.showMessageDialog(null, "Oops!! No Internet Connection", "Error",JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    });

        jButton2.setText("Reject");
        jButton2.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            if(new CheckInternetConnection().process())
                                            {
                                                process();
                                            }
                                            else
                                            {
                                                JOptionPane.showMessageDialog(null, "Oops!! No Internet Connection", "Error",JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    });

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

       
       jLabel1.setText("Staff No."+this.staffno);

       
        jLabel2.setText("Email ID");

        jLabel3.setText("Date Of Birth");

        FullName.setEditable(false);
        FullName.setText(this.emailid);

        DOB.setEditable(false);
        DOB.setText(this.dob);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(DOB))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(35, 35, 35)
                            .addComponent(FullName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(FullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        this.setLocationRelativeTo(null);
    }

    public void process()
    {
        this.accept = false;

        th = new Thread(this);
        th.start();
    }

    public void run()
    {
        if(accept)
        {
            ipp.start();
            ipp.setText("Processing Request. Please Wait....");
            ipp.revalidate();
            ipp.repaint();

            String to[] = {this.emailid};
            sending mer = new sending("rravsofts@gmail.com","guru1111","BSAEIA Admin Registeration","Sir,\nBSAEIA Head Accepted your request.\nYour password is BSAEIA (In capitals only).\n\n Thank You\n\n Regards\n\nRav Softs.",to);

            if(mer.send())
            {
                 markAdminRequest mer1 = new markAdminRequest();
                int a[] = {this.messageno};

                if(mer1.mark(a))
                {
                    ModifyAdmin ma = new ModifyAdmin();
                    String data[] = ma.process();
                    SendAdmin sa;
                    if(data == null)
                    {
                        sa = new SendAdmin("1",this.staffno+",");
                    }
                    else
                    {
                        sa = new SendAdmin("1",data[0]+this.staffno+",");
                    }

                    if(sa.process())
                    {
                        dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Oops!! No Internet Connection","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
            else
            {
                JOptionPane.showMessageDialog(null,"Oops!! No Internet Connection","Error",JOptionPane.ERROR_MESSAGE);
            }

            ipp.stop();
            dispose();
        }
        else
        {
            ipp.start();
            ipp.setText("Removing request from server. Please Wait....");
            ipp.revalidate();
            ipp.repaint();

            markAdminRequest mer = new markAdminRequest();
            int a[] = {this.messageno};

            if(!mer.mark(a))
            {
                JOptionPane.showMessageDialog(null,"Oops!! No Internet Connection","Error",JOptionPane.ERROR_MESSAGE);
            }
            else
            {

                String to[] = {this.emailid};
                sending sm;
                
                sm = new sending("rravsofts@gmail.com","guru1111","BSAEIA Admin Registeration","Sir,\nBSAEIA Head Rejected your request.\n\n Thank You\n\n Regards\n\nRav Softs.",to);
                if(!sm.send())
                {
                    JOptionPane.showMessageDialog(null,"Oops!! No Internet Connection","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            ipp.stop();
            dispose();
        }
    }

    public void process1()
    {
        this.accept = true;
        th = new Thread(this);
        th.start();
    }

    
}

