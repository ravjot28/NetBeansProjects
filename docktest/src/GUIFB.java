import com.google.code.facebookapi.FacebookException;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.event.*;
import javax.print.attribute.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
public class GUIFB extends JFrame implements ActionListener
{
    JFrame f;
    JTextArea t;
    JButton publish;
    JScrollPane scrollPane=new JScrollPane(t);
    public GUIFB()
    {
        f=new JFrame("Facebook");
        publish=new JButton("Publish");
        t=new JTextArea(5,84);
        t.setLineWrap(true);
        t.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                String text = t.getText();
                int length = text.length();
                if (length == 420)
                {
                    e.consume();
                } else if (length > 420) {
                    t.setText(text.substring(0, 420));
                    JOptionPane.showMessageDialog(null,"Facebook allows only 420 characters cant exceed","Error",JOptionPane.ERROR_MESSAGE);

                }
            }
        });
        scrollPane.validate();
        JPanel p=new JPanel();
        p.add(t);
        p.add(publish);
        f.setLayout(new BorderLayout());
        publish.addActionListener(this);
        f.add(p,BorderLayout.CENTER);
        //f.add(t,BorderLayout.NORTH);
       // f.add(publish,BorderLayout.SOUTH);
        f.pack();
        f.addWindowListener(new WindowAdapter() {      public void windowClosing(WindowEvent e) {        f.setVisible(false);     }    });
    f.setLocationRelativeTo(null);
    
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("publish"))
        {
                String message=t.getText();
                if((message.equalsIgnoreCase(""))||(message.equalsIgnoreCase(null)))
                {
                    JOptionPane.showMessageDialog(null,"Oops enter the status first :P","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    System.out.println(message);
                    try {
                            new SendtoFacebook().rav(message);
                        } catch (FacebookException ex) {    }
                }
            }
        }

    }


