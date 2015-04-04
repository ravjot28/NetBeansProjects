import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TextAreaTest extends JFrame {

    private int maxChars;

    public TextAreaTest(int maxChars) {
        super("Text Area Test");
        this.maxChars = maxChars;

        installTextArea();

        Dimension screenSize = getToolkit().getScreenSize();
        setSize(screenSize.width / 2, screenSize.height / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void installTextArea() {
        final JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                String text = textArea.getText();
                int length = text.length();
                if (length == maxChars) {
                    e.consume();
                } else if (length > maxChars) {
                    textArea.setText(text.substring(0, maxChars));
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(12, 12, 12, 12),
            scrollPane.getBorder()));
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
      /*  if (args.length != 1) {
            System.err.println("Usage: java TextAreaTest <max chars>");
            System.exit(1);
        }*/
        new TextAreaTest(140);
    }
}