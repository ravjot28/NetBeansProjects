package slidingjframeasmenu;
import org.jdesktop.swingx.*;
import javax.swing.*;
import java.awt.*;
public class TaskPaneExample1 {

public static void main(String[] args)
{
  SwingUtilities.invokeLater(new Runnable()
  {
    public void run() {
      new TaskPaneExample1();
    }
  });
}

public TaskPaneExample1()
{
  JFrame frame = new JFrame("TaskPane Example 1");
  frame.add(doInit());
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setLocationRelativeTo(null);
  frame.pack();
  frame.setVisible(true);
}

private Component doInit()
{
  JXPanel panel = new JXPanel();
  panel.setLayout(new BorderLayout());

  final JXLabel label = new JXLabel();
  label.setFont(new Font("Segoe UI", Font.BOLD, 14));
  label.setText("task pane item 1 : a label");
  label.setIcon(new ImageIcon("gmail.png"));
  label.setHorizontalAlignment(JXLabel.LEFT);

  final JXLabel label1 = new JXLabel();
  label.setFont(new Font("Segoe UI", Font.BOLD, 14));
  label.setText("task pane item 2 : a label");
  label.setIcon(new ImageIcon("gmail.png"));
  label.setHorizontalAlignment(JXLabel.LEFT);

  JXTaskPaneContainer taskpanecontainer = new JXTaskPaneContainer();

  // create a taskpane, and set it's title and icon
  JXTaskPane taskpane = new JXTaskPane();
  taskpane.setTitle("My Tasks");
  taskpane.setIcon(new ImageIcon("gmail.png"));

  taskpane.add(new JButton("Press Me"));

  taskpanecontainer.add(taskpane);

  panel.add(taskpanecontainer, BorderLayout.CENTER);

  return panel;
}
}
