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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javazoom.jl.decoder.JavaLayerException;

public class GUI extends JFrame implements Observer
{
    private JButton add,exit,play,next,n,pr,pa,re,st,ree;
    private MP3 selectedDownload;
    JFrame f;
    int status=-1;
     JFrame f12;
    Thread t;
    JScrollPane pane;
    JPanel pre;
    JTable table;
    String na;

    public GUI(String name)
    {
        na=name;
         LookAndFeel lf = UIManager.getLookAndFeel();
         selectedDownload=new MP3(na);
               try
               {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                   //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                   //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception e) {
                    }
        f=new JFrame("Rav's Mp3 Player");

        // Handle window closing events.
        f.addWindowListener(new WindowAdapter() {      public void windowClosing(WindowEvent e) {        actionExit();      }    });
        // Set up add panel.
        JPanel addPanel = new JPanel();
        add = new JButton("Add");
       add.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        actionadd();      }    });
        add.setEnabled(true);
        addPanel.add(add);
        play = new JButton("Play");
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
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JavaLayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
      }    });
        play.setEnabled(true);
        addPanel.add(play);
       
        st = new JButton("Stop");
       st.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        try{selectedDownload.stopp();}catch(Exception ad){}      }    });
        st.setEnabled(true);
        addPanel.add(st);
        re = new JButton("Resume");
       re.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        try{selectedDownload.resume();}catch(Exception ad){}      }    });
        re.setEnabled(true);
        addPanel.add(re);
        n = new JButton("Next");
       n.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        try{selectedDownload.next();}catch(Exception ad){}      }    });
        n.setEnabled(true);
        addPanel.add(n);
        pr = new JButton("Previous");
       pr.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        try{selectedDownload.prev();}catch(Exception ad){}      }    });
        pr.setEnabled(true);
        addPanel.add(pr);
        exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        actionExit();      }    });
        exit.setEnabled(true);
        addPanel.add(exit);
        next = new JButton("To Tray");
        next.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        f.setVisible(false); new FullTray();      }    });
        next.setEnabled(true);
        addPanel.add(next);
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
        new Add(na);
        updateButtons();
    }


    /* Update each button's state based off of the currently selected download's status. */
    private void updateButtons()
    {
           exit.setEnabled(true);
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
  FullTray() {
    Runnable runner = new Runnable() {
      public void run() {
        if (SystemTray.isSupported()) {
          final SystemTray tray = SystemTray.getSystemTray();
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
                data[i-1][1]=data1.substring(data1.lastIndexOf("\\")+1,data1.lastIndexOf("."));
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
f12.setUndecorated(true);
f12.setVisible(true);
}





}
