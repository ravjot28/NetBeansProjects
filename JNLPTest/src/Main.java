
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Main
{
    public static void main(String arp[])
    {
        Main m = new Main();
        m.process();
    }

    public void process()
    {
        JFrame f = new JFrame("Hello World JNLP :)");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new FlowLayout());
        JButton b[] = new JButton[5];
        for(int i=0;i<5;i++)
        {
            b[i] = new JButton("Button " + (i + 1));
            b[i].setActionCommand(""+(i+1));
            b[i].addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            JOptionPane.showMessageDialog(null,"You pressed Button "+ae.getActionCommand(), null, JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    });
            f.add(b[i]);
        }

        f.pack();
        f.setVisible(true);

    }
}
