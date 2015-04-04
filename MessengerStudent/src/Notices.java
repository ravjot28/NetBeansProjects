import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Notices implements ActionListener
{
    JButton b[];
    JFrame frame;

    private InfiniteProgressPanel glassPane;

    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    
    Notices()
    {
        frame = new JFrame("Surveys");

        File f = new File("Notices\\");
        String l[] = f.list();

        String list="";

        for(int i=0;i<l.length;i++)
        {
            if((!new File("Notices\\"+l[i]).isHidden())&&(!new File("Notices\\"+l[i]).isDirectory()))
            {
                try
                {
                    BufferedReader bu = new BufferedReader(new FileReader("Notices\\"+l[i]));
                    if(bu.readLine().trim().equals("Notice"))
                    {
                        list+="Notices\\"+l[i]+",";
                    }
                    bu.close();
                }catch(Exception s){}
            }
        }

        StringTokenizer token = new StringTokenizer(list,",");

        b = new JButton[token.countTokens()];

        frame.setLayout(new GridLayout(token.countTokens(),0));

        int count=0;

        while(token.hasMoreTokens())
        {
            b[count]=new JButton("Notice "+(count+1));
            b[count].setActionCommand(token.nextToken());
            b[count].addActionListener(this);
            frame.add(b[count]);
            count++;
        }

        //this.glassPane = new InfiniteProgressPanel();
        //frame.setGlassPane(glassPane);

        frame.setName("GTBIT Messenger");
        frame.setIconImage(new ImageIcon("img\\r.gif").getImage());
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setTitle("GTBIT Messenger");
        frame.pack();
        frame.setLocation(h/2,w/6);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String fr = null,d = null,mm = null;
        try
        {
            BufferedReader b = new BufferedReader(new FileReader(ae.getActionCommand().trim()));
            String temp=b.readLine();
            String from = b.readLine();
            String date = b.readLine();
            temp=b.readLine();
            String mess="";
            String m="";
            while(mess!=null)
            {
                m+=mess+" ";
                mess=b.readLine();
            }
            b.close();
            fr=from;
            d=date;
            mm=m;
        }catch(Exception asd){}
        frame.dispose();
        new ViewData(fr.replaceAll("From-->","").trim() ,mm,d.replaceAll("Date-->","").trim());
    }

}
