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

public class empdetailsManager1 extends javax.swing.JFrame
{
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    XrButton jButton1 = new XrButton(new ImageIcon("Bin\\img\\accept.png"));
    XrButton jButton2 = new XrButton(new ImageIcon("Bin\\img\\uc.png"));
    XrButton jButton3 = new XrButton(new ImageIcon("Bin\\img\\reject.png"));
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    String empid;
    String mempid;

    /** Creates new form empdetails */
    public empdetailsManager1(String emp,String asd)
    {
        empid=asd;
        mempid=emp;
        initComponents();
    }
    
    private void initComponents() 
    {
        String a[]=getdetails();
        look();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18));
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Employee's Detail");

        jLabel2.setFont(new java.awt.Font("Serif", 1, 16));
        jLabel2.setText("Employee ID : "+a[0]);

        jLabel3.setFont(new java.awt.Font("Serif", 1, 16));
        jLabel3.setText("Employee Name : "+a[1]);

        jLabel4.setFont(new java.awt.Font("Serif", 1, 16));
        jLabel4.setText("Current Project : "+a[2]);

        jLabel5.setFont(new java.awt.Font("Serif", 1, 16));
        jLabel5.setText("Department : "+a[3]);

        jLabel6.setFont(new java.awt.Font("Serif", 1, 16));
        jLabel6.setText("Date Of Joining : "+a[4]);

        jLabel7.setFont(new java.awt.Font("Serif", 1, 16));
        jLabel7.setText("Contact No. : "+a[6]);

        jLabel8.setFont(new java.awt.Font("Serif", 1, 16));
        jLabel8.setText("Region : "+a[7]);

        jLabel9.setFont(new java.awt.Font("Serif", 1, 16));
        jLabel9.setText("Address : "+a[5]);

        jLabel10.setFont(new java.awt.Font("Serif", 1, 16));
        jLabel10.setText("Date Of Resignation : "+a[8]);

        jLabel11.setFont(new java.awt.Font("Serif", 1, 16));
        jLabel11.setText("Reason : ");

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

        jButton2.setToolTipText("Under Consideration");

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

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText(a[9]);
        jTextArea1.setEditable(false);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(157, 157, 157)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(90, 90, 90)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jButton1)
                        .addGap(73, 73, 73)
                        .addComponent(jButton2)
                        .addGap(64, 64, 64)
                        .addComponent(jButton3)))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(45, 45, 45)
                .addComponent(jLabel10)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(71, 71, 71))
        );
        //setAlwaysOnTop(true);
        addWindowListener(new WindowAdapter()
        {      public void windowClosing(WindowEvent e) {       setVisible(false);      }    });
        setTitle("Employee Detail Screen");
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\r.gif"));
        setLocation(h/3,w/50);
        setResizable(false);
        pack();
        
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

    public void update(int a)
    {
        String conf=new StatusQuery(empid).search("D:/Harman.mdb");
        String p=conf.substring(1);
        if(a==0)
        {
             Connection con = null;
             try
             {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D:/Harman.mdb";
                con = DriverManager.getConnection(driver,"","");
                Statement sta = con.createStatement();
                sta.executeUpdate("UPDATE exitmanag SET confirmation='"+("0"+p)+"'"+" where emp_id="+empid);
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
                sta.executeUpdate("UPDATE exitmanag SET confirmation='"+("2"+p)+"'"+" where emp_id="+empid);
                sta.close();
                con.close();
            } catch (Exception e) {    }
        }
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

}

    
   
