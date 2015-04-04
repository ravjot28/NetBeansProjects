package classdiferentiation;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class AddComponentOnJFrameAtRuntime extends JFrame implements ActionListener
{
JPanel panel;
static int i=0;
public AddComponentOnJFrameAtRuntime()
{
 super("Add component on JFrame at runtime");
 setLayout(new BorderLayout());
 panel=new JPanel();
 panel.setLayout(new GridLayout(i,1));
 add(panel,BorderLayout.CENTER);
 JButton button=new JButton("CLICK HERE");
 add(button,BorderLayout.SOUTH);
 button.addActionListener(this);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 pack();
 setVisible(true);
}

public void actionPerformed(ActionEvent evt)
{
 panel.add(new JButton("Button"));
 i++;
 panel.revalidate();
 validate();
}

public static void main(String[]args)
{
 AddComponentOnJFrameAtRuntime acojfar=new AddComponentOnJFrameAtRuntime();
}
}

