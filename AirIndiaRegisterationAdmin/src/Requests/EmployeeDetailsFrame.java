package Requests;

import RavCustomizedProgressBar.InfiniteProgressPanel;
import customizedtextfields.IntegerField;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import process.markEmployeeRequest;
import sendnrecievedata.SendHead;
import sendnrecievedata.sending;
import support.CheckInternetConnection;




public class EmployeeDetailsFrame extends javax.swing.JFrame implements Runnable
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
    String[] information;
    ArrayList<String> nominations;
    int messageno;

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();

    Thread th;
    InfiniteProgressPanel ipp;

    boolean accept = false;

    boolean edit;

    String memno="";

    public EmployeeDetailsFrame(String[] i,ArrayList<String> n,int m,boolean e)
    {
        this.edit = e;
        this.messageno = m;
        this.information = i;
        this.nominations = n;
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
        setTitle("Staff No."+information[1]);

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
                                                processAccept();
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

        if(!edit)
            jLabel1.setText("Staff No."+information[1]);
        else
            jLabel1.setText("Staff No."+information[1]+" [Edit Mode]");

        jLabel2.setText("Full Name");

        jLabel3.setText("Date Of Birth");

        FullName.setEditable(false);
        FullName.setText(information[0]);

        DOB.setEditable(false);
        DOB.setText(information[9]);

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

    public void processAccept()
    {
        java.awt.EventQueue.invokeLater(new Runnable()
             {
                public void run()
                {
                    new MembershipNo().setVisible(true);
                }
            });
    }

    public void run()
    {
        if(accept)
        {
            ipp.start();
            ipp.setText("Processing Request. Please Wait....");
            ipp.revalidate();
            ipp.repaint();
            String fullname = information[0];
            String staffno = information[1];
            String address = information[2];
            String city = information[3];
            String state = information[4];
            String pincode = information[5];
            String landline = information[6];
            String mobileno = information[7];
            String emailid = information[8];
            String dob = information[9];

            String empinfo = "Name: "+fullname+"\nStaff No.: "+staffno+"\nAddress: "+address+
                    "\nCity: "+city+"\nState: "+state+"\nPincode: "+pincode+"\nLand Line: "+landline
                    +"\nMobile No.: "+mobileno+"\nEmail ID: "+emailid+"\nDate Of Birth: "+dob+"\n\n";

            String nomininfo="";

            System.out.println(nominations.size());
            for(int i=0;i<nominations.size();i++)
            {
                StringTokenizer s = new StringTokenizer(nominations.get(i),"||");
                if(s.countTokens() == 9)
                {
                    nomininfo += "Nomination No."+(i+1);
                
                    System.out.println(s.countTokens());
                    String temp = "\nFull Name: "+s.nextToken()+"\n"+s.nextToken()+" "+s.nextToken()
                        +"\nAge: "+s.nextToken()+"\n"+s.nextToken()+": "+s.nextToken()+"\nRelation: "
                        +s.nextToken()+"\nRecieve Percentage: "+s.nextToken()+"\nAdress: "+s.nextToken()+"\n\n";

                    nomininfo+= temp;
                }
                else
                {
                    continue;
                }
            }

            SendHead mer = new SendHead("Staff No."+staffno,empinfo+"\n\n"+nomininfo+"\n\nYour Membership number is "+memno);
            
            if(mer.process(emailid))
            {
                 markEmployeeRequest mer1 = new markEmployeeRequest();
                int a[] = {this.messageno};

                if(mer1.mark(a))
                {
                    File f = new File("Bin"+System.getProperty("file.separator")+"Data");
                    if(!f.exists())
                        f.mkdirs();
                    try
                    {
                        BufferedWriter b = new BufferedWriter(new FileWriter("Bin"+System.getProperty("file.separator")+"Data"+System.getProperty("file.separator")+staffno));
                        b.append(empinfo+"\n\n"+nomininfo+"\n\nYour Membership number is "+memno);
                        b.close();
                    }catch(Exception ae){ae.printStackTrace();}
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

            markEmployeeRequest mer = new markEmployeeRequest();
            int a[] = {this.messageno};

            if(!mer.mark(a))
            {
                JOptionPane.showMessageDialog(null,"Oops!! No Internet Connection","Error",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                String emailid = information[8];
                
                String to[] = {emailid};
                sending sm;
                if(!edit)
                    sm = new sending("rravsofts@gmail.com","guru1111","BSAEIA Registeration","Sir,\nBSAEIA Admin Rejected your request.\n\n Thank You\n\n Regards\n\nRav Softs.",to);
                else
                    sm = new sending("rravsofts@gmail.com","guru1111","BSAEIA Registeration","Sir,\nBSAEIA Admin Rejected your Editing request.\n\n Thank You\n\n Regards\n\nRav Softs.",to);
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

    public class MembershipNo extends javax.swing.JFrame {
        
    public MembershipNo() {
        initComponents();
    }
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new IntegerField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("img"+System.getProperty("file.separator")+"rav.gif").getImage());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Staff No.");

        jLabel2.setText("Membership No");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Submit");
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            if(!jTextField1.getText().trim().equals(""))
                                            {
                                                memno = jTextField1.getText().trim();
                                                dispose();
                                                process1();
                                            }
                                            else
                                            {
                                                JOptionPane.showMessageDialog(null,"Oops!! Enter the Membership Number","Error",JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();

        int frame_x = getSize().height;
        int frame_y = getSize().width;


        setLocation((d.width - frame_y)/2,(d.height - frame_x)/2);
    }
    
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;

    }

    
}

