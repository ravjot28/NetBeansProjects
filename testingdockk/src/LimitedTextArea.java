import javax.swing.*;
import javax.swing.text.*;
public class LimitedTextArea extends JFrame {
public LimitedTextArea() {
setDefaultCloseOperation(EXIT_ON_CLOSE);
JTextArea text = new JTextArea(5, 40);
// Set the customized Document on the text area. Only allow
// a maximum of ten characters:
text.setDocument(new LimitedDocument(10));
getContentPane().add(new JScrollPane( text ));
pack();
setLocationRelativeTo(null);
}
public static void main(String[] args) {
new LimitedTextArea().setVisible(true);
}
// Document that only allows a certain number of characters
class LimitedDocument extends PlainDocument {
private int maxLength;
public LimitedDocument(int maxLength) {
this.maxLength = maxLength;
}
// This method is overriden from the super class. It will be called when
// you are trying to insert text in your text component (by typing
// or pasting).
public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
int currentLength = getLength();
if( currentLength >= maxLength ) {
// There's not room for more characters. Return.
return;
}
if( currentLength + str.length() > maxLength ) {
// All of the characters we are trying to insert will not fit.
// We must trim the string.
str = str.substring(0, maxLength - currentLength);
}
// Insert the text:
super.insertString(offs, str, a);
}
}
}