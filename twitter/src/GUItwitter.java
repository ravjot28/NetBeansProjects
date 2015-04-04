import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GUItwitter extends JFrame implements ActionListener,Runnable
{
    JFrame f,fplz;
    Thread thread=new Thread(this);
    JButton reset,publish,edit;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    JTextField t;
    String uname,ps;
    String status="";
    GUItwitter(String u,String p1)
    {
         LookAndFeel lf = UIManager.getLookAndFeel();
               try
               {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception e) {
                    }
        uname=u;
        ps=p1;
        edit=new JButton("Edit Account Settings");
        edit.addActionListener(this);
        f=new JFrame("Twitter");
        t=new JTextField(20);
        reset=new JButton("Reset");
        publish=new JButton("Publish");
        reset.addActionListener(this);
        publish.addActionListener(this);
        f.setLocation(h/2, w/4);
        //f.setLayout(new GridLayout(2,1));
        f.setIconImage(new javax.swing.ImageIcon("R.gif").getImage());
        JPanel p=new JPanel();
        p.add(t);
        p.add(publish);
        p.add(edit);
        p.add(reset);
        //f.add(t);
        f.add(p,BorderLayout.CENTER);
        f.addWindowListener(new WindowAdapter()
        {      public void windowClosing(WindowEvent e) {        System.exit(0);      }    });

        f.pack();
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equalsIgnoreCase("reset"))
        {
            t.setText("");
        }
        else
            if(e.getActionCommand().equalsIgnoreCase("Edit Account Settings"))
            {
               thread.start();
            }
        else
        {
            status=t.getText();
            if((status.equalsIgnoreCase(""))||(status.equalsIgnoreCase(null)))
            {
                JOptionPane.showMessageDialog(null,"Please enter the status first !!","Error",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                if(status.length()>140)
                {
                    JOptionPane.showMessageDialog(null,"Twitter has 140 character limit sorry !!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    new plzwai();
                    thread.start();
                }
            }
        }
    }

    public void run() 
    {
         try {
                new Twitter().send(uname,ps, status);
            } catch (Exception ex) {  }
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
         fplz = new JFrame("Connecting Twitter Please Wait....");
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
    fplz.setLocation(h/3,w/4);
    fplz.setSize(700, 100);
    fplz.setVisible(true);
    }
}


}
