import java.awt.LayoutManager;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class JTransparentPanel extends JPanel
{
public JTransparentPanel()
{
this(new FlowLayout());
}

public JTransparentPanel(LayoutManager lm)
{
super(lm);
setOpaque(false);
}
}