import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class AnimatingSheet extends JPanel {
          Dimension animatingSize = new Dimension (0, 1);
          JComponent source;
          BufferedImage offscreenImage;
          public AnimatingSheet ( ) {
              super( );
              setOpaque(true);
          }
          public void setSource (JComponent source) {
              this.source = source;
              animatingSize.width = source.getWidth( );
              makeOffscreenImage(source);
          }

          public void setAnimatingHeight (int height) {
              animatingSize.height = height;
              setSize (animatingSize);
          }
          private void makeOffscreenImage(JComponent source) {
              GraphicsEnvironment ge =
                  GraphicsEnvironment.getLocalGraphicsEnvironment( );
              GraphicsConfiguration gfxConfig =
                  ge.getDefaultScreenDevice( ).getDefaultConfiguration( );
              offscreenImage =
                  gfxConfig.createCompatibleImage(source.getWidth( ),
                                                  source.getHeight( ));
              Graphics2D offscreenGraphics =
                  (Graphics2D) offscreenImage.getGraphics( );
              // windows workaround
              offscreenGraphics.setColor (source.getBackground( ));
              offscreenGraphics.fillRect (0, 0,
                                          source.getWidth( ), source.getHeight( ));
              // paint from source to offscreen buffer
              source.paint (offscreenGraphics);
          }
          public Dimension getPreferredSize( ) { return animatingSize; }
          public Dimension getMinimumSize( ) { return animatingSize; }
          public Dimension getMaximumSize( ) { return animatingSize; }
          public void update (Graphics g) {
              // override to eliminate flicker from
              // unnecessary clear
              paint (g);
          }
          public void paint (Graphics g) {
               // get the top-most n pixels of source and
               // paint them into g, where n is height
               // (different from sheet example, which used bottom-most)
               BufferedImage fragment =
                   offscreenImage.getSubimage (0,
                                               0,                                                                   source.getWidth( ),
                                               animatingSize.height);
               g.drawImage (fragment, 0, 0, this);
          }
}
