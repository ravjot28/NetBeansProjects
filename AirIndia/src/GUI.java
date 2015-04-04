import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.text.*;
public class GUI extends JFrame implements ActionListener,Runnable
{
    String dir1=new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/";
    String dir2=new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/";
    JFrame fplz;
    Thread thread=new Thread(this);
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    JRoundButton submit;
    JRoundButton forgot;
    JLabel head;
    JLabel note;
    JLabel id;
    JLabel pswd;
    JPasswordField p;
    IntegerField i;
    String rav;

    public GUI(String r)
    {
        rav=r;
        launch();
    }

    public void run()
    {
        String t[] = new String[1];
                                    t[0]=new EmailQuery(i.getText()).search(rav);
                                    String pwd=new PassQuery(i.getText()).search(rav);
                                    String message="Dear Employee,\n You or someone has requested to retrieve the password for the Pay Roll application.\n Your Account details i.e. Employee ID and the password are given below.\n Please enter this password and for the security purposes please change the password as soon you login [Optional].\n\n "+"Employee ID-->"+i.getText()+"\nYour Password is --->"+pwd+"\n\n Note:Please do not reply to this email .\n Once retrieved the password you can delete this Email.\n This Email is not Spam.\n\n Thank You.\n\n Rav Softs Presentation";
                                    sending s1=new sending("airindiapayroll@gmail.com",message,"Your Password",t,"airindia1960");
                                    String result=s1.send();
                                    if(result.equalsIgnoreCase("Your message is successfully mailed"))
                                    {

                                        fplz.setVisible(false);
                                        JOptionPane.showMessageDialog(null, result+".Please Check your mail","Alert",JOptionPane.INFORMATION_MESSAGE);
                                        if(t[0].endsWith("gmail.com"))
                                        {
                                            String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler http://www.gmail.com";
                                            try{Process p = Runtime.getRuntime().exec(cmd);}catch(Exception sda){}
                                        }
                                        else
                                            if((t[0].endsWith("yahoo.com"))||(t[0].endsWith("yahoo.co.in"))||(t[0].endsWith("yahoo.in")))
                                            {
                                                String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler http://www.ymail.com";
                                                try{Process p = Runtime.getRuntime().exec(cmd);}catch(Exception sda){}
                                            }
                                            else
                                                if(t[0].endsWith("rediffmail.com"))
                                                {
                                                    String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler http://www.rediffmail.com";
                                                    try{Process p = Runtime.getRuntime().exec(cmd);}catch(Exception sda){}
                                                }
                                                else
                                                    if(t[0].endsWith("hotmail.com"))
                                                    {
                                                        String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler http://www.hotmail.com";
                                                        try{Process p = Runtime.getRuntime().exec(cmd);}catch(Exception sda){}
                                                    }
                                                    else
                                                    {
                                                        String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler http://www.google.com";
                                                        try{Process p = Runtime.getRuntime().exec(cmd);}catch(Exception sda){}
                                                    }
                                                    dispose();
                                                    new GUI(rav).setVisible(true);
                                    }
                                    else
                                    {

                                        fplz.setVisible(false);
                                        JOptionPane.showMessageDialog(null,"Oops Internet Connection Problem Please check your connection and then restart","Error",JOptionPane.ERROR_MESSAGE);
                                    }
    }

