import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class ViewData implements Runnable
{
    String m="";
    String tn="";
    String d="";
    Thread thr=new Thread(this);

     Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();


    ViewData(String tname , String mess , String date)
    {
        m=mess;
        d=date;
        tn=tname;
        thr.start();
    }

    public void run()
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame1().setVisible(true);
            }
        });
    }

    class NewJFrame1 extends JFrame
    {
         int total=0;
         JLabel jLabel1;
         JLabel jLabel2;
         JLabel jLabel3;
         JLabel jLabel4;
         JScrollPane jScrollPane1;
         JTextArea jTextArea1;


    public NewJFrame1()
    {

        initComponents();
    }

    private void initComponents()
    {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jLabel4 = new JLabel();

        setName("GTBIT Messenger");
        //setIconImage(new ImageIcon("img/r.gif").getImage());
        setIconImage(new ImageIcon("img\\r.gif").getImage());
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setMaximumSize(new Dimension(704,474));
        setMinimumSize(new Dimension(704,474));
        setPreferredSize(new Dimension(704,474));
        getContentPane().setLayout(null);

        jLabel1.setFont(new Font("Zapfino", 1, 18));
        jLabel1.setText("GTBIT Messenger");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(250, 20, 413, 61);

        jLabel2.setText("From "+tn);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 80, 400, 16);

        jLabel3.setText("Date "+d);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(530, 80, 229, 16);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setLineWrap(true);
        jTextArea1.setEditable(false);
        jTextArea1.setText(m);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 110, 616, 274);
        
        jLabel4.setIcon(new ImageIcon("img\\4.jpg"));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 710, 470);

        setName("GTBIT Messenger");
        setIconImage(new ImageIcon("img\\r.gif").getImage());
        setTitle("GTBIT Messenger");
        pack();
        setLocation(h/2,w/8);
    }

}


}
