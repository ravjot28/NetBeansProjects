import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileFilter;

public class AdminPage extends JFrame
{
    JButton jButton1;
    JButton jButton2;
    JButton jButton3;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JTextField jTextField1;
    
    String password;

    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    public final static String bg="Bin\\img1\\bg.jpeg";

    public final static String bt="Bin\\img1\\setting.png";
    
    public AdminPage(String p)
    {
        password=p;
        initComponents();
    }

    private void initComponents()
    {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jButton3 = new JButton();
        jTextField1 = new JTextField();
        jButton2 = new JButton();
        jButton1 = new JButton();
        jLabel3 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(428,213));
        setMaximumSize(new Dimension(428,213));
        setMinimumSize(new Dimension(428,213));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Zapfino", 1, 18));
        jLabel1.setText("GTBIT Informer");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 20, 200, 40);

        jLabel2.setText("Choose File");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 100, 80, 16);

        jButton3.setText("Create DB");
        getContentPane().add(jButton3);
        jButton3.setBounds(170, 150, 105, 29);
        jButton3.setVisible(false);
        jButton3.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            EventQueue.invokeLater(new Runnable()
                                            {
                                                public void run()
                                                {
                                                    new ReadExcel(jTextField1.getText().trim());
                                                }
                                            });
                                        }
                                     });

        jTextField1.setBackground(new Color(204, 204, 204));
        jTextField1.setEditable(false);
        jTextField1.setDragEnabled(false);
        jTextField1.setFocusTraversalKeysEnabled(false);
        jTextField1.setFocusable(false);
        jTextField1.setRequestFocusEnabled(false);
        jTextField1.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(260, 90, 150, 28);

        jButton2.setText("Choose");
        getContentPane().add(jButton2);
        jButton2.setBounds(130, 90, 97, 29);
        jButton2.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            int retVal;
                                            JFileChooser fc = new JFileChooser();
                                            fc.addChoosableFileFilter(new TextFilter());
                                            fc.setMultiSelectionEnabled(true);
                                            retVal = fc.showOpenDialog(fc);
                                            if (retVal == JFileChooser.APPROVE_OPTION)
                                            {
                                                System.out.println(fc.getSelectedFile().toString());
                                                jTextField1.setText(fc.getSelectedFile().toString());
                                                jButton3.setVisible(true);
                                            }
                                        }
                                    });

        jButton1.setIcon(new ImageIcon(bt));
        jButton1.setBorderPainted(false);
        getContentPane().add(jButton1);
        jButton1.setBounds(370, 150, 50, 30);
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            EventQueue.invokeLater(new Runnable()
                                            {
                                                public void run()
                                                {
                                                    new AdminSetting(password).setVisible(true);
                                                }
                                            });
                                        }
                                    });

        jLabel3.setIcon(new ImageIcon(bg));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 430, 190);

       setResizable(false);
        pack();
        setLocation(h/2,w/7);
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
}
