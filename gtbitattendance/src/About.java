import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;


public class About extends JFrame
{
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;

    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    public final static String back="img/bg.jpeg";
    URL bg=getClass().getClassLoader().getResource(back);

    public About()
    {
        initComponents();
    }

    private void initComponents()
    {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(414,313));
        setMaximumSize(new Dimension(414,313));
        setMinimumSize(new Dimension(414,313));
        getContentPane().setLayout(null);

        jLabel1.setFont(new Font("Zapfino", 1, 18));
        jLabel1.setText("About GTBIT Informer");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(73, 20, 267, 61);

        jLabel2.setText("sadgdasav d vfad afvfdvavasdvadsfdsafdsafdsafdsaf");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(46, 111, 330, 16);

        jLabel3.setFont(new Font("Hiragino Kaku Gothic StdN", 0, 14));
        jLabel3.setText("Created by Ravjot Singh And Baljit Singh");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(66, 258, 337, 22);

        jLabel4.setBackground(new Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(bg));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 420, 300);

        setResizable(false);
        pack();
        setLocation(h/2,w/7);
    }
}
