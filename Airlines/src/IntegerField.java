import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
public class IntegerField extends JTextField
{
  public IntegerField()
  {
    super();
  }
  public IntegerField(int cols)
  {
    super(cols);
  }
  public int getInt()
  {
    final String text = getText();
    if (text == null || text.length() == 0)
    {
      return 0;
    }
    return Integer.parseInt(text);
  }
  public void setInt(int value)
  {
    setText(String.valueOf(value));
  }
  protected Document createDefaultModel()
  {
    return new IntegerDocument();
  }
  static class IntegerDocument extends PlainDocument
  {
    public void insertString(int offs, String str, AttributeSet a)
      throws BadLocationException
    {
      if (str != null)
      {
        try
        {
          Integer.decode(str);
          super.insertString(offs, str, a);
        }
        catch (NumberFormatException ex)
        {
          Toolkit.getDefaultToolkit().beep();
        }
      }
    }
  }
}


    