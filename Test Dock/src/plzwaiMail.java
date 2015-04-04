
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class plzwai extends JFrame implements Runnable
{
    Thread t=new Thread(this);
    private JFrame fplz;
    private JLabel lplz;

    plzwai()
    {
        t.start();
    }

    public void run()
    {
        fplz=new JFrame("Information");
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
        fplz.setVisible(true);
    }
}