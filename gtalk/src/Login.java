import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jivesoftware.smack.XMPPException;

public class Login implements Runnable
{
    Thread th= new Thread(this);
    javax.swing.JButton jButton1;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JPasswordField jPasswordField1;
    javax.swing.JTextField jTextField1;
    JFrame f ;


    Login()
    {
        NewJPanel1 n =new NewJPanel1();
        f= new JFrame("RGtalk");
        f.add(n);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
    }

    class NewJPanel1 extends javax.swing.JPanel
    {

        public NewJPanel1()
        {
            initComponents();
        }

        private void initComponents()
        {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon("Bin/Img/gmail.png"));

        jLabel2.setText("Email");

        jLabel3.setText("Password");

        jButton1.setText("Sign In");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(!(jTextField1.getText().equalsIgnoreCase(""))&&!(jPasswordField1.getText().equalsIgnoreCase("")))
                {
                    try
                    {
                        String emailen = new Base64Encoder(new Base64Encoder(new Base64Encoder(jTextField1.getText().trim()).get()).get()).get();
                        String pswden = new Base64Encoder(new Base64Encoder(new Base64Encoder(jPasswordField1.getText().trim()).get()).get()).get();
                        System.out.println("Email "+emailen+" Password "+pswden);

        try
        {
            BufferedWriter b = new BufferedWriter(new FileWriter("Bin/Data/UserInfo/userinfo.ravs"));
            b.append(emailen);
            b.newLine();
            b.append(pswden);
            b.close();
            f.dispose();
            th.start();
        }catch(Exception ex){}
                    }catch(Exception e){}
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"OOPS!! Please enter the password and email id","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel2)
                            .add(jLabel1))
                        .add(34, 34, 34)
                        .add(jTextField1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 19, Short.MAX_VALUE)
                        .add(jPasswordField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .add(jButton1)
                .add(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jLabel1)
                .add(24, 24, 24)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .add(36, 36, 36)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jPasswordField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .add(43, 43, 43)
                .add(jButton1)
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }
}

    public void run()
    {
        try {
            new ChatClient().begin(jTextField1.getText().trim(), jPasswordField1.getText().trim());
        } catch (XMPPException ex) {
            
        }
    }

}
