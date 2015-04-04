package CustomToolTip;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ToolTipsHack
{
    public static void main(String[] args)
    {
	JButton button;
	JFrame frame = new JFrame("Tool Tips Hack");
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
	BoxLayout layout = new BoxLayout(frame.getContentPane( ),BoxLayout.Y_AXIS);
	frame.getContentPane( ).setLayout(layout);
	button = new CustomJButton( );
	button.setText("Open");
	button.setToolTipText("Open an existing file");
	frame.getContentPane( ).add(button);
	button = new CustomJButton( );
	button.setText("Save");
	button.setToolTipText("Save the currently open file");
	frame.getContentPane( ).add(button);
	frame.getContentPane( ).add(new JLabel("a label"));
	frame.getContentPane( ).add(new JLabel("a label"));
	frame.getContentPane( ).add(new JLabel("a label"));
	frame.pack( );
	frame.show( );
    }
}
