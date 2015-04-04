package movemouse;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class AutoMouseHack
{
    public JButton info,new_dir,delete,showme;

    public void createDemo()
    {
        JFrame f=new JFrame("File Flipper");
        String[] dirs={".","..","build","docs","lib","src","www"};
        String[] files={"build.xml","readme.txt"};
        JList dir_list=new JList(dirs);
        JList files_list=new JList(files);
        JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,dir_list,files_list);
        info=new JButton("Info");
        new_dir=new JButton("New Dir");
        delete=new JButton("Delete");
        JPanel toolbar=new JPanel();
        toolbar.setLayout(new FlowLayout());
        toolbar.add(info);
        toolbar.add(new_dir);
        toolbar.add(delete);
        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add("North",toolbar);
        f.getContentPane().add("Center",split);
        f.pack();
        f.show();
    }

    public void createHelp() throws IOException
    {
        JFrame f=new JFrame("Help");
        JButton close=new JButton("Close");
        showme=new JButton("SHow Me");
        showme.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent a)
            {
                  try
                    {
                        moveMouse(showme,info,2000);
                        moveMouse(info,info,1000);
                        moveMouse(info,new_dir,1000);
                        moveMouse(new_dir,new_dir,1000);
                        moveMouse(new_dir,delete,1000);
                        moveMouse(delete,delete,1000);
                        moveMouse(delete,showme,1000);
                    }catch(Exception a2){}
           }
        })
                ;
        JEditorPane html=new JEditorPane("text/html",
                                            "<html><body>"+
                                              "<p>afdadsfadfadfadfadfadsfdaf dfadsf asf adsfadf</p>"+
                                              "<p><b>afd</b>adsfadfadfadfadfadsfdaf dfadsf asf adsfadf</p>"+
                                              "<p>afdadsfadfadfadfadfadsfdaf dfadsf asf adsfadf</p>"+
                                              "<p><b>afdadsfa</b>dfadfadfadfadsfdaf dfadsf asf adsfadf</p>"+
                                              "<p>afdadsfadfadfadfadfadsfdaf dfadsf asf adsfadf</p>");
        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add("North",close);
        f.getContentPane().add("Center",html);
        f.getContentPane().add("South",showme);
        f.pack();
        f.setLocation(400,50);
        f.setVisible(true);
    }

    public void moveMouse(JComponent start,JComponent end,final int duration) throws Exception
    {
        final Robot robot=new Robot();
        final Point start_coords=start.getLocationOnScreen();
        start_coords.translate(start.getWidth()/2,start.getHeight()/2);
        final Point end_coords=end.getLocationOnScreen();
        end_coords.translate(end.getWidth()/2,end.getHeight()/2);
        int steps=duration/50;
        int distx=(end_coords.x-start_coords.x);
        int disty=(end_coords.y-start_coords.y);

        for(int i=1;i<=steps;i++)
        {
            int x=start_coords.x+i*distx/steps;
            int y=start_coords.y+i*disty/steps;
            robot.mouseMove(x, y);
            try
            {
                Thread.currentThread().sleep(50);
            }catch(Exception s){}
        }
    }

    public static void main(String a[]) throws IOException
    {
        AutoMouseHack hack=new AutoMouseHack();
        hack.createDemo();
        hack.createHelp();
    }
}
