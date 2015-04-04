/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dissolveframe;

import Support.Spin;
import Support.Dissolve;
import Support.SpinDissolver;
import Support.Dissolver;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main
{
    public static void main(String ae[])
    {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                final Dissolve nf = new Dissolve();
                nf.addWindowListener(new WindowAdapter()
                                {
                                    public void windowClosing(WindowEvent e)
                                    {
                                        new Dissolver().dissolveExit(nf);
                                    }
                                });
                nf.setVisible(true);
            }
        });
    }
}
