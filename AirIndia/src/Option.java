import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.text.*;

public class Option extends JFrame implements ActionListener
{
    JFrame fplz;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    static String emp;
    String rav;
    String loc;
    public Option(String em,String prav,String l)
    {
        loc=l;
        rav=prav;
        emp=em;
        launch();
    }

    private void launch()
    {
        JRoundButton view;
        JRoundButton edit;
        JRoundButton print;
        JRoundButton mail;
        JLabel jLabel1;
        jLabel1 = new JLabel();
        view = new JRoundButton(null,new ImageIcon("Bin\\img\\view.png"));
        mail = new JRoundButton(null,new ImageIcon("Bin\\img\\mail.png"));
        print = new JRoundButton(null,new ImageIcon("Bin\\img\\viewcomp.png"));
        edit = new JRoundButton(null,new ImageIcon("Bin\\img\\edit.png"));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Choose Options");
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\airindia.jpg"));
        jLabel1.setIcon(new ImageIcon("Bin\\img\\1960_Air_India.jpg"));
        edit.setToolTipText("Edit Account");
        mail.setToolTipText("Mail Pay Slip");
        view.setToolTipText("View Pay Slip without PLI");
        print.setActionCommand("Merge");
        edit.setActionCommand("Edit");
        mail.setActionCommand("Mail");
        view.setActionCommand("View");
        print.setToolTipText("View Pay Slip with PLI");
        print.addActionListener(this);
        edit.addActionListener(this);
        mail.addActionListener(this);
        view.addActionListener(this);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)    //59,59,59
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(print)
                        .addGap(36, 36, 36)
                        .addComponent(view)
                        .addGap(35, 35, 35)
                        .addComponent(mail)
                        .addGap(29, 29, 29)
                        .addComponent(edit)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(print)
                    .addComponent(view)
                    .addComponent(mail)
                    .addComponent(edit))
                .addContainerGap())
        );
        setLocation(h/2,w/14);
        pack();
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equalsIgnoreCase("merge"))
        {
            new checkmerge().setVisible(true);
        }
        else
        if(e.getActionCommand().equalsIgnoreCase("mail"))
        {
            new time("mail").setVisible(true);
        }
            else
                if(e.getActionCommand().equalsIgnoreCase("edit"))
                {
                        new edit().setVisible(true);
                }
                else
                {
                    new  checkview().setVisible(true);
                }
    }

    public void mk(String strManyDirectories)
   {
       (new File(strManyDirectories)).mkdirs();
  }

     class plzwai extends JFrame
{
        Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    plzwai(String message)
    {
         LookAndFeel lf = UIManager.getLookAndFeel();
               try
               {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception e) {
                    }
         fplz = new JFrame(message);
   fplz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final JProgressBar aJProgressBar = new JProgressBar(JProgressBar.HORIZONTAL);
    //aJProgressBar.setStringPainted(true);
    aJProgressBar.setIndeterminate(true);
    fplz.add(new JPanel(),BorderLayout.NORTH);
    fplz.setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\airindia.jpg"));
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

class checkview extends JFrame
{
    JButton sub;
    JLabel head;
    JPasswordField pas;

    public checkview()
    {
        launch();
    }

    private void launch()
    {

        head = new JLabel();
        pas = new JPasswordField();
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

    Keymap k = pas.getKeymap();
    JTextComponent.loadKeymap(k, newBindings, pas.getActions());
        XrButton sub = new XrButton(new ImageIcon("Bin\\img\\ok.png"));

        head.setFont(new Font("Verdana", 1, 16));
        head.setText("Employee ID: "+emp+" please enter the password");

        sub.setFont(new Font("Verdana", 1, 12));
        sub.setToolTipText("Submit");

        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                String pwd=new PassQuery(emp).search(rav);
                if((pas.getText().equalsIgnoreCase(null))||(pas.getText().equalsIgnoreCase("")))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter the Password","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                    if(pas.getText().equalsIgnoreCase(pwd))
                    {
                        dispose();
                        new time("basic").setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Oops Incorrect Password","Error",JOptionPane.ERROR_MESSAGE);
                    }
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(sub))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(head))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(pas,GroupLayout.PREFERRED_SIZE, 216,GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(head)
                .addGap(45, 45, 45)
                .addComponent(pas,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(sub)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        addWindowListener(new WindowAdapter()
        {      public void windowClosing(WindowEvent e) {       setVisible(false);      }    });
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\airindia.jpg"));
        setLocation(h/2,w/7);
        setResizable(false);
        setTitle("Authentication");
        pack();
    }

}    

     class checkmerge extends JFrame
{
    JButton sub;
    JLabel head;
    JPasswordField pas;

    public checkmerge()
    {
        launch();
    }

    private void launch()
    {

        head = new JLabel();
        pas = new JPasswordField();
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

    Keymap k = pas.getKeymap();
    JTextComponent.loadKeymap(k, newBindings, pas.getActions());
        XrButton sub = new XrButton(new ImageIcon("Bin\\img\\ok.png"));

        head.setFont(new Font("Verdana", 1, 16));
        head.setText("Employee ID: "+emp+" please enter the password");

        sub.setFont(new Font("Verdana", 1, 12));
        sub.setToolTipText("Submit");

        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                String pwd=new PassQuery(emp).search(rav);
                if((pas.getText().equalsIgnoreCase(null))||(pas.getText().equalsIgnoreCase("")))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter the Password","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                    if(pas.getText().equalsIgnoreCase(pwd))
                    {
                        dispose();
                        new time("basicpli").setVisible(true);
                        //merge();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Oops Incorrect Password","Error",JOptionPane.ERROR_MESSAGE);
                    }
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(sub))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(head))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(pas,GroupLayout.PREFERRED_SIZE, 216,GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(head)
                .addGap(45, 45, 45)
                .addComponent(pas,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(sub)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        addWindowListener(new WindowAdapter()
        {      public void windowClosing(WindowEvent e) {       setVisible(false);      }    });
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\airindia.jpg"));
        setLocation(h/2,w/7);
        setResizable(false);
        setTitle("Authentication");
        pack();
    }

}

class edit extends JFrame
{
    JButton email;
    JButton pas;
    JLabel head;
    JLabel pass;
    JLabel id;

    public edit()
    {
        launch();
    }

    private void launch() {

        head = new JLabel();
        pass = new JLabel();
        id = new JLabel();
        email = new JRoundButton(null,new ImageIcon("Bin\\img\\changemail.png"));
        pas = new JRoundButton(null,new ImageIcon("Bin\\img\\changepass.png"));

        head.setFont(new Font("Verdana", 1, 18));
        head.setText("Edit User's Account");

        pass.setFont(new Font("Serif", 1, 14));
        pass.setText("Change Password");

        id.setFont(new Font("Serif", 1, 14));
        id.setText("Change Email ID");

        pas.setToolTipText("Change Password");

        email.setToolTipText("Change Email ID");

	email.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                dispose();
                new email().setVisible(true);
            }
        });

