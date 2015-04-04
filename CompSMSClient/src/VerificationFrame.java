import Encrytp.Base64Decoder;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;


public class VerificationFrame extends JFrame implements Runnable,FileDetails
{
    JButton Submit;
    JButton Resend;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JTextField jTextField1;
    JTextField jTextField2;

    String data="";

    InfiniteProgressPanel glasspane;

    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    Thread th = new Thread(this);

    static int send_or_recieve=-1;

    static String inputPh = "";
    static String inputSecret = "";
    
    public VerificationFrame()
    {
        initComponents();
    }

    private void initComponents()
    {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        Submit = new JButton();
        Resend = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        glasspane = new InfiniteProgressPanel("Connecting Server. Please Wait...");

        setTitle("Rav SMS Service");
        setIconImage(new ImageIcon(imageicon).getImage());

        setGlassPane(glasspane);

        jLabel1.setFont(new Font("Georgia", 1, 24));
        jLabel1.setText("Rav SMS Service Verification");

        jLabel2.setFont(new Font("Times New Roman", 1, 18));
        jLabel2.setText("Contact Number *");

        jLabel3.setFont(new Font("Times New Roman", 1, 18));
        jLabel3.setText("Secret Code *");

        jTextField1.setFont(new Font("Tahoma", 0, 14));

        jTextField2.setFont(new Font("Tahoma", 0, 14));

        Submit.setFont(new Font("Tahoma", 1, 14));
        Submit.setText("Submit");

        Submit.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent evt)
                                        {
                                            SubmitActionPerformed(evt);
                                        }
                                    });

        Resend.setFont(new Font("Tahoma", 1, 14));
        Resend.setText("Resend");

        Resend.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent evt)
                                        {
                                            ResendActionPerformed(evt);
                                        }
                                    });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Submit)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Resend))
                            .addComponent(jLabel1))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(Submit)
                    .addComponent(Resend))
                .addContainerGap())
        );
        setLocation(h/2,w/7);
        setResizable(false);
        pack();
    }

    private void SubmitActionPerformed(ActionEvent evt)
    {
        inputPh = jTextField1.getText().trim();
        inputSecret = jTextField2.getText().trim();
        if(inputPh.equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please Enter the Contact Number", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
            if(inputSecret.equalsIgnoreCase(""))
            {
                JOptionPane.showMessageDialog(null, "Please Enter the Secret Code", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                try
                {
                    BufferedReader b = new BufferedReader(new FileReader(dirpath+filename));
                    data = b.readLine().trim();
                    data = new Base64Decoder(data).get();
                    data = data.trim();
                    b.close();
                }catch(Exception as){}
                send_or_recieve=2;
                th.start();
                th = new Thread(this);
            }
    }

    private void ResendActionPerformed(ActionEvent evt)
    {
        try
        {
            BufferedReader b = new BufferedReader(new FileReader(dirpath+filename));
            data = b.readLine().trim();
            data = new Base64Decoder(data).get();
            data = data.trim();
            b.close();
        }catch(Exception as){}
        StringTokenizer s = new StringTokenizer(data,"##");
        String f = s.nextToken();
        String m = s.nextToken();
        String l = s.nextToken();
        String e = s.nextToken();
        String p = s.nextToken();
        String lo = s.nextToken();
        data = "rav##"+f+","+m+","+l+","+e+"##"+p+","+lo;
        send_or_recieve=1;
        th.start();
        th = new Thread(this);
    }

    public void run()
    {
        if(send_or_recieve==1)
        {
            glasspane.start();
            String to[] = {adminemail};
            sending s1 = new sending(adminemail,"",data, to,adminpassword );
            glasspane.setText("Sending Request To The Server. Please Wait..");
            String result = s1.send();
            if(result.equalsIgnoreCase("yes"))
            {
                glasspane.stop();
                JOptionPane.showMessageDialog(null, "Kindly login with Secret Code and Contact Number mailed you or messaged you", "Alert", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Oops Internet Connection Issue. Please Check you internet and try again", "Error", JOptionPane.ERROR_MESSAGE);
            }

            jTextField1.setText("");
            jTextField2.setText("");
        }
        else
        {
            glasspane.start();
            glasspane.setText("Verifying details with Server. Please wait..");
            StringTokenizer s = new StringTokenizer(data,"##");
            String f = s.nextToken();
            String m = s.nextToken();
            String l = s.nextToken();
            String e = s.nextToken();
            String p = s.nextToken();
            String lo = s.nextToken();
            GettingLocation gl = new GettingLocation(lo);
            gl.createMap();
            lo = gl.getLocation();
            int a = Integer.parseInt(lo);
            int dir = a/100;
            int post = a%100;
            String rav = "";
            switch(dir)
            {
                case 26:rav="north.";
                    break;
                case 27:rav="east.";
                    break;
                case 28:rav="west.";
                    break;
                case 29:rav="south.";
                    break;
            }
            if(post>=10)
            {
                rav+=post;
            }
            else
            {
                rav+="0"+post;
            }
            System.out.println("Calling verification");
            Verification v = new Verification(rav,e+"##"+p,"ravjotsingupkey@gmail.com","docomo3401",inputPh,inputSecret);
            if(v.startreading())
            {
                JOptionPane.showMessageDialog(null, "Congratualtion !!! Now you can use Rav SMS Service", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Oops !!! Invalid Contact Number or Secret Code", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            glasspane.stop();
        }
    }
}
