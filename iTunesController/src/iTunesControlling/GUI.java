package iTunesControlling;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import jtunes.ClassFactory;
import jtunes.IITTrack;
import jtunes.IiTunes;

public class GUI extends javax.swing.JFrame
{
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension d = kit.getScreenSize();

    IITTrack track;


    IiTunes itunes;

    static
    {
        System.loadLibrary("com4j");
    }
    private JLabel jLabel1;

    public GUI()
    {
        itunes = ClassFactory.createiTunesApp();
        initComponents();
    }

    private void initComponents()
    {
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setTitle("iTunes Controller");
        setIconImage(new ImageIcon("Bin\\img\\r.gif").getImage());
        //setLayout(new GridLayout(2,0));

        setCursor(getToolkit().createCustomCursor(new ImageIcon("Bin\\img\\cursor.gif").getImage(), new Point(0,0), "Rav Cursor"));


        addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent we){itunes.quit(); System.exit(0);}});

        jButton1.setIcon(new javax.swing.ImageIcon("Bin\\img\\next.gif"));  
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae){next();}});

        jButton2.setIcon(new javax.swing.ImageIcon("Bin\\img\\pause.png"));  
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae){pause();}});

        jButton3.setIcon(new javax.swing.ImageIcon("Bin\\img\\play.gif"));  
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae){play();}});

        jButton4.setIcon(new javax.swing.ImageIcon("Bin\\img\\prev.gif"));  
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae){prev();}});

        jButton5.setIcon(new javax.swing.ImageIcon("Bin\\img\\stop.gif"));  
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae){stop();}});

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel1.setText("iTunes Controller Window Version ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        setAlwaysOnTop(true);
        pack();
        int x = (d.width-getSize().width)/2;
        int y = (d.height-getSize().height)/2;

        setLocation(x, y);
    }

    public void stop()
    {
        try
         {

            itunes.stop();
	  } catch (Exception ex) {System.out.println("exception : " + ex.getMessage()); ex.printStackTrace();}
    }

     public void play()
    {
        try
         {
            itunes.play();
	  } catch (Exception ex) {System.out.println("exception : " + ex.getMessage()); ex.printStackTrace();}
    }

      public void pause()
    {
        try
         {

            itunes.playPause();
	  } catch (Exception ex) {System.out.println("exception : " + ex.getMessage()); ex.printStackTrace();}
    }

       public void next()
    {
        try
         {

            itunes.nextTrack();
	  } catch (Exception ex) {System.out.println("exception : " + ex.getMessage()); ex.printStackTrace();}
    }

        public void prev()
    {
         try
         {

            itunes.previousTrack();
	  } catch (Exception ex) {System.out.println("exception : " + ex.getMessage()); ex.printStackTrace();}
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
}
