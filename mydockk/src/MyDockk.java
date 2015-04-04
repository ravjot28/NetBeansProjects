import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyDockk extends JFrame implements ActionListener
{
    static String filen="Bin/DockItem.ravs";
    JFrame f;
    JButton di[]=new JButton[100];
    JButton bug;
    Toolkit tk = Toolkit.getDefaultToolkit();
    public static void main(String[] args)
    {
        MyDockk m=new MyDockk();
    }

    public MyDockk()
    {
        LookAndFeel lf = UIManager.getLookAndFeel();
               try
               {
                   // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                   UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (Exception e) {
                    }
        f=new JFrame("My Dockk");
        JButton b=new JButton("",new ImageIcon("Icons/add.png"));
        b.addActionListener
                (new ActionListener()
                            {
                                public void actionPerformed(ActionEvent e)
                                {
                                    String fn=null;
                                    String fn1=null;
                                    FileDialog fd=new FileDialog(MyDockk.this,"Select Dock Item",FileDialog.LOAD);
                                    fd.show();
                                    if((fn=fd.getFile())!=null)
                                    {
                                        BufferedWriter pw=null;
                                        fn=fd.getDirectory()+fd.getFile();
                                        if(check(fn))
                                        {
                                            JOptionPane.showMessageDialog(null,"Oops The Dock Item You Want To Add is Already Present..","Alert",JOptionPane.INFORMATION_MESSAGE);
                                            f.setVisible(false);
                                            new MyDockk();
                                        }
                                        else
                                        {
                                        try
                                        {
                                           pw=new BufferedWriter(new FileWriter(filen,true));
                                           pw.append(fn);
                                           pw.newLine();
                                           pw.close();
                                           fd.setVisible(false);
                                           f.setVisible(false);
                                           new MyDockk();
                                        }catch(Exception rr){}
                                    }
                                    }

                                }
                            }
                );

       f.addWindowListener(
                new WindowAdapter()
                {
                    public void windowClosing(WindowEvent e)
                    {
                        System.exit(0);
                    }
        });   
        int nol=getNumberOfLines(filen);
        String name=null;
        String name1=null;
        if(nol==0)
        {
            bug=new JButton(new ImageIcon("Icons/bug.png"));
            bug.setToolTipText("Bug Report");
            bug.setActionCommand("bug");
             bug.addActionListener(new ActionListener ()
             {
                 public void actionPerformed(ActionEvent aee)
                 {
                      GUI gg=new GUI();
                      try
                      {
                        gg.launch();
                      }catch(Exception e32){}
                 }
             });
               lf = UIManager.getLookAndFeel();
               try
               {
                   // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                   UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (Exception e) {
                    }
               f.setLocation((((int) tk.getScreenSize().width)/3)+130,1);
               f.setLayout(new GridLayout(1,2));
               f.add(bug);
               b.setToolTipText("Add Dock Item");
            f.add(b);
            f.setUndecorated(true);
            f.pack();
            f.setVisible(true);
        }
        else
        {
            bug=new JButton(new ImageIcon("Icons/bug.png"));
            bug.setToolTipText("Bug Report");
             bug.setActionCommand("bug");
             bug.addActionListener(new ActionListener ()
             {
                 public void actionPerformed(ActionEvent aee)
                 {
                      GUI gg=new GUI();
                      try
                      {
                        gg.launch();
                      }catch(Exception e32){}
                 }
             });
            f.add(bug);
            JButton close[]=new JButton[100];
              lf = UIManager.getLookAndFeel();
               try
               {
                   // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                   UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (Exception e) {
                    }
            f.setLayout(new GridLayout(1,nol));
            JPanel p[]=new JPanel[100];
            JPanel p1[]=new JPanel[100];
            JPanel p2[]=new JPanel[100];
            JPanel p3[]=new JPanel[100];
            JButton j=null;
            try
            {
                BufferedReader bf=new BufferedReader(new FileReader(filen));
                for(int r=0;r<nol;r++)
                {
                    p[r]=new JPanel(new GridLayout(2,1));
                    p1[r]=new JPanel(new GridLayout(1,2));
                    p2[r]=new JPanel(new GridLayout(1,2));
                    p3[r]=new JPanel();
                    name=bf.readLine();
                    name1=name.substring(name.lastIndexOf('\\')+1);
                    File file = new File(name);
                    sun.awt.shell.ShellFolder sf =sun.awt.shell.ShellFolder.getShellFolder(file);
                    di[r]=new JButton(new ImageIcon(sf.getIcon(true)));
                    di[r].setActionCommand(name);
                    di[r].setToolTipText(name1);
                    close[r]=new JButton(new ImageIcon("Icons/close.png"));
                    close[r].setActionCommand(name);
                    close[r].setToolTipText("Close");
                    close[r].setSize(12,12);
                   p3[r].add(close[r]);
                    p1[r].add(p2[r]);
                    p1[r].add(p3[r]);
                    p[r].add(p1[r]);
                    p[r].add(di[r]);
                    //di[r].add(close[r]);
                  //  di[r].setBackground(Color.white);
                   // di[r].setForeground(Color.white);
                    di[r].setSize(32,32);
                    di[r].addActionListener(this);
                    close[r].addActionListener
                            (
                                new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        String item=e.getActionCommand();
                                        String data=null;
                                       try
         {
            BufferedReader b=new BufferedReader(new FileReader(filen));
            BufferedWriter b1=new BufferedWriter(new FileWriter("Bin/temp.ravs",true));
            data=b.readLine();
            while(data!=null)
            {
                if(data.equals(item))
                {}
                else
                {
                    b1.append(data);
                    b1.newLine();
                }
                data=b.readLine();
             }
             b.close();
             b1.close();
            }catch(Exception e10){}
            File f11=new File("Bin/DockItem.ravs");
            f11.delete();
            try
            {
                BufferedReader b2=new BufferedReader(new FileReader("Bin/temp.ravs"));
                BufferedWriter b3=new BufferedWriter(new FileWriter(filen));
                data=b2.readLine();
                while(data!=null)
                {
                    if(data.equals(item))
                    {}
                    else
                    {
                        b3.append(data);
                        b3.newLine();
                    }
                    data=b2.readLine();
                 }
                 b2.close();
                 b3.close();
           }catch(Exception e33){}
           File f12=new File("Bin/temp.ravs");
           f12.delete();
                                        f.setVisible(false);
                                        new MyDockk();
                                    }
                                }
                            );
                    name=null;
                    f.add(p[r]);
                }
            }catch(Exception e){}
            b.setToolTipText("Add Dock Item");
            f.add(b);
            f.setUndecorated(true);
            f.setLocation((((int) tk.getScreenSize().width)/2)-(nol*30),-6);
            if(nol!=1)
            {
            f.setSize(nol*70,73);
            }
            else
            {
                f.setSize(120,73);
                //f.pack();
            }
            f.setVisible(true);
        }

    }

    public int  number(String a)
    {
        int b=0;
        int r=0;
        String c=null;
        try
        {
            BufferedReader bb=new BufferedReader(new FileReader(filen));
            c=bb.readLine();
            while(c!=null)
            {
                if(c.equalsIgnoreCase(a))
                {
                    b=r;
                    break;
                }
                r++;
                c=bb.readLine();
            }

        }catch(Exception e){}
        return b;
    }

    public String next(int r)
    {
        String a=null;
        String b1=null;
        try
        {
            BufferedReader b=new BufferedReader(new FileReader(filen));
            a=b.readLine();
            for(int i=0;i<=r+1;i++)
            {

                if(i==(r+1))
                {
                    a=b1;
                }
                b1=b.readLine();
            }
        }catch(Exception e){}
        return a;
    }

    public boolean check(String a)
    {
        boolean p=false;
        String b=null;
        try
        {
           BufferedReader b2=new BufferedReader(new FileReader(filen));
           b=b2.readLine();
           while(b!=null)
           {
                if(b.equalsIgnoreCase(a))
                {
                    p=true;
                    break;
                }
                b=b2.readLine();
           }
        }catch(Exception e){}
        return p;
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

    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getActionCommand().equalsIgnoreCase("computer"))
        {
            try {
                Runtime.getRuntime().exec("explorer shell:MyComputerFolder");
            } catch (IOException ex)
            {
            }
        }
        else
        {
        try
        {

        String s=e.getActionCommand();
       /* if(extension.equalsIgnoreCase("exe"))
        {
            String[] commands =
       {"cmd.exe",
        "/c",s};
            r.exec(commands);
        }
        else
            if(extension.equalsIgnoreCase("pdf"))
            {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+s);

            }
            else
                if((extension.equalsIgnoreCase("xls"))||(extension.equalsIgnoreCase("xlsx")))
                {
                     String[] commands = {"cmd", "/c", "start", "\"DummyTitle\"",s};
                     Runtime.getRuntime().exec(commands);
                }
                else
                    if((extension.equalsIgnoreCase("ppt"))||(extension.equalsIgnoreCase("pptx")))
                {
                    Runtime.getRuntime().exec("cmd /c start powerpnt.exe \""+s+"\"");
                }
                    else
                        if((extension.equalsIgnoreCase("mdb"))||(extension.equalsIgnoreCase("accdb")))
                        {
                            Runtime.getRuntime().exec("cmd /c start msaccess.exe \""+s+"\"");
                        }
                        else
                            if((extension.equalsIgnoreCase("docx"))||(extension.equalsIgnoreCase("doc")))
                            {
                                Runtime.getRuntime().exec("cmd /c start winword.exe \""+s+"\"");
                            }
                            else
                                if(extension.equalsIgnoreCase("txt"))
                                {
                                    Runtime.getRuntime().exec("cmd /c start notepad.exe \""+s+"\"");
                                }
                                else
                                    if(extension.equalsIgnoreCase("xps"))
                                    {
                                        Runtime.getRuntime().exec("cmd /c start XpsRchVw.exe \""+s+"\"");
                                    }
                                    else
                                        if(extension.equalsIgnoreCase("rtf"))
                                        {
                                            Runtime.getRuntime().exec("cmd /c start write.exe \""+s+"\"");
                                        }
                                        else
                                            if(extension.equalsIgnoreCase("pps"))
                                            {
                                                Runtime.getRuntime().exec("cmd /c start powerpnt.exe /S \""+s+"\"");
                                            }
                                            else
                                                if(extension.equalsIgnoreCase("wpd"))
                                                {
                                                    Runtime.getRuntime().exec("cmd /c WPWin12.exe : \""+s+"\"");
                                                }*/
                                       String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler" + " " + s;
                                        System.out.println(cmd);
                                        Process p = Runtime.getRuntime().exec(cmd);
                                                    
                                                  /*  else
                                                        if(extension.equalsIgnoreCase("shw"))
                                                        {
                                                             Runtime.getRuntime().exec("cmd /c start  Prwin12.exe \""+s+"\"");
                                                        }
                                                        else
                                                            if(extension.equalsIgnoreCase("qpw"))
                                                            {
                                                                 Runtime.getRuntime().exec("cmd /c start qpw.exe \""+s+"\"");
                                                            }
                                                            
                                                         else      if
                                                               {
                                                                    Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL "+s);
                                                                }*/
                                                                }

        catch(Exception e2)
        {
            JOptionPane.showMessageDialog(null, "Oops the Dock could not execute the program", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }




}
