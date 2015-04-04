import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;


class ProgressBar extends JProgressBar implements TableCellRenderer
{

  public ProgressBar(int min, int max)
  {
        super(min, max);
  }

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column)
  {
        setValue((int) ((Float) value).floatValue());
        return this;
  }
}