	 pas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                dispose();
                new pas().setVisible(true);
            }
        });

         GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(head))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(id)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(email))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pass)
                                .addGap(69, 69, 69)
                                .addComponent(pas)))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(head)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(pass)
                    .addComponent(pas))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(id)
                    .addComponent(email))
                .addContainerGap(100, Short.MAX_VALUE))
        );
         addWindowListener(new WindowAdapter()
        {      public void windowClosing(WindowEvent e) {       setVisible(false);      }    });
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\airindia.jpg"));
        setLocation(h/2,w/7);
        setResizable(false);
        setTitle("Edit Account");
        pack();
    }

}

public class pas extends JFrame
{
    String pwd=new PassQuery(emp).search(rav);
    JButton sub;
    JLabel old;
    JLabel new1;
    JLabel new2;
    JLabel head;
    JPasswordField pas1;
    JPasswordField pas2;
    JPasswordField pas3;

    public pas()
    {
        launch();
    }

    private void launch() {

        head = new JLabel();
        old = new  JLabel();
        new1 = new JLabel();
        new2 = new  JLabel();
        pas1 = new  JPasswordField();
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

    Keymap k = pas1.getKeymap();
    JTextComponent.loadKeymap(k, newBindings, pas1.getActions());
        pas2 = new JPasswordField();


    Keymap k2 = pas2.getKeymap();
    JTextComponent.loadKeymap(k2, newBindings, pas2.getActions());
        pas3 = new JPasswordField();


    Keymap k3 = pas3.getKeymap();
    JTextComponent.loadKeymap(k3, newBindings, pas3.getActions());
        XrButton sub = new XrButton(new ImageIcon("Bin\\img\\ok.png"));

        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                if(pas1.getText().equals(pwd))
                {
                if((pas1.getText().equalsIgnoreCase(""))||(pas1.getText().equalsIgnoreCase(null))||(pas2.getText().equalsIgnoreCase(""))||(pas2.getText().equalsIgnoreCase(null))||(pas3.getText().equalsIgnoreCase(""))||(pas3.getText().equalsIgnoreCase(null)))
                {
                    JOptionPane.showMessageDialog(null, "Please all the text fields","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    if((pas2.getText().equalsIgnoreCase(pas3.getText())))
                    {
                        String r=update(pas2.getText());
                        if(r.equalsIgnoreCase("ok"))
                        {
                            JOptionPane.showMessageDialog(null, "Updated....","Alert",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                          JOptionPane.showMessageDialog(null, "Encountered Error cant update..","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "New password do not match","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect old password","Error",JOptionPane.ERROR_MESSAGE);
                }
                dispose();
            }
        });

        head.setFont(new Font("Verdana", 1, 16));
        head.setText("Change Password");

        old.setFont(new Font("Verdana", 0, 12));
        old.setText("Old Password");

        new1.setFont(new Font("Verdana", 0, 12));
        new1.setText("New Password");

        new2.setFont(new Font("Verdana", 0, 12));
        new2.setText("Confirm Password");

        sub.setToolTipText("Submit");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(old)
                    .addComponent(new1)
                    .addComponent(new2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(pas1,GroupLayout.PREFERRED_SIZE, 123,GroupLayout.PREFERRED_SIZE)
                    .addComponent(pas2,GroupLayout.PREFERRED_SIZE, 123,GroupLayout.PREFERRED_SIZE)
                    .addComponent(pas3, GroupLayout.PREFERRED_SIZE, 123,GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(166, Short.MAX_VALUE)
                .addComponent(sub)
                .addGap(161, 161, 161))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(head)
                .addGap(119, 119, 119))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(head)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(old)
                    .addComponent(pas1,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(new1)
                    .addComponent(pas2,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(new2)
                    .addComponent(pas3,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(sub)
                .addGap(22, 22, 22))
        );
        addWindowListener(new WindowAdapter()
        {      public void windowClosing(WindowEvent e) {       setVisible(false);      }    });
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\airindia.jpg"));
        setLocation(h/2,w/7);
        setResizable(false);
        setTitle("Change Password");
        pack();
    }

    public String update(String r1)
    {
       Connection con = null;
    try
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+rav;
            con = DriverManager.getConnection(driver,"","");
           Statement sta = con.createStatement();
        sta.executeUpdate("UPDATE EMP SET PASS='"+r1+"' where EMPID="+emp);
        sta.close();
        con.close();
        return "ok";
    } catch (Exception e) {
      return e.toString();
    }
    }



}
 class email extends JFrame
{
    String pwd=new PassQuery(emp).search(rav);
    JButton sub;
    JLabel head;
    JLabel email;
    JLabel pas;
    JPasswordField pass;
    JTextField mail;

    public email() {
        launch();
    }

    private void launch() {

        head = new JLabel();
        email = new JLabel();
        pas = new JLabel();
        pass = new JPasswordField();
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

    Keymap k = pass.getKeymap();
    JTextComponent.loadKeymap(k, newBindings, pass.getActions());
        mail = new JTextField();
        XrButton sub = new XrButton(new ImageIcon("Bin\\img\\ok.png"));

          head.setFont(new Font("Verdana", 1, 16));
        head.setText("Change Email ID");

        email.setFont(new Font("Verdana", 0, 12));
        email.setText("Enter New Email ID");

        pas.setFont(new Font("Verdana", 0, 12));
        pas.setText("Enter the Password");

        sub.setToolTipText("Submit");
        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                if(pass.getText().equals(pwd))
                {
                   if((mail.getText().equalsIgnoreCase(null))||(mail.getText().equalsIgnoreCase("")))
                   {
                       JOptionPane.showMessageDialog(null, "Please Enter the new email id","Error",JOptionPane.ERROR_MESSAGE);
                   }
                   else
                   {
                        String r=update(mail.getText());
                        if(r.equalsIgnoreCase("ok"))
                        {
                            JOptionPane.showMessageDialog(null, "Updated....","Alert",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                          JOptionPane.showMessageDialog(null, "Encountered Error cant update..","Error",JOptionPane.ERROR_MESSAGE);
                        }
                   }
                }
                else
                {

                    JOptionPane.showMessageDialog(null, "Incorrect Password","Error",JOptionPane.ERROR_MESSAGE);
                }
                dispose();
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(head))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(pas)
                            .addComponent(email))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(mail)
                            .addComponent(pass, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(165, Short.MAX_VALUE)
                .addComponent(sub)
                .addGap(170, 170, 170))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(head)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(email)
                    .addComponent(mail,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(pas,GroupLayout.Alignment.TRAILING)
                    .addComponent(pass,GroupLayout.Alignment.TRAILING,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(sub)
                .addContainerGap(56, Short.MAX_VALUE))
        );
         addWindowListener(new WindowAdapter()
        {      public void windowClosing(WindowEvent e) {       setVisible(false);      }    });
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\airindia.jpg"));
        setLocation(h/2,w/7);
        setResizable(false);
        setTitle("Change Email");
        pack();
    }

    public String update(String r1)
    {
        Connection con = null;
        try
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+rav;
            con = DriverManager.getConnection(driver,"","");
           Statement sta = con.createStatement();
        sta.executeUpdate("UPDATE EMP SET EMAIL='"+r1+"' where EMPID="+emp);
        sta.close();
        con.close();
        return "ok";
    } catch (Exception e) {
      return e.toString();
    }
    }

}

