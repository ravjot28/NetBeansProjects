import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.*;
import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class GUI extends JFrame implements Observer
{
    private JButton add,play,next,prev,playlist,resume,stop,home,tray1;
    private MP3 selectedDownload;
    JFrame f;
    int status=-1;
     JFrame f12;
    Thread t;
    JScrollPane pane;
    JPanel pre;
    JTable table;
    String na;
    TrayIcon trayIcon;
    JFrame fplz;
    final SystemTray tray = SystemTray.getSystemTray();

     public void look()
    {
         try
         {
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
             //UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
              //UIManager.setLookAndFeel("com.easynth.lookandfeel.EaSynthLookAndFeel");
             //UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
             /*System.setProperty("Quaqua.tabLayoutPolicy","wrap");
             UIManager.setLookAndFeel(
                  ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel()
              );*/
         }catch(Exception e){}
    }

    public GUI(String name)
    {
        look();

        na=name;
        System.out.println(na);
         selectedDownload=new MP3(na);
        f=new JFrame("Rav's Mp3 Player");

        // Handle window closing events.
        f.addWindowListener(new WindowAdapter() {      public void windowClosing(WindowEvent e) {        actionExit();      }    });
        f.setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\Icons\\r.gif"));
        // Set up add panel.
        JPanel addPanel = new JPanel();
        add = new JButton("",new ImageIcon("Bin\\Icons\\add.gif"));
       add.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        actionadd();    }    });
        add.setEnabled(true);
        addPanel.add(add);
        add.setToolTipText("Add Songs");
        playlist = new JButton("",new ImageIcon("Bin\\Icons\\playlist.gif"));
       playlist.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {     playlist.setEnabled(false);   tablee();      }    });
        playlist.setEnabled(true);
        addPanel.add(playlist);
        playlist.setEnabled(false);
        playlist.setToolTipText("Playlist");
         stop = new JButton("",new ImageIcon("Bin\\Icons\\stop.gif"));
       stop.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        try{selectedDownload.stopp();}catch(Exception ad){}      }    });
        stop.setEnabled(true);
        addPanel.add(stop);
        stop.setToolTipText("Stop");
         prev = new JButton("",new ImageIcon("Bin\\Icons\\prev.gif"));
       prev.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        try{selectedDownload.prev();}catch(Exception ad){}      }    });
        prev.setEnabled(true);
        addPanel.add(prev);
        prev.setToolTipText("Previous");
        play = new JButton("",new ImageIcon("Bin\\Icons\\play.gif"));
        play.setToolTipText("Play");
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(getNumberOfLines(na)==0)
                {   JOptionPane.showMessageDialog(null,"Please Add Songs in your play list","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
            //f.setVisible(false);
            //new FullTray();
            play.setEnabled(false);
            try {
            tablee();
            selectedDownload.download();
                } catch (Exception ex) {
                   try{selectedDownload.next();}catch(Exception ad){}
                }
                }
      }    });
        play.setEnabled(true);
        addPanel.add(play);
        next = new JButton("",new ImageIcon("Bin\\Icons\\next.gif"));
       next.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        try{selectedDownload.next();}catch(Exception ad){}      }    });
        next.setEnabled(true);
        addPanel.add(next);
       next.setToolTipText("Next");
        resume = new JButton("",new ImageIcon("Bin\\Icons\\resume.gif"));
       resume.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        try{selectedDownload.resume();}catch(Exception ad){}      }    });
        resume.setEnabled(true);
        addPanel.add(resume);
        resume.setToolTipText("Resume");
         home = new JButton("",new ImageIcon("Bin\\Icons\\home.gif"));
       home.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        try{f.setVisible(false); f12.setVisible(false); selectedDownload.c();   }catch(Exception asd){}finally{
	      tray.remove(trayIcon); new Opening();}    }    });
        home.setEnabled(true);
        addPanel.add(home);
        home.setToolTipText("Home");
        tray1 = new JButton("",new ImageIcon("Bin\\Icons\\tray.gif"));
        tray1.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        f.setVisible(false); new FullTray();      }    });
        tray1.setEnabled(true);
        addPanel.add(tray1);
        tray1.setToolTipText("Minimize To Tray");
        f.addWindowListener(
      new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
          System.exit(0);
          }
        }
      );
       f.add(addPanel);
        f.pack();
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        
  }

    // Exit this program.
    private void actionExit()
    {
        System.exit(0);
    }

    
    private void actionadd()
    {
        new Add1(na);
        updateButtons();
    }


    /* Update each button's state based off of the currently selected download's status. */
    private void updateButtons()
    {
            add.setEnabled(true);
            
    }

  /* Update is called when a Download notifies its observers of any changes. */
  public void update(Observable o, Object arg)
  {
    // Update buttons if the selected download has changed.
    if (selectedDownload != null && selectedDownload.equals(o))
      updateButtons();
  }

 
  class FullTray {
  class ShowMessageListener implements ActionListener {

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
          Image image = Toolkit.getDefaultToolkit().getImage("mp3.gif");
          PopupMenu popup = new PopupMenu();
          final TrayIcon trayIcon = new TrayIcon(image,"Rav's Mp3 Player", popup);

          MenuItem item = new MenuItem("Open");
	  item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
	      f.setVisible(true);
            }
	  });
          popup.add(item);
           item = new MenuItem("Add");
	  item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
	      actionadd();
            }
	  });
           popup.add(item);
           item = new MenuItem("Next");
	  item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
	      try{selectedDownload.next();}catch(Exception ad){}
            }
	  });
           popup.add(item);
           item = new MenuItem("Previous");
	  item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
	      try{selectedDownload.prev();}catch(Exception ad){}
            }
	  });
          popup.add(item);
          item = new MenuItem("Stop");
	  item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
	      try{selectedDownload.stopp();}catch(Exception ad){}
            }
	  });
          popup.add(item);
           popup.add(item);
          item = new MenuItem("Resume");
	  item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
	      try{selectedDownload.resume();}catch(Exception ad){}
            }
	  });

          popup.add(item);
          item = new MenuItem("Home Screen");
	  item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
	      try{f.setVisible(false); f12.setVisible(false); selectedDownload.c();   }catch(Exception asd){}finally{
	      tray.remove(trayIcon); new Opening();}
            }
	  });
          popup.add(item);
          item = new MenuItem("Close");
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

