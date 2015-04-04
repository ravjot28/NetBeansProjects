package CustomToolTip;

import javax.swing.JButton;
import javax.swing.JToolTip;

public class CustomJButton extends JButton {
		JToolTip _tooltip;

		public CustomJButton( ) {
			_tooltip = new CustomToolTip("");
			_tooltip.setComponent(this);
		}

		public JToolTip createToolTip( ) {
			return _tooltip;
		}
	}