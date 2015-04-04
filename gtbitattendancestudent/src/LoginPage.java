import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class LoginPage extends JFrame
{
    JButton jButton1;
    JButton jButton2;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JLabel jLabel5;
    JLabel jLabel6;
    JPasswordField jPasswordField1;
    JPasswordField jPasswordField2;
    JTextField jTextField1;
    JTextField jTextField2;

    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    public final static String bg="Bin\\img\\bg.jpeg";
    
    public LoginPage()
    {
        initComponents();
    }

    private void initComponents()
    {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jLabel3 = new JLabel();
        jTextField2 = new JTextField();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jPasswordField1 = new JPasswordField();
        jPasswordField2 = new JPasswordField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel6 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(390, 388));
        setMinimumSize(new Dimension(390, 388));
        setPreferredSize(new Dimension(390, 388));
        getContentPane().setLayout(null);

        jLabel1.setFont(new Font("Zapfino", 1, 18));
        jLabel1.setText("GTBIT Informer");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(109, 20, 191, 61);

        jLabel2.setText("Enroll. No.");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 110, 66, 16);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(180, 100, 171, 28);

        jLabel3.setText("Email ID");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 160, 52, 16);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(180, 150, 171, 28);

        jLabel4.setText("Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 210, 59, 16);

        jLabel5.setText("Confirm Password");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 260, 114, 16);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(180, 200, 171, 28);
        getContentPane().add(jPasswordField2);
        jPasswordField2.setBounds(180, 250, 171, 28);

        jButton1.setText("Submit");
        getContentPane().add(jButton1);
        jButton1.setBounds(90, 320, 88, 29);
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            if(jTextField1.getText().trim().equalsIgnoreCase(""))
                                            {
                                                JOptionPane.showMessageDialog(null, "OOps Please Enter the Enroll. No.", "Error", JOptionPane.ERROR_MESSAGE);
                                            }
                                            else
                                            {
                                                if(jTextField2.getText().trim().equalsIgnoreCase(""))
                                                {
                                                    JOptionPane.showMessageDialog(null, "OOps Please Enter the Email ID", "Error", JOptionPane.ERROR_MESSAGE);
                                                }
                                                else
                                                {
                                                    if((jPasswordField1.getText().trim().equalsIgnoreCase(""))||(jPasswordField2.getText().trim().equalsIgnoreCase("")))
                                                    {
                                                        JOptionPane.showMessageDialog(null, "OOps Please Enter the Password", "Error", JOptionPane.ERROR_MESSAGE);
                                                    }
                                                    else
                                                        if(jPasswordField1.getText().trim().equalsIgnoreCase(jPasswordField2.getText().trim()))
                                                        {
                                                            try
                                                            {
                                                                BufferedWriter b = new BufferedWriter(new FileWriter("Bin\\Data\\UserInfo1\\userinfo.ravs"));
                                                                b.append(new Base64Encoder(new Base64Encoder(jTextField1.getText().trim()).get().trim()).get().trim());
                                                                b.newLine();
                                                                b.append(new Base64Encoder(new Base64Encoder(jTextField2.getText().trim()).get().trim()).get().trim());
                                                                b.newLine();
                                                                b.append(new Base64Encoder(new Base64Encoder(jPasswordField1.getText().trim()).get().trim()).get().trim());
                                                                b.close();
                                                                dispose();
                                                                EventQueue.invokeLater(new Runnable()
                                                                {
                                                                    public void run()
                                                                    {
                                                                        new Login().setVisible(true);
                                                                    }
                                                                });
                                                            }catch(Exception asd){}
                                                        }
                                                    else
                                                    {
                                                        JOptionPane.showMessageDialog(null, "OOps Password do not match", "Error", JOptionPane.ERROR_MESSAGE);
                                                    }
                                                }
                                            }
                                        }
                                    });

        jButton2.setText("Reset");
        getContentPane().add(jButton2);
        jButton2.setBounds(200, 320, 78, 29);
        jButton2.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            jTextField1.setText("");
                                            jTextField2.setText("");
                                            jPasswordField1.setText("");
                                            jPasswordField2.setText("");
                                        }
                                    });

        jLabel6.setIcon(new ImageIcon(bg));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 390, 370);

        setResizable(false);
        pack();
        setLocation(h/2,w/7);
    }
}
