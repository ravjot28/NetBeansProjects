package texthintjtextfield;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(new HintTextField("A hint here..."), BorderLayout.NORTH);
        frame.add(new HintTextField("Another hint here..."), BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
}

class HintTextField extends JTextField implements FocusListener {

    private final String hint;

    public HintTextField(final String hint)
    {
        super(hint);
        this.hint = hint;
        super.addFocusListener(this);
        super.setForeground(Color.GRAY);
        super.setFont(new Font("Times New Roman",1,15));
    }

    @Override
    public void focusGained(FocusEvent e)
    {
        if(this.getText().isEmpty()) {
            super.setText("");
        }
    }
    @Override
    public void focusLost(FocusEvent e)
    {
        if(this.getText().isEmpty()) {
            super.setText(hint);
        }
    }

    @Override
    public String getText()
    {
        String typed = super.getText();
        return typed.equals(hint) ? "" : typed;
    }
}