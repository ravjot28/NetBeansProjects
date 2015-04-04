import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.jdesktop.swingx.JXTaskPane;

public class Main extends javax.swing.JFrame implements Runnable{

    String students[];

    Thread th;

    DescriptionPanel dp[];

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension d = kit.getScreenSize();

    InfiniteProgressPanel glassPane;

    String enroll;

    public final static String logo="img/gtbit.jpg";
    URL logourl=getClass().getClassLoader().getResource(logo);

    public Main(String[] a,String e) {
        this.enroll = e;
        this.students = a;
        initComponents();
    }

    public void run()
    {
        glassPane.start();
        String to[] = {"cse1yaad@gmail.com"};
        String mess ="";
        for(int i=0;i<dp.length;i++)
            mess+=dp[i].getData().trim()+"@";
        glassPane.setText("Sending Data to Database");
        glassPane.revalidate();
        glassPane.repaint();
        sending s = new sending("cse1yaad@gmail.com",mess,this.enroll,to,"docomo3401");
        if(s.send())
        {
            glassPane.stop();
            JOptionPane.showMessageDialog(null,"Mubaraka database mai dal gaya. Ab ebook mail kardenge compile kar k.Dubara mat bhejna database k liye :)", "Wah Kamaal hogayi", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
        else
        {
            glassPane.stop();
            JOptionPane.showMessageDialog(null,"Aree net prob aa gayi :(", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void call()
    {
        th = null;
                th = new Thread(this);
                th.start();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton("Send");

        glassPane = new InfiniteProgressPanel("Collecting Data Please Wait...");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setGlassPane(glassPane);

        setTitle("Yaddien Likh Dalo");

        setIconImage(Toolkit.getDefaultToolkit().getImage(logourl));

        //jPanel1.setLayout(new java.awt.GridLayout(7, 10, 1, 1));

        TweetScrollPane tsp = new TweetScrollPane();

        JPanel p = new JPanel();
        p.add(tsp);

        jButton1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ar)
            {
                call();
            }
        });

        //tsp.setPreferredSize(new Dimension(600,600));
        jPanel1.add(p);


         add(jPanel1,BorderLayout.CENTER);

         JPanel p1 =new JPanel();
         p1.setLayout(new GridLayout(0,3));
         p1.add(new JPanel());
         p1.add(new JPanel());
         p1.add(jButton1);

         add(p1,BorderLayout.SOUTH);


        pack();

        int w = getSize().width;

        int h = getSize().height;

        int x = (d.width-w)/2;

        int y = (d.height-h)/2;



        setResizable(false);


        setBounds(x, y,w,h);
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;

   class TweetScrollPane extends JPanel
{
    JScrollPane jScrollPane1;
    public TweetScrollPane()
    {
        jScrollPane1 = new javax.swing.JScrollPane();

        jScrollPane1.setMaximumSize(new java.awt.Dimension(500, 350));
        jScrollPane1.setMinimumSize((new java.awt.Dimension(500, 350)));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 350));
        jScrollPane1.setBorder(BorderFactory.createLineBorder(Color.black));
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // set leftPane as the scrollable component
        MainPanel t = new MainPanel();
        jScrollPane1.setViewportView(t);
        t.revalidate();
        add(jScrollPane1);
    }
}

   class MainPanel extends JPanel
   {
       public MainPanel()
       {
           setLayout(new java.awt.GridLayout(0, 2, 31, 1));
           
           JXTaskPane taskpane[] = new JXTaskPane[students.length];

        dp = new DescriptionPanel[students.length];

        for(int i=0;i<students.length;i++)
        {
            dp[i] = new DescriptionPanel();
            taskpane[i] = new JXTaskPane();
            taskpane[i].setTitle(students[i]);
            taskpane[i].setToolTipText("Write 2 line description for "+students[i]);
            taskpane[i].add(dp[i]);
            add(taskpane[i]);
        }
       }
   }


}

