import java.awt.dnd.*;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.*;

public class MyMain extends JFrame implements ActionListener,DropTargetListener
{
    final String predefined[][]={
                                    {"My Computer","explorer shell:MyComputerFolder"},
                                    {"Recycle Bin","explorer shell:RecycleBinFolder"},
                                    {"Control Panel","explorer shell:ControlPanelFolder"},
                                    {"Administrative Tools","explorer shell:Administrative Tools"},
                                    {"Programs and Features","explorer shell:ChangeRemoveProgramsFolder"},
                                    {"Network","explorer shell:NetworkPlacesFolder"},
                                    {"Favorites","explorer shell:Favorites"},
                                    {"Games","explorer shell:Games"},
                                    {"Fonts","explorer shell:Fonts"},
                                    {"Users","explorer shell:UserProfiles"},
                                    {"Public","explorer shell:Public"},
                                    {"Public Documents","explorer shell:Common Documents"},
                                    {"Music","explorer shell:My Music"},
                                    {"Public Music","explorer shell:CommonMusic"},
                                    {"Pictures","explorer shell:My Pictures"},
                                    {"Public Pictures","explorer shell:CommonPictures"},
                                    {"Videos","explorer shell:My Video"},
                                    {"Public Videos","explorer shell:CommonVideo"},
                                    {"Downloads","explorer shell:Downloads"},
                                    {"Public Downloads","explorer shell:CommonDownloads"}
                                };
    JDialog f;
    JPopupMenu popup;
    JDialog fapp;
    JButton twitter,mail,txt2pdf,fb,sh,hiber;
    JButton bb[];
    JButton prev,next,theme,mycomp,apps;
    JPanel p,pp,ppp;
    DropTarget dt;
    static int ex=0;
    static int ex1=0;
    final int diff=77;
    static int inc=0;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    final String fname="Bin\\App\\Items\\DockItems.ravs";
    final String fnametemp="Bin\\App\\Items\\DockItemstemp.ravs";
    int n;
    final int maxno=9;
    static int header=0;
    static int entry=0;
    static int ch=0;
    LookAndFeel lf = UIManager.getLookAndFeel();
    String name[];
    static boolean ent=true;

