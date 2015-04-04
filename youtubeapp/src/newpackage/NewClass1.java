package newpackage;

import com.google.gdata.util.ServiceException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class NewClass1 extends JFrame implements Runnable
{
    Thread thread = new Thread(this);
    String fname="";
    JFrame fplz;
    
    public static void main(String a[])
    {
        new NewClass1();
    }

    NewClass1()
    {
        JFrame f=new JFrame("Hi");
        JButton b=new JButton("File");
        f.add(b);
        b.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent ae)
                                {
                                    int retVal;
                                    JFileChooser fc = new JFileChooser();
                                    fc.addChoosableFileFilter(new TextFilter());
                                    fc.setMultiSelectionEnabled(true);
                                    retVal = fc.showOpenDialog(fc);
                                    if (retVal == JFileChooser.APPROVE_OPTION)
                                    {
                                        fname=fc.getSelectedFile().toString();
                                        System.out.println(fname);
                                        new plzwai();
                                        thread.start();
                                    }
                                }
                            });
         f.pack();
         f.setVisible(true);
    }

    class TextFilter extends FileFilter
    {

        public boolean accept(File f)
        {
            if (f.isDirectory())
            {
                return true;
            }
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if (i > 0 && i < s.length() - 1)
            {
                if (s.substring(i + 1).toLowerCase().equals("mp4"))
                {
                    return true;
                }
                else
                if (s.substring(i + 1).toLowerCase().equals("mov"))
                {
                    return true;
                }
                else
                if (s.substring(i + 1).toLowerCase().equals("flv"))
                {
                    return true;
                }
                else
                if (s.substring(i + 1).toLowerCase().equals("avi"))
                {
                    return true;
                }
                else
                if (s.substring(i + 1).toLowerCase().equals("mpg"))
                {
                    return true;
                }
                else
                if (s.substring(i + 1).toLowerCase().equals("mpeg"))
                {
                    return true;
                }
                else
                if (s.substring(i + 1).toLowerCase().equals("wmv"))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            return false;
        }

        public String getDescription()
        {
            return "Accepts only avi,flv,mp4,mov,wmv,mpg,mpeg files.";
        }
    }

    public void run()
    {
        String tags[]={"Funny","Best Comedy"};
        try {
            new NewClass("ravjot28", "docomo8888", "Virgin Ban add :)", tags, "Virgin Banned Ads IPL", fname,"private");
        }catch(Exception as){}
        fplz.setVisible(false);
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
        /*fplz=new JFrame("Information");
        lplz=new JLabel("Uploading Files Please Wait..... Do not close this application while uploading files as it can harm your computer speed");
        fplz.add(new JPanel(),BorderLayout.NORTH);
        fplz.add(new JPanel(),BorderLayout.SOUTH);
        fplz.add(new JPanel(),BorderLayout.EAST);
        fplz.add(new JPanel(),BorderLayout.WEST);
        fplz.add(lplz,BorderLayout.CENTER);
        fplz.addWindowListener(new WindowAdapter() {

                public void windowClosing(WindowEvent e) {       new plzwai();    }
            });
        fplz.pack();
        fplz.setLocationRelativeTo(null);
        fplz.setVisible(true);*/
         fplz = new JFrame("Connecting and Uploading Video [youtube.com]......");
   fplz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final JProgressBar aJProgressBar = new JProgressBar(JProgressBar.HORIZONTAL);
    //aJProgressBar.setStringPainted(true);
    aJProgressBar.setIndeterminate(true);
    //fplz.setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\airindia.jpg"));
    fplz.add(new JPanel(),BorderLayout.NORTH);
    fplz.add(new JPanel(),BorderLayout.WEST);
    fplz.add(new JPanel(),BorderLayout.EAST);
    fplz.add(new JPanel(),BorderLayout.SOUTH);
    fplz.add(aJProgressBar, BorderLayout.CENTER);
    fplz.setLocation(h/3,w/4);
    fplz.setSize(700, 100);
    fplz.setVisible(true);
    }
}
    
}
