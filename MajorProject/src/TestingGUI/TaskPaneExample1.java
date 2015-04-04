package TestingGUI;

import org.jdesktop.swingx.*;
import javax.swing.*;
import java.awt.*;


public class TaskPaneExample1
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
                                    {
                                        public void run()
                                        {
                                            new TaskPaneExample1();
                                        }
                                    }
                                 );
    }

    public TaskPaneExample1()
    {
        JFrame frame = new JFrame("TaskPane Example 1");
        frame.setLayout(new FlowLayout());
        frame.add(doInit("Monday"));
        frame.add(doInit("Tuesday"));
        frame.add(doInit("Wednesday"));
        frame.add(doInit("Thursday"));
        frame.add(doInit("Friday"));
        frame.add(doInit("Saturday"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    private Component doInit(String day)
    {
        JXPanel panel = new JXPanel();
        panel.setLayout(new BorderLayout());

        /*

        final JXLabel label1 = new JXLabel();
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setText("task pane item 2 : a label");
        label.setIcon(new ImageIcon("gmail.png"));
        label.setHorizontalAlignment(JXLabel.LEFT);*/

        JXTaskPaneContainer taskpanecontainer = new JXTaskPaneContainer();

        // create a taskpane, and set it's title and icon
        JXTaskPane taskpane = new JXTaskPane();
        taskpane.setTitle(day);
        taskpane.setIcon(new ImageIcon("gmail.png"));

        taskpane.add(getTimeTable(0)); //taskpane.add(new JButton("Press Me"));

        taskpanecontainer.add(taskpane);

        panel.add(taskpanecontainer, BorderLayout.CENTER);

        return panel;
    }

    public JPanel getTimeTable(int day)
    {
        final JXLabel label1 = new JXLabel();
        label1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label1.setText("Physics");
        label1.setHorizontalAlignment(JXLabel.CENTER);

        final JXLabel label2 = new JXLabel();
        label2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label2.setText("Physics");
        label2.setHorizontalAlignment(JXLabel.CENTER);

        final JXLabel label3 = new JXLabel();
        label3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label3.setText("Physics");
        label3.setHorizontalAlignment(JXLabel.CENTER);

        final JXLabel label4 = new JXLabel();
        label4.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label4.setText("Physics");
        label4.setHorizontalAlignment(JXLabel.CENTER);

        final JXLabel label5 = new JXLabel();
        label5.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label5.setText("Physics");
        label5.setHorizontalAlignment(JXLabel.CENTER);

        final JXLabel label6 = new JXLabel();
        label6.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label6.setText("Physics");
        label6.setHorizontalAlignment(JXLabel.CENTER);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(6,0));
        p.add(label1);
        p.add(label2);
        p.add(label3);
        p.add(label4);
        p.add(label5);
        p.add(label6);
        return p;
    }
}
