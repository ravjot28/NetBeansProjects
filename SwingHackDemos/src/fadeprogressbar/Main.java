package fadeprogressbar;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


public class Main
{
    private InfiniteProgressPanel glassPane;
    JButton b;

    public static void main(String e[])
    {
        new Main();
    }

    Main()
    {
        JFrame f=new JFrame("Hello");
        this.glassPane = new InfiniteProgressPanel();
        f.setGlassPane(glassPane);
        b=new JButton("CLick me");
        f.setLayout(new GridLayout(3,1));
        f.add(new JLabel("Ravjot"));
        f.add(new JLabel("Singh"));
        f.add(b);
        b.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent e)
                                {
                                    //p();
                                    SwingUtilities.invokeLater(new Runnable()
                                    {
                                        public void run()
                                        {
                                            b.setEnabled(false);
                                            glassPane.start();
                                        }
                                    });
                                }
                            });
        f.pack();
        f.setVisible(true);
    }

    

     private void perform() {
       
        //displaySuccess("You've successfully waited :)");

        glassPane.stop();
        b.setEnabled(true);
    }


}
