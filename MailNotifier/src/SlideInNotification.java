
import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	import java.awt.image.*;

	public class SlideInNotification extends Object {

		protected static final int ANIMATION_TIME = 500;
		protected static final float ANIMATION_TIME_F =	(float) ANIMATION_TIME;
		protected static final int ANIMATION_DELAY = 10;

		JWindow window;
		JComponent contents;
		AnimatingSheet animatingSheet;
		Rectangle desktopBounds;
		Dimension tempWindowSize;
		Timer animationTimer;
		int showX, startY;
		long animationStart;

		public SlideInNotification ( ) {
			initDesktopBounds( );
		}

		public SlideInNotification (JComponent contents) {
			this( );
			setContents (contents);
		}

        protected void initDesktopBounds( ) {
            GraphicsEnvironment env =
                GraphicsEnvironment.getLocalGraphicsEnvironment( );
               desktopBounds = env.getMaximumWindowBounds( );
            System.out.println ("max window bounds = " + desktopBounds);
        }

        public void setContents (JComponent contents) {
            this.contents = contents;
            JWindow tempWindow = new JWindow( );
            tempWindow.getContentPane( ).add (contents);
            tempWindow.pack( );
            tempWindowSize = tempWindow.getSize( );
            tempWindow.getContentPane( ).removeAll( );
            window = new JWindow( );
             tempWindow.setAlwaysOnTop(true);
             window.setAlwaysOnTop(true);
            animatingSheet = new AnimatingSheet ( );
            animatingSheet.setSource (contents);
            window.getContentPane().add(animatingSheet);
        }

        public void showAt (int x) {
            // create a window with an animating sheet
            // copy over its contents from the temp window
            // animate it
            // when done, remove animating sheet and add real contents

            showX = x;
            startY = desktopBounds.y + desktopBounds.height;

            ActionListener animationLogic = new ActionListener( ) {
                    public void actionPerformed(ActionEvent e) {
                        long elapsed = System.currentTimeMillis( ) - animationStart;
                        if (elapsed > ANIMATION_TIME) {
                            // put real contents in window and show
                              window.getContentPane( ).removeAll( );
           window.getContentPane( ).add (contents);
          window.pack( ); window.setLocation (showX,
               startY - window.getSize( ).height);
                            window.setVisible(true);
window.repaint( );
animationTimer.stop( ); animationTimer = null;
                       } else
                       {
            // calculate % done
             float progress =(float) elapsed / ANIMATION_TIME_F;
              // get height to show 
             int animatingHeight =(int) (progress * tempWindowSize.getHeight( ));


      animatingHeight = Math.max (animatingHeight, 1);
      animatingSheet.setAnimatingHeight (animatingHeight);
                            window.pack( );
                            window.getContentPane().setBackground(Color.white);
                            window.setLocation (showX,startY - window.getHeight( ));
                            window.setVisible(true);
                            window.repaint( );
                        }
                    }
            };
     animationTimer =new Timer (ANIMATION_DELAY, animationLogic);
     animationStart = System.currentTimeMillis( );
     animationTimer.start( );
  }
        public void closing()
        {
            window.dispose();
        }

  // AnimatingSheet inner class listed below

}