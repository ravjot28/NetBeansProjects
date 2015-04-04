
package guitest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SelectRadioButton{
  JLabel label;
  public static void main(String[] args){
    SelectRadioButton sr = new SelectRadioButton();
  }

  public SelectRadioButton(){
    JFrame frame = new JFrame("Radio button selection");
    JRadioButton first = new JRadioButton("First");
    JRadioButton second = new JRadioButton("Second");
    JRadioButton third = new JRadioButton("Third");
    JRadioButton fourth = new JRadioButton("Fourth");
    JRadioButton fifth = new JRadioButton("Fifth");
    JPanel panel = new JPanel();
    panel.add(first);
    panel.add(second);
    panel.add(third);
    panel.add(fourth);
    panel.add(fifth);
    ButtonGroup bg = new ButtonGroup();
    bg.add(first);
    bg.add(second);
    bg.add(third);
    bg.add(fourth);
    bg.add(fifth);
    first.addActionListener(new MyAction());
    second.addActionListener(new MyAction());
    third.addActionListener(new MyAction());
    fourth.addActionListener(new MyAction());
    fifth.addActionListener(new MyAction());
    label = new JLabel("Roseindia.net");
    frame.add(panel, BorderLayout.NORTH);
    frame.add(label, BorderLayout.CENTER);
    frame.setSize(400, 400);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public class MyAction implements ActionListener{
    public void actionPerformed(ActionEvent e){
      label.setText(e.getActionCommand());
      JOptionPane.showMessageDialog(null,"This is the " + e.getActionCommand() +
" radio button.");
    }
  }
}