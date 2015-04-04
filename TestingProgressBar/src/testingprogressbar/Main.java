package testingprogressbar;

import javax.swing.JFrame;
//Below is our customized Progress Bar, you have to import this API in your project
import RavCustomizedProgressBar.InfiniteProgressPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Main
{
    static InfiniteProgressPanel ipp;
    
    public static void main(String[] args)
    {
        JFrame f = new JFrame("Hi");
        //Creating Object of InfiniteProgressPanel class
        ipp = new InfiniteProgressPanel("Please Wait...");
        //Adding the InfiniteProgressPanel as Glass Pane of our JFrame
        f.setGlassPane(ipp);
        JButton b1 = new JButton("Start Progress Bar");
        b1.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent ae)
                                {
                                    //The below method starts the progress Bar
                                    ipp.start();
                                    //To stop the Progress Bar call ipp.stop();
                                }
                            });
        
        f.setLayout(new FlowLayout());
        f.add(b1);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

}
