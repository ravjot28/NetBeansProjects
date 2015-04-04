package experiments;
 import java.awt.*;
   import javax.swing.*;
   import java.awt.event.*;
   import javax.swing.JFrame;

    public class keydemoRun
      {
       public static void main( String args[] ) throws AWTException
         {
         Dimension screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
         JFrame PassFrame = new JFrame();
         PassFrame.setUndecorated(true);
         PassFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
         PassFrame.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
         PassFrame.setSize( (int)screen.getWidth(), (int)screen.getHeight() );
         PassFrame.addKeyListener(new WindowLstnr());
         PassFrame.addWindowFocusListener(new WindowLstnr());
         PassFrame.addWindowStateListener(new WindowLstnr());
         PassFrame.setVisible( true );
         }



       static class WindowLstnr implements
         WindowFocusListener,WindowStateListener,KeyListener{
          public void windowGainedFocus(WindowEvent e){
            }

          public void windowLostFocus(WindowEvent e){
            }

          public void windowStateChanged(WindowEvent e){
            }

          public void keyPressed( KeyEvent event )
            {
                if(event.isAltDown())
            {
                System.exit(0);
            }
            }

          public void keyReleased( KeyEvent event )
            {
            }

          public void keyTyped( KeyEvent event )
            {
            }


         }


      }