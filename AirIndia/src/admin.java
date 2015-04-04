import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.filechooser.FileFilter;

public class admin extends JFrame
{
    String dir=new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/";
    String dir1=new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/";
    String dir2=new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/";
    JRoundButton add;
    JRoundButton delete;
    JRoundButton edit;
    JRoundButton home;
    JLabel head;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    public admin()
    {
        launch();
    }


    
    private void launch() {

        head = new JLabel();
        add = new JRoundButton(null,new ImageIcon("Bin\\img\\addadmin.png"));
        delete = new JRoundButton(null,new ImageIcon("Bin\\img\\deleteadmin.png"));
        edit = new JRoundButton(null,new ImageIcon("Bin\\img\\changepass.png"));
        home = new JRoundButton(null,new ImageIcon("Bin\\img\\homeadmin.png"));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Page");
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\airindia.jpg"));

        head.setIcon(new ImageIcon("Bin\\img\\1960_Air_India.jpg"));

        add.setToolTipText("Add New or change previous Record");
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                new checkview("add").setVisible(true);
            }
        });

        delete.setToolTipText("Delete Record");
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                new checkview("del").setVisible(true);
            }
        });

        edit.setToolTipText("Change Admin Password");
        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                new checkview("edit").setVisible(true);
            }
        });

        home.setToolTipText("Back Home Screen");
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                dispose();
                new Main();
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(head))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(add)
                        .addGap(29, 29, 29)
                        .addComponent(edit)
                        .addGap(33, 33, 33)
                        .addComponent(delete)
                        .addGap(18, 18, 18)
                        .addComponent(home)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(head)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(edit)
                    .addComponent(delete)
                    .addComponent(home))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        setLocation(h/2,w/14);
        setResizable(false);
        pack();
    }

    class checkview extends JFrame
{
    JButton sub;
    JLabel head;
    JPasswordField pas;
    String option="";

