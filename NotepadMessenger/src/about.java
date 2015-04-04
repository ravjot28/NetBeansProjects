import java.awt.*;
import javax.swing.*;
import java.net.*;

public class about
{
	static JFrame window=new JFrame("About Notepad");
	notepad samp;
	JButton btn;

	URL url = getClass().getClassLoader().getResource("img/author.png");

	public about(notepad ref)
	{
		samp=ref;
		Container c=window.getContentPane();
		c.setLayout(new FlowLayout());
		
		String about="<html>"+"<body>"+"Notepad Messenger<br>"+"New concept of Notepad<br>"+"<br><br><br>"+""+"Developed By Gizmo Team<br>"+"Version:2.0<br>"+"</body>"+"</html>";
		
		ImageIcon icon=new ImageIcon(url);
		JLabel l=new JLabel("",icon,SwingConstants.LEFT);
		l.setText(about);
		l.setVerticalTextPosition(SwingConstants.TOP);
		l.setIconTextGap(20);
		c.add(l);

		int w=340;
		int h=250;
		window.setSize(w,h);
		Point center=GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		window.setLocation(center.x-w/2,center.y-h/2+25);
		window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		window.setVisible(false);
	}
} 