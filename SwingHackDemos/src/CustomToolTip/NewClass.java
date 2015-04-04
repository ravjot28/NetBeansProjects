/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CustomToolTip;

import javax.swing.JButton;
import javax.swing.JToolTip;

class CustomJButton1 extends JButton {
		JToolTip _tooltip;

		public CustomJButton1() {
			_tooltip = new CustomToolTip("");
			_tooltip.setComponent(this);
		}

		public JToolTip createToolTip() {
			return _tooltip;
		}
	}