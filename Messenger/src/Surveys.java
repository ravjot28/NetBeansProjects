import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Surveys implements ActionListener,Runnable
{
    JButton b[];
    String name;
    Thread th = new Thread(this);
    String fname;
    private InfiniteProgressPanel glassPane;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    Surveys()
    {
        String fname = "Bin/Data/UserInfo/userinfo.ravs";
        JFrame frame = new JFrame("Surveys");
        try
        {
           BufferedReader b= new BufferedReader(new FileReader(fname));
           name=b.readLine().trim();
           b.close();
        }catch(Exception asd){}
        File f = new File("Bin/Data/Surveys/");
        String l[] = f.list();
        b = new JButton[l.length];
        
        frame.setLayout(new GridLayout(l.length,0));

        for(int i=0;i<l.length;i++)
        {
            if(!new File("Bin/Data/Surveys/"+l[i]).isHidden())
            {
                String temp=l[i].replaceAll(".ravs","").trim();
                temp=temp.replaceAll(name,"");
                String yr=temp.substring(0,4);
                String mn=temp.substring(4,6);
                String dt=temp.substring(6,8);
                String nm = dt+"/"+mn+"/"+yr;
                b[i]=new JButton("Survey on "+nm);
                b[i].setActionCommand(l[i].trim());
                b[i].addActionListener(this);
                frame.add(b[i]);
            }
        }
        this.glassPane = new InfiniteProgressPanel();
        frame.setGlassPane(glassPane);
        frame.setName("GTBIT Messenger");
        frame.setIconImage(new ImageIcon("img/r.gif").getImage());
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setTitle("GTBIT Messenger");
        frame.pack();
        frame.setLocation(h/2,w/6);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String file = ae.getActionCommand();
        System.out.println("Bin/Data/Surveys/"+file);
        fname=file.replaceAll(".ravs","");
        th.start();
    }

    public void run()
    {
        glassPane.start();
        new InboxReader(fname);
        glassPane.stop();
        new Surveys();
    }
}
