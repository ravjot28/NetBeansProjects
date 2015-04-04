import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class JRoundButton extends JButton
{

  private Shape shape = null;
  private boolean pressed = false;

  public JRoundButton(String text, Icon icon)
  {
    super(text, icon);

    Dimension size = getPreferredSize();
    size.width = size.height = Math.max(size.width,size.height);
    setPreferredSize(size);
    setFocusPainted(icon == null);

    setContentAreaFilled(false);
  }

  protected void paintComponent(Graphics g)
  {
    Graphics2D g2 = (Graphics2D)g;
    g2.setColor(getBackground());

    pressed = getModel().isPressed();
    Arc2D.Double arc = new Arc2D.Double(0, 0, getSize().width-1, getSize().height-1, 0, 360, Arc2D.CHORD);
    g2.fill(arc);

    super.paintComponent(g);
  }

  protected void paintBorder(Graphics g)
  {
    Graphics2D g2 = (Graphics2D)g;

    g2.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
                         RenderingHints.VALUE_ANTIALIAS_ON );
    g2.setRenderingHint( RenderingHints.KEY_RENDERING,
                         RenderingHints.VALUE_RENDER_QUALITY );

    Color col1 = getBackground().darker();
    Color col2 = getBackground().brighter();

    Stroke s = new BasicStroke(3);
    g2.setStroke(s);

    Arc2D.Double arc = new Arc2D.Double(1, 1, getSize().width-3, getSize().height-3, 0, 360, Arc2D.CHORD);

    Point2D.Double pt1 = new Point2D.Double(0,0);
    Point2D.Double pt2 = new Point2D.Double(getSize().width-1, getSize().height-1);
    GradientPaint gp = null;

    if (pressed)
      gp = new GradientPaint(pt1, col1, pt2, col2, true);
    else
      gp = new GradientPaint(pt1, col2, pt2, col1, true);

    g2.setPaint(gp);
    g2.draw(arc);
  }

  public boolean contains(int x, int y)
  {
    if (shape == null || !shape.getBounds().equals(getBounds()))
    {
      shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
    }
    return shape.contains(x, y);
  }

  public static void main(String[] args)
  {
    JFrame frame = new JFrame();
    frame.getContentPane().setLayout(new FlowLayout());
    frame.getContentPane().add( new JRoundButton("cool", null) );
    frame.setSize(150, 150);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

} // class JRoundButton