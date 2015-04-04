import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class GUI1 extends JFrame implements Runnable
{
    public final static String frameimage="img/r.gif";
    String fname="";
    JButton jButton1;
    JFrame fplz;
    JTextField jTextField1;
    Thread thread=new Thread(this);
    public static final String RESULT= "Bin/Certi.pdf";
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    public GUI1()
    {
        initComponents();
    }

    private void initComponents()
    {
        look();
        URL frameurl=getClass().getClassLoader().getResource(frameimage);
        jButton1 = new JButton();
        jTextField1 = new IntegerField();
        jTextField1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                String text = jTextField1.getText();
                int length = text.length();
                if (length == 6)
                {
                    e.consume();
                } else if (length > 6) {
                    jTextField1.setText(text.substring(0, 6));
                }
            }
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Prepare Certificate");
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent e)
                                        {
                                            if(jTextField1.getText().equals(""))
                                            {
                                                JOptionPane.showMessageDialog(null,"Oops Please enter the Staff No.","Error",JOptionPane.ERROR_MESSAGE);
                                                
                                            }
                                            else
                                            {
                                                File f=new File("Bin/Info/"+jTextField1.getText().trim()+".ravs");
                                                if(f.exists())
                                                {
                                                    fname=jTextField1.getText().trim();
                                                    new plzwai();
                                                    thread.start();
                                                    dispose();
                                                }
                                                else
                                                {
                                                    JOptionPane.showMessageDialog(null,"Oops Entered Wrong Staff No.","Error",JOptionPane.ERROR_MESSAGE);
                                                }
                                            }

                                            jTextField1.setText("");
                                        }
                                    });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1,GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        setTitle("Member Page");
        setIconImage(Toolkit.getDefaultToolkit().getImage(frameurl));
        setLocation(h-h/2,w/7);
        setResizable(false);
        pack();
    }
    public static void main(String args[])
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new GUI1().setVisible(true);
            }
        });
    }

    public void run()
    {
        try
        {
            System.out.println("Fname "+fname);
            new FirstPageOfPaySlip().launch(fname);
            new CropPages().manipulatePdf(RESULT,"certi.pdf");
        } catch (Exception ex) {JOptionPane.showMessageDialog(null,ex,"Error",JOptionPane.ERROR_MESSAGE);}
        String cmd1="rundll32" + " " + "url.dll,FileProtocolHandler" + " "+"certi.pdf";
        try
        {
            Runtime.getRuntime().exec(cmd1);
        } catch (Exception ex) {
                                    try
        {
            Runtime rt=Runtime.getRuntime();
            rt.exec("open certi.pdf");
        }catch(Exception as){//System.out.println(as);
        }
        }
            fplz.dispose();
        

    }

    public void look()
    {
         try
         {
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
             //UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
              //UIManager.setLookAndFeel("com.easynth.lookandfeel.EaSynthLookAndFeel");
             //UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
             /*System.setProperty("Quaqua.tabLayoutPolicy","wrap");
             UIManager.setLookAndFeel(
                  ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel()
              );*/
         }catch(Exception e){}
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
             //UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
              //UIManager.setLookAndFeel("com.easynth.lookandfeel.EaSynthLookAndFeel");
             //UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
             /*System.setProperty("Quaqua.tabLayoutPolicy","wrap");
             UIManager.setLookAndFeel(
                  ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel()
              );*/
         }catch(Exception e){}
         fplz = new JFrame("Genrating The Certificate . Please Wait....");
         fplz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final JProgressBar aJProgressBar = new JProgressBar(JProgressBar.HORIZONTAL);
    //aJProgressBar.setStringPainted(true);
    aJProgressBar.setIndeterminate(true);
    URL frameurl=getClass().getClassLoader().getResource(frameimage);
    fplz.setIconImage(Toolkit.getDefaultToolkit().getImage(frameurl));
    //fplz.setUndecorated(true);
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
}
