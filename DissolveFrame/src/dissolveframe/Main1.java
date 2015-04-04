/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dissolveframe;

import Support.Spin;
import Support.SpinDissolver;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Rav
 */
public class Main1 {

    public static void main(String arp[])
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                final Spin nf = new Spin();
                nf.addWindowListener(new WindowAdapter()
                                {
                                    public void windowClosing(WindowEvent e)
                                    {
                                        new SpinDissolver().dissolveExit(nf);
                                    }
                                });
                nf.setVisible(true);
            }
        });
    }

}
