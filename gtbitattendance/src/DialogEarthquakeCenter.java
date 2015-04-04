import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class DialogEarthquakeCenter extends Object {

            public static final int SHAKE_DISTANCE = 10;
            public static final double SHAKE_CYCLE = 100;
            public static final int SHAKE_DURATION = 800;
            public static final int SHAKE_UPDATE = 5;

            private JFrame dialog;
            private Point naturalLocation;
            private long startTime;
            private Timer shakeTimer;
            private final double HALF_PI = Math.PI / 2.0;
            private final double TWO_PI = Math.PI * 2.0;

            public DialogEarthquakeCenter (JFrame d) {
                dialog = d;
            }

            public void startShake( ) {
                naturalLocation = dialog.getLocation( );
                startTime = System.currentTimeMillis( );
                shakeTimer =
                   new Timer(SHAKE_UPDATE,
                             new ActionListener( ) {

                              public void actionPerformed (ActionEvent e) {
                                  // calculate elapsed time
                                  long elapsed = System.currentTimeMillis()-startTime;
                                  // use sin to calculate an x-offset
                                  double waveOffset = (elapsed % SHAKE_CYCLE) /
                                      SHAKE_CYCLE;
                                  double angle = waveOffset * TWO_PI;

                                  // offset the x-location by an amount
                                  // proportional to the sine, up to
                                  // shake_distance
                                  int shakenX = (int) ((Math.sin (angle) *
                                                        SHAKE_DISTANCE) +
                                                       naturalLocation.x);
                                  dialog.setLocation (shakenX, naturalLocation.y);
                                  dialog.repaint( );

                                  // should we stop timer?
                                  if (elapsed >= SHAKE_DURATION)                                                  stopShake( );
                              }
                         }
                         );
            shakeTimer.start( );
        }

        public void stopShake( ) {
            shakeTimer.stop( );
            dialog.setLocation (naturalLocation);
            dialog.repaint( );
        }

      /*  public static void main (String[] args) {
            JOptionPane pane =
                new JOptionPane ("You've totally screwed up your login\n" +
                                 "Go back and do it again… and do you think\n" +
"you could remember your password this time?",
JOptionPane.ERROR_MESSAGE, JOptionPane.OK_OPTION);
            JDialog d = pane.createDialog (null, "Shakin'!");

DialogEarthquakeCenter dec = new DialogEarthquakeCenter (d);
            d.pack();
            d.setModal (false);
            d.setVisible(true);
            dec.startShake( );

            // wait (forever) for a non-null click and then quit
            /*while (pane.getValue( ) == JOptionPane.UNINITIALIZED_VALUE ) {
               try { Thread.sleep(100); }
               catch (InterruptedException ie) {}

		*/	  // }
               //System.exit(0);
            //}*/

}