    public checkview(String opt)
    {
        option=opt;
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
        head.setText("Admin Confirmation Enter the admin password");

        sub.setFont(new Font("Verdana", 1, 12));
        sub.setToolTipText("Submit");

        sub.addActionListener(new ActionListener() {
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
                if((pas.getText().equalsIgnoreCase(null))||(pas.getText().equalsIgnoreCase("")))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter the Password","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                    if(pas.getText().equalsIgnoreCase(rr.trim()))
                    {
                        if(option.equalsIgnoreCase("add"))
                        {
                            dispose();
                            new add();
                        }
                        else
                            if(option.equalsIgnoreCase("edit"))
                            {
                                dispose();
                                new pas().setVisible(true);
                            }
                        else
                            if(option.equalsIgnoreCase("del"))
                            {
                                dispose();
                                new del().setVisible(true);
                            }
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

class add implements Runnable
{
    Thread thread=new Thread(this);
    String fname1[];
    String error="";
    String errors="";
    String fname[];
    JFrame fplz;
    String db[];

    public add()
    {
        launch();
    }

    private void launch()
    {
        filecho();
    }
     public void filecho()
    {

            int retVal;
                         JFileChooser fc = new JFileChooser();
                         fc.addChoosableFileFilter(new TextFilter());
                         fc.setMultiSelectionEnabled(true);
                         retVal = fc.showOpenDialog(fc);
                         dispose();
                         if (retVal == JFileChooser.APPROVE_OPTION)
                         {
                             File ff[] = fc.getSelectedFiles();
                             fname=new String[ff.length];
                             for(int i=0;i<ff.length;i++)
                             {
                                 fname[i]=ff[i].getAbsolutePath();
                             }
                             String ravs="";
                             String p="0000000000000000000000000";
                             String dobdoj="105112  1940 01 01  1958 05 06 0500";
                             int cc=0;
                             for(int r=0;r<fname.length;r++)
                             {
                                try
                                {
                                  BufferedReader bbb=new BufferedReader(new FileReader(fname[r]));
                                  ravs=bbb.readLine();
                                  bbb.close();
                                }catch(Exception asd){}
                                if(ravs.trim().length()==p.length())
                                {
                                    error=error+"1";
                                }
                                else
                                if(ravs.trim().length()==dobdoj.length())
                                {
                                    error=error+"2";
                                }
                                else
                                {
                                    error=error+"0";
                                    errors=errors+fname[r]+",";
                                }
                             }
                             fc.setVisible(false);
                             int pp=0;
                             for(int i=0;i<error.length();i++)
                             {
                                 if(error.charAt(i)=='0')
                                 {
                                     pp++;
                                 }
                                else
                                 {
                                    cc++;
                                 }
                             }
                             if(error.length()!=pp)
                             {
                                 fname1=new String[cc];
                                 int cco=0;
                                 for(int i=0;i<error.length();i++)
                                 {
                                     if(error.charAt(i)=='1')
                                     {
                                         fname1[cco]=fname[i];
                                         cco++;
                                     }
                                     else
                                        if(error.charAt(i)=='2')
                                        {
                                            fname1[cco]="#"+fname[i];
                                            cco++;
                                        }
                                 }

                                new plzwai();
                                thread.start();
                             }
                            else
                             {
                                JOptionPane.showMessageDialog(null, "Oops all the files were of invalid format","Error",JOptionPane.ERROR_MESSAGE);
                                new Main();
                             }

                        }

                        else
                        {
                            JOptionPane.showMessageDialog(null, "Please Select the database file","Error",JOptionPane.ERROR_MESSAGE);
                            System.exit(0);
                        }


    }
    

    public boolean check(int a)
    {
         Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+dir1+"MDB/"+"Emp.mdb";
            con = DriverManager.getConnection(driver,"","");
            Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT * FROM EMP where EMPID="+a);
            if(res.next())
            {
                return true;
            }
      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {
    }
      return false;
    }

    public void run()
    {
        String rr="";
        try
                            {
                                BufferedReader b=new BufferedReader(new FileReader(dir2+"data.ravs"));
                                rr=new Base64Decoder(b.readLine()).get();
                                b.close();
                            }catch(Exception asd){}
        for(int i=0;i<fname1.length;i++)
        {
            if(fname1[i].charAt(0)!='#')
            {
            int yymm=0;
            try
            {
                BufferedReader b=new BufferedReader(new FileReader(fname1[i]));
                String data=b.readLine();
                yymm=Integer.parseInt(data.substring(0,data.length()-1));
                b.close();
            }catch(Exception as){}
            db=new String[getNumberOfLines(fname1[i])];
            int count=0;
            try
            {
                BufferedReader b=new BufferedReader(new FileReader(fname1[i]));
                String data=b.readLine();
                while(data!=null)
                {
                    db[count]=data;
                    data=b.readLine();
                    count++;
                }
            }catch(Exception sdc){}
                CreateDB c=new CreateDB(db,""+yymm);
                c.create();
            }
            else
            {
                try
                {
                String dobfname=fname[i].substring(0);
                BufferedReader dobb=new BufferedReader(new FileReader(dobfname));
                String data=dobb.readLine();
                while(data!=null)
                {
                    String em=data.substring(0,6);
                    String dob=data.substring(8,18);
                    String doj=data.substring(20,30);
                     String dir1=new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/";
                    new UpdateDOB(em,dob,doj,dir1+"MDB/"+"Emp.mdb");
                    data=dobb.readLine();
                }
                }catch(Exception sdf){}
            }
        }
        if(fname1.length!=fname.length)
        {
            JOptionPane.showMessageDialog(null, "Some file(s) were of different format so the files were excluded .","Error",JOptionPane.ERROR_MESSAGE);
        }
        fplz.setVisible(false);
        new Main();
    }

    public int getNumberOfLines(String name) {
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


     class TextFilter extends FileFilter
   {

  public boolean accept(File f) {
    if (f.isDirectory())
      return true;
    String s = f.getName();
    int i = s.lastIndexOf('.');

    if (i > 0 && i < s.length() - 1)
      if (s.substring(i + 1).toLowerCase().equals("txt"))
        return true;

    return false;
  }

  public String getDescription() {
    return "Accepts txt files only.";
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
       
         fplz = new JFrame("Loading and Checking Data . Please Wait......");
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

}

 public void mk(String strManyDirectories)
   {
       boolean success = (new File(strManyDirectories)).mkdir();
   }

 public void insert(int emp,String loc,String rav)
    {
        Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+rav);
            Statement sta = con.createStatement();
            int c = sta.executeUpdate("INSERT INTO EMP"+ " " +"(EMPID,EMAIL,PASS,LOC)"+ " VALUES " +
                        "("+emp+",'xyz@abc.com','guest','"+loc+"')");
            sta.close();
            con.close();
        } catch (Exception e) {   }
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
        } catch (Exception e) {      }
        return "";
    }



 class del extends JFrame
 {
    XrButton sub = new XrButton(new ImageIcon("Bin\\img\\ok.png"));
    XrButton reset = new XrButton(new ImageIcon("Bin\\img\\reset.png"));
    JLabel head;
    JLabel date;
    IntegerField dat;
    public del()
    {
        launch();
    }

    private void launch()
    {

        head = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        dat = new IntegerField();
        dat.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                String text = dat.getText();
                int length = text.length();
                if (length == 6)
                {
                    e.consume();
                } else if (length >6) {
                    dat.setText(text.substring(0, 6));
                }
            }
        });

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        head.setFont(new Font("Verdana", 1, 18)); // NOI18N
        head.setText("Delete Records");

        date.setFont(new Font("Serif", 1, 14));
        date.setText("Enter the Year and month in form YYYYMM");

        dat.setFont(new Font("Serif", 0, 14)); // NOI18N

        sub.setToolTipText("Submit");
        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                String p=dat.getText();
                int m=Integer.parseInt(p.substring(4, 6));
                int y=Integer.parseInt(p.substring(0, 4));
                if(p.equalsIgnoreCase(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter the period of record in form YYYYMM ","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                if(p.length()!=6)
                {
                    JOptionPane.showMessageDialog(null, "Please the correct form YYYYMM","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                if((m<=0)||(m>12))
                {
                    JOptionPane.showMessageDialog(null, "Invalid month entered","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                if((y<=1947)||(y>Integer.parseInt(new CalendarExample().name())))
                {
                    JOptionPane.showMessageDialog(null, "Invalid year entered","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    boolean bb=false;
                    File dir = new File(new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/");
                    String[] children = dir.list();
                    if (children == null)
                    {
                        bb=false;
                    }
                    else
                    {
                        for (int i=0; i<children.length; i++)
                        {
                            String filename = children[i];
                            if(filename.equalsIgnoreCase(p))
                            {
                                bb=true;
                            }
                        }
                    }
                    if(bb)
                    {
                        if(deleteDir(new File(new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/"+p)))
                        {
                            File dir1 = new File(new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/");
                            String[] children1 = dir1.list();
                            if (children1.length==0)
                            {
                                Connection con = null;
                                try
                                {
                                     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                     String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/"+"MDB/"+"Emp.mdb";
                                     con = DriverManager.getConnection(driver,"","");
                                     Statement sta = con.createStatement();
                                     // getting the data back
                                     ResultSet res = sta.executeQuery("DELETE FROM EMP");
                                     res.close();
                                     sta.close();
                                     con.close();
                                     JOptionPane.showMessageDialog(null, "Deleted now you dont have any records left so please enter the records","Alert",JOptionPane.INFORMATION_MESSAGE);
                                }catch(Exception sa){}
                            }
                            JOptionPane.showMessageDialog(null, "Deleted...","Alert",JOptionPane.INFORMATION_MESSAGE);
                            
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Encountered Error . If the folder the open please close it and try again...","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "The desired folder is not present.","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        reset.setToolTipText("Reset");
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                dat.setText("");
            }
        });

        GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(head))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(sub)
                        .addGap(43, 43, 43)
                        .addComponent(reset)))
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(date)
                .addGap(57, 57, 57))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addComponent(dat,GroupLayout.PREFERRED_SIZE, 115,GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(head)
                .addGap(31, 31, 31)
                .addComponent(date)
                .addGap(18, 18, 18)
                .addComponent(dat,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(sub)
                    .addComponent(reset))
                .addGap(50, 50, 50))
        );
        addWindowListener(new WindowAdapter()
        {      public void windowClosing(WindowEvent e) {       setVisible(false);      }    });
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\airindia.jpg"));
        setLocation(h/2,w/7);
        setResizable(false);
        setTitle("Delete Records");
        pack();
    }

    public boolean deleteDir(File dir)
    {
        if (dir.isDirectory())
        {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++)
            {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success)
                {
                    return false;
                }
            }
        }
        return dir.delete();
    }

}

    



 class pas extends JFrame
{
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

                String dir2=new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/";
                         String pwd="";
                         try
                            {
                                BufferedReader b=new BufferedReader(new FileReader(dir2+"data.ravs"));
                                pwd=new Base64Decoder(b.readLine()).get().trim();
                                b.close();
                            }catch(Exception asd){}
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
                        try
                            {
                                BufferedWriter b=new BufferedWriter(new FileWriter(dir2+"data.ravs"));
                                String pwd1=new Base64Encoder(pas2.getText().trim()).get();
                                b.append(pwd1);
                                JOptionPane.showMessageDialog(null, "Admin Password Changed","Alert",JOptionPane.INFORMATION_MESSAGE);
                                b.close();
                            }catch(Exception asd){JOptionPane.showMessageDialog(null,asd,"Error",JOptionPane.ERROR_MESSAGE);}
                        
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
    
    }


    
}
