
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class ehs extends javax.swing.JFrame implements Runnable
{
    Thread t12=new Thread(this);
    XrButton jButton1 = new XrButton(new ImageIcon("Bin\\img\\logout.png"));
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    JFrame fplz;
    String t[] = new String[1];
    String t1;
    String emp;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    
    public ehs()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        look();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jTable1.setFont(new java.awt.Font("Serif", 1, 14));
        String a[][]=new DetailQueryehs().search("D:/Harman.mdb");
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            a,
            new String [] {
                "Resignation Date", "Name (Emp ID)", "Send Mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getColumn("Send Mail").setCellRenderer(new ButtonRenderer());
        jTable1.getColumn("Send Mail").setCellEditor(new ButtonEditor(new JCheckBox()));
        jTable1.addMouseListener(new CellButtonsMouseListener());
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(2).setResizable(false);

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 18));
        jLabel13.setForeground(new java.awt.Color(0, 51, 255));
        jLabel13.setText("Welcome To Exit System");

        jButton1.setToolTipText("LogOut");
        jButton1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                 dispose();
                 new login().setVisible(true);
            }
            });

        jLabel14.setFont(new java.awt.Font("Serif", 1, 14));
        jLabel14.setText("Deatils of Employee");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)
                        .addGap(14, 14, 14)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("", jPanel1);

        jTabbedPane1.addTab("Notification", jTabbedPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                .addContainerGap())
        );
        setTitle("EHS Screen");
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\r.gif"));
        setLocation(h/4,w/20);
        setResizable(false);
        pack();
    }

    public void run()
    {
        t[0]=t1;
        String date=new Calendar1().getdate();
        String a[]=getdetails(emp);
        String message=date+"\n\n"+a[0]+"\n"+a[1]
                +"\n\n\n\nDear Candidate, "
                +"\n\nWith reference to your resignation letter dated on "+a[3]
                +", we hereby accept your resignation and agree to relieve you from the duties on "+date+"."
                +"\nWe confirm that you have been working in our company from "+a[2]
                +"\n\nDuring your employment with us we found you to be hard working, diligent and honest in performing your duties." 
                +"The management would like to thank you for your service with the company and we wish you all the best in your future endeavors. "
                +"\n\n\n\nYours Sincerely"
                +"\n\nHCL TECHNOLOGY ";
                                    sending s1=new sending("exitmanagementsystem@gmail.com",message,"Your Password",t,"ravjotrocks");
                                    String result=s1.send();
                                    if(result.equalsIgnoreCase("Your message is successfully mailed"))
                                    {

                                        fplz.setVisible(false);
                                        JOptionPane.showMessageDialog(null, "Mail Sent","Alert",JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    else
                                    {

                                        fplz.setVisible(false);
                                        JOptionPane.showMessageDialog(null,"Oops Internet Connection Problem Please check your connection and then restart","Error",JOptionPane.ERROR_MESSAGE);
                                    }
    }
    class CellButtonsMouseListener extends MouseAdapter{
    @Override
    public void mouseReleased(MouseEvent e) {
        JTable t = (JTable)e.getComponent();
        Point pt = e.getPoint();
        int row  = t.rowAtPoint(pt);
        int col  = t.columnAtPoint(pt);
        if(t.convertRowIndexToModel(row)>=0 && t.convertColumnIndexToModel(col)>1 && t.convertColumnIndexToModel(col)<3)
        {
            if(t.convertColumnIndexToModel(col)==2)
            {
                Object o = jTable1.getValueAt(row,1);
                String empid=o.toString().substring(o.toString().indexOf("(")+1,o.toString().lastIndexOf(")"));
                String co=new StatusQuery(empid).search("D:/Harman.mdb");
                if(!co.equalsIgnoreCase("00000000"))
                {
                t1=new EmailQuery(empid).search("D:/Harman.mdb");
                emp=empid;
                update(empid);
                new plzwai();
                t12.start();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "You have already sent the relieving letter","Alert",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            TableCellEditor ce = t.getCellEditor(row, col);
            ce.stopCellEditing();
            Component c = ce.getTableCellEditorComponent(t, null, true, row, col);
            Point p = SwingUtilities.convertPoint(t, pt, c);
            Component b = SwingUtilities.getDeepestComponentAt(c, p.x, p.y);
            if(b instanceof JButton) ((JButton)b).doClick();
        }
    }
}

    class ButtonRenderer extends JButton implements TableCellRenderer {

  public ButtonRenderer() {
    setOpaque(true);
  }

  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(UIManager.getColor("Button.background"));
    }
    setText((value == null) ? "" : value.toString());
    return this;
  }
}
class ButtonEditor extends DefaultCellEditor {
  protected JButton button;

  private String label;

  private boolean isPushed;

  public ButtonEditor(JCheckBox checkBox) {
    super(checkBox);
    button = new JButton();
    button.setOpaque(true);

  }

  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else {
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    label = (value == null) ? "" : value.toString();
    button.setText(label);
    isPushed = true;
    return button;
  }

  public Object getCellEditorValue() {
    if (isPushed) {
      //
      //
      //JOptionPane.showMessageDialog(button, label + ": Ouch!");
      // System.out.println(label + ": Ouch!");
    }
    isPushed = false;
    return new String(label);
  }

  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }

  protected void fireEditingStopped() {
    super.fireEditingStopped();
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

    public void update(String empid)
    {
        Connection con = null;
    try
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D:/Harman.mdb";
            con = DriverManager.getConnection(driver,"","");
           Statement sta = con.createStatement();
        sta.executeUpdate("UPDATE exitmanag SET confirmation='00000000'"+" where emp_id="+empid);
        sta.close();
        con.close();
    } catch (Exception e) {    }
    }
    class plzwai extends JFrame
{
        Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    plzwai()
    {
               try
               {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                   //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception e) {
                    }
         fplz = new JFrame("Sending Relieving Letter  .Please Wait....");
   fplz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final JProgressBar aJProgressBar = new JProgressBar(JProgressBar.HORIZONTAL);
    //aJProgressBar.setStringPainted(true);
    aJProgressBar.setIndeterminate(true);
    fplz.setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\airindia.jpg"));
    fplz.add(new JPanel(),BorderLayout.NORTH);
    fplz.add(new JPanel(),BorderLayout.WEST);
    fplz.add(new JPanel(),BorderLayout.EAST);
    fplz.add(new JPanel(),BorderLayout.SOUTH);
    fplz.add(aJProgressBar, BorderLayout.CENTER);
    fplz.setResizable(false);
    fplz.setLocation(h/3,w/4);
    fplz.setSize(700, 100);
    fplz.setVisible(true);
    }
}

     public String[] getdetails(String empid)
    {
        String a[]=new String[4];
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
            a[0]=res.getString("emp_name");
            a[2]=res.getString("dateofjoinning");
            a[1]=res.getString("emp_adr");
            a[3]=res.getString("dor");
            }

      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {  System.out.println(e);  }
        return a;
    }

}
