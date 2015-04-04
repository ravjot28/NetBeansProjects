import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GUItwitter extends JFrame implements ActionListener
{
    JFrame f;
    JButton reset,publish,edit;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    JTextArea t;
    JScrollPane scrollPane = new JScrollPane(t);
    String uname,ps;
    GUItwitter(String u,String p1)
    {
        uname=u;
        ps=p1;
        edit=new JButton("Edit Account Settings");
        edit.addActionListener(this);
        f=new JFrame("Twitter");
        t=new JTextArea(3,50);
        t.setLineWrap(true);
        t.setWrapStyleWord(true);
        t.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                String text = t.getText();
                int length = text.length();
                if (length == 140) 
                {
                    e.consume();
                } else if (length > 140) {
                    t.setText(text.substring(0, 140));
                    JOptionPane.showMessageDialog(null,"Twitter allows only 140 characters cant exceed","Error",JOptionPane.ERROR_MESSAGE);
                    
                }
            }
        });
        scrollPane.validate();
        reset=new JButton("Reset");
        publish=new JButton("Publish");
        reset.addActionListener(this);
        publish.addActionListener(this);
        f.setLocation(h/2, w/4);
        //f.setLayout(new GridLayout(2,1));
        f.setIconImage(new javax.swing.ImageIcon("R.gif").getImage());
        JPanel p=new JPanel();
        p.add(t);
        p.add(publish);
        p.add(edit);
        p.add(reset);
        //f.add(t);
        f.add(p,BorderLayout.CENTER);
        f.addWindowListener(new WindowAdapter()
        {      public void windowClosing(WindowEvent e) {        f.setVisible(false);      }    });

        f.pack();
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equalsIgnoreCase("reset"))
        {
            t.setText("");
        }
        else
            if(e.getActionCommand().equalsIgnoreCase("Edit Account Settings"))
            {
                f.setVisible(false);
                new Firsttwitter(0);
            }
        else
        {
            String status=t.getText();
            if((status.equalsIgnoreCase(""))||(status.equalsIgnoreCase(null)))
            {
                JOptionPane.showMessageDialog(null,"Please enter the status first !!","Error",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                if(status.length()>140)
                {
                    JOptionPane.showMessageDialog(null,"Twitter has 140 character limit sorry !!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
            try {
                new Twitter().send(uname,ps, status);
            } catch (Exception ex) {  }

                }
            }
        }
    }

}
