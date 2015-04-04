package searchtextcomponents;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NewClass
{
    public static void main(String e[])
    {
        JTextArea text_area = new JTextArea(10,20);
        JScrollPane scroll = new JScrollPane(text_area);
        IncrementalSearch isearch = new IncrementalSearch(text_area);

        final JTextField search_field = new JTextField();
        search_field.getDocument().addDocumentListener(isearch);
        search_field.addActionListener(isearch);

        JFrame f = new JFrame("Hi");
        f.getContentPane().add("North",search_field);
        f.getContentPane().add("Center",scroll);
        scroll.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_F1)
                {
                    search_field.requestFocus(true);
                }
            }

            public void keyPressed(KeyEvent e) {
                search_field.requestFocus(true);
            }

            public void keyReleased(KeyEvent e) 
            {
                search_field.requestFocus(true);
            }
        });
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
