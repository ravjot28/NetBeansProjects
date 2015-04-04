import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.JTextComponent;
import javax.swing.text.Keymap;

public class login extends JFrame
{
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    JLabel empid;
    JTextField empidt;
    JLabel head;
    JLabel password;
    JPasswordField passwordt;
    XrButton reset = new XrButton(new ImageIcon("Bin\\img\\reset.png"));
    XrButton submit = new XrButton(new ImageIcon("Bin\\img\\ok.png"));
    
    public login()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        look();
        head = new JLabel();
        empid = new JLabel();
        password = new JLabel();
        empidt = new IntegerField();
        passwordt = new JPasswordField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        head.setFont(new Font("Verdana", 1, 18));
        head.setText("Login Screen");

        empid.setFont(new Font("Serif", 0, 16));
        empid.setText("Employee ID");

        password.setFont(new Font("Serif", 0, 16));
        password.setText("Password");

        empidt.setFont(new Font("Serif", 0, 16));
        empidt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                String text = empidt.getText();
                int length = text.length();
                if (length == 6)
                {
                    e.consume();
                } else if (length > 6) {
                    empidt.setText(text.substring(0, 1));
                }
            }
        });
        
        passwordt.setFont(new Font("Serif", 0, 16));
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

    Keymap k = passwordt.getKeymap();
    JTextComponent.loadKeymap(k, newBindings, passwordt.getActions());

        submit.setToolTipText("Submit");
        submit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                if(empidt.getText().equalsIgnoreCase(""))
                {
                    JOptionPane.showMessageDialog(null,"Please enter the Employee ID","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                if(passwordt.getText().equalsIgnoreCase(""))
                {
                    JOptionPane.showMessageDialog(null,"Please enter the password","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    check(empidt.getText().trim(),passwordt.getText().trim());
                }
            }
        });

        reset.setToolTipText("Clear All");
        reset.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                empidt.setText("");
                passwordt.setText("");
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)  //137, 137, 137
                        .addComponent(head))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(empid)
                            .addComponent(password))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordt)
                            .addComponent(empidt,GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130) //116, 116, 116
                        .addComponent(submit)
                        .addGap(35, 35, 35)
                        .addComponent(reset)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(head)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(empid)
                    .addComponent(empidt,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(password)
                    .addComponent(passwordt,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(reset))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        setTitle("Login Screen");
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\r.gif"));
        setLocation(h/2,w/9);
        setResizable(false);
        pack();
    }
    
     public void look()
    {
         try
         {
             //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
             UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
              //UIManager.setLookAndFeel("com.easynth.lookandfeel.EaSynthLookAndFeel");
             //UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
             /*System.setProperty("Quaqua.tabLayoutPolicy","wrap");
             UIManager.setLookAndFeel(
                  ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel()
              );*/
         }catch(Exception e){}
    }

     public String[] getdetails()
    {
        String a[]=new String[10];
        Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D:/Harman.mdb";
            con = DriverManager.getConnection(driver,"","");
            Statement sta = con.createStatement();
            ResultSet res = sta.executeQuery("SELECT * FROM exitmanag where emp_id="+empid);
            if(res.next())
            {
            a[0]=res.getString("emp_id");
            a[1]=res.getString("emp_name");
            a[2]=res.getString("currentproject");
            a[3]=res.getString("department");
            a[4]=res.getString("dateofjoinning");
            a[5]=res.getString("emp_adr");
            a[6]=res.getString("emp_phoneno");
            a[7]=res.getString("region");
            a[8]=res.getString("dor");
            String loc=res.getString("reason");
            String p="";
            try
            {
                BufferedReader bb=new BufferedReader(new FileReader(loc));
                String data=bb.readLine();
                while(data!=null)
                {
                    p=p+data+"\n";
                    data=bb.readLine();
                }
                bb.close();
            }catch(Exception sadfafa){}
            a[9]=p;
            }

      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {  System.out.println(e);  }
        return a;
    }

     public void check(String empid,String pass)
     {
         
        String pswd=new PassQuery(empid).search("D:\\Harman.mdb");
        if(pswd.equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null,"Incorrect Employee ID","Error",JOptionPane.ERROR_MESSAGE);
        }
        else
        if(!pswd.equalsIgnoreCase(pass))
        {
            JOptionPane.showMessageDialog(null,"Incorrect Password","Error",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            String role=new RoleQuery(empid).search("D:\\Harman.mdb");
            if(role.equalsIgnoreCase("e"))
            {
                dispose();
                new emp(empid).setVisible(true);
            }
            else
            if(role.equalsIgnoreCase("mphr"))
            {
                dispose();
                EventQueue.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        new mph().setVisible(true);
                    }
                });
            }
            else
            if(role.equalsIgnoreCase("mp"))
            {
                dispose();
                EventQueue.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        new mp().setVisible(true);
                    }
                });
            }
            else
            if(role.equalsIgnoreCase("mhr"))
            {
                dispose();
                EventQueue.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        new mh().setVisible(true);
                    }
                });
            }
             else
            if(role.equalsIgnoreCase("a"))
            {
                dispose();
                new admin(empid).setVisible(true);
                //JOptionPane.showMessageDialog(null,"Admin screen under construction","Error",JOptionPane.ERROR_MESSAGE);
            }
             else
            if(role.equalsIgnoreCase("i"))
            {
                dispose();
                new it(empid).setVisible(true);
                //JOptionPane.showMessageDialog(null,"IT screen under construction","Error",JOptionPane.ERROR_MESSAGE);
            }
            else
            if(role.equalsIgnoreCase("eh"))
            {
                dispose();
                new ehs().setVisible(true);
            }
            else
            if(role.equalsIgnoreCase("hr"))
            {
                dispose();
                new hr(empid).setVisible(true);
                //JOptionPane.showMessageDialog(null,"HR screen under construction","Error",JOptionPane.ERROR_MESSAGE);
            }
            else
            if(role.equalsIgnoreCase("p"))
            {
                dispose();
                new projecthead(empid).setVisible(true);
            }
            else
            if(role.equalsIgnoreCase("m"))
            {
                dispose();
                new manager1(empid).setVisible(true);
            }
        }
     }
}
