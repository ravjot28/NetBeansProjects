import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.*;

public class Second extends JFrame implements ActionListener
{
    String in[]=new String[7];
    JFrame f;
    JButton accept,quit;
    TextArea t;
    JPanel p1,p2;
    public Second(String[] info)
    {
        String term=null;
        String data=null;
        in=info;
        p1=new JPanel();
        p2=new JPanel();
        accept=new JButton("Accept");
        quit=new JButton("Quit");
        
        f=new JFrame("Terms And Conditions");
        f.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e) {System.exit(0);}});
        f.setLocation(400,100);
        f.setLayout(new BorderLayout());
        try
        {
         BufferedReader b=new BufferedReader(new FileReader("Files/term.txt"));
         data=b.readLine();
         while(data!=null)
         {
             if(term==null)
             {
                 term="\u2665 "+data+"\n\n";
             }
             else
             {
                 term=term+"\u2665 "+data+"\n\n";
             }
             
             data=b.readLine();
         }
         b.close();
        }catch(Exception e){}
        t=new TextArea(term,100,60,TextArea.SCROLLBARS_VERTICAL_ONLY);
        t.setFont(new Font("sansserif", Font.BOLD,12));
        t.setEditable(false);
        p1.add(t);
        p2.add(accept);
        p2.add(quit);
        f.add(p1,BorderLayout.CENTER);
        f.add(p2,BorderLayout.SOUTH);
        accept.addActionListener(this);
        quit.addActionListener(this);
        f.setSize(500,500);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equalsIgnoreCase("accept"))
        {
            f.setVisible(false);
            new Main(in);
        }
        else
        {
            System.exit(0);
        }
    }

}
