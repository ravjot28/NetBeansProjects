/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package splotlight;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.image.*;
import java.awt.geom.*;

import javax.swing.*;

import java.util.*;

public class SpotlightPanel extends JComponent implements MouseListener
{
    protected boolean blur;
    protected List spotlights;
    protected ConvolveOp blurOp;
    protected RenderingHints hints;

    public SpotlightPanel()
    {
        this(true);
    }

    public SpotlightPanel(boolean blur)
    {
        this.blur = blur;
        spotlights = new ArrayList();
        blurOp = new ConvolveOp(getBlurKernel(3), ConvolveOp.EDGE_NO_OP, null);
        hints = new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        hints.put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
    }

    public Spotlight addSpotlight(int x, int y, int radius)
    {
        return addSpotlight(x, y, radius, radius);
    }

    public Spotlight addSpotlight(int x, int y, int w, int h)
    {
        if (spotlights.size() == 0)
        {
            setVisible(true);
            addMouseListener(this);
        }

        Spotlight spot = new Spotlight(x, y, w, h);
        spotlights.add(spot);
        return spot;
    }

    public void removeSpotlight(Spotlight spot)
    {
        if (spot != null)
        {
            spotlights.remove(spot);
            if (spotlights.size() == 0)
            {
                setVisible(false);
                removeMouseListener(this);
            }
        }
    }

    public void clearSpotlights()
    {
        spotlights.clear();
        setVisible(false);
        removeMouseListener(this);
    }

    protected Kernel getBlurKernel(int blurSize)
    {
        if (blurSize <= 0)
            return null;

        int size = blurSize * blurSize;
        float coeff = 0.90f / size;
        float[] kernelData = new float[size];

        for (int i = 0; i < size; i ++)
            kernelData[i] = coeff;

        return new Kernel(blurSize, blurSize, kernelData);
    }

    protected void paintSpotlights(Graphics g)
    {
        if (spotlights.size() > 0)
        {
            int width = getWidth();
            int height = getHeight();

            double screenArea = width * height;
            double spotsArea = 0.0;

            Rectangle2D screen = new Rectangle2D.Double(0, 0, width, height);
            Area mask = new Area(screen);

            for (int i = 0; i < spotlights.size(); i++)
            {
                Spotlight spot = (Spotlight) spotlights.get(i);
                spotsArea += spot.getArea();
                mask.subtract(new Area(spot.getSpot()));
            }

            Graphics2D g2 = (Graphics2D) g;
            Color shieldColor = new Color(0.0f, 0.0f, 0.0f, 1.0f - (float) (spotsArea / screenArea));

            if (blur)
            {
                BufferedImage buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2buffer = (Graphics2D) buffer.createGraphics();

                g2buffer.setRenderingHints(hints);
                g2buffer.setColor(shieldColor);
                g2buffer.fill(mask);

                g2.drawImage(buffer, blurOp, 0, 0);
            } else {
                g2.setRenderingHints(hints);
                g2.setColor(shieldColor);
                g2.fill(mask);
            }
        }
    }

    public void paintComponent(Graphics g)
    {
        paintSpotlights(g);
    }

    public void mouseClicked(MouseEvent e)
    {
        clearSpotlights();
    }

    public void mousePressed(MouseEvent e)
    {
    }

    public void mouseReleased(MouseEvent e)
    {
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
    }
}