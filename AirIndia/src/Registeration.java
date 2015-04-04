import java.awt.*;
import java.awt.event.*;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Registeration extends JFrame implements Runnable
{
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    XrButton submit = new XrButton(new ImageIcon("Bin\\img\\ok.png"));
    XrButton reset= new XrButton(new ImageIcon("Bin\\img\\reset.png"));
    JLabel note;
    JLabel head;
    JLabel id;
    JTextField i;
    String empid;
    String rav;
    JFrame fplz;
    Thread thread=new Thread(this);
    public Registeration(String emp,String r)
    {
        rav=r;
        empid=emp;
        launch();
    }

    private void launch()
    {
        look();
        head = new JLabel();
        note = new JLabel();
        id = new JLabel();
        i = new JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\airindia.jpg"));

        head.setFont(new Font("Perpetua Titling MT", 1, 18));
        head.setForeground(new Color(51, 153, 255));
        head.setText("Air India Pay Roll Registeration");

        note.setFont(new Font("Andalus", 0, 16));
        note.setForeground(new Color(255, 0, 0));
        note.setText("** Compulsory Fields");
        submit.setFont(new Font("Book Antiqua", 1, 14));
        submit.setToolTipText("Submit");
        submit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                if((i.getText().equalsIgnoreCase(null))||(i.getText().equalsIgnoreCase("")))
                {
                    JOptionPane.showMessageDialog(null,"Please enter the Email ID","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    new plzwai();
                    i.setEditable(false);
                        thread.start();
                }
            }
        });

        reset.setFont(new Font("Book Antiqua", 1, 14));
        reset.setToolTipText("Reset");
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                i.setText("");
            }
        });

        id.setFont(new Font("Andalus", 1, 16));
        id.setText("Email ID **");

        i.setFont(new Font("Andalus", 1, 16));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(submit)
                .addGap(62, 62, 62)
                .addComponent(reset)
                .addContainerGap(171, Short.MAX_VALUE))
            .addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(390, Short.MAX_VALUE)
                .addComponent(note)
                .addContainerGap())
            .addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(id)
                        .addGap(63, 63, 63)
                        .addComponent(i, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(head)
                        .addGap(62, 62, 62))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(head)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(id)
                    .addComponent(i, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(reset))
                .addGap(43, 43, 43)
                .addComponent(note)
                .addContainerGap())
        );
        setLocation(h/2,w/7);
        setTitle("Registeration");
        setResizable(false);
        pack();
    }

     public void look()
    {
         try
         {
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
         }catch(Exception e){}
    }

    public void run() {
        try {
            String[] t = new String[1];
            t[0] = i.getText();
            String password = new PasswordGenerator().gen();
            String message="Dear Employee, \n This mail is to provide you the password which was requested by you for registering the Pay Roll Application.\n Below your account's details are given i.e. your Employee ID and the password.\n Please after Log in the application it is advisable to change the password as per your convienece. "+"\nEmployee ID--> "+empid+"\nYour password is " + password+"\n\n Note:Please do not reply to this email .\n Once retrieved the password you can delete this Email.\n This Email is not Spam.\n\n Thank You.\n\n Rav Softs Presentation";
            sending s1 = new sending("airindiapayroll@gmail.com",message, "Your Account Has been created", t, "airindia1960");
            String result = s1.send();
            new Update(empid, t[0], password, rav);
            if (result.equalsIgnoreCase("Your message is successfully mailed"))
            {
                
                fplz.setVisible(false);
                JOptionPane.showMessageDialog(null, "Your new password has been mailed to the given email id.Please login again with new password", "Alert", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                java.awt.EventQueue.invokeLater(new Runnable() {

                    public void run() {
                        new GUI(rav).setVisible(true);
                    }
                });
                if (t[0].endsWith("gmail.com")) {
                    String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler http://www.gmail.com";
                    try {
                        Process p = Runtime.getRuntime().exec(cmd);
                    } catch (Exception sda) {
                    }
                } else if ((t[0].endsWith("yahoo.com")) || (t[0].endsWith("yahoo.co.in")) || (t[0].endsWith("yahoo.in"))) {
                    String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler http://www.ymail.com";
                    try {
                        Process p = Runtime.getRuntime().exec(cmd);
                    } catch (Exception sda) {
                    }
                } else if (t[0].endsWith("rediffmail.com")) {
                    String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler http://www.rediffmail.com";
                    try {
                        Process p = Runtime.getRuntime().exec(cmd);
                    } catch (Exception sda) {
                    }
                } else if (t[0].endsWith("hotmail.com")) {
                    String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler http://www.hotmail.com";
                    try {
                        Process p = Runtime.getRuntime().exec(cmd);
                    } catch (Exception sda) {
                    }
                } else {
                    String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler http://www.google.com";
                    try {
                        Process p = Runtime.getRuntime().exec(cmd);
                    } catch (Exception sda) {
                    }
                }
            } else {
                fplz.setVisible(false);
                JOptionPane.showMessageDialog(null, "Oops Internet Connection Problem Please check your connection and then restart", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Registeration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       class plzwai extends JFrame
{
        Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    plzwai()
    {
         LookAndFeel lf = UIManager.getLookAndFeel();
               try
               {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception e) {
                    }
         fplz = new JFrame("Registering Please Wait....");

   fplz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   fplz.setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\airindia.jpg"));
    final JProgressBar aJProgressBar = new JProgressBar(JProgressBar.HORIZONTAL);
    //aJProgressBar.setStringPainted(true);
    aJProgressBar.setIndeterminate(true);
    fplz.add(new JPanel(),BorderLayout.NORTH);
    fplz.add(new JPanel(),BorderLayout.WEST);
    fplz.add(new JPanel(),BorderLayout.EAST);
    fplz.add(new JPanel(),BorderLayout.SOUTH);
    fplz.add(aJProgressBar, BorderLayout.CENTER);
    fplz.setLocation(h/3,w/4);
    fplz.setResizable(false);
    fplz.setSize(700, 100);
    fplz.setVisible(true);
    }
}
}