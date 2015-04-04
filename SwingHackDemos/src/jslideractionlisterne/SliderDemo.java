/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jslideractionlisterne;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderDemo extends JFrame {
  protected JLabel label;

  protected JSlider slider;

  public SliderDemo() {
    init();
  }

  public void init() {
    getContentPane().setLayout(new FlowLayout());

    JPanel p0 = new JPanel();
    p0.setLayout(new BoxLayout(p0, BoxLayout.X_AXIS));

    JPanel p1 = new JPanel();
    p1.setLayout(new GridLayout(3, 1));

    JPanel p = new JPanel();
    p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));

    label = new JLabel("101.5 FM");
    label.setFont(new Font("Arial", Font.BOLD, 24));
    p.add(label);

    p1.add(p);

    slider = new JSlider(JSlider.HORIZONTAL, 1, 5, 1);
    slider.setPaintLabels(true);
    slider.setMajorTickSpacing(5);
    MyChangeListener lst = new MyChangeListener();
    slider.addChangeListener(lst);

    p = new JPanel();
    p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
    p.add(slider);
    p1.add(p);

    p = new JPanel();
    p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

    JPanel p2 = new JPanel();
    p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));

    for (int k = 1; k <= 5; k++) {
      JButton fv = new JButton(Integer.toString(k));
      fv.addActionListener(new MyActionListener(k));
      p2.add(fv);
    }

    p.add(p2);
    p1.add(p);
    p0.add(p1);

    p = new JPanel();
    p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));

    p0.add(p);

    getContentPane().add(p0);

    lst.stateChanged(new ChangeEvent(slider));
  }

  public synchronized void playStation(int index) {
    slider.setValue(index);
  }

  class MyActionListener implements ActionListener {
    protected int m_index;

    MyActionListener(int index) {
      m_index = index;
    }

    public void actionPerformed(ActionEvent e) {
      playStation(m_index);
    }
  }

  class MyChangeListener implements ChangeListener {
    MyChangeListener() {
    }

    public synchronized void stateChanged(ChangeEvent e) {
      int frequency = slider.getValue();
      label.setText(frequency + " FM");
    }
  }

  public static void main(String[] za) {
    SliderDemo d = new SliderDemo();
    d.setSize(400, 200);
    d.show();

  }
}

           