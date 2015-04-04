import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

public class emp extends JFrame
{
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    JTabbedPane emppane;
    JTextArea feedbackt;
    JLabel head;
    JLabel hr1;
    JLabel hr2;
    JLabel hr3;
    XrButton jButton1 = new XrButton(new ImageIcon("Bin\\img\\ok.png"));
    XrButton jButton2 = new XrButton(new ImageIcon("Bin\\img\\ok.png"));
    JCheckBox jCheckBox17;
    JCheckBox jCheckBox18;
    JCheckBox jCheckBox19;
    JCheckBox jCheckBox20;
    JCheckBox jCheckBox23;
    JCheckBox jCheckBox24;
    JCheckBox jCheckBox25;
    JCheckBox jCheckBox26;
    JCheckBox jCheckBox27;
    JCheckBox jCheckBox28;
    JCheckBox jCheckBox29;
    JCheckBox jCheckBox30;
    JCheckBox jCheckBox31;
    JCheckBox jCheckBox32;
    JCheckBox jCheckBox33;
    JCheckBox jCheckBox34;
    JCheckBox jCheckBox35;
    JCheckBox jCheckBox36;
    JCheckBox jCheckBox37;
    JCheckBox jCheckBox38;
    JCheckBox jCheckBox39;
    JCheckBox jCheckBox40;
    JCheckBox jCheckBox41;
    JCheckBox jCheckBox42;
    JCheckBox jCheckBox43;
    JCheckBox jCheckBox44;
    JCheckBox jCheckBox45;
    JCheckBox jCheckBox46;
    JCheckBox jCheckBox47;
    JCheckBox jCheckBox48;
    JLabel jLabel1;
    JLabel jLabel10;
    JLabel jLabel11;
    JLabel jLabel12;
    JLabel jLabel13;
    JLabel jLabel14;
    JLabel jLabel15;
    JLabel jLabel16;
    JLabel jLabel17;
    JLabel jLabel18;
    JLabel jLabel19;
    JLabel jLabel2;
    JLabel jLabel20;
    JLabel jLabel21;
    JLabel jLabel22;
    JLabel jLabel23;
    JLabel jLabel24;
    JLabel jLabel25;
    JLabel jLabel26;
    JLabel jLabel27;
    JLabel jLabel3;
    JLabel jLabel4;
    JLabel jLabel5;
    JLabel jLabel6;
    JLabel jLabel7;
    JLabel jLabel8;
    JLabel jLabel9;
    JPanel jPanel1;
    JPanel jPanel2;
    JPanel jPanel3;
    JScrollPane jScrollPane1;
    JScrollPane jScrollPane2;
    JScrollPane jScrollPane3;
    JScrollPane jScrollPane4;
    JTabbedPane jTabbedPane1;
    JTabbedPane jTabbedPane3;
    JTabbedPane jTabbedPane4;
    JTextArea jTextArea1;
    JTextArea jTextArea2;
    JTextField jTextField1;
    JTextField jTextField2;
    JTextField jTextField3;
    JTextField jTextField4;
    JTextField jTextField5;
    JTextField jTextField6;
    JLabel lastman;
    JLabel manager1;
    JLabel projecthead;
    JTextArea reason;
    XrButton reset = new XrButton(new ImageIcon("Bin\\img\\reset.png"));
    XrButton resetf = new XrButton(new ImageIcon("Bin\\img\\Right.png"));
    JTabbedPane resig;
    JPanel resignation;
    XrButton submitf = new XrButton(new ImageIcon("Bin\\img\\Left.png"));
    XrButton submit = new XrButton(new ImageIcon("Bin\\img\\ok.png"));
    XrButton jButton3 = new XrButton(new ImageIcon("Bin\\img\\logout.png"));
    String empid;
    static int count=0;
    
    
    public emp(String emp)
    {
        empid=emp;
        initComponents();
    }
    
