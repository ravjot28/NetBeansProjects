import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class Main implements ActionListener
{
    String p[]=new String[new Gettable().getperino()];
    String data[]=new String[5];
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    static int count=0;
    JDialog f;
    public static void main(String asda[])
    {
        new Main();
    }

    Main()
    {
        data=new Gettable().getdata();
        String day=new GetDayName().name();
        if(day.equalsIgnoreCase("monday"))
        {
            count=0;
        }
        else
        if(day.equalsIgnoreCase("tuesday"))
        {
            count=1;
        }
        else
        if(day.equalsIgnoreCase("wednesday"))
        {
            count=2;
        }
        else
        if(day.equalsIgnoreCase("thursday"))
        {
            count=3;
        }
        else
        if(day.equalsIgnoreCase("friday"))
        {
            count=4;
        }
        launch();
    }

    public void launch()
    {
        p=new Gettable().getper(data[count]);
        LookAndFeel lf = UIManager.getLookAndFeel();
               try
               {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                   //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                   //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception e) {
                    }
        JLabel l[]=new JLabel[p.length];
        JRoundButton r=new JRoundButton(null,new ImageIcon("right.png"));
        JRoundButton le=new JRoundButton(null,new ImageIcon("left.png"));
        r.setActionCommand("right");
        le.setActionCommand("left");
        r.addActionListener(this);
        le.addActionListener(this);
        f=new JDialog();
        f.setTitle("Time Table For "+new GetDayName().name());
        JPanel p1=new JPanel();
        p1.setLayout(new GridLayout(p.length,0));
        for(int i=0;i<p.length;i++)
        {
            l[i]=new JLabel(""+p[i]);
            l[i].setFont(new Font("Perpetua Titling MT", 1, 18));
            l[i].setForeground(new Color(000, 000, 000));
        }
        for(int i=0;i<p.length;i++)
        {
            p1.add(l[i]);
        }
        JPanel pr=new JPanel();
        pr.add(le);
        pr.add(r);
        f.add(new JPanel(),BorderLayout.NORTH);
        f.add(pr,BorderLayout.SOUTH);
        f.add(new JPanel(),BorderLayout.WEST);
        f.add(new JPanel(),BorderLayout.EAST);
        f.add(p1,BorderLayout.CENTER);
        f.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e) {System.exit(0);}});
        f.setLocation(h/2, w/8);
        f.pack();
        f.setIconImage(Toolkit.getDefaultToolkit().getImage("r.gif"));
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equalsIgnoreCase("right"))
        {
            if(count==4)
            {
                count=4;
            }
 else
            {
                count++;
 }
            f.setVisible(false);
            launch();
        }
 else
        {
             if(count==0)
            {
                count=0;
            }
 else
            {
                count--;
 }
             f.setVisible(false);
            launch();

 }
    }
}


