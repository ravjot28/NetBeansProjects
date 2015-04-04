import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.JTextComponent;
import javax.swing.text.Keymap;

public class Option1 extends JFrame implements Runnable
{
    public final static String okimage="img/ok.png";
    public final static String frameimage="img/r.gif";
    public final static String filechooserimage="img/filechoose.png";
    public final static String changepassimage="img/changepass.png";
    URL okurl=getClass().getClassLoader().getResource(okimage);
    URL frameurl=getClass().getClassLoader().getResource(frameimage);
    URL filechooseurl=getClass().getClassLoader().getResource(filechooserimage);
    URL changepassurl=getClass().getClassLoader().getResource(changepassimage);
    JFrame fplz;
    Thread thread=new Thread(this);
    XrButton filechooser=new XrButton(new ImageIcon(filechooseurl));;
    JLabel head;
    JTextField location;
    XrButton passwordchange=new XrButton(new ImageIcon(changepassurl));;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    JButton jButton1;
    JLabel jLabel1;
    String filename;
    public Option1() {
        initComponents();
    }
    
    private void initComponents() {
        look();
        head = new JLabel();
        location = new JTextField();
        jLabel1 = new JLabel();
        jButton1 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        head.setFont(new Font("Verdana", 1, 18));
        head.setText("Welcome Admin");

        filechooser.setText("Choose File");
        filechooser.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent e)
                                            {
                                                jButton1.setVisible(true);
                                                int retVal;
                                                JFileChooser fc = new JFileChooser();
                                                fc.addChoosableFileFilter(new TextFilter());
                                                fc.setMultiSelectionEnabled(true);
                                                retVal = fc.showOpenDialog(fc);
                                                if (retVal == JFileChooser.APPROVE_OPTION)
                                                {
                                                    location.setText(fc.getSelectedFile().toString());
                                                }
                                            }
                                        });

        location.setToolTipText("Location");
        location.setEnabled(false);

        passwordchange.setText("Change Password");
        passwordchange.addActionListener(new ActionListener()
                                            {
                                                public void actionPerformed(ActionEvent e)
                                                {
                                                    new pas().setVisible(true);
                                                }
                                            });

        jLabel1.setText("Change Admin Password");

        jButton1.setText("Create Files");
        jButton1.setVisible(false);
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent e)
                                        {
                                            filename=location.getText();
                                            filename=location.getText();
                                            new plzwai();
                                            thread.start();
                                            jButton1.setVisible(false);
                                        }
                                    });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(head)
                .addGap(120, 120, 120))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32)
                        .addComponent(passwordchange))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filechooser)
                        .addGap(18, 18, 18)
                        .addComponent(location, GroupLayout.PREFERRED_SIZE, 189,GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jButton1)
                .addContainerGap(165, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(head)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(filechooser)
                    .addComponent(location,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordchange)
                    .addComponent(jLabel1))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        setTitle("Admin Page");
        setIconImage(Toolkit.getDefaultToolkit().getImage(frameurl));
        setLocation(h-h/2,w/7);
        setResizable(false);
        pack();
    }
    
    public void run()
    {
        new ReadExcelFile(filename);
        fplz.dispose();
        JOptionPane.showMessageDialog(null,"Success Files are created","Alert",JOptionPane.INFORMATION_MESSAGE);
    }

    class TextFilter extends FileFilter
   {

  public boolean accept(File f)
  {
    if (f.isDirectory())
      return true;
    String s = f.getName();
    int i = s.lastIndexOf('.');

    if (i > 0 && i < s.length() - 1)
      if (s.substring(i + 1).toLowerCase().equals("xls"))
        return true;

    return false;
  }

  public String getDescription()
  {
    return "Accepts only xls files.";
  }

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
         fplz = new JFrame("Loading and Checking Data . Please Wait......");
   fplz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final JProgressBar aJProgressBar = new JProgressBar(JProgressBar.HORIZONTAL);
    //aJProgressBar.setStringPainted(true);
    aJProgressBar.setIndeterminate(true);
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

    public class pas extends JFrame
{
    JButton sub;
    JLabel old;
    JLabel new1;
    JLabel new2;
    JLabel head;
    JPasswordField pas1;
    JPasswordField pas2;
    JPasswordField pas3;

    public pas()
    {
        launch();
    }

    private void launch() {

        head = new JLabel();
        old = new  JLabel();
        new1 = new JLabel();
        new2 = new  JLabel();
        pas1 = new  JPasswordField();
         JTextComponent.KeyBinding[] newBindings = {
        new JTextComponent.KeyBinding(
          KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK),
          DefaultEditorKit.beepAction),
        new JTextComponent.KeyBinding(
          KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK),
          DefaultEditorKit.beepAction),
        new JTextComponent.KeyBinding(
            KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK),
            DefaultEditorKit.beepAction)
      };

    Keymap k = pas1.getKeymap();
    JTextComponent.loadKeymap(k, newBindings, pas1.getActions());
        pas2 = new JPasswordField();


    Keymap k2 = pas2.getKeymap();
    JTextComponent.loadKeymap(k2, newBindings, pas2.getActions());
        pas3 = new JPasswordField();


    Keymap k3 = pas3.getKeymap();
    JTextComponent.loadKeymap(k3, newBindings, pas3.getActions());
        XrButton sub = new XrButton(new ImageIcon(okurl));

        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                if(pas1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Oops Not entered Old Password","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                if(pas2.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Oops Not entered New Password","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                if(pas2.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Oops Not entered Confirmation Password","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                try
                {
                    BufferedReader b=new BufferedReader(new FileReader("Bin/Info/appid.ravs"));
                    String oldpass=new Base64Decoder(new Base64Decoder(new Base64Decoder(b.readLine().trim()).get()).get()).get();
                    b.close();
                    if(pas1.getText().trim().equals(oldpass.trim()))
                    {
                        if(pas2.getText().trim().equals(pas3.getText().trim()))
                        {
                            try
                            {
                                BufferedWriter b1=new BufferedWriter(new FileWriter("Bin/Info/appid.ravs"));
                                b1.append(new Base64Encoder(new Base64Encoder(new Base64Encoder(pas2.getText().trim()).get()).get()).get());
                                System.out.println(pas2.getText().trim()+"    ");
                                b1.close();
                                JOptionPane.showMessageDialog(null, "Password Changed","Alert",JOptionPane.INFORMATION_MESSAGE);
                                dispose();
                            }catch(Exception sd1){}
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "New Password do not match please try again","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Oops Entered Wrong Old Password","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }catch(Exception e){}
                
                }
                
            }
        });

        head.setFont(new Font("Verdana", 1, 16));
        head.setText("Change Password");

        old.setFont(new Font("Verdana", 0, 12));
        old.setText("Old Password");

        new1.setFont(new Font("Verdana", 0, 12));
        new1.setText("New Password");

        new2.setFont(new Font("Verdana", 0, 12));
        new2.setText("Confirm Password");

        sub.setToolTipText("Submit");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(old)
                    .addComponent(new1)
                    .addComponent(new2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(pas1,GroupLayout.PREFERRED_SIZE, 123,GroupLayout.PREFERRED_SIZE)
                    .addComponent(pas2,GroupLayout.PREFERRED_SIZE, 123,GroupLayout.PREFERRED_SIZE)
                    .addComponent(pas3, GroupLayout.PREFERRED_SIZE, 123,GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(166, Short.MAX_VALUE)
                .addComponent(sub)
                .addGap(161, 161, 161))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(head)
                .addGap(119, 119, 119))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(head)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(old)
                    .addComponent(pas1,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(new1)
                    .addComponent(pas2,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(new2)
                    .addComponent(pas3,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(sub)
                .addGap(22, 22, 22))
        );
        addWindowListener(new WindowAdapter()
        {      public void windowClosing(WindowEvent e) {       dispose();     }    });
        setIconImage(Toolkit.getDefaultToolkit().getImage(frameurl));
        setLocation(h/2,w/7);
        setResizable(false);
        setTitle("Change Password");
        pack();
    }
    }

}


