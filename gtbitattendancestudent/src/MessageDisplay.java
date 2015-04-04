import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class MessageDisplay extends JFrame
{
    JLabel jLabel1;
    JScrollPane jScrollPane1;
    JTextArea jTextArea1;
    String mess;
    JLabel jLabel2;

    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    public final static String bg="Bin\\img\\bg.jpeg";

    public MessageDisplay(String m)
    {
        mess=m;
        initComponents();
    }

    private void initComponents()
    {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(400, 326));
        setMinimumSize(new Dimension(400, 326));
        setPreferredSize(new Dimension(400, 326));
        getContentPane().setLayout(null);

        jLabel1.setFont(new Font("Zapfino", 1, 18));
        jLabel1.setText("GTBIT Informer");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 20, 191, 61);

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new Font("Constantia", 1, 15));
        jTextArea1.setRows(5);
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setText(mess);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 89, 360, 200);

        jLabel2.setIcon(new ImageIcon(bg));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 400, 320);

        setResizable(false);
        pack();
        setLocation(h/2,w/7);
    }
}