    MyMain(int choice)
    {
        ch=choice;
        look();
        theme=new JButton("");
        theme.addActionListener(this);
        prev=new JButton("<");
        next=new JButton(">");
        next.addActionListener(this);
        prev.addActionListener(this);
        n=getNumberOfLines(fname);
        p=new JPanel();
        name=new String[n];
        f=new JDialog();
        dt = new DropTarget(f, this);
        f.setUndecorated(true);
       // f.setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\r.gif"));
        if(n>0)
        {
            load();
        }
        else
        {
            mycomp=new JButton("MyComp");
            mycomp.setToolTipText("My Computer");
            mycomp.addActionListener(this);
            mycomp.setActionCommand("explorer shell:MyComputerFolder");
            p.add(mycomp);
            prev.setEnabled(false);
            next.setEnabled(false);
            f.add(theme,BorderLayout.NORTH);
            f.add(new JPanel(),BorderLayout.SOUTH);
            f.add(prev,BorderLayout.WEST);
            f.add(next,BorderLayout.EAST);
            f.add(p,BorderLayout.CENTER);
            sh=new JButton("Shutdown");
                hiber=new JButton("Sleep");
                sh.addActionListener(this);
                hiber.addActionListener(this);
                ppp=new JPanel();
                ppp.setLayout(new GridLayout(0,3));
                apps=new JButton("v");
                apps.addActionListener(this);
                ppp.add(sh);
                ppp.add(apps);
                ppp.add(hiber);
                f.add(ppp,BorderLayout.SOUTH);
            f.pack();
        }
        if((n<maxno)&&(n>0))
        {
            f.setLocation(w/2-(n*35),1);
        }
        else
            if(n==0)
            {
                f.setLocation(((w/2)-145),1);
            }
        else
        {
            f.setLocation(w/2-(maxno*35),1);
        }
        f.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {System.exit(0);}});
        if(entry==0)
        {
            new FullTray();
        }
        entry=entry+1;
        f.setVisible(true);
        if(n>=maxno)
        {
            final JPopupMenu popup = new JPopupMenu();
            popup.add(new JMenuItem(new AbstractAction("Size") {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("In delete Size of frame Height "+f.getHeight()+" Width "+f.getWidth());
            }
        }));
         mycomp.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if(e.isMetaDown())
                {
                    System.out.println(e.getXOnScreen()+"  "+e.getYOnScreen());
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        final Point p=f.getLocationOnScreen();
        for(int i=0;i<n;i++)
        {
            bb[i].addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if(e.isMetaDown())
                {
                    System.out.println(e.getXOnScreen()+"  "+e.getYOnScreen());
                    System.out.println("Position of frame is X: "+p.x+" Y:"+p.y);
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        }
        }
        else
        {
            
        }

    }

    public void load()
    {
        String data;
                int a=0;
                GridLayout g=new GridLayout(1,n);
                g.setHgap(2);
                g.setVgap(100);
                p.setLayout(g);
                try
                {
                    BufferedReader b=new BufferedReader(new FileReader(fname));
                    data=b.readLine();
                    while(data!=null)
                    {
                        name[a]=data;
                        a++;
                        data=b.readLine();
                    }
                    b.close();
                }catch(Exception e){}
                bb=new JButton[n];
                if(n>maxno)
                {
                    for(int i=header;i<header+maxno;i++)
                    {
                    try {
                        sun.awt.shell.ShellFolder sf = sun.awt.shell.ShellFolder.getShellFolder(new File(name[i].trim()));
                        bb[i] = new JButton(new ImageIcon(sf.getIcon(true)));
                        bb[i].setActionCommand("rundll32" + " " + "url.dll,FileProtocolHandler" + " " +name[i]);
                        bb[i].addActionListener(this);
                        File ff=new File(name[i]);
                        if(ff.isDirectory()||(name[i].substring(name[i].lastIndexOf('\\') + 1).equalsIgnoreCase(""))||(name[i].substring(name[i].lastIndexOf('\\') + 1)==null))
                        {
                            bb[i].setToolTipText(name[i]);
                        }
                        else
                        {
                            bb[i].setToolTipText(name[i].substring(name[i].lastIndexOf('\\') + 1,name[i].lastIndexOf(".")));
                        }
                    } catch (FileNotFoundException ex) {
                        bb[i] = new JButton(new ImageIcon("Bin\\img\\r.gif"));
                        bb[i].setActionCommand("rundll32" + " " + "url.dll,FileProtocolHandler" + " " +name[i]);
                        bb[i].addActionListener(this);
                        File ff=new File(name[i]);
                        if(ff.isDirectory()||(name[i].substring(name[i].lastIndexOf('\\') + 1).equalsIgnoreCase(""))||(name[i].substring(name[i].lastIndexOf('\\') + 1)==null))
                        {
                            bb[i].setToolTipText(name[i]);
                        }
                        else
                        {
                            bb[i].setToolTipText(name[i].substring(name[i].lastIndexOf('\\') + 1,name[i].lastIndexOf(".")));
                        }
                    }
                
                    }
                    mycomp=new JButton("MyComp");
                    mycomp.setToolTipText("My Computer");
                    mycomp.addActionListener(this);
                    mycomp.setActionCommand("explorer shell:MyComputerFolder");
                    p.add(mycomp);
                    for(int i=header;i<header+maxno;i++)
                    {
                        p.add(bb[i]);
                    }
                    if(header==0)
                    {
                        prev.setEnabled(false);
                    }
                    else
                        if(header+maxno==n)
                        {
                            next.setEnabled(false);
                        }
                }
                else
                {
                    for(int i=header;i<n;i++)
                    {
                    try {
                        sun.awt.shell.ShellFolder sf = sun.awt.shell.ShellFolder.getShellFolder(new File(name[i].trim()));
                         bb[i] = new JButton(new ImageIcon(sf.getIcon(true)));
                        bb[i].setActionCommand("rundll32" + " " + "url.dll,FileProtocolHandler" + " " +name[i]);
                        bb[i].addActionListener(this);
                        File ff=new File(name[i]);
                        if(ff.isDirectory()||(name[i].substring(name[i].lastIndexOf('\\') + 1).equalsIgnoreCase(""))||(name[i].substring(name[i].lastIndexOf('\\') + 1)==null))
                        {
                            bb[i].setToolTipText(name[i]);
                        }
                        else
                        {
                            bb[i].setToolTipText(name[i].substring(name[i].lastIndexOf('\\') + 1,name[i].lastIndexOf(".")));
                        }
                    } catch (FileNotFoundException ex) {
                        bb[i] = new JButton(new ImageIcon("Bin\\img\\r.gif"));
                        bb[i].setActionCommand("rundll32" + " " + "url.dll,FileProtocolHandler" + " " +name[i]);
                        bb[i].addActionListener(this);
                        File ff=new File(name[i]);
                        if(ff.isDirectory()||(name[i].substring(name[i].lastIndexOf('\\') + 1).equalsIgnoreCase(""))||(name[i].substring(name[i].lastIndexOf('\\') + 1)==null))
                        {
                            bb[i].setToolTipText(name[i]);
                        }
                        else
                        {
                            bb[i].setToolTipText(name[i].substring(name[i].lastIndexOf('\\') + 1,name[i].lastIndexOf(".")));
                        }
                    }
                    
                    }
                    mycomp=new JButton("MyComp");
                    mycomp.setToolTipText("My Computer");
                    mycomp.addActionListener(this);
                    mycomp.setActionCommand("explorer shell:MyComputerFolder");
                    p.add(mycomp);
                    for(int i=header;i<n;i++)
                    {
                        p.add(bb[i]);
                    }
                    prev.setEnabled(false);
                    next.setEnabled(false);
                }
                pp=new JPanel();
                pp.setLayout(new GridLayout(1,3));
                pp.add(prev);
                pp.add(theme);
                pp.add(next);
                sh=new JButton("Shutdown");
                hiber=new JButton("Sleep");
                sh.addActionListener(this);
                hiber.addActionListener(this);
                ppp=new JPanel();
                ppp.setLayout(new GridLayout(0,3));
                apps=new JButton("v");
                apps.addActionListener(this);
                ppp.add(sh);
                ppp.add(apps);
                ppp.add(hiber);
                f.add(ppp,BorderLayout.SOUTH);
                f.add(pp,BorderLayout.NORTH);
                f.add(p,BorderLayout.CENTER);
                f.pack();
                
    }

     public void look()
    {
         switch(ch)
        {
            case 1:   try
               {
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (Exception e) {   }
            break;
            case 2:try
               {
                        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (Exception e) {   }
            break;
            case 3:try
               {
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception e) {   }
            break;

        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equalsIgnoreCase("<"))
        {
            inc=inc-1;
                header=header-1;
            f.setVisible(false);
                new MyMain(ch);
        }
        else
            if(e.getActionCommand().equalsIgnoreCase(">"))
            {
                inc=inc+1;
                    header=header+1;
                f.setVisible(false);
                new MyMain(ch);
            }
            else
                if(e.getActionCommand().equalsIgnoreCase("Theme"))
                {
                    if(ch==3)

                    {
                        ch=1;
                    }
                    else
                    {
                        ch=ch+1;
                    }
                    if(!ent)
                    {

                    fapp.setVisible(false);
                    }
                    f.setVisible(false);
                    new MyMain(ch);
                }
                else
                    if(e.getActionCommand().equals("v"))
                    {
                        ent=false;
                        apps.setText("^");
                        apps.setActionCommand("^");
                        new Apps();
                    }
                    else
                        if(e.getActionCommand().equalsIgnoreCase("^"))
                        {
                            ent=true;
                            fapp.setVisible(false);
                            apps.setText("v");
                            apps.setActionCommand("v");
                        }
                        else
        if(e.getActionCommand().equalsIgnoreCase("shutdown"))
        {
            try {
                    File f=new File("Bin\\App\\Items\\Predefined\\Rav.jar");
                    Process p = Runtime.getRuntime().exec("rundll32" + " " + "url.dll,FileProtocolHandler" + " " + f.getAbsolutePath());
                } catch (IOException ex) {  }
        }
        else
            if(e.getActionCommand().equalsIgnoreCase("Sleep"))
            {
                try {
                    File f=new File("Bin\\App\\Items\\Predefined\\Rav1.jar");
                    Process p = Runtime.getRuntime().exec("rundll32" + " " + "url.dll,FileProtocolHandler" + " " + f.getAbsolutePath());
                } catch (IOException ex) {  }
            }
                    else
            {
                new Open(e.getActionCommand());
            }
    }

    public void dragEnter(DropTargetDragEvent dtde) {
    }

    public void dragOver(DropTargetDragEvent dtde) {
    }

    public void dropActionChanged(DropTargetDragEvent dtde) {
    }

    public void dragExit(DropTargetEvent dte) {
    }

    public void drop(DropTargetDropEvent dtde)
  {
      try
      {
        Transferable tr = dtde.getTransferable();
        DataFlavor[] flavors = tr.getTransferDataFlavors();
        for (int i = 0; i < flavors.length; i++)
        {
            if (flavors[i].isFlavorJavaFileListType())
            {
               dtde.acceptDrop(DnDConstants.ACTION_COPY);
               java.util.List list = (java.util.List) tr.getTransferData(flavors[i]);
               if(list.size()<3)
               {
                new AddintoFiles(list.subList(0,1));
               }
               else
               {
                   new AddintoFiles(list.subList(0,2));
               }
               dtde.dropComplete(true);
               f.setVisible(false);
               new MyMain(ch);
            }
            else
            {
                f.setVisible(false);
                new MyMain(ch);
                JOptionPane.showMessageDialog(null,"Can not Find the file's Flavor","Error",JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
        dtde.rejectDrop();
        }
        catch (Exception e)
        {}
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

     class FullTray
{
  final SystemTray tray = SystemTray.getSystemTray();
  class ShowMessageListener implements ActionListener
  {

    TrayIcon trayIcon;
    String title;
    String message;
    TrayIcon.MessageType messageType;
    ShowMessageListener(
        TrayIcon trayIcon,
        String title,
        String message,
        TrayIcon.MessageType messageType) {
      this.trayIcon = trayIcon;
      this.title = title;
      this.message = message;
      this.messageType = messageType;
    }
    public void actionPerformed(ActionEvent e) {
      trayIcon.displayMessage(title, message, messageType);
    }
  }
  FullTray()
  {
    Runnable runner = new Runnable() {
      public void run() {
        if (SystemTray.isSupported()) {
        ImageIcon i=new ImageIcon("Bin\\img\\r.gif");
          Image image = i.getImage();
          PopupMenu popup = new PopupMenu();
          final TrayIcon trayIcon = new TrayIcon(image,"Rav's Dock", popup);
          MenuItem item= new MenuItem("Twitter");
	  item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
	      new Firsttwitter();
            }
	  });
          popup.add(item);
          item= new MenuItem("Mail");
	  item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
	      new FirstMail();
            }
	  });
          popup.add(item);
          item= new MenuItem("Facebook");
	  item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
	      new GUIFB();
            }
	  });
          popup.add(item);
          item= new MenuItem("txt 2 pdf");
	  item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
	      new TextFileToPDF();
            }
	  });
          popup.add(item);
          item= new MenuItem("Close");
	  item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
	      tray.remove(trayIcon);
              System.exit(0);
            }
	  });
          popup.add(item);
          try {
            tray.add(trayIcon);
          } catch (AWTException easd) {
            System.err.println("Can't add to tray");
          }
        } else {
          System.err.println("Tray unavailable");
        }
      }
    };
    EventQueue.invokeLater(runner);
  }
}

