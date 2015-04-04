import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MailSender
{
    JFrame f;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    public final static String send="img/send.jpg";
    URL sen=getClass().getClassLoader().getResource(send);

     public final static String logout="img/logout.png";
     URL log=getClass().getClassLoader().getResource(logout);

    MailSender(String email , String pswd)
    {
        f = new JFrame("R Mail Sender");
         try
        {
            BufferedWriter ba=new BufferedWriter(new FileWriter("Bin/Temp/att.ravs"));
            BufferedWriter ba1=new BufferedWriter(new FileWriter("Bin/Temp/attachment.ravs"));
            ba.append("");
            ba1.append("");
            ba.close();
            ba1.close();
        }catch(Exception ada){}
        MailSenderPanel mp = new MailSenderPanel(email,pswd);
        f.add(mp);
        f.pack();
        f.setLocation(h/2,w/30);
        f.addWindowListener(new WindowAdapter()
                                {
                                    public void windowClosing(WindowEvent e)
                                    {
                                         try
                                         {
                                            BufferedWriter ba=new BufferedWriter(new FileWriter("Bin/Temp/att.ravs"));
                                            BufferedWriter ba1=new BufferedWriter(new FileWriter("Bin/Temp/attachment.ravs"));
                                            ba.append("");
                                            ba1.append("");
                                            ba.close();
                                            ba1.close();
                                        }catch(Exception ada){}
                                        System.exit(0);
                                    }
                                });
        f.setResizable(false);
        f.setVisible(true);
    }

public class MailSenderPanel extends JPanel implements Runnable
{
    Thread th = new Thread(this);
    JButton jButton1;
    JButton jButton2;
    JButton jButton3;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JLabel jLabel5;
    JLabel jLabel6;
    JScrollPane jScrollPane1;
    JTextArea jTextArea1;
    JTextField jTextField1;
    JTextField jTextField2;
    JTextField jTextField3;
    JTextField jTextField4;
    String email="";
    String pswd="";
    String ss[];
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    private InfiniteProgressPanel glassPane;
    
    public MailSenderPanel(String e,String p)
    {
        this.email = e;
        this.pswd = p;
        initComponents();
    }

    private void initComponents()
    {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jLabel4 = new JLabel();
        jTextField2 = new JTextField();
        jLabel5 = new JLabel();
        jTextField3 = new JTextField();
        jLabel6 = new JLabel();
        jTextField4 = new JTextField();
        jButton1 = new JButton();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jButton2 = new JButton();
        jButton3 = new JButton();

        setBackground(new Color(255, 255, 255));
        setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
         this.glassPane = new InfiniteProgressPanel();
         f.setGlassPane(glassPane);
        if(email.contains("@gmail.com"))
        {
            jLabel1.setText("<html><img src=file:Bin/Img/gmail.png/></html>");
        }
        else
        {
            jLabel1.setText("<html><img src=file:Bin/Img/yahoo.png/></html>");
        }
        jTextArea1.setLineWrap(true);
        jLabel2.setBackground(new Color(255, 255, 255));
        jLabel2.setFont(new Font("Zapfino", 1, 18));
        jLabel2.setText("R Mail Sender");
        jLabel2.setToolTipText("Rav Softs.");

        jLabel3.setFont(new Font("American Typewriter", 1, 14)); // NOI18N
        jLabel3.setText("To");

        jTextField1.setFont(new Font("Hiragino Kaku Gothic ProN", 1, 14)); // NOI18N

        jLabel4.setFont(new Font("American Typewriter", 1, 14)); // NOI18N
        jLabel4.setText("Cc");

        jTextField2.setFont(new Font("Hiragino Kaku Gothic ProN", 1, 14)); // NOI18N

        jLabel5.setFont(new Font("American Typewriter", 1, 14)); // NOI18N
        jLabel5.setText("Bcc");

        jTextField3.setFont(new Font("Hiragino Kaku Gothic ProN", 1, 14)); // NOI18N

        jLabel6.setFont(new Font("American Typewriter", 1, 14)); // NOI18N
        jLabel6.setText("Subject");

        jTextField4.setFont(new Font("Hiragino Kaku Gothic ProN", 1, 14)); // NOI18N

        jButton1.setText("Attach Files");
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            new attachement();
                                        }
                                    });
        jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));

        jTextArea1.setBackground(new Color(204, 204, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new Font("Comic Sans MS", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setToolTipText("Send");
        jButton2.setIcon(new ImageIcon(sen));
        //jButton2.setIcon(new ImageIcon("send.jpg"));
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton2.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            boolean send=false;
                                            if(jTextField1.getText().trim().equalsIgnoreCase(""))
                                            {
                                                JOptionPane.showMessageDialog(null,"Please enter To field","Error",JOptionPane.ERROR_MESSAGE);
                                            }
                                            else
                                            if(jTextField4.getText().trim().equalsIgnoreCase(""))
                                            {
                                                int answer = JOptionPane.showConfirmDialog(null, "Do you want the subject to be empty?", "Alert", JOptionPane.YES_NO_OPTION);

                                                if (answer == JOptionPane.YES_OPTION)
                                                {
                                                    glassPane.start();
                                                    ss=new String[getNumberOfLines("Bin/Temp/attachment.ravs")];
                                                    String data1=null;
                                                    try
                                                    {
                                                        BufferedReader bbb=new BufferedReader(new FileReader("Bin/Temp/attachment.ravs"));
                                                        data1=bbb.readLine();
                                                        for(int i=0;i<getNumberOfLines("Bin/Temp/attachment.ravs");i++)
                                                        {
                                                            ss[i]=data1;
                                                            data1=bbb.readLine();
                                                            JOptionPane.showMessageDialog(null,ss[i],"Hi",JOptionPane.INFORMATION_MESSAGE);
                                                        }
                                                        bbb.close();
                                                    }catch(Exception bf){}
                                                    th.start();
                                                }
                                            }
                                            else
                                            if(jTextArea1.getText().trim().equalsIgnoreCase(""))
                                            {
                                                int answer = JOptionPane.showConfirmDialog(null, "Do you want the message body to be empty?", "Alert", JOptionPane.YES_NO_OPTION);

                                                if (answer == JOptionPane.YES_OPTION)
                                                {
                                                    glassPane.start();
                                                    ss=new String[getNumberOfLines("Bin/Temp/attachment.ravs")];
                                                    String data1=null;
                                                    try
                                                    {
                                                        BufferedReader bbb=new BufferedReader(new FileReader("Bin/Temp/attachment.ravs"));
                                                        data1=bbb.readLine();
                                                        for(int i=0;i<getNumberOfLines("Bin/Temp/attachment.ravs");i++)
                                                        {
                                                            ss[i]=data1;
                                                            data1=bbb.readLine();
                                                            JOptionPane.showMessageDialog(null,ss[i],"Hi",JOptionPane.INFORMATION_MESSAGE);
                                                        }
                                                        bbb.close();
                                                    }catch(Exception bf){}
                                                    th.start();
                                                }
                                            }
                                            else
                                            {
                                                glassPane.start();
                                                ss=new String[getNumberOfLines("Bin/Temp/attachment.ravs")];
                                                String data1=null;
                                                try
                                                {
                                                    BufferedReader bbb=new BufferedReader(new FileReader("Bin/Temp/attachment.ravs"));
                                                    data1=bbb.readLine();
                                                    for(int i=0;i<getNumberOfLines("Bin/Temp/attachment.ravs");i++)
                                                    {
                                                        ss[i]=data1;
                                                        data1=bbb.readLine();
                                                        JOptionPane.showMessageDialog(null,ss[i],"Hi",JOptionPane.INFORMATION_MESSAGE);
                                                    }
                                                    bbb.close();
                                                }catch(Exception bf){}
                                                th.start();
                                            }
                                        }
                                    });

        jButton3.setToolTipText("Log Out");
        jButton3.setIcon(new ImageIcon(log));
        //jButton3.setIcon(new ImageIcon("logout.png"));
        jButton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
         jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            int answer = JOptionPane.showConfirmDialog(null, "You want to delete the current account?", "Change Account", JOptionPane.YES_NO_OPTION);

                                            if (answer == JOptionPane.YES_OPTION)
                                            {
                                                try
                                                {
                                                    BufferedWriter ba=new BufferedWriter(new FileWriter("Bin/Data/UserInfo.ravs"));
                                                    ba.append("");
                                                    ba.close();
                                                }catch(Exception ada){}
                                                f.dispose();
                                                new LoginPage();
                                            }
                                        }
                                    });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4,GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addGap(119, 119, 119)
                                .addComponent(jLabel2)))))
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(178, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(172, 172, 172))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jButton2)
                .addGap(83, 83, 83)
                .addComponent(jButton3)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4,GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    public int getNumberOfLines(String name)
    {
	int numberOfLines = 0;
	LineNumberReader lineCounter = null;
	try
        {
            lineCounter = new LineNumberReader(new FileReader(name));
            while ((lineCounter.readLine()) != null)
            {
                continue;
            }
            numberOfLines = lineCounter.getLineNumber();
	} catch (IOException e)
           {}
	return numberOfLines;
    }

    public void run()
    {
        if(email.contains("@gmail.com"))
        {
            String emailss = jTextField1.getText().trim()+","+jTextField2.getText().trim()+","+jTextField3.getText().trim()+",";
           StringTokenizer st1=new StringTokenizer(emailss,",");
           String ttt [] =new String[st1.countTokens()];
           int i=0;
           while(st1.hasMoreTokens())
           {
               ttt[i]=st1.nextToken();
               i++;
           }
           //System.out.println("Emails "+emailss);
            sendingGmail1 s1=new sendingGmail1(email,jTextArea1.getText().trim(),jTextField4.getText().trim(),ttt,pswd,ss);
            String result=s1.send();
            glassPane.stop();
            if(result.equals("Your message is successfully mailed"))
            {
                JOptionPane.showMessageDialog(null, result,"Alert",JOptionPane.INFORMATION_MESSAGE);
                f.dispose();
                new MailSender(email,pswd);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"OOps Something went wrong and sending Failed !!","Error",JOptionPane.ERROR_MESSAGE);
                f.dispose();
                new MailSender(email,pswd);
            }
        }
        else
        {
           StringTokenizer st1=new StringTokenizer(jTextField1.getText().trim(),",");
           String ttt [] =new String[st1.countTokens()];
           int i=0;
           while(st1.hasMoreTokens())
           {
               ttt[i]=st1.nextToken();
               i++;
           }
            sendingYahoo1 s1=new sendingYahoo1(email,jTextArea1.getText().trim(),jTextField4.getText().trim(),ttt,pswd,ss);
            String result=s1.send();
            glassPane.stop();
            if(result.equals("Your message is successfully mailed"))
            {
                JOptionPane.showMessageDialog(null, result,"Alert",JOptionPane.INFORMATION_MESSAGE);
                f.dispose();
                new MailSender(email,pswd);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"OOps Something went wrong and sending Failed !!","Error",JOptionPane.ERROR_MESSAGE);
                f.dispose();
                new MailSender(email,pswd);
            }

        }
        try
        {
            BufferedWriter ba=new BufferedWriter(new FileWriter("Bin/Temp/att.ravs"));
            BufferedWriter ba1=new BufferedWriter(new FileWriter("Bin/Temp/attachment.ravs"));
            ba.append("");
            ba1.append("");
            ba.close();
            ba1.close();
        }catch(Exception ada){}
    }

}

}
