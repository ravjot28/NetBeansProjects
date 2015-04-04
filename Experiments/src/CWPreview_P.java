import java.applet.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.rtf.*;

import java.awt.*;
import java.awt.event.*;

import java.net.*;
import java.io.*;

import java.awt.font.*;
import java.net.URL;

public class CWPreview_P extends JApplet {

public void init() {
try {
javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
public void run() {
try {
JEditorPane editorPane = createEditorPane();

try {

 InputStream is = DemoFonts.class.getResourceAsStream("segoepr.ttf");
Font font = Font.createFont(Font.TRUETYPE_FONT, is);
float size = 20.0f;
font = font.deriveFont(size);
editorPane.setFont(font);
} catch (Exception e) { System.err.println("No font available"); }

getContentPane().add(editorPane, BorderLayout.CENTER);
} catch (Exception e) { System.err.println("Can't create viewer."); }
}
});
} catch (Exception e) { System.err.println("Unable to initialize class."); }
}

private JEditorPane createEditorPane() throws Exception {

JEditorPane editorPane = new JEditorPane();

editorPane.setContentType("text/rtf");

editorPane.setEditable(true);
System.out.println("Running Editor...");

return editorPane;

}
}