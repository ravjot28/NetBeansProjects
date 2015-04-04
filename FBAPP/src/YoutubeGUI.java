
import com.google.code.facebookapi.FacebookException;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import org.apache.commons.httpclient.HttpException;


public class YoutubeGUI extends javax.swing.JFrame implements Runnable
{
    JFrame fplz;
    Thread thread=new Thread(this);
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    String message="";
    String url="";
    public YoutubeGUI()
    {
        initComponents();
    }
    
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Publish Youtube Videos");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea1.setLineWrap(true);
        jTextArea1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                String text = jTextArea1.getText();
                int length = text.length();
                if (length == 420)
                {
                    e.consume();
                } else if (length > 420) {
                    jTextArea1.setText(text.substring(0, 420));
                    JOptionPane.showMessageDialog(null,"Facebook allows only 420 characters cant exceed","Error",JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Message");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Youtube URL");

        jButton1.setToolTipText("Publish");
        jButton1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                message=jTextArea1.getText();
                url=jTextField1.getText();
                if(url.equalsIgnoreCase(""))
                {
                    JOptionPane.showMessageDialog(null,"Enter the URL","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                    if(!url.contains("youtube"))
                    {
                        JOptionPane.showMessageDialog(null,"Enter the correct url","Error",JOptionPane.ERROR_MESSAGE);
                    }
                else
                {
                    new plzwai();
                    thread.start();
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
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(47, 47, 47)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                            .addComponent(jLabel2))))
                .addGap(73, 73, 73))
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jButton1)
                .addContainerGap(198, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(27, 27, 27))
        );
        setTitle("Facebook Application");
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin/img/r.png"));
         setLocation(h/2,w/7);
        setResizable(false);
        pack();
    }

    XrButton jButton1 = new XrButton(new ImageIcon("Bin/img/share.png"));
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;

    public void run()
    {
        String s="";
        try {
                    s=new SendtoFacebookyoutube().send(message,url);
                    fplz.setVisible(false);
                    JOptionPane.showMessageDialog(null,s,"Information",JOptionPane.INFORMATION_MESSAGE);
                } catch (FacebookException ex) {
                    Logger.getLogger(GUIFB.class.getName()).log(Level.SEVERE, null, ex);
                } catch (HttpException ex) {
                    Logger.getLogger(GUIFB.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUIFB.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    // End of variables declaration
    class plzwai extends JFrame
{
        Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    plzwai()
    {
         LookAndFeel lf = UIManager.getLookAndFeel();
               try
               {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception e) {
                    }
        /*fplz=new JFrame("Information");
        lplz=new JLabel("Uploading Files Please Wait..... Do not close this application while uploading files as it can harm your computer speed");
        fplz.add(new JPanel(),BorderLayout.NORTH);
        fplz.add(new JPanel(),BorderLayout.SOUTH);
        fplz.add(new JPanel(),BorderLayout.EAST);
        fplz.add(new JPanel(),BorderLayout.WEST);
        fplz.add(lplz,BorderLayout.CENTER);
        fplz.addWindowListener(new WindowAdapter() {

                public void windowClosing(WindowEvent e) {       new plzwai();    }
            });
        fplz.pack();
        fplz.setLocationRelativeTo(null);
        fplz.setVisible(true);*/
         fplz = new JFrame("Connecting Facebook Please Wait....");
   fplz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final JProgressBar aJProgressBar = new JProgressBar(JProgressBar.HORIZONTAL);
    //aJProgressBar.setStringPainted(true);
    aJProgressBar.setIndeterminate(true);
    fplz.setIconImage(Toolkit.getDefaultToolkit().getImage("Bin/img/airindia.jpg"));
    fplz.add(new JPanel(),BorderLayout.NORTH);
    fplz.add(new JPanel(),BorderLayout.WEST);
    fplz.add(new JPanel(),BorderLayout.EAST);
    fplz.add(new JPanel(),BorderLayout.SOUTH);
    fplz.add(aJProgressBar, BorderLayout.CENTER);
    fplz.setLocation(h/3,w/4);
    fplz.setSize(700, 100);
    fplz.setVisible(true);
    }
}
}