    private void launch()
    {
        look();
        head = new JLabel();
        note = new JLabel();
        submit = new JRoundButton(null,new ImageIcon("Bin\\img\\ok.png"));
        forgot = new JRoundButton(null,new ImageIcon("Bin\\img\\forgotpass.png"));
        id = new JLabel();
        pswd = new JLabel();
        i = new IntegerField();
        p = new JPasswordField();
         JTextComponent.KeyBinding[] newBindings = {
        new JTextComponent.KeyBinding(
          KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK),
          DefaultEditorKit.beepAction),
        new JTextComponent.KeyBinding(
          KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK),
          DefaultEditorKit.beepAction),
        new JTextComponent.KeyBinding(
            KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK),
            DefaultEditorKit.beepAction)
      };

    Keymap k = p.getKeymap();
    JTextComponent.loadKeymap(k, newBindings, p.getActions());

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome Page");
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\airindia.jpg"));

        head.setFont(new Font("Perpetua Titling MT", 1, 18));
        head.setForeground(new Color(51, 153, 255));
        head.setText("Air India Pay Roll");

        note.setFont(new Font("Andalus", 1, 16));
        note.setForeground(new Color(255, 0, 51));
        note.setText("* New Users enter 'guest' as password");

        submit.setFont(new Font("Arial", 1, 14));
        submit.setToolTipText("Submit");
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                 String dir2=new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/";
                         String rr="";
                         try
                            {
                                BufferedReader b=new BufferedReader(new FileReader(dir2+"data.ravs"));
                                rr=new Base64Decoder(b.readLine()).get();
                                b.close();
                            }catch(Exception asd){}
                        
                 if((i.getText().equals("000000")))//&&(p.getText().equalsIgnoreCase(rr))
                         {
                            if(p.getText().equals(rr.trim()))
                            {
                                dispose();
                                java.awt.EventQueue.invokeLater(new Runnable()
                                {
                                    public void run()
                                    {
                                        new admin().setVisible(true);
                                    }
                                });
                             }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Oops Wrong Password","Error",JOptionPane.ERROR_MESSAGE);
                            }
                         }
                        else
                         {
                if((i.getText().equalsIgnoreCase(""))||(i.getText().equalsIgnoreCase(null)))
                {
                    JOptionPane.showMessageDialog(null,"Please enter the Employee ID","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                     if((p.getText().equalsIgnoreCase(null))||(p.getText().equalsIgnoreCase("")))
                    {
                        JOptionPane.showMessageDialog(null,"Please enter the password","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        
                        String pwd=new PassQuery(i.getText()).search(rav);
                        if((p.getText().equals(pwd))&&(pwd.equals("guest")))
                        {
                            //setVisible(false);
                            dispose();
                            new Registeration(i.getText(),rav).setVisible(true);
                        }
                        else
                            if(p.getText().equals(pwd))
                        {
                                String loc1=getloc(Integer.parseInt(i.getText().trim()),dir1+"MDB/"+"Emp.mdb");
                                 dispose();
                                 new Option(i.getText(),rav,loc1).setVisible(true);
                        }
                            else
                                if(pwd.equals(""))
                                {
                                    JOptionPane.showMessageDialog(null,"Oops Wrong Employee ID Entered","Error",JOptionPane.ERROR_MESSAGE);
                                }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Oops Wrong Password Entered","Error",JOptionPane.ERROR_MESSAGE);
                            }
                    
                    }

                }
            }
            }
        });

        forgot.setFont(new Font("Arial", 1, 14));
        forgot.setToolTipText("Forgot Password");
        forgot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                if((i.getText().equals(""))&&(i.getText().equalsIgnoreCase(null)))
                {
                    JOptionPane.showMessageDialog(null,"Please Enter the Employee ID","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    String pwd=new PassQuery(i.getText()).search(rav);
                        if(pwd.equals("guest"))
                        {
                            JOptionPane.showMessageDialog(null,"You are a New User so please enter guest as password","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        else
                                if((pwd.equals(""))&&(!i.getText().equals("111111")))
                                {
                                    JOptionPane.showMessageDialog(null,"Oops Wrong Employee ID Entered","Error",JOptionPane.ERROR_MESSAGE);
                                }
                                else
                                {
                                    new plzwai();
                                    thread.start();
                                }

                }
            }
        });

        id.setFont(new Font("Andalus", 1, 16));
        id.setText("Employee ID");

        pswd.setFont(new Font("Andalus", 1, 16));
        pswd.setText("Password");

        i.setFont(new Font("Andalus", 0, 16));
        i.setToolTipText("Enter the Employee ID");
        i.setSelectedTextColor(new Color(204, 204, 204));
        i.setSelectionColor(new Color(204, 204, 204));
        i.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                String text = i.getText();
                int length = text.length();
                if (length == 6)
                {
                    e.consume();
                } else if (length >6) {
                    i.setText(text.substring(0, 6));
                }
            }
        });


        p.setFont(new Font("", 0, 14));
        p.setToolTipText("New User enter 'guest' as password");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(228, Short.MAX_VALUE)
                .addComponent(note)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(submit)
                .addGap(77, 77, 77)
                .addComponent(forgot)
                .addContainerGap(141, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(head))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(id)
                            .addComponent(pswd))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(p,GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(i,GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))))
                .addContainerGap(147,GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(head)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(id)
                    .addComponent(i,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(pswd)
                    .addComponent(p,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(forgot)
                    .addComponent(submit))
                .addGap(39, 39, 39)
                .addComponent(note)
                .addContainerGap())
        );
        setLocation(h/2,w/7);
        setResizable(false);
        pack();
    }



    public void actionPerformed(ActionEvent e) {
    }

    public void look()
    {
         try
         {
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
         }catch(Exception e){}
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
         fplz = new JFrame("Sending the password .Please Wait....");
   fplz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final JProgressBar aJProgressBar = new JProgressBar(JProgressBar.HORIZONTAL);
    //aJProgressBar.setStringPainted(true);
    aJProgressBar.setIndeterminate(true);
    fplz.setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\airindia.jpg"));
    fplz.add(new JPanel(),BorderLayout.NORTH);
    fplz.add(new JPanel(),BorderLayout.WEST);
    fplz.add(new JPanel(),BorderLayout.EAST);
    fplz.add(new JPanel(),BorderLayout.SOUTH);
    fplz.add(aJProgressBar, BorderLayout.CENTER);
    fplz.setResizable(false);
    fplz.setLocation(h/3,w/4);
    fplz.setSize(700, 100);
    fplz.setVisible(true);
    }
}

    public String getloc(int emp,String rav)
    {
        Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+rav);
            Statement sta = con.createStatement();
           ResultSet res = sta.executeQuery("SELECT * FROM EMP where EMPID="+emp);
            if(res.next())
            {
                return res.getString("LOC");
            }
            sta.close();
            con.close();
        } catch (Exception e) {   }
        return "";
    }
}
