import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.security.Security;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Notice implements Runnable
{
    String m="";
    String tn="";
    String sur="";
    String d="";
    String y="";
    String b="";
    Thread thr=new Thread(this);

     Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();


    Notice(String survey , String tname , String mess , String date,String year,String branch)
    {
        y=year;
        b=branch;
        m=mess;
        d=date;
        sur=survey;
        tn=tname;
        try
        {
            //File f = new File("Notices/");
            File f = new File("Notices\\");
            //BufferedWriter bb = new BufferedWriter(new FileWriter("Notices/"+(f.list().length+1)+".ravs"));
            BufferedWriter bb = new BufferedWriter(new FileWriter("Notices\\"+(f.list().length+1)+".ravs"));
            if(sur.contains("yes"))
            {
                bb.append("Survey");
            }
            else
            {
                bb.append("Notice");
            }
            bb.newLine();
            bb.append("From-->"+tname);
            bb.newLine();
            bb.append("Date-->"+date);
            bb.newLine();
            bb.append("Message-->");
            bb.newLine();
            bb.append(mess);
            bb.close();
        }catch(Exception asdsa){}
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

    class NewJFrame1 extends JFrame implements Runnable
    {
         public InfiniteProgressPanel glassPane;
         int total=0;
         Thread thread = new Thread(this);
         JButton jButton1;
         JButton jButton2;
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
        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel4 = new JLabel();

        this.glassPane = new InfiniteProgressPanel();

        setName("GTBIT Messenger");
        //setIconImage(new ImageIcon("img/r.gif").getImage());
        setIconImage(new ImageIcon("img\\r.gif").getImage());
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setMaximumSize(new Dimension(704,474));
        setMinimumSize(new Dimension(704,474));
        setPreferredSize(new Dimension(704,474));
        getContentPane().setLayout(null);
        setGlassPane(glassPane);

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

        jButton1.setText("Yes");
        getContentPane().add(jButton1);
        jButton1.setBounds(230, 420, 75, 29);
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            System.out.println(sur.substring(3));
                                            StringTokenizer yr=new StringTokenizer(y,",");
                                            int year=yr.countTokens();
                                            StringTokenizer br=new StringTokenizer(b,",");
                                            int branch=br.countTokens();
                                            System.out.println(year+"  "+branch);
                                            total=(branch*60)*year;
                                            thread.start();
                                        }
                                    });

        jButton2.setText("No");
        getContentPane().add(jButton2);
        jButton2.setBounds(390, 420, 75, 29);
        jButton2.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            dispose();
                                        }
                                    });

        //jLabel4.setIcon(new ImageIcon("img/4.jpg")); // NOI18N
        jLabel4.setIcon(new ImageIcon("img\\4.jpg"));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 710, 470);
        if(sur.contains("no"))
        {
            jButton1.setVisible(false);
            jButton2.setVisible(false);
        }

        setName("GTBIT Messenger");
        setIconImage(new ImageIcon("img\\r.gif").getImage());
        setTitle("GTBIT Messenger");
        pack();
        setLocation(h/2,w/8);
    }

    public void run()
    {
        glassPane.start();
        String to[]={"ravsurvey@gmail.com"};
        sending1 s = new sending1("gtbitinfo1@gmail.com",""+total,sur.substring(3),to,"docomo3401");
        String check=s.send();
        if(check.equalsIgnoreCase("caught"))
        {
            glassPane.stop();
            JOptionPane.showMessageDialog(null,"Network Problem Please check your internet connection","Error",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            glassPane.stop();
            JOptionPane.showMessageDialog(null,"Survey Response Sent","Confirmation",JOptionPane.INFORMATION_MESSAGE);
        }
        dispose();
    }

}


    public class sending1
{
    private static final String SMTP_HOST_NAME = "smtp.gmail.com";
    private static final String SMTP_PORT = "465";
    private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    String MsgTxt=null;
    String Subject=null;
    String From=null;
    String pwd=null;
    String[] too;
    String ss="";

    public sending1(String fr,String msg,String sub,String[] fro,String p)
    {
        MsgTxt=msg;
        Subject=sub;
        From=fr;
        pwd=p;
        too=fro;
    }

    public String send()
    {
        String s="";
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            try
            {
                sendSSLMessage(too,Subject,MsgTxt,From,pwd);
            }catch(Exception e)
            {
                s=e.getMessage();
            }
            if(s.equals(""))
            {
                s="Your message is successfully mailed";
            }
            return(ss);
    }



    public void sendSSLMessage(String recipients[], String subject,String message, String from,String pwd)
    {
        try{
        boolean debug = false;
        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.smtp.socketFactory.port", SMTP_PORT);
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");
        final String from1=from;
        final String pwd1=pwd;
        Session session = Session.getInstance(props,new javax.mail.Authenticator()
        {protected PasswordAuthentication getPasswordAuthentication()
            {return new PasswordAuthentication(from1,pwd1);}});

        session.setDebug(debug);

        Message msg = new MimeMessage(session);
        InternetAddress addressFrom = new InternetAddress(from);
        msg.setFrom(addressFrom);

        InternetAddress[] addressTo = new InternetAddress[recipients.length];
        for (int i = 0; i < recipients.length; i++)
        {
            addressTo[i] = new InternetAddress(recipients[i]);
        }
        msg.setRecipients(Message.RecipientType.TO, addressTo);

        msg.setSubject(subject);
        msg.setContent(message, "text/plain");
        Transport.send(msg);
        from=null;
        recipients=null;
        pwd=null;
        subject=null;
        message=null;
        }catch(Exception asda){ss="caught";}
    }
}





}
