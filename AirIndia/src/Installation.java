import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class Installation extends JFrame implements Runnable
{
    String dir1=new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/";
    Thread thread=new Thread(this);
    String fname1[];
    String error="";
    String errors="";
    JFrame fplz;
    String db[];
    XrButton sub = new XrButton(new ImageIcon("Bin\\img\\ok.png"));
    XrButton reset = new XrButton(new ImageIcon("Bin\\img\\reset.png"));
    JLabel head;
    JLabel id;
    JLabel pas;
    JPasswordField pass;
    JTextField idd;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    String fname[];
    public Installation(int a)
    {
        if(a==0)
        {
        try
         {
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
         }catch(Exception e){}
        launch();
        }
    }

    private void launch()
    {
        head = new JLabel();
        id = new JLabel();
        pas = new JLabel();
        idd = new JTextField();
        pass = new JPasswordField();

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
        setTitle("Installation Login");
        head.setFont(new  Font("Verdana", 1, 16));
        head.setText("Installation Login");

        id.setFont(new Font("Verdana", 0, 14));
        id.setText("Product ID");

        pas.setFont(new Font("Verdana", 0, 14));
        pas.setText("Password");

        idd.setFont(new Font("Verdana", 0, 14));

        sub.setToolTipText("Submit");
        sub.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                if((idd.getText().equalsIgnoreCase(null))||(idd.getText().equalsIgnoreCase("")))
                {
                    JOptionPane.showMessageDialog(null,"Please enter the Product ID given by the developers","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                if((pass.getText().equalsIgnoreCase(null))||(pass.getText().equalsIgnoreCase("")))
                {
                    JOptionPane.showMessageDialog(null,"Please enter the password given by the developers","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    if((idd.getText().trim().equalsIgnoreCase("123456789"))&&(pass.getText().trim().equalsIgnoreCase("ravjot")))
                    {
                            filecho();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Oops incorrect information entered. Please try again","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        reset.setToolTipText("Reset");
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                idd.setText("");
                pass.setText("");
            }
        });

         GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(117, 117, 117)
                            .addComponent(head))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(76, 76, 76)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(id)
                                .addComponent(pas))
                            .addGap(53, 53, 53)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(pass)
                                .addComponent(idd,GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(sub)
                        .addGap(57, 57, 57)
                        .addComponent(reset)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(head)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(id)
                    .addComponent(idd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pas)
                    .addComponent(pass, GroupLayout.PREFERRED_SIZE, 21,GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(sub)
                    .addComponent(reset))
                .addGap(39, 39, 39))
        );
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\airindia.jpg"));
        setLocation(h/2,w/7);
        setResizable(false);
        pack();
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
    

     public void mk(String strManyDirectories)
   {
       boolean success = (new File(strManyDirectories)).mkdirs();
   }    

    public void run()
    {
        String dir=new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/";
        mk(dir);
         String dir2=new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/";
        try
        {
            BufferedWriter b=new BufferedWriter(new FileWriter(dir2+"data.ravs"));
            b.append(new Base64Encoder("admin").get());
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
