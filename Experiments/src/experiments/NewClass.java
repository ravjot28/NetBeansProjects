package experiments;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;
class TextClock1 extends JFrame
{
    final int mm;
    int ss;
    private JTextField _timeField;
    public TextClock1()
    {
        Calendar now = Calendar.getInstance();
        mm = now.get(Calendar.MINUTE)+20;
        ss =60;
        _timeField = new JTextField(5);
        _timeField.setEditable(false);
        _timeField.setFont(new Font("sansserif", Font.PLAIN, 48));

        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(_timeField);

        this.setContentPane(content);
        this.setTitle("Text Clock 1");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        javax.swing.Timer t = new javax.swing.Timer(1000, new ClockListener());
        t.start();
    }
    class ClockListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
        {
            Calendar now = Calendar.getInstance();
            int m = now.get(Calendar.MINUTE);
            m=-m+mm;
            ss--;
            if(ss<0)
            {
                ss=60;
            }
            _timeField.setText(m + ":" + ss);
    	}
    }

    public static void main(String[] args)
    {
        JFrame clock = new TextClock1();
        clock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clock.setVisible(true);
    }
}