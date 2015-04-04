import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;



public class TransparentBackground3 extends JComponent implements ComponentListener, WindowFocusListener, Runnable
{

	// constants ---------------------------------------------------------------
	// instance ----------------------------------------------------------------
	private JFrame _frame;
	private BufferedImage _background;
	private long _lastUpdate = 0;
	private boolean _refreshRequested = true;
	private Robot _robot;
	private Rectangle _screenRect;
	private ConvolveOp _blurOp;

	// constructor -------------------------------------------------------------

	public TransparentBackground3(JFrame frame) {
		_frame = frame;
		try {
			_robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
			return;
		}

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		_screenRect = new Rectangle(dim.width, dim.height);

		float[] my_kernel = {
				0.10f, 0.10f, 0.10f,
				0.10f, 0.20f, 0.10f,
				0.10f, 0.10f, 0.10f};
		_blurOp = new ConvolveOp(new Kernel(3, 3, my_kernel));
		updateBackground();
		_frame.addComponentListener(this);
		_frame.addWindowFocusListener(this);
		new Thread(this).start();
	}

	// protected ---------------------------------------------------------------

	protected void updateBackground() {
		_background = _robot.createScreenCapture(_screenRect);
	}



	protected void refresh() {
		if (_frame.isVisible() && this.isVisible()) {
			repaint();
			_refreshRequested = true;
			_lastUpdate = System.currentTimeMillis();
		}
	}


	// JComponent --------------------------------------------------------------

	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Point pos = this.getLocationOnScreen();
		BufferedImage buf = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		buf.getGraphics().drawImage(_background, -pos.x, -pos.y, null);

		Image img = _blurOp.filter(buf, null);
		g2.drawImage(img, 0, 0, null);
		g2.setColor(new Color(255, 255, 255, 180));
		g2.fillRect(0, 0, getWidth(), getHeight());
	}

	// ComponentListener -------------------------------------------------------
	public void componentHidden(ComponentEvent e) {
	}

	public void componentMoved(ComponentEvent e) {
		repaint();
	}

	public void componentResized(ComponentEvent e) {
		repaint();

	}

	public void componentShown(ComponentEvent e) {
		repaint();
	}

	// WindowFocusListener -----------------------------------------------------
	public void windowGainedFocus(WindowEvent e) {
		refresh();
	}

	public void windowLostFocus(WindowEvent e) {
		refresh();
	}

	// Runnable ----------------------------------------------------------------
	public void run() {
		try {
			while (true) {
				Thread.sleep(10);
				long now = System.currentTimeMillis();
				if (_refreshRequested && ((now - _lastUpdate) > 10)) {
					if (_frame.isVisible()) {
						Point location = _frame.getLocation();
						_frame.setLocation(-_frame.getWidth(), -_frame.getHeight());
						updateBackground();
						_frame.setLocation(location);
						refresh();
					}
					_lastUpdate = now;
					_refreshRequested = false;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Transparent Window");
		TransparentBackground3 bg = new TransparentBackground3(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(bg);
		frame.pack();
		frame.setSize(200, 200);
		frame.setLocation(500, 500);
		frame.setVisible(true);
	}
}