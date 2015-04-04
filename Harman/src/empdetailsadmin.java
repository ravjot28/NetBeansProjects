import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class empdetailsadmin extends javax.swing.JFrame
{
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    XrButton jButton1 = new XrButton(new ImageIcon("Bin\\img\\accept.png"));
    XrButton jButton2 = new XrButton(new ImageIcon("Bin\\img\\uc.png"));
    XrButton jButton3 = new XrButton(new ImageIcon("Bin\\img\\reject.png"));
    private javax.swing.JTextField jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    String empid;
    String mempid;

    public empdetailsadmin(String emp,String asd)
    {
        empid=asd;
        mempid=emp;
        initComponents();
    }

    private void initComponents()
    {
        String rav[]=getdetails();
        look();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox1 = new IntegerField();
        jTextField1 = new IntegerField();
        jTextField2 = new IntegerField();
        jTextField1.setText("0");
        jTextField2.setText("0");
        jCheckBox1.setText("0");
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Admin Dept");

        jLabel2.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel2.setText("Employee Name (ID) : "+rav[1]+" ("+empid+")");

        jLabel3.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel3.setText("Any imprest :");

        jLabel4.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel4.setText("Travel Advance :");

        jLabel5.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel5.setText("Outstanding loans/advances :");

        jButton1.setToolTipText("Accept");
        jButton1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                int response;
                    response = JOptionPane.showConfirmDialog(null, "Are you sure you want to accept the resignation?");
                    if(response==0)
                    {
                        update(0);
                        dispose();
                    }
            }
        });

        jButton2.setToolTipText("Send Message");
        jButton2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                int response;
                response = JOptionPane.showConfirmDialog(null, "Are you sure you want to send the message?");
                if(response==0)
                {
                boolean notice,leave,icard;
                String no="";
                String le="";
                String ic="";
                if(!jTextField2.getText().trim().equalsIgnoreCase("0"))
                {
                    notice=true;
                }
                else
                {
                    notice=false;
                }
                if(!jTextField1.getText().trim().equalsIgnoreCase("0"))
                {
                    leave=true;
                }
                else
                {
                    leave=false;
                }if(!jCheckBox1.getText().trim().equalsIgnoreCase("0"))
                {
                    icard=true;
                }
                else
                {
                    icard=false;
                }
                if(notice)
                {
                    no="Imprest to be paid Rs."+jTextField2.getText().trim();
                }
                if(leave)
                {
                    le="Travel advance to be paid Rs."+jTextField1.getText().trim();
                }
                if(icard)
                {
                    ic="Outstanding loans/advance to be paid Rs."+jCheckBox1.getText().trim();
                }
                String message="";
                if(!no.equalsIgnoreCase(""))
                {
                    message+=no+",";
                }
                if(!le.equalsIgnoreCase(""))
                {
                    message+=le+",";
                }
                if(!ic.equalsIgnoreCase(""))
                {
                    message+=ic+",";
                }
                    new mailsendinghr(mempid,empid,message).setVisible(true);
                }
                dispose();
            }
        });

        jButton3.setToolTipText("Reject");
        jButton3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                int response;
                response = JOptionPane.showConfirmDialog(null, "Are you sure you want to reject the resignation?");
                if(response==0)
                {
                    update(2);
                    File f=new File("Bin/reasons/"+empid+".ravs");
                    f.delete();
                    new mailsending(mempid,empid).setVisible(true);
                    dispose();
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox1)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                            .addComponent(jTextField1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3))
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(34, 34, 34))
        );
        //setAlwaysOnTop(true);
        addWindowListener(new WindowAdapter()
        {      public void windowClosing(WindowEvent e) {       setVisible(false);      }    });
        setTitle("Employee Detail Screen");
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\r.gif"));
        setLocation(h/2,w/10);
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

     public void update(int a)
    {
        String conf=new StatusQuery(empid).search("D:/Harman.mdb");
        String p=conf.substring(6);
        if(a==0)
        {
             Connection con = null;
             try
             {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D:/Harman.mdb";
                con = DriverManager.getConnection(driver,"","");
                Statement sta = con.createStatement();
                sta.executeUpdate("UPDATE exitmanag SET confirmation='"+conf.charAt(0)+conf.charAt(1)+conf.charAt(2)+conf.charAt(3)+conf.charAt(4)+("0"+p)+"'"+" where emp_id="+empid);
                sta.close();
                con.close();
            } catch (Exception e) {    }
        }
        else
        {
            Connection con = null;
             try
             {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D:/Harman.mdb";
                con = DriverManager.getConnection(driver,"","");
                Statement sta = con.createStatement();
                sta.executeUpdate("UPDATE exitmanag SET reason='na'"+" where emp_id="+empid);
                sta.executeUpdate("UPDATE exitmanag SET dor='0'"+" where emp_id="+empid);
                sta.executeUpdate("UPDATE exitmanag SET confirmation='"+conf.charAt(0)+conf.charAt(1)+conf.charAt(2)+conf.charAt(3)+conf.charAt(4)+("2"+p)+"'"+" where emp_id="+empid);
                sta.close();
                con.close();
            } catch (Exception e) {    }
        }
    }

     public String[] getdetails()
    {
        String a[]=new String[10];
        Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D:/Harman.mdb";
            con = DriverManager.getConnection(driver,"","");
            Statement sta = con.createStatement();
            ResultSet res = sta.executeQuery("SELECT * FROM exitmanag where emp_id="+empid);
            if(res.next())
            {
            a[0]=res.getString("emp_id");
            a[1]=res.getString("emp_name");
            a[2]=res.getString("currentproject");
            a[3]=res.getString("department");
            a[4]=res.getString("dateofjoinning");
            a[5]=res.getString("emp_adr");
            a[6]=res.getString("emp_phoneno");
            a[7]=res.getString("region");
            a[8]=res.getString("dor");
            String loc=res.getString("reason");
            String p="";
            try
            {
                BufferedReader bb=new BufferedReader(new FileReader(loc));
                String data=bb.readLine();
                while(data!=null)
                {
                    p=p+data+"\n";
                    data=bb.readLine();
                }
                bb.close();
            }catch(Exception sadfafa){}
            a[9]=p;
            }

      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {  System.out.println(e);  }
        return a;
    }
}
