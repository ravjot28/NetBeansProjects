package guitest;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public final class TestJRadioButton
    {
    private static final Color LABEL_FOREGROUND = new Color( 0x0000b0 );
    public static void main( String args[] )
        {
        SwingUtilities.invokeLater( new Runnable()
        {
        public void run()
            {
            final JFrame jFrame = new JFrame();
            final Container contentPane = jFrame.getContentPane();
            final ButtonGroup flowers = new ButtonGroup();

            final JRadioButton daffodil =new JRadioButton( "daffodil", true );
            final JRadioButton impatiens =new JRadioButton( "impatiens", false );
            final JRadioButton sunflower =new JRadioButton( "sunflower", false );
            flowers.add( daffodil );
            flowers.add( impatiens );
            flowers.add( sunflower );
            contentPane.add( daffodil, BorderLayout.WEST );
            contentPane.add( impatiens, BorderLayout.CENTER );
            contentPane.add( sunflower, BorderLayout.EAST );
            jFrame.setSize( 400, 100 );
            jFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            jFrame.validate();
            jFrame.setVisible( true );
            }
        } );
        }
    }