    private void initComponents()
    {
        look();
        final int length=new File("Bin/Message/"+empid+"/").listFiles().length;
        emppane = new JTabbedPane();
        resig = new JTabbedPane();
        resignation = new JPanel();
        jScrollPane1 = new JScrollPane();
        reason = new JTextArea();
        head = new JLabel();
        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jTabbedPane3 = new JTabbedPane();
        jPanel2 = new JPanel();
        manager1 = new JLabel();
        projecthead = new JLabel();
        hr1 = new JLabel();
        hr2 = new  JLabel();
        hr3 = new JLabel();
        lastman = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel27 = new JLabel();
        jCheckBox17 = new JCheckBox();
        jCheckBox18 = new JCheckBox();
        jCheckBox19 = new JCheckBox();
        jCheckBox20 = new JCheckBox();
        jCheckBox31 = new JCheckBox();
        jCheckBox32 = new JCheckBox();
        jCheckBox33 = new JCheckBox();
        jCheckBox34 = new JCheckBox();
        jCheckBox35 = new JCheckBox();
        jCheckBox36 = new JCheckBox();
        jCheckBox37 = new JCheckBox();
        jCheckBox38 = new JCheckBox();
        jCheckBox39 = new JCheckBox();
        jCheckBox40 = new JCheckBox();
        jCheckBox41 = new JCheckBox();
        jCheckBox42 = new JCheckBox();
        jCheckBox43 = new JCheckBox();
        jCheckBox44 = new JCheckBox();
        jCheckBox45 = new JCheckBox();
        jCheckBox46 = new JCheckBox();
        jCheckBox47 = new JCheckBox();
        jCheckBox48 = new JCheckBox();
        jTabbedPane4 = new JTabbedPane();
        jPanel3 = new JPanel();
        jScrollPane2 = new JScrollPane();
        feedbackt = new JTextArea();
        jLabel10 = new JLabel();
        jTextField2 = new JTextField();
        jLabel11 = new JLabel();
        jLabel26 = new JLabel();
        jTabbedPane1 = new JTabbedPane();
        jPanel1 = new JPanel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();
        jLabel15 = new JLabel();
        jLabel16 = new JLabel();
        jCheckBox23 = new JCheckBox();
        jCheckBox24 = new JCheckBox();
        jCheckBox25 = new JCheckBox();
        jCheckBox26 = new JCheckBox();
        jCheckBox27 = new JCheckBox();
        jLabel17 = new JLabel();
        jLabel18 = new JLabel();
        jLabel19 = new JLabel();
        jLabel20 = new JLabel();
        jLabel21 = new JLabel();
        jLabel22 = new JLabel();
        jLabel23 = new JLabel();
        jCheckBox28 = new JCheckBox();
        jCheckBox29 = new JCheckBox();
        jCheckBox30 = new JCheckBox();
        jLabel24 = new JLabel();
        jScrollPane3 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jLabel25 = new JLabel();
        jScrollPane4 = new JScrollPane();
        jTextArea2 = new JTextArea();
        jTextField3 = new IntegerField();
        String status=new StatusQuery(empid).search("D:\\Harman.mdb");
         if((!checkreason().equalsIgnoreCase("na")))
         {
             if(status.startsWith("0000000"))
             {
                JOptionPane.showMessageDialog(null,"Resignation Confirmed","Alert",JOptionPane.INFORMATION_MESSAGE);
             }
             else
             if(status.contains("2"))
             {
                JOptionPane.showMessageDialog(null,"Resignation Rejected","Alert",JOptionPane.INFORMATION_MESSAGE);
             }
             else
             {
                JOptionPane.showMessageDialog(null,"Your Resignation is submitted","Alert",JOptionPane.INFORMATION_MESSAGE);
             }
         }
        jTextField3.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                String text = jTextField3.getText();
                int length = text.length();
                if (length == 1)
                {
                    e.consume();
                } else if (length > 1) {
                    jTextField3.setText(text.substring(0, 1));
                }
            }
        });
        jTextField4 = new IntegerField();
        jTextField4.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                String text = jTextField4.getText();
                int length = text.length();
                if (length == 1)
                {
                    e.consume();
                } else if (length > 1) {
                    jTextField4.setText(text.substring(0, 1));
                }
            }
        });
        jTextField5 = new IntegerField();
        jTextField5.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                String text = jTextField5.getText();
                int length = text.length();
                if (length == 1)
                {
                    e.consume();
                } else if (length > 1) {
                    jTextField5.setText(text.substring(0, 1));
                }
            }
        });
        jTextField6 = new IntegerField();
        jTextField6.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                String text = jTextField6.getText();
                int length = text.length();
                if (length == 1)
                {
                    e.consume();
                } else if (length > 1) {
                    jTextField6.setText(text.substring(0, 1));
                }
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        emppane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

        resig.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

        reason.setColumns(20);
        reason.setRows(5);
        reason.setLineWrap(true);
        reason.setFont(new Font("Serif", 0, 14));
        jScrollPane1.setViewportView(reason);

        submit.setToolTipText("Submit");
        submit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                if(reason.getText().equalsIgnoreCase(""))
                {
                    JOptionPane.showMessageDialog(null,"Please fill the reason","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    int response;
                    response = JOptionPane.showConfirmDialog(null, "Are you sure you want to submit your resignation?");
                    if(response==0)
                    {
                        try
                        {
                            BufferedWriter bb=new BufferedWriter(new FileWriter("Bin\\reasons\\"+empid+".ravs"));
                            bb.append(reason.getText());
                            bb.close();
                        }catch(Exception adfa){}
                        new Update(empid,"D:\\Harman.mdb");
                        submit.setEnabled(false);
                        reason.setEditable(false);
                        jTextField1.setEditable(false);
                        JOptionPane.showMessageDialog(null,"Your Resignation is submitted","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        reset.setToolTipText("Cancel");
        reset.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                int response;
                response = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
                if(response==0)
                {
                    System.exit(0);
                }
            }
        });

        head.setFont(new Font("Verdana", 1, 14)); 
        head.setText("CC");

        jLabel1.setFont(new Font("Verdana", 1, 14));
        jLabel1.setText("Employee ID : "+empid);

        jTextField1.setFont(new Font("Tahoma", 0, 14));

        jLabel2.setFont(new Font("Verdana", 1, 18));
        jLabel2.setForeground(new Color(51, 102, 255));
        jLabel2.setText("Welcome To Exit System");

        jLabel3.setFont(new Font("Verdana", 1, 14)); 
        jLabel3.setText("Reason For Resignation");

        jButton3.setToolTipText("Log Out");
        jButton3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                dispose();
                new login().setVisible(true);
            }
        });

        javax.swing.GroupLayout resignationLayout = new javax.swing.GroupLayout(resignation);
        resignation.setLayout(resignationLayout);
        resignationLayout.setHorizontalGroup(
            resignationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resignationLayout.createSequentialGroup()
                .addContainerGap(281, Short.MAX_VALUE)
                .addComponent(submit)
                .addGap(129, 129, 129)
                .addComponent(reset)
                .addGap(410, 410, 410))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resignationLayout.createSequentialGroup()
                .addContainerGap(355, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(418, 418, 418))
            .addGroup(resignationLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addContainerGap(844, Short.MAX_VALUE))
            .addGroup(resignationLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(resignationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(resignationLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resignationLayout.createSequentialGroup()
                        .addGroup(resignationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(resignationLayout.createSequentialGroup()
                                .addComponent(head)
                                .addGap(39, 39, 39)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE))
                            .addComponent(jButton3))
                        .addGap(166, 166, 166))))
        );
        resignationLayout.setVerticalGroup(
            resignationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resignationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(resignationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton3))
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addGroup(resignationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(head)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(resignationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(reset))
                .addGap(17, 17, 17))
        );

        resig.addTab("", resignation);

        emppane.addTab("Resignation", resig);

        manager1.setFont(new Font("Serif", 1, 16));
        manager1.setText("Manager 1");

        projecthead.setFont(new Font("Serif", 1, 16));
        projecthead.setText("Project Head");

        hr1.setFont(new Font("Serif", 1, 16)); 
        hr1.setText("HR");

        hr2.setFont(new Font("Serif", 1, 16)); 
        hr2.setText("FLM");

        hr3.setFont(new Font("Serif", 1, 16)); 
        hr3.setText("IT");

        lastman.setFont(new Font("Serif", 1, 16));
        lastman.setText("Admin");

        jLabel4.setFont(new Font("Serif", 1, 16));
        jLabel4.setText("Training");

        jLabel5.setFont(new Font("Verdana", 1, 18));
        jLabel5.setText("Department");

        jLabel6.setFont(new Font("Verdana", 1, 18)); 
        jLabel6.setText("Accepted");

        jLabel7.setFont(new Font("Verdana", 1, 18)); 
        jLabel7.setText("Under Consideration");

        jLabel8.setFont(new Font("Verdana", 1, 18));
        jLabel8.setText("Rejected");

        jLabel9.setFont(new Font("Serif", 1, 16)); 
        jLabel9.setText("EHS");

        jLabel27.setFont(new Font("Verdana", 1, 18));
        jLabel27.setForeground(new Color(51, 102, 255));
        jLabel27.setText("Current Status");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel5)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(78, 78, 78)
                .addComponent(jLabel7)
                .addGap(50, 50, 50)
                .addComponent(jLabel8)
                .addGap(87, 87, 87))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(manager1)
                    .addComponent(projecthead)
                    .addComponent(hr1)
                    .addComponent(hr2)
                    .addComponent(hr3)
                    .addComponent(lastman)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addGap(210, 210, 210)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox17)
                    .addComponent(jCheckBox18)
                    .addComponent(jCheckBox31)
                    .addComponent(jCheckBox46)
                    .addComponent(jCheckBox32)
                    .addComponent(jCheckBox33)
                    .addComponent(jCheckBox45)
                    .addComponent(jCheckBox44))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox19)
                    .addComponent(jCheckBox20)
                    .addComponent(jCheckBox39)
                    .addComponent(jCheckBox40)
                    .addComponent(jCheckBox41)
                    .addComponent(jCheckBox43)
                    .addComponent(jCheckBox34))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox35)
                    .addComponent(jCheckBox42)
                    .addComponent(jCheckBox36)
                    .addComponent(jCheckBox37)
                    .addComponent(jCheckBox38)
                    .addComponent(jCheckBox48)
                    .addComponent(jCheckBox47))
                .addGap(124, 124, 124))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(434, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addGap(386, 386, 386))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(manager1)
                    .addComponent(jCheckBox42)
                    .addComponent(jCheckBox20)
                    .addComponent(jCheckBox17))
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(projecthead)
                                .addGap(40, 40, 40)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(hr1)
                                    .addComponent(jCheckBox31)
                                    .addComponent(jCheckBox39)
                                    .addComponent(jCheckBox36)))
                            .addComponent(jCheckBox18)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox35)
                            .addComponent(jCheckBox19))))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(hr2)
                            .addComponent(jCheckBox46))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(hr3)
                            .addComponent(jCheckBox32)
                            .addComponent(jCheckBox38)
                            .addComponent(jCheckBox41)))
                    .addComponent(jCheckBox37)
                    .addComponent(jCheckBox40))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBox43)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lastman)
                            .addComponent(jCheckBox33)
                            .addComponent(jCheckBox48))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox47)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jCheckBox34)
                                    .addComponent(jCheckBox45))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox44)
                                    .addComponent(jLabel9))))
                        .addGap(26, 26, 26))))
        );

        jTabbedPane3.addTab("", jPanel2);
        emppane.addTab("Status", jTabbedPane3);
        feedbackt.setColumns(20);
        feedbackt.setRows(5);
        feedbackt.setLineWrap(true);
        feedbackt.setFont(new Font("Serif", 0, 14));
        jScrollPane2.setViewportView(feedbackt);
        jTextField2.setEnabled(false);
        feedbackt.setEnabled(false);
        if(length==0)
        {
            submitf.setVisible(false);
            resetf.setVisible(false);         
        }
        else
            if(length==1)
        {
            submitf.setVisible(false);
            resetf.setVisible(false);
            String m="";
            try
            {
                BufferedReader b=new BufferedReader(new FileReader("Bin/Message/"+empid+"/"+(count+1)+".ravs"));
                String data=b.readLine();
                jTextField2.setText(data);
                while(data!=null)
                {
                    data=b.readLine();
                    if(data!=null)
                    {
                        m+=data+"\n";
                    }
                }
            }catch(Exception asda){}
            feedbackt.setText(m);
        }
 else
     {
            submitf.setVisible(false);
            String m="";
            try
            {
                BufferedReader b=new BufferedReader(new FileReader("Bin/Message/"+empid+"/"+(count+1)+".ravs"));
                String data=b.readLine();
                jTextField2.setText(data);
                while(data!=null)
                {
                    data=b.readLine();
                    if(data!=null)
                    {
                        m+=data+"\n";
                    }
                }
            }catch(Exception asda){}
            feedbackt.setText(m);
        }
        
        submitf.setToolTipText("Arrow Left");
        submitf.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                count--;
                resetf.setVisible(true);
                String m="";
                try
                {
                    BufferedReader b=new BufferedReader(new FileReader("Bin/Message/"+empid+"/"+(count+1)+".ravs"));
                    String data=b.readLine();
                    jTextField2.setText(data);
                    while(data!=null)
                    {
                        data=b.readLine();
                        if(data!=null)
                        {
                            m+=data+"\n";
                        }
                    }
                }catch(Exception asda){}
                feedbackt.setText(m);
                if(count<=0)
                {
                    count=0;
                    submitf.setVisible(false);
                }
            }
        });
        resetf.setToolTipText("Arrow Right");
        resetf.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                count++;
                submitf.setVisible(true);
                String m="";
                try
                {
                    BufferedReader b=new BufferedReader(new FileReader("Bin/Message/"+empid+"/"+(count+1)+".ravs"));
                    String data=b.readLine();
                    jTextField2.setText(data);
                    while(data!=null)
                    {
                        data=b.readLine();
                        if(data!=null)
                        {
                            m+=data+"\n";
                        }
                    }
                }catch(Exception asda){}
                feedbackt.setText(m);
                if(count>=length-1)
                {
                    count=length-1;
                    resetf.setVisible(false);
                }
            }
        });

        jLabel10.setFont(new Font("Serif", 1, 16)); 
        jLabel10.setText("From :");

        jTextField2.setFont(new Font("Tahoma", 0, 16)); 

        jLabel11.setFont(new Font("Serif", 1, 16)); 
        jLabel11.setText("Message");

        jButton1.setToolTipText("Send");
        jButton1.setVisible(false);

        jLabel26.setFont(new Font("Verdana", 1, 18));

        jLabel26.setForeground(new Color(51, 102, 255));
        jLabel26.setText("Message Box");

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(submitf)
                        .addGap(80, 80, 80)
                        .addComponent(jButton1)
                        .addGap(89, 89, 89)
                        .addComponent(resetf)
                        .addGap(121, 121, 121))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2)
                                    .addComponent(jTextField2,GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE))))))
                .addGap(182, 182, 182))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(383, 383, 383)
                .addComponent(jLabel26)
                .addContainerGap(453, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel26)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jLabel11)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2,GroupLayout.PREFERRED_SIZE, 294,GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(resetf)
                    .addComponent(submitf)
                    .addComponent(jButton1))
                .addGap(40, 40, 40))
        );

        jTabbedPane4.addTab("", jPanel3);

        emppane.addTab("Message Box", jTabbedPane4);

        jLabel12.setFont(new Font("Verdana", 1, 18)); 
        jLabel12.setForeground(new Color(0, 51, 255));
        jLabel12.setText("Exit System Feedback Form");

        jLabel13.setFont(new Font("Serif", 1, 12)); 
        jLabel13.setText("It is our company policy to seek infomation on how we can improve.");

        jLabel14.setFont(new Font("Serif", 1, 12)); 
        jLabel14.setText("We would appreciate your taking the time to answer the following questions.");

        jLabel15.setFont(new Font("Serif", 1, 12)); 
        jLabel15.setText("Your responses are treated as confidential.Thank you for taking the time.");

        jLabel16.setFont(new Font("Serif", 0, 12)); 
        jLabel16.setText("Q.1 What prompted you to seek alternative employment?");

        jCheckBox23.setFont(new Font("Serif", 0, 12)); 
        jCheckBox23.setText("Type of work");

        jCheckBox24.setFont(new Font("Serif", 0, 12)); 
        jCheckBox24.setText("Quality of supervisor");

        jCheckBox25.setFont(new Font("Serif", 0, 12));
        jCheckBox25.setText("Work condition");

        jCheckBox26.setFont(new Font("Serif", 0, 12)); 
        jCheckBox26.setText("Lack of recognition");

        jCheckBox27.setFont(new Font("Serif", 0, 12)); 
        jCheckBox27.setText("Compensation ");

        jLabel17.setFont(new Font("Serif", 0, 12)); 
        jLabel17.setText("Q.2 How would you rate your supervisor in following areas");

        jLabel18.setFont(new Font("Serif", 0, 12));
        jLabel18.setText("5) outstanding 4)very good 3) good 2) Poor 1) very poor");

        jLabel19.setFont(new Font("Serif", 0, 12));
        jLabel19.setText("Gave fair and equal treatment to everyone");

        jLabel20.setFont(new Font("Serif", 0, 12));
        jLabel20.setText("Provided recognition for job well done");

        jLabel21.setFont(new Font("Serif", 0, 12));
        jLabel21.setText("Listened to suggestions");

        jLabel22.setFont(new Font("Serif", 0, 12));
        jLabel22.setText("Resolved complaints and problems");

        jLabel23.setFont(new Font("Serif", 0, 12));
        jLabel23.setText("Q.3 Workload :");

        jCheckBox28.setFont(new Font("Serif", 0, 12));
        jCheckBox28.setText("too much");

        jCheckBox29.setFont(new Font("Serif", 0, 12));
        jCheckBox29.setText("too light");

        jCheckBox30.setFont(new Font("Serif", 0, 12));
        jCheckBox30.setText("about right");

        jLabel24.setFont(new Font("Serif", 0, 12)); 
        jLabel24.setText("Q.4 What did you like most about your job ?");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setLineWrap(true);
        jTextArea1.setFont(new Font("Serif", 0, 14));
        jScrollPane3.setViewportView(jTextArea1);

        jLabel25.setFont(new Font("Serif", 0, 12));  
        jLabel25.setText("Q.5 What did u like least about your job ? ");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setLineWrap(true);
        jTextArea2.setFont(new Font("Serif", 0, 14));
        jScrollPane4.setViewportView(jTextArea2);

        jButton2.setToolTipText("Send");
        jButton2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                try
                {
                    BufferedWriter b=new BufferedWriter(new FileWriter("Bin/feedback/"+empid+".ravs"));
                    b.append("Feedback Details");
                    b.newLine();
                    b.newLine();
                    b.append("Q.1 What prompted you to seek alternative employment?");
                    b.newLine();
                    if(jCheckBox23.isSelected())
                    {
                        b.append("Type Of Work");
                        b.newLine();
                    }
                    else
                    if(jCheckBox24.isSelected())
                    {
                        b.append("Quality of supervisor");
                        b.newLine();
                    }
                    else
                    if(jCheckBox25.isSelected())
                    {
                        b.append("Work Condition");
                        b.newLine();
                    }
                    else
                    if(jCheckBox26.isSelected())
                    {
                        b.append("Lack of recognition");
                        b.newLine();
                    }
                    else
                    if(jCheckBox27.isSelected())
                    {
                        b.append("Compensation");
                        b.newLine();
                    }
                    b.newLine();
                    b.append("Q.2 How would you rate your supervisor in following areas");
                    b.newLine();
                    if(jTextField3.getText().equalsIgnoreCase("1"))
                    {
                        b.append("Gave fair and equal treatment to everyone : very poor");
                        b.newLine();
                    }
                    else
                    if(jTextField3.getText().equalsIgnoreCase("2"))
                    {
                        b.append("Gave fair and equal treatment to everyone : poor");
                        b.newLine();
                    }
                    else
                    if(jTextField3.getText().equalsIgnoreCase("3"))
                    {
                        b.append("Gave fair and equal treatment to everyone : good");
                        b.newLine();
                    }
                    else
                    if(jTextField3.getText().equalsIgnoreCase("4"))
                    {
                        b.append("Gave fair and equal treatment to everyone : very good");
                        b.newLine();
                    }
                    else
                    if(jTextField3.getText().equalsIgnoreCase("5"))
                    {
                        b.append("Gave fair and equal treatment to everyone : outstanding");
                        b.newLine();
                    }
                   if(jTextField4.getText().equalsIgnoreCase("1"))
                    {
                        b.append("Provided recognition for job well done : very poor");
                        b.newLine();
                    }
                    else
                    if(jTextField4.getText().equalsIgnoreCase("2"))
                    {
                        b.append("Provided recognition for job well done : poor");
                        b.newLine();
                    }
                    else
                    if(jTextField4.getText().equalsIgnoreCase("3"))
                    {
                        b.append("Provided recognition for job well done : good");
                        b.newLine();
                    }
                    else
                    if(jTextField4.getText().equalsIgnoreCase("4"))
                    {
                        b.append("Provided recognition for job well done : very good");
                        b.newLine();
                    }
                    else
                    if(jTextField4.getText().equalsIgnoreCase("5"))
                    {
                        b.append("Provided recognition for job well done : outstanding");
                        b.newLine();
                    }
                    if(jTextField5.getText().equalsIgnoreCase("1"))
                    {
                        b.append("Listened to suggestions : very poor");
                        b.newLine();
                    }
                    else
                    if(jTextField5.getText().equalsIgnoreCase("2"))
                    {
                        b.append("Listened to suggestions : poor");
                        b.newLine();
                    }
                    else
                    if(jTextField5.getText().equalsIgnoreCase("3"))
                    {
                        b.append("Listened to suggestions : good");
                        b.newLine();
                    }
                    else
                    if(jTextField5.getText().equalsIgnoreCase("4"))
                    {
                        b.append("Listened to suggestions : very good");
                        b.newLine();
                    }
                    else
                    if(jTextField5.getText().equalsIgnoreCase("5"))
                    {
                        b.append("Listened to suggestions : outstanding");
                        b.newLine();
                    }
                    if(jTextField6.getText().equalsIgnoreCase("1"))
                    {
                        b.append("Resolved complaints and problems : very poor");
                        b.newLine();
                    }
                    else
                    if(jTextField6.getText().equalsIgnoreCase("2"))
                    {
                        b.append("Resolved complaints and problems : poor");
                        b.newLine();
                    }
                    else
                    if(jTextField6.getText().equalsIgnoreCase("3"))
                    {
                        b.append("Resolved complaints and problems : good");
                        b.newLine();
                    }
                    else
                    if(jTextField6.getText().equalsIgnoreCase("4"))
                    {
                        b.append("Resolved complaints and problems : very good");
                        b.newLine();
                    }
                    else
                    if(jTextField6.getText().equalsIgnoreCase("5"))
                    {
                        b.append("Resolved complaints and problems : outstanding");
                        b.newLine();
                    }
                    b.newLine();
                    b.append("Q.3 Workload :");
                    b.newLine();
                    if(jCheckBox23.isSelected())
                    {
                        b.append("Too Much");
                        b.newLine();
                    }
                    else
                    if(jCheckBox24.isSelected())
                    {
                        b.append("Too Light");
                        b.newLine();
                    }
                    else
                    if(jCheckBox25.isSelected())
                    {
                        b.append("About Right");
                        b.newLine();
                    }
                    b.newLine();
                    b.append("Q.4 What did you like most about your job ?");
                    b.newLine();
                    b.append(jTextArea1.getText().trim());
                    b.newLine();
                    b.append("Q.5 What did u like least about your job ? ");
                    b.newLine();
                    b.append(jTextArea2.getText().trim());
                    b.close();
                }catch(Exception ad){}
                JOptionPane.showMessageDialog(null,"Thank you for the feedback. Good luck","Alert",JOptionPane.INFORMATION_MESSAGE);
                jButton2.setEnabled(false);
            }
        });
        

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jCheckBox23)
                .addContainerGap(807, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField3,GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(jTextField4)
                    .addComponent(jTextField5)
                    .addComponent(jTextField6))
                .addContainerGap(656, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox28)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox29)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel18))
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jCheckBox24)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox27)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox26)
                        .addGap(42, 42, 42)
                        .addComponent(jCheckBox25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(214, 214, 214)
                        .addComponent(jLabel25)))
                .addContainerGap(162, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 261,GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163)
                .addComponent(jScrollPane4,GroupLayout.PREFERRED_SIZE, 267,GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(365, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(323, 323, 323))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(436, 436, 436)
                .addComponent(jButton2)
                .addContainerGap(459, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox23)
                    .addComponent(jCheckBox24)
                    .addComponent(jCheckBox27)
                    .addComponent(jCheckBox26)
                    .addComponent(jCheckBox25))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextField4,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField5,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTextField6,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jCheckBox28)
                    .addComponent(jCheckBox29)
                    .addComponent(jCheckBox30))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, 0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3,GroupLayout.PREFERRED_SIZE, 66,GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jButton2)
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("", jPanel1);

        emppane.addTab("Feedback", jTabbedPane1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emppane, GroupLayout.PREFERRED_SIZE, 980,  GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emppane,GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                .addContainerGap())
        );

        jCheckBox17.setEnabled(false);
        jCheckBox18.setEnabled(false);
        jCheckBox19.setEnabled(false);
        jCheckBox20.setEnabled(false);
        jCheckBox31.setEnabled(false);
        jCheckBox32.setEnabled(false);
        jCheckBox33.setEnabled(false);
        jCheckBox34.setEnabled(false);
        jCheckBox35.setEnabled(false);
        jCheckBox36.setEnabled(false);
        jCheckBox37.setEnabled(false);
        jCheckBox38.setEnabled(false);
        jCheckBox39.setEnabled(false);
        jCheckBox40.setEnabled(false);
        jCheckBox41.setEnabled(false);
        jCheckBox42.setEnabled(false);
        jCheckBox43.setEnabled(false);
        jCheckBox44.setEnabled(false);
        jCheckBox45.setEnabled(false);
        jCheckBox46.setEnabled(false);
        jCheckBox47.setEnabled(false);
        jCheckBox48.setEnabled(false);
        String m=""+status.charAt(0);
        String p=""+status.charAt(1);
        String hr=""+status.charAt(2);
        String f=""+status.charAt(3);
        String i=""+status.charAt(4);
        String a=""+status.charAt(5);
        String t=""+status.charAt(6);
        if(m.equalsIgnoreCase("0"))
        {
            jCheckBox17.setSelected(true);
        }
        else
            if(m.equalsIgnoreCase("1"))
            {
                jCheckBox20.setSelected(true);
            }
            else
                if(m.equalsIgnoreCase("2"))
                {
                    jCheckBox42.setSelected(true);
                }
        if(p.equalsIgnoreCase("0"))
        {
            jCheckBox18.setSelected(true);
        }
        else
            if(p.equalsIgnoreCase("1"))
            {
                jCheckBox19.setSelected(true);
            }
            else
                if(p.equalsIgnoreCase("2"))
                {
                    jCheckBox35.setSelected(true);
                }
        if(hr.equalsIgnoreCase("0"))
        {
            jCheckBox31.setSelected(true);
        }
        else
            if(hr.equalsIgnoreCase("1"))
            {
                jCheckBox39.setSelected(true);
            }
            else
                if(hr.equalsIgnoreCase("2"))
                {
                    jCheckBox36.setSelected(true);
                }
        if(f.equalsIgnoreCase("0"))
        {
            jCheckBox46.setSelected(true);
        }
        else
            if(f.equalsIgnoreCase("1"))
            {
                jCheckBox40.setSelected(true);
            }
            else
                if(f.equalsIgnoreCase("2"))
                {
                    jCheckBox37.setSelected(true);
                }
        if(i.equalsIgnoreCase("0"))
        {
            jCheckBox32.setSelected(true);
        }
        else
            if(i.equalsIgnoreCase("1"))
            {
                jCheckBox41.setSelected(true);
            }
            else
                if(i.equalsIgnoreCase("2"))
                {
                    jCheckBox38.setSelected(true);
                }
        if(a.equalsIgnoreCase("0"))
        {
            jCheckBox33.setSelected(true);
        }
        else
            if(a.equalsIgnoreCase("1"))
            {
                jCheckBox43.setSelected(true);
            }
            else
                if(a.equalsIgnoreCase("2"))
                {
                    jCheckBox48.setSelected(true);
                }
        if(t.equalsIgnoreCase("0"))
        {
            jCheckBox45.setSelected(true);
        }
        else
            if(t.equalsIgnoreCase("1"))
            {
                jCheckBox34.setSelected(true);
            }
            else
                if(t.equalsIgnoreCase("2"))
                {
                    jCheckBox47.setSelected(true);
                }

        if((status.contains("0000000"))&&(!status.equalsIgnoreCase("00000000")))
        {
            jButton2.setEnabled(true);
        }
        else
        if(status.equalsIgnoreCase("00000000"))
        {
            jButton2.setEnabled(true);
            jCheckBox44.setSelected(true);
            submit.setEnabled(false);
            reason.setEditable(false);
            jTextField1.setEditable(false);
            submitf.setEnabled(false);
            resetf.setEnabled(false);
        }
        else
        {
            jButton2.setEnabled(false);
        }
        File ff=new File("Bin/feedback/"+empid+".ravs");
        if(ff.exists())
        {
            jButton2.setEnabled(false);
        }
        if(!checkreason().equalsIgnoreCase("na"))
        {
            submit.setEnabled(false);
            reason.setEditable(false);
            jTextField1.setEditable(false);
            String d="";
            try
            {
                BufferedReader bb=new BufferedReader(new FileReader("Bin\\reasons\\"+empid+".ravs"));
                String data=bb.readLine();
                while(data!=null)
                {
                    d=d+data+"\n";
                    data=bb.readLine();
                }
                bb.close();
            }catch(Exception sad){}
            reason.setText(d);
        }
        emppane.getAccessibleContext().setAccessibleName("Resignation");
        setTitle("Employee Screen");
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\r.gif"));
        setLocation(h/5,w/150);
        setResizable(false);
        pack();
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

    public String checkreason()
    {
        Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D:\\Harman.mdb";
            con = DriverManager.getConnection(driver,"","");
            Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT * FROM exitmanag where emp_id="+empid);
            if(res.next())
            {
                return res.getString("reason").trim();
            }
            res.close();
            sta.close();
            con.close();
        } catch (Exception e) {    }
      return "";
    }
}
