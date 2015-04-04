import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class GUI extends JFrame implements ActionListener
{
    JFrame f;
    String son;
    JButton b1,b2;
    String source;
    public static void main(String args[])
    {
        GUI g=new GUI();
    }

    GUI()
    {
        f=new JFrame("MP3 Player");
        f.setLayout(new BorderLayout());
        b1=new JButton("Add");
        b2=new JButton("Play");
        b2.addActionListener(this);
        b1.addActionListener(this);
        f.add(b2,BorderLayout.NORTH);
        f.add(b1,BorderLayout.SOUTH);
        f.pack();
        f.addWindowListener(
      new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
          System.exit(0);
          }
        }
      );
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
       
        if(e.getActionCommand().equalsIgnoreCase("play"))
        {
            acti();
        }
        else
        {

         DemoJFileChooser panel = new DemoJFileChooser();
         source=panel.go();
         if(source.equalsIgnoreCase("no"))
         {
             JOptionPane.showMessageDialog(null,"Select the desired folder","Alert",JOptionPane.INFORMATION_MESSAGE);
         }
         else
         {
             File directory = new File(source);
             File[] files = directory.listFiles(new Filter());
             for (int index = 0; index < files.length; index++)
             {
                //Print out the name of files in the directory
                 try
                 {
                    BufferedWriter pw=new BufferedWriter(new FileWriter("list.txt",true));
                    pw.append( files[index].toString());
                    pw.newLine();
                    pw.close();
                 }catch(Exception rr){}
             }
         }
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

    public void acti()
    {
           MP3 m=new MP3();
    }

    class Filter implements FileFilter
    {
        public boolean accept(File file)
        {
            return file.getName().endsWith("mp3");
        }
    }



}

 