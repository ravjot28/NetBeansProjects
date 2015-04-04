

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class SheetableJFrame extends JFrame
{
    JComponent sheet;
    JPanel glass;

    public SheetableJFrame(String title)
    {
        super(title);
        glass = (JPanel) getGlassPane();
    }

    public JComponent showJDialogAsSheet(JDialog dialog)
    {
        sheet = (JComponent) dialog.getContentPane();
        sheet.setBackground(Color.red);
        glass.setLayout(new GridBagLayout());
        sheet.setBorder(new LineBorder(Color.black,1));
        glass.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        glass.add(sheet,gbc);
        gbc.gridy = 1;
        gbc.weighty = Integer.MAX_VALUE;
        glass.add(Box.createGlue(),gbc);
        glass.setVisible(true);
        return sheet;
    }

    public void hideSheet()
    {
        glass.setVisible(false);
    }
}
