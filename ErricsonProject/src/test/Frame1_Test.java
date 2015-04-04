package test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Frame1_Test extends JFrame {

    JButton jButton1;
    JLabel jLabel1;
    Glass glassPane;
    Frame2_Test f2;

    private void create() {

        jLabel1 = new JLabel();
        jButton1 = new JButton();
        f2 = new Frame2_Test();
        f2.create();

        glassPane = new Glass();

        setGlassPane(glassPane);
        setTitle("Frame 1");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Frame 1");
        getContentPane().add(jLabel1, BorderLayout.PAGE_START);

        jButton1.setText("Submit");
        getContentPane().add(jButton1, BorderLayout.PAGE_END);

        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            glassPane.start();
                                            f2.setVisible(true);
                                        }
                                    });

        pack();
    }

    public void done(){
        glassPane.stop();
    }
    
    public static void main(String args[]) {
        Frame1_Test f = new Frame1_Test();
        f.create();
        f.setVisible(true);
    }

    class Frame2_Test extends JFrame {

        JButton jButton1;
        JLabel jLabel1;

        private void create() {

            jLabel1 = new JLabel();
            jButton1 = new JButton();

            setTitle("Frame 2");
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            this.addWindowFocusListener(new WindowAdapter()
                                        {
                                             public void windowClosing(WindowEvent e) {
                                                    done();
                                            }
                                        });

            jLabel1.setText("Frame 2");
            getContentPane().add(jLabel1, BorderLayout.PAGE_START);

            jButton1.setText("Submit");
            getContentPane().add(jButton1, BorderLayout.PAGE_END);
            jButton1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae){ done(); dispose();}
            });

            pack();
        }
    }

}