class Apps extends JFrame implements ActionListener
{
    JPanel p;
    GridLayout g=new GridLayout(0,4);
    Apps()
    {
        look();
        fapp=new JDialog();
        p=new JPanel();
        p.setLayout(g);
        g.setHgap(5);
        g.setVgap(5);
        twitter=new JButton("Twitter");
        twitter.addActionListener(this);
        mail=new JButton("Mail");
        mail.addActionListener(this);
        txt2pdf=new JButton(".txt to .pdf");
        txt2pdf.addActionListener(this);
        fb=new JButton("Facebook");
        fb.addActionListener(this);
        p.add(twitter);
        p.add(mail);
        p.add(txt2pdf);
        p.add(fb);
        fapp.setUndecorated(true);
        fapp.add(p,BorderLayout.CENTER);
        fapp.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {fapp.setVisible(false);
                            apps.setText("v");
                            apps.setActionCommand("v");}});
        if(ch==1)
        {
            fapp.setLocation((w/2)-130,90);
        }
        else
        {
            fapp.setLocation((w/2)-110,97);
        }
        fapp.pack();
        fapp.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equalsIgnoreCase("twitter"))
        {
            new Firsttwitter();
        }
        else
            if(e.getActionCommand().equalsIgnoreCase("mail"))
            {
                new FirstMail();
            }
            else
                if(e.getActionCommand().equalsIgnoreCase(".txt to .pdf"))
                {
                    new TextFileToPDF();
                }
                else
                    if(e.getActionCommand().equalsIgnoreCase("facebook"))
                    {
                        new GUIFB();
                    }
    }

}

public void del(String e)
{
    String item=e;
                                        String data=null;
                                       try
         {
            BufferedReader b=new BufferedReader(new FileReader(fname));
            BufferedWriter b1=new BufferedWriter(new FileWriter(fnametemp,true));
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
            File f11=new File(fname);
            f11.delete();
            try
            {
                BufferedReader b2=new BufferedReader(new FileReader(fnametemp));
                BufferedWriter b3=new BufferedWriter(new FileWriter(fname));
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
           File f12=new File(fnametemp);
           f12.delete();
                                        f.setVisible(false);
                                        new MyMain(ch);
}

}