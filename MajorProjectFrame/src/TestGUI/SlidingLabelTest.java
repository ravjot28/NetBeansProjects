/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestGUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


/*
* SlidingLabelTest.java
*
* File creation information:
*
* Author: Ted Hill
* Date: Apr 14, 2005
* Time: 8:59:53 AM
*/

/**
* This class experiments with the 'animation' of showing and hiding a
JComponent.
*
* When the mouse is brought close to the top of the panel, a label
'slides' down
* into view. When the mouse moves away from the top of the panel, the
label 'rolls up'
* out of view.
* Two Swing Timers are used:
* 1. Slides the label into view.
* 2. Rolls the label up out of view.
*
* There is also a button on the panel. Each time it is clicked, it
will move the label
* down slightly. This was added initially before the timers as a way
to experiment with
* moving a component.
*
* Note that a null layout is used with absolute positioning.
* Null layout should be fine for the ImageViewer panel where the image
is essentially
* painted as the background. That is, when the toolbar slides down, it
won't push the
* image down, it will slide over and cover the top of the image.
*/
public class SlidingLabelTest extends JPanel
{
private static final int LABEL_HEIGHT = 30;
private static final int INITIAL_LABEL_WIDTH = 30;

private static final int TIMER_INTERVAL = 1;
private static final int PIXEL_DELTA = 2;


private JLabel label;

private Dimension labelDimension = new
Dimension(INITIAL_LABEL_WIDTH, LABEL_HEIGHT);

private JButton button;

private int vertOffset = - LABEL_HEIGHT;

private Timer showTimer = new ShowLabelTimer();
private Timer hideTimer = new HideLabelTimer();

public SlidingLabelTest()
{
setBackground(Color.BLACK);

initLabel();
// positionLabel(vertOffset);

// setLayout(new BorderLayout());
// add(label, BorderLayout.NORTH);

positionLabel(vertOffset);

setLayout(null);
add(label);

addButton();

addMouseMotionListener(new MouseMotionListener()
{
public void mouseDragged(MouseEvent e)
{
// TODO: add an implementation
}

public void mouseMoved(MouseEvent e)
{
final int height = e.getY();

if(height < 10 && ! showTimer.isRunning() && !
label.isVisible())
{
// vertOffset = - LABEL_HEIGHT;
// label.setVisible(true);
showTimer.start();
}
else if (height > LABEL_HEIGHT + 5 &&
!hideTimer.isRunning() && label.isVisible())
{
hideTimer.start();
}
}
});
}

private void addButton()
{
button = new JButton("Move Label");

Dimension buttonDimension = new Dimension(100, 30);
button.setPreferredSize(buttonDimension);
button.setMaximumSize(buttonDimension);
button.setMinimumSize(buttonDimension);

add(button);

Dimension size = button.getPreferredSize();
button.setBounds(200, 100, size.width, size.height);

button.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
label.setVisible(true);
positionLabel(vertOffset);

vertOffset += 2;
}
});
}

private void positionLabel(final int offset)
{
int panelWidth = getWidth();

System.out.println("SlidingLabelTest.positionLabel()");
System.out.println(" offset = " + offset);

// this will change the label's size
labelDimension.setSize(panelWidth, LABEL_HEIGHT);


// insets are zero because no border.
Insets insets = getInsets();

Dimension size = label.getPreferredSize();

label.setBounds(insets.left,
offset + insets.top,
size.width,
size.height);
}

private void initLabel()
{
label = new JLabel("Test Label");

label.setMinimumSize(labelDimension);
label.setPreferredSize(labelDimension);

label.setBackground(Color.YELLOW);
label.setOpaque(true);

// label.setVisible(true);
label.setVisible(false);

// label.setLocation(0, 0);
// label.setBounds(0, 0, 300, 30);
}


private class ShowLabelTimer extends Timer implements ActionListener
{
ShowLabelTimer()
{
// first param is callback interval in milliseconds
super(TIMER_INTERVAL, null); // call back in millis
addActionListener(this);
}



public void start()
{
vertOffset = - LABEL_HEIGHT;
label.setVisible(true);
super.start();
}


public void actionPerformed(ActionEvent e)
{
System.out.println("ShowLabelTimer.actionPerformed() vertOffset: " + vertOffset);

if(vertOffset <= 0)
{
positionLabel(vertOffset);
}
else
{
showTimer.stop();
}

vertOffset += PIXEL_DELTA;
}
}


private class HideLabelTimer extends Timer implements ActionListener
{
HideLabelTimer()
{
// first param is callback interval in milliseconds
super(TIMER_INTERVAL, null); // call back in millis
addActionListener(this);
}

public void stop()
{
label.setVisible(false);
super.stop(); // TODO: add an implementation
}

public void actionPerformed(ActionEvent e)
{
System.out.println("HideLabelTimer.actionPerformed() vertOffset: " + vertOffset);

if(vertOffset >= (-LABEL_HEIGHT))
{
vertOffset -= PIXEL_DELTA;
positionLabel(vertOffset);
}
else
{
hideTimer.stop();
}
}
}



public static void main(String[ ] args)
{
JFrame frame = new JFrame("SlidingLabelTest");

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

frame.getContentPane( ).add(new SlidingLabelTest( ),BorderLayout.CENTER);
frame.setSize(400, 200);
// frame.pack( );
frame.setVisible(true);
}
} 