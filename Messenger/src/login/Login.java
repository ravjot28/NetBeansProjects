package login;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Login extends JFrame
{
    JButton jButton1;
    JButton jButton2;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JPasswordField jPasswordField1;
    JTextField jTextField1;
    
    public Login()
    {
        super("GTBIT Messenger");
        initComponents();
    }

    private void initComponents()
    {
        jTextField1 = new JTextField();
        jPasswordField1 = new JPasswordField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel4 = new JLabel();

        setName("GTBIT Messenger");
        setIconImage(new ImageIcon("img/r.gif").getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500, 500));
        getContentPane().setLayout(null);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(210, 120, 188, 28);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(210, 220, 188, 28);

        jLabel1.setText("Login ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 130, 53, 16);

        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 230, 59, 16);

        jLabel3.setFont(new Font("Zapfino", 1, 18));
        jLabel3.setText("GTBIT Messenger");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 20, 213, 61);

        jButton1.setText("Login");
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent evt)
                                        {
                                            
                                        }
                                    });
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 300, 79, 29);

        jButton2.setText("Reset");
        getContentPane().add(jButton2);
        jButton2.setBounds(280, 300, 78, 29);
        jButton2.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent evt)
                                        {
                                            jTextField1.setText("");
                                            jPasswordField1.setText("");
                                        }
                                    });

        jLabel4.setIcon(new ImageIcon("img/loginbg.jpg"));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 500, 500);

        pack();
    }
    
    public static void main(String args[])
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Login().setVisible(true);
            }
        });
    }

}
