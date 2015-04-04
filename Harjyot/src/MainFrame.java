import JButtonDrag.RavDragHandler;
import RavButton.RavButton;
import java.awt.Dimension;
import java.awt.Toolkit;

public class MainFrame extends javax.swing.JDialog {

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension d = kit.getScreenSize();
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;

    public MainFrame() {
        initComponents();
    }
    private void initComponents()
    {
        jButton1 = new RavButton(new javax.swing.ImageIcon("setting.png"));
        jButton2 = new RavButton(new javax.swing.ImageIcon("setting.png"));
        jButton3 = new RavButton(new javax.swing.ImageIcon("setting.png"));


        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        com.sun.awt.AWTUtilities.setWindowOpacity(this, 0.75f);
        getContentPane().setLayout(null);

        getContentPane().add(jButton1);
        jButton1.setBounds(50, 40, 55, 55);
        jButton1.addMouseMotionListener(new RavDragHandler());

        getContentPane().add(jButton2);
        jButton2.setBounds(50, 10, 55, 55);
        jButton2.addMouseMotionListener(new RavDragHandler());

        getContentPane().add(jButton3);
        jButton3.setBounds(50, 70, 55, 55);
        jButton3.addMouseMotionListener(new RavDragHandler());
        setBounds(d.width-200, 1, 200, d.height);
    }
}

