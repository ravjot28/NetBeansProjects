package sheetframes;

import javax.swing.*;
	import javax.swing.border.*;
	import java.awt.*;
	import java.awt.event.*;

	public class SheetableJFrame extends JFrame {

	JComponent sheet;
	JPanel glass;

	public SheetableJFrame (String name) {
		super(name);
		glass = (JPanel) getGlassPane( );
	}
	public JComponent showJDialogAsSheet (JDialog dialog) {
		sheet = (JComponent) dialog.getContentPane( );
		sheet.setBackground (Color.red);
		glass.setLayout (new GridBagLayout( ));
		sheet.setBorder (new LineBorder(Color.black, 1));
		glass.removeAll( );
		GridBagConstraints gbc = new GridBagConstraints( );
		gbc.anchor = GridBagConstraints.NORTH;
		glass.add (sheet, gbc);
		gbc.gridy=1;
		gbc.weighty = Integer.MAX_VALUE;
		glass.add (Box.createGlue( ), gbc);
		glass.setVisible(true);
		return sheet;
	}
	public void hideSheet( ) {
		glass.setVisible(false);
	}
  }