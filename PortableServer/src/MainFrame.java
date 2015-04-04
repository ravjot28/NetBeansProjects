
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame implements Runnable,ServerList
{
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension d = kit.getScreenSize();

    URL buttonImage = getClass().getClassLoader().getResource(buttonimg);
    URL ic = getClass().getClassLoader().getResource(icon);

    Thread th = new Thread(this);

    InfiniteProgressPanel glassPane;

    String Apps;

    String List;

    public MainFrame()
    {
        super("Portable Server");
        initComponents();
    }

    private void initComponents()
    {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        glassPane = new InfiniteProgressPanel("Collecting Data. Please Wait...");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setIconImage(Toolkit.getDefaultToolkit().getImage(ic));

        setGlassPane(glassPane);

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 1, 18));
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Portable Server");

        jLabel2.setBackground(new java.awt.Color(255, 0, 51));
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("**Format of the Input is:  ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Exclude \"<\" \">\" for above statement");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText("<Application Name>,<Download Link><@>");

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setIcon(new javax.swing.ImageIcon(buttonImage)); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            process();
                                        }
                                    });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("Import Applications to Server");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addComponent(jButton1, 0, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
         setResizable(false);

        setLocation(d.height/2,d.width/9);

        pack();
    }

    public void process()
    {
        th = null;
        th = new Thread(this);
        Apps = jTextArea1.getText().trim();
        append();
        th.start();
    }

    public boolean append()
    {
        try
        {
            BufferedWriter b = new BufferedWriter(new FileWriter(fname,true));
            StringTokenizer s = new StringTokenizer(Apps,"@");
            while(s.hasMoreElements())
            {
                String temp = s.nextToken().trim();
                if(temp.length()>1)
                {
                    b.append(temp);
                    b.newLine();
                }
            }
            b.close();
            return true;
        }catch(Exception ae){return false;}
    }

    public void run()
    {
        glassPane.start();
        ReadAllEmail rae = new ReadAllEmail(emailId,password);
        if(rae.startreading())
        {
           String to[] = {emailId};
           SendApps sa = new SendApps(emailId,getList(),"",to,password);
           glassPane.setText("Sending Data to Server....");
           glassPane.revalidate();
           if(sa.send())
           {
                JOptionPane.showMessageDialog(null, "Success !!! Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                jTextArea1.setText("");
                glassPane.stop();
           }
           else
           {
               JOptionPane.showMessageDialog(null, "Oops !!! Internet Connection Error. Kindly Check Your Connection", "Error", JOptionPane.ERROR_MESSAGE);
               glassPane.stop();
           }
           glassPane.stop();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Oops !!! Internet Connection Error. Kindly Check Your Connection", "Error", JOptionPane.ERROR_MESSAGE);
            glassPane.stop();
        }
    }

    public String getList()
    {
        try
        {
            List = "";
            BufferedReader b = new BufferedReader(new FileReader(fname));
            String data = b.readLine();
            while(data!=null)
            {
                if(data.trim().length()>1)
                {
                    List+=data+"##";
                }
                    data=b.readLine();
            }
            return List;
        }catch(Exception ae){return null;}
    }
}