 class time extends JFrame implements Runnable
 {
    Thread thread1=new Thread(this);
    XrButton submit = new XrButton(new ImageIcon("Bin\\img\\ok.png"));
    XrButton reset= new XrButton(new ImageIcon("Bin\\img\\reset.png"));
    JComboBox m;
    JComboBox y;
    JLabel head;
    JLabel mo;
    JLabel ye;
    String option;
    public time(String opt)
    {
        option=opt;
        launch();
    }

    private void launch()
    {
        m = new JComboBox();
        y = new JComboBox();
        head = new JLabel();
        mo = new JLabel();
        ye = new JLabel();
        String month[]=new String[] { "Select Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "November", "December" };

        m.setModel(new DefaultComboBoxModel(month));
        m.setToolTipText("Select Month");
        int cur=Integer.parseInt(new CalendarExample().name());
        String yea[]=new String[cur-1952];
        int count=1;
        yea[0]="Select Year";
        for(int i=cur;i>=1954;i--)
        {
            yea[count]=""+i;
            count++;
        }

        y.setModel(new DefaultComboBoxModel(yea));
        y.setToolTipText("Select Year");

        head.setFont(new Font("Verdana", 1, 18)); // NOI18N
        head.setText("Year Month for Pay Slip");

        submit.setToolTipText("Submit");
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                String month1=m.getSelectedItem().toString();
                String year=y.getSelectedItem().toString();
                if(month1.equalsIgnoreCase("Select Month"))
                {
                    JOptionPane.showMessageDialog(null, "Please Select the month","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                 if(year.equalsIgnoreCase("Select Year"))
                 {
                    JOptionPane.showMessageDialog(null, "Please Select the year","Error",JOptionPane.ERROR_MESSAGE);
                 }
                 else
                  {
                    String folder="";
                    String data1[];
                      if(m.getSelectedIndex()>10)
                      {
                          folder=year+m.getSelectedIndex();
                      }
                      else
                      {
                          folder=year.toString()+"0"+m.getSelectedIndex();
                      }
                      String location=folder;
                      String dir2=new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/";
                      String loc2=dir2+location+"/"+loc+"/"+emp+".ravs";
                      File file=new File(loc2);
                      if(file.exists())
                      {
                        if(getNumberOfLines(loc2)>1)
                        {
                          data1=new String[getNumberOfLines(loc2)];
                          int count=0;
                          try
                          {
                            BufferedReader b=new BufferedReader(new FileReader(loc2));
                            String data=b.readLine();
                            while(data!=null)
                            {
                                data1[count]=new Base64Decoder(data).get().trim();
                                count++;
                                data=b.readLine();
                            }
                          }catch(Exception sd){}
                          File fp=new File(new Dir().getdir()+"test/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12");
                                if(option.equalsIgnoreCase("basic"))
                                {
                                    try
                                    {
                                        if(!fp.exists())
                                        {
                                            mk(new Dir().getdir()+"test/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12");
                                        }
                                        new plzwai("Processing Basic pay slip Please wait.......");
                                        new FirstPageOfPaySlip().launch(data1,m.getSelectedItem().toString()+"/"+y.getSelectedItem().toString());
                                       // new SecondPageOfPaySlip().launch(emp,rav);
                                    } catch (Exception ex) {}
                                    String cmd1="rundll32" + " " + "url.dll,FileProtocolHandler" + " "+new Dir().getdir()+"test/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/Basic_Slips.pdf";
                                    try
                                    {
                                        dispose();
                                        fplz.setVisible(false);
                                        Runtime.getRuntime().exec(cmd1);
                                    } catch (Exception ex) {         }
                                   
                                }
                                else
                                 if(option.equalsIgnoreCase("basicpli"))
                                 {
                                    try
                                    {
                                        if(!fp.exists())
                                        {
                                            mk(new Dir().getdir()+"test/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12");
                                        }
                                        new plzwai("Processing Complete pay slip Please wait.......");
                                        new FirstPageOfPaySlip().launch(data1,m.getSelectedItem().toString()+"/"+y.getSelectedItem().toString());
                                       new SecondPageOfPaySlip().launch(data1,m.getSelectedItem().toString()+"/"+y.getSelectedItem().toString());
                                       new PDFMerger();
                                    } catch (Exception ex) {}
                                    String cmd1="rundll32" + " " + "url.dll,FileProtocolHandler" + " "+new Dir().getdir()+"test/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/Complete_Pay_Slip.pdf";
                                    try
                                    {
                                        dispose();
                                        fplz.setVisible(false);
                                        Runtime.getRuntime().exec(cmd1);
                                    } catch (Exception ex) {         }
                                    
                                 }
                                else
                                    if(option.equalsIgnoreCase("mail"))
                                    {
                                        try
                                        {
                                            if(!fp.exists())
                                        {
                                            mk(new Dir().getdir()+"test/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12");
                                        }
                                            new FirstPageOfPaySlip().launch(data1,m.getSelectedItem().toString()+"/"+y.getSelectedItem().toString());
                                            new SecondPageOfPaySlip().launch(data1,m.getSelectedItem().toString()+"/"+y.getSelectedItem().toString());
                                            new PDFMerger();
                                        } catch (Exception ex) {}
                                        String cmd1="rundll32" + " " + "url.dll,FileProtocolHandler" + " "+new Dir().getdir()+"test/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/Complete_Pay_Slip.pdf";
                                        new plzwai("Sending Complete Pay Slip Please wait.......");
                                        dispose();
                                        thread1.start();
                                        
                                    }
                      }
                       else
                      {
                        JOptionPane.showMessageDialog(null, "The details of the employee is not present for the given time period","Error",JOptionPane.ERROR_MESSAGE);
                      }
                      }
                      else
                      {
                        JOptionPane.showMessageDialog(null, "The details of the employee is not present for the given time period","Error",JOptionPane.ERROR_MESSAGE);
                      }
                }
            }
        });

        reset.setToolTipText("Cancel");
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                dispose();
            }
        });

        mo.setFont(new Font("Serif", 1, 14)); // NOI18N
        mo.setText("Month");

        ye.setFont(new Font("Serif", 1, 14)); // NOI18N
        ye.setText("Year");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(head)
                .addContainerGap(112, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(mo)
                .addGap(27, 27, 27)
                .addComponent(m,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(ye)
                .addGap(26, 26, 26)
                .addComponent(y,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(submit)
                .addGap(51, 51, 51)
                .addComponent(reset)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(head)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(mo)
                    .addComponent(m,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                    .addComponent(y,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                    .addComponent(ye))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(reset))
                .addContainerGap())
        );
         addWindowListener(new WindowAdapter()
        {      public void windowClosing(WindowEvent e) {       setVisible(false);      }    });
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\airindia.jpg"));
        setLocation(h/2,w/7);
        setResizable(false);
        setTitle("Time Period");
        pack();
    }

    public  boolean del(File path)
    {
    if( path.exists() ) {
      File[] files = path.listFiles();
      for(int i=0; i<files.length; i++) {
         if(files[i].isDirectory()) {
           del(files[i]);
         }
         else {
           files[i].delete();
         }
      }
    }
    return( path.delete() );
  }

    public int getNumberOfLines(String name)
    {
		int numberOfLines = 0;


		LineNumberReader lineCounter = null;
		try {
			lineCounter = new LineNumberReader(new FileReader(name));
			while ((lineCounter.readLine()) != null) {
				continue;
			}
			numberOfLines = lineCounter.getLineNumber();

		} catch (IOException e)
                {
		}

		return numberOfLines;
	}

        public void run() 
        {
             String t1[]={new EmailQuery(emp).search(rav)};
             String aa[]={new Dir().getdir()+"test/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/Complete_Pay_Slip.pdf"};
             String messa="Dear Employee,\n Here is your complete pay slip in PDF format .\n Please save it on your computer.\n This email is sent because you have requested for your complete Pay Slip to be mailed to you via Pay Roll Application."+"\n\n Note:Please do not reply to this email .\n Once downloaded your pay slip you can delete the mail.\n This Email is not Spam.\n\n Thank You.\n\n Rav Softs Presentation";
             sending1 s1=new sending1("airindiapayroll@gmail.com",messa,"Pay Slip",t1,"airindia1960",aa);
             String result=s1.send();
             fplz.setVisible(false);
             if(result.equals("Your message is successfully mailed"))
             {
               JOptionPane.showMessageDialog(null, result,"Alert",JOptionPane.INFORMATION_MESSAGE);
             }
             else
             {
                JOptionPane.showMessageDialog(null,"Encountered Connection Error","Alert",JOptionPane.INFORMATION_MESSAGE);
             }
        }

}


}