public void tablee()
{
    f12=new JFrame("Tabel");
    f12.setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\Icons\\playlistu.gif"));
        pre=new JPanel();
        String[] columnNames = {"Number","Song"};
        Object[][] data =new Object[getNumberOfLines(na)][2];
        int i=1;
        String data1=null;
        try
        {
            BufferedReader b=new BufferedReader(new FileReader(na));
            data1=b.readLine();
            while(data1!=null)
            {
                data[i-1][0]=new Integer(i);
                data[i-1][1]=data1.substring(data1.lastIndexOf("\\")+1,data1.lastIndexOf("."));//.substring(data1.lastIndexOf("\\")+1,data1.lastIndexOf("."));
                data1=b.readLine();
                i++;
            }
        }catch(Exception e){}

        table = new JTable(data, columnNames){
      public boolean isCellEditable(int rowIndex, int colIndex) {
        return false;   //Disallow the editing of any cell
      }
    };
    TableColumn column = null;
for (int i1 = 0; i1 < 2; i1++) {
    column = table.getColumnModel().getColumn(i1);
    if (i1 == 1) {
        column.setPreferredWidth(300); //third column is bigger
    } else {
        column.setPreferredWidth(50);
    }
}
    pane = new JScrollPane(table);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
   table.addMouseListener(new MouseAdapter(){
     public void mouseClicked(MouseEvent e){
      if (e.getClickCount() == 2)
      {
          int[] selRows;
          Object value;
         selRows = table.getSelectedRows();
         if (selRows.length > 0) {
          TableModel tm = table.getModel();
          value = tm.getValueAt(selRows[0],0);
          try{selectedDownload.table(selRows[0]);}catch(Exception ee){System.out.print(ee);}

         }
      }
      }
     } );
pre.setLayout(new BorderLayout());
pre.add(table.getTableHeader(),BorderLayout.PAGE_START);
pre.add(pane, BorderLayout.CENTER);
f12.add(pre);
f12.setLocationByPlatform(true);
f12.setSize(385,350);
f12.addWindowListener(new WindowAdapter()
{      public void windowClosing(WindowEvent e)
       {        playlist.setEnabled(true);
       }
});
//f12.setUndecorated(true);
f12.setVisible(true);
}

}
