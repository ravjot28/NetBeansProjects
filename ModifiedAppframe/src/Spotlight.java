import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

public class Spotlight
{
    protected Ellipse2D.Double spot;
    protected Rectangle2D.Double bounds;

    public Spotlight(int x, int y, int w, int h)
    {
        this.spot = new Ellipse2D.Double(x, y, w, h);
    }

    public Ellipse2D getSpot()
    {
        return spot;
    }

    public double getArea()
    {
        return Math.PI * spot.getWidth() * spot.getHeight() / 4.0;
    }
}