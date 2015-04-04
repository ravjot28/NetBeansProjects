/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DissolveFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DissolveHack {

		public static void main(String[] args) {

			final JFrame frame = new JFrame("Dissolve Hack");
			JButton quit = new JButton("Quit");
			quit.addActionListener(new ActionListener( ) {
				public void actionPerformed(ActionEvent evt) {
				new Dissolver( ).dissolveExit(frame);
				}
			});

			frame.getContentPane( ).add(quit);
			frame.pack( );
			frame.setLocation(300,300);
			frame.setSize(400,400);
			frame.setVisible(true);
		}
	}