import com.google.code.facebookapi.FacebookException;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
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
import org.json.JSONException;

public class GUIFB extends javax.swing.JFrame implements Runnable
{
    JFrame fplz;
    XrButton jButton1 = new XrButton(new ImageIcon("Bin/img/share.png"));
    XrButton jButton2 = new XrButton(new ImageIcon("Bin/img/video.png"));
    XrButton jButton3 = new XrButton(new ImageIcon("Bin/img/edit.png"));
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    Thread thread=new Thread(this);
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    public GUIFB()
    {
        initComponents();
    }
    
    private void initComponents()
    {
         LookAndFeel lf = UIManager.getLookAndFeel();
               try
               {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception e) {
                    }

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Facebook Application");
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin/img/r.png"));


        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Rav FB App");

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

        jButton1.setToolTipText("Share");
        jButton1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                new plzwai();
                thread.start();
            }
        });

        jButton2.setToolTipText("Publish video");
        jButton2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YoutubeGUI().setVisible(true);
            }
        });
                
            }
        });

        jButton3.setToolTipText("Edit Account");
        jButton3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                File f=new File("Bin/AppID/id.ravs");
                f.delete();
                dispose();
                new Main();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(137, 137, 137))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(38, 38, 38)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        setLocation(h/2,w/7);
        setResizable(false);
        pack();
    }

    public void run() 
    {
        String a="";
            try {
                a = new SendtoFacebook().rav(jTextArea1.getText());
            } catch (Exception ex) {
             System.err.println("Error "+ex);
            }
        fplz.setVisible(false);
        if(a.equalsIgnoreCase("y"))
        {
            JOptionPane.showMessageDialog(null,"successfully updated","Information",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Encountered Error please try again","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

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
