package customizedtextfields;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class StringField extends JTextField
{
    public StringField()
    {
        super();
    }

    public StringField(int cols)
    {
        super(cols);
    }

    public String getString()
    {       
        final String text = getText();

        if (text == null || text.length() == 0)
        {
            return "";
        }

        return text;
    }

    public void setString(String value)
    {
        setText(value);
    }

    protected Document createDefaultModel()
    {
        return new StringDocument();
    }

    static class StringDocument extends PlainDocument
    {
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException
        {
            if (str != null)
            {
                try
                {
                    if(containsNumbers(str))
                    {
                        throw new NumberFormatException();
                    }
                    else
                    {
                        super.insertString(offs, str, a);
                    }
                }
                catch (NumberFormatException ex)
                {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }

        public boolean containsNumbers(String str)
        {
            if (str == null || str.length() == 0)
                return true;

            for (int i = 0; i < str.length(); i++)
            {
                if (!Character.isLetter(str.charAt(i)))
                    return true;
            }
        return false;
        }

    }
}