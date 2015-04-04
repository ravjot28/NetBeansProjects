import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.WindowConstants;


public class AdminSetting extends JFrame
{
    JButton jButton1;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JLabel jLabel5;
    JPasswordField jPasswordField1;
    JPasswordField jPasswordField2;
    JPasswordField jPasswordField3;

    String password;

    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    public final static String back="img/bg.jpeg";
    URL bg=getClass().getClassLoader().getResource(back);

    public AdminSetting(String p)
    {
        password = p;
        initComponents();
    }

    private void initComponents()
    {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jPasswordField1 = new JPasswordField();
        jPasswordField2 = new JPasswordField();
        jPasswordField3 = new JPasswordField();
        jButton1 = new JButton();
        jLabel5 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(400,310));
        setMaximumSize(new Dimension(400,310));
        setMinimumSize(new Dimension(400,310));
        getContentPane().setLayout(null);

        jLabel1.setFont(new Font("Zapfino", 1, 18));
        jLabel1.setText("GTBIT Informer");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(102, 20, 191, 61);

        jLabel2.setText("Old Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(37, 116, 85, 16);

        jLabel3.setText("New Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(37, 158, 90, 16);

        jLabel4.setText("Confirm Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(37, 194, 114, 16);

        jPasswordField1.setBackground(new Color(204, 204, 204));
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(184, 110, 174, 28);

        jPasswordField2.setBackground(new Color(204, 204, 204));
        getContentPane().add(jPasswordField2);
        jPasswordField2.setBounds(184, 146, 174, 28);

        jPasswordField3.setBackground(new Color(204, 204, 204));
        getContentPane().add(jPasswordField3);
        jPasswordField3.setBounds(184, 182, 174, 28);

        jButton1.setText("Change Password");
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent evt)
                                        {
                                            if((jPasswordField1.getText().trim().equalsIgnoreCase(""))||jPasswordField2.getText().trim().equalsIgnoreCase("")||jPasswordField3.getText().trim().equalsIgnoreCase(""))
                                            {
                                                JOptionPane.showMessageDialog(null,"OOPs Enter all the fields","Error",JOptionPane.ERROR_MESSAGE);
                                            }
                                            else
                                            {
                                                if(jPasswordField1.getText().trim().equalsIgnoreCase(password))
                                                {
                                                    if(jPasswordField2.getText().trim().equalsIgnoreCase(jPasswordField3.getText().trim()))
                                                    {
                                                        try
                                                        {
                                                            BufferedWriter b = new BufferedWriter(new FileWriter("Bin/Data/UserInfo/userinfo.ravs"));
                                                            b.append(new Base64Encoder(new Base64Encoder("admin").get()).get());
                                                            b.newLine();
                                                            b.append(new Base64Encoder(new Base64Encoder(jPasswordField2.getText().trim()).get()).get());
                                                            b.close();
                                                        }catch(Exception as){}
                                                        JOptionPane.showMessageDialog(null,"Password Changed","Confirmation",JOptionPane.INFORMATION_MESSAGE);
                                                        dispose();
                                                    }
                                                    else
                                                    {
                                                        JOptionPane.showMessageDialog(null,"New Password do not match","Error",JOptionPane.ERROR_MESSAGE);
                                                    }
                                                }
                                                else
                                                {
                                                    JOptionPane.showMessageDialog(null,"Incorrect Old Password","Error",JOptionPane.ERROR_MESSAGE);
                                                }
                                            }
                                        }
                                    });
        getContentPane().add(jButton1);
        jButton1.setBounds(130, 242, 154, 29);

        jLabel5.setIcon(new ImageIcon(bg));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 400, 300);

        setResizable(false);
        pack();
        setLocation(h/2,w/7);
    }
}
