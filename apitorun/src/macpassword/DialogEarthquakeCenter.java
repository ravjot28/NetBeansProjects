package macpassword;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.JTextComponent;
import javax.swing.text.Keymap;

public class DialogEarthquakeCenter extends Object
{
    public static final int SHAKE_DISTANCE = 10;
    public static final double SHAKE_CYCLE = 100;
    public static final int SHAKE_DURATION = 2000;
    public static final int SHAKE_UPDATE = 5;
    private JDialog dialog;
    private Point naturalLocation;
    private long startTime;
    private Timer shakeTimer;
    private final double HALF_PI = Math.PI / 2.0;
    private final double TWO_PI = Math.PI * 2.0;
    DialogEarthquakeCenter dec ;

    public DialogEarthquakeCenter (JDialog d)
    {
        dialog = d;
    }

    public void startShake( )
    {
        naturalLocation = dialog.getLocation( );
        startTime = System.currentTimeMillis( );
        shakeTimer =new Timer(SHAKE_UPDATE,new ActionListener( )
                    {
                        public void actionPerformed (ActionEvent e)
                        {
                            // calculate elapsed time
                            long elapsed = System.currentTimeMillis()-startTime;
                            // use sin to calculate an x-offset
                            double waveOffset = (elapsed % SHAKE_CYCLE) /SHAKE_CYCLE;
                            double angle = waveOffset * TWO_PI;
                            // offset the x-location by an amount
                            // proportional to the sine, up to
                            // shake_distance
                            int shakenX = (int) ((Math.sin (angle) *SHAKE_DISTANCE) +naturalLocation.x);
                            dialog.setLocation (shakenX, naturalLocation.y);
                            dialog.repaint( );
                            // should we stop timer?
                            if (elapsed >= SHAKE_DURATION)                                                  stopShake( );
                        }
                     });
        shakeTimer.start( );
    }

    public void stopShake( )
    {
        shakeTimer.stop( );
        dialog.setLocation (naturalLocation);
        dialog.repaint( );
    }

    public static void main (String[] args)
    {
        new DialogEarthquakeCenter();
    }

    DialogEarthquakeCenter()
    {
        //JOptionPane pane =new JOptionPane ("You've totally screwed up your login\n" +"Go back and do it again… and do you think\n" +"you could remember your password this time?",JOptionPane.ERROR_MESSAGE, JOptionPane.OK_OPTION);
        //JDialog d = pane.createDialog (null, "Shakin'!");
        login d1=new login();
        dec= new DialogEarthquakeCenter (d1);
        d1.pack();
        d1.setModal (false);
        d1.setVisible(true);
        
        // wait (forever) for a non-null click and then quit
        /*while (pane.getValue( ) == JOptionPane.UNINITIALIZED_VALUE )
        {
            try
            {
                Thread.sleep(100);
            }catch (InterruptedException ie)
                {
                }
        }
               System.exit(0);*/
    }


    class login extends JDialog
{
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    JLabel empid;
    JTextField empidt;
    JLabel head;
    JLabel password;
    JPasswordField passwordt;
    JButton reset = new JButton("Submit");
    JButton submit = new JButton("Cancel");

    public login()
    {
        initComponents();
    }

    private void initComponents()
    {
        look();
        head = new JLabel();
        empid = new JLabel();
        password = new JLabel();
        empidt = new JTextField();
        passwordt = new JPasswordField();

//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        head.setFont(new Font("Verdana", 1, 18));
        head.setText("Login Screen");

        empid.setFont(new Font("Serif", 0, 16));
        empid.setText("Employee ID");

        password.setFont(new Font("Serif", 0, 16));
        password.setText("Password");

        empidt.setFont(new Font("Serif", 0, 16));
        empidt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                String text = empidt.getText();
                int length = text.length();
                if (length == 6)
                {
                    e.consume();
                } else if (length > 6) {
                    empidt.setText(text.substring(0, 1));
                }
            }
        });

        passwordt.setFont(new Font("Serif", 0, 16));
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

    Keymap k = passwordt.getKeymap();
    JTextComponent.loadKeymap(k, newBindings, passwordt.getActions());

        submit.setToolTipText("Submit");
        submit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                    dec.startShake( );
            }
        });

        reset.setToolTipText("Clear All");
        reset.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                empidt.setText("");
                passwordt.setText("");
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)  //137, 137, 137
                        .addComponent(head))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(empid)
                            .addComponent(password))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordt)
                            .addComponent(empidt,GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130) //116, 116, 116
                        .addComponent(submit)
                        .addGap(35, 35, 35)
                        .addComponent(reset)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(head)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(empid)
                    .addComponent(empidt,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(password)
                    .addComponent(passwordt,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(reset))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        setTitle("Login Screen");
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\r.gif"));
        setLocation(h/2,w/9);
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

     
}


}
