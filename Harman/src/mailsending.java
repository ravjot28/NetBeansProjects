import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class mailsending extends javax.swing.JFrame 
{
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    XrButton jButton1 = new XrButton(new ImageIcon("Bin\\img\\ok.png"));
    XrButton jButton2 = new XrButton(new ImageIcon("Bin\\img\\reset.png"));
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    String mempid;
    String empid;
    public mailsending(String a,String b)
    {
        mempid=a;
        empid=b;
        initComponents();
    }
    
    private void initComponents()
    {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18));
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Message Sending");

        jLabel2.setFont(new java.awt.Font("Serif", 1, 14));
        jLabel2.setText("To : "+empid);

        jLabel3.setFont(new java.awt.Font("Serif", 1, 14));
        jLabel3.setText("Reason for Rejecting");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setLineWrap(true);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setToolTipText("Submit");
        jButton1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                if(jTextArea1.getText().equalsIgnoreCase(""))
                {
                    JOptionPane.showMessageDialog(null,"Please give the reason for rejecting the resignation","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    String role=new RoleQuery(mempid).search("D:/Harman.mdb");
                    String message=jTextArea1.getText();
                    if(role.equalsIgnoreCase("m"))
                    {
                        role="Manager 1 Despt.";
                    }
                    else
                    if(role.equalsIgnoreCase("p"))
                    {
                        role="Project Head Despt.";
                    }
                    else
                    if(role.equalsIgnoreCase("hr"))
                    {
                        role="HR Dept.";
                    }
                    else
                    if(role.equalsIgnoreCase("a"))
                    {
                        role="Admin Dept.";
                    }
                    else
                    if(role.equalsIgnoreCase("i"))
                    {
                        role="IT Dept.";
                    }
                    try
                    {
                        int i=new File("Bin/Message/"+empid+"/").list().length;
                        BufferedWriter b=new BufferedWriter(new FileWriter("Bin/Message/"+empid+"/"+(i+1)+".ravs"));
                        b.append(role);
                        b.newLine();
                        b.append(message);
                        b.close();
                    }catch(Exception asd){}
                    JOptionPane.showMessageDialog(null,"Message Sent","Alert",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            }
        });

        jButton2.setToolTipText("Reset");
        jButton2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                jTextArea1.setText("");
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jButton1)
                        .addGap(46, 46, 46)
                        .addComponent(jButton2)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );
       // setAlwaysOnTop(true);
        addWindowListener(new WindowAdapter()
        {      public void windowClosing(WindowEvent e) {       setVisible(false);      }    });
        setTitle("Sending Message");
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\r.gif"));
        setLocation(h/2,w/10);
        setResizable(false);
        pack();
    }
}
