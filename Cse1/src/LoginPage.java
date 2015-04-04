
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class LoginPage extends javax.swing.JFrame
{

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension d = kit.getScreenSize();

    public final static String logo="img/gtbit.jpg";
    URL logourl=getClass().getClassLoader().getResource(logo);

    public final static String pic="img/login.jpg";
    URL picurl=getClass().getClassLoader().getResource(pic);

    public void look()
    {
         try
         {
             UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
         }catch(Exception e){}
    }
    
    public LoginPage()
    {
        look();
        initComponents();
    }
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new IntegerField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setIconImage(Toolkit.getDefaultToolkit().getImage(logourl));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CSE-1 2011 Batch Rocks");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        
        setMinimumSize(new java.awt.Dimension(666, 507));

        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CSE-1 2011 Batch ki Yaadon Ka Database :)");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 10, 405, 26);

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Kripya Kar k apna enroll no daliye");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 90, 230, 20);

        jTextField1.setFont(new java.awt.Font("Palatino Linotype", 0, 14));
        getContentPane().add(jTextField1);
        jTextField1.setBounds(10, 130, 183, 26);

        jButton1.setText("Done");
        getContentPane().add(jButton1);
        jButton1.setBounds(570, 450, 87, 23);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               process();
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(picurl));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 660, 480);

        pack();

        int w = getSize().width;

        int h = getSize().height;

        int x = (d.width-w)/2;

        int y = (d.height-h)/2;



        setResizable(false);


        setLocation(x, y);
    }

    public void process()
    {
        if(jTextField1.getText().trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null,"Aree Enroll No. to daalo naa", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            ListOfStudents los = new ListOfStudents();
            los.setData(jTextField1.getText().trim());
            if(!los.check(jTextField1.getText().trim()))
            {
                JOptionPane.showMessageDialog(null,"Aree Galat Enroll No. dala. Chalo dubara try karo", "Error", JOptionPane.ERROR_MESSAGE);
                jTextField1.setText("");
            }
            else
            {
                final String a[] = los.getData();
                dispose();
                java.awt.EventQueue.invokeLater(new Runnable() {

                    public void run() {

                        new Main(a,jTextField1.getText().trim()).setVisible(true);

                    }

                });
            }
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;

}
