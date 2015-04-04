import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Bubbles extends JPanel implements ActionListener {


    private static Color colors[] = {
      Color.blue, Color.cyan, Color.green,
      Color.magenta, Color.orange, Color.pink,
      Color.red, Color.yellow, Color.lightGray, Color.white
    };


    private Ellipse2D.Float[] ellipses;
    private double esize[];
    private float estroke[];
    private double maxSize = 0;
    private boolean initialize = true;

    Timer timer;
    ActionListener updateProBar;


    public Bubbles() {

        setBackground(Color.black);
        ellipses = new Ellipse2D.Float[25];
        esize = new double[ellipses.length];
        estroke = new float[ellipses.length];

        for (int i = 0; i < ellipses.length; i++) {
            ellipses[i] = new Ellipse2D.Float();
            getRandomXY(i, 20 * Math.random(), 200, 200);
        }

        timer = new Timer(20, this);
        timer.setInitialDelay(190);
        timer.start();
    }


    public void getRandomXY(int i, double size, int w, int h) {

        esize[i] = size;
        estroke[i] = 1.0f;
        double x = Math.random() * (w - (maxSize / 2));
        double y = Math.random() * (h - (maxSize / 2));
        ellipses[i].setFrame(x, y, size, size);
    }


    public void reset(int w, int h) {

        maxSize = w / 10;
        for (int i = 0; i < ellipses.length; i++) {
            getRandomXY(i, maxSize * Math.random(), w, h);
        }
    }


    public void step(int w, int h) {

        for (int i = 0; i < ellipses.length; i++) {

            estroke[i] += 0.025f;
            esize[i]++;

            if (esize[i] > maxSize) {
                getRandomXY(i, 1, w, h);

            } else {
                ellipses[i].setFrame(ellipses[i].getX(), ellipses[i].getY(),
                                     esize[i], esize[i]);
            }
        }
    }


    public void render(int w, int h, Graphics2D g2) {

        for (int i = 0; i < ellipses.length; i++) {
            g2.setColor(colors[i % colors.length]);
            g2.setStroke(new BasicStroke(estroke[i]));
            g2.draw(ellipses[i]);
        }
    }


    public void paint(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        RenderingHints rh =
            new RenderingHints(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
               RenderingHints.VALUE_RENDER_QUALITY);

        g2.setRenderingHints(rh);
        Dimension size = getSize();

        if (initialize) {
            reset(size.width, size.height);
            initialize = false;
        }

        this.step(size.width, size.height);

        render(size.width, size.height, g2);

    }


    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Bubbles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Bubbles());
        frame.setSize(350, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}