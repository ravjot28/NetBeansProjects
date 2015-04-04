package TestingGUI;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import javax.imageio.ImageIO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class ImageProgressBar extends JProgressBar {
private BufferedImage theImage;
private class CustomProgressBarUI extends BasicProgressBarUI {
protected void paintDeterminate(Graphics g, JComponent c) {
if (!(g instanceof Graphics2D)) return;
if (theImage == null) {
super.paintDeterminate(g, c);
return;
}
Insets b = getInsets();
int barRectWidth = getWidth() - (b.right + b.left);
int barRectHeight = getHeight() - (b.top + b.bottom);
int amountFull = getAmountFull(b, barRectWidth, barRectHeight);
Graphics2D g2 = (Graphics2D) g;
g2.setColor(getForeground());
if (getOrientation() == JProgressBar.HORIZONTAL) {
if (c.getComponentOrientation().isLeftToRight()) {
fillRectangle(b.left, b.top, amountFull + b.left, barRectHeight, g2);
} else {
fillRectangle(barRectWidth + b.left - amountFull, b.top, amountFull, barRectHeight, g2);
}
} else {
fillRectangle(b.left, b.top + barRectHeight - amountFull, barRectWidth, amountFull, g2);
}
if (progressBar.isStringPainted()) {
paintString(g, b.left, b.top,
barRectWidth, barRectHeight,
amountFull, b);
}
}
private void fillRectangle(int x, int y, int aWidth, int aHeight, Graphics2D aGraphics) {
if (theImage == null) {
aGraphics.fillRect(x, y, aWidth, aHeight);
return;
}
double scaleX = (double)aWidth / (double)theImage.getWidth();
double scaleY = (double)aHeight / (double)theImage.getHeight();
AffineTransform transform = AffineTransform.getScaleInstance(scaleX, scaleY);
aGraphics.translate(x, y);
aGraphics.drawImage(theImage, transform, null);
aGraphics.translate(-x, -y);
}
}
public ImageProgressBar() {}
public ImageProgressBar(int orient) {
super(orient);
}
public ImageProgressBar(int min, int max) {
super(min, max);
}
public ImageProgressBar(int orient, int min, int max) {
super(orient, min, max);
}
public ImageProgressBar(BoundedRangeModel newModel) {
super(newModel);
}
public void setImage(BufferedImage aBufferedImage) {
theImage = aBufferedImage;
}
public void setUI(ProgressBarUI ui) {
super.setUI(new CustomProgressBarUI());
}
public static void main(String[] args) {
final JFrame frame = new JFrame("Test");
frame.addWindowListener(new WindowAdapter() {
public void windowClosing(WindowEvent e) {
System.exit(0);
}
});
JPanel panel = new JPanel(new GridLayout(2, 1));
final ImageProgressBar progressBar = new ImageProgressBar(JProgressBar.HORIZONTAL, 0, 100);
progressBar.setStringPainted(true);
final JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
slider.addChangeListener(new ChangeListener() {
public void stateChanged(ChangeEvent e) {
progressBar.setValue(slider.getValue());
}
});
panel.add(progressBar);
panel.add(slider);
BufferedImage image = null;
try {
image = ImageIO.read(new File("p.png"));
} catch (IOException e) {
e.printStackTrace();
}
if (image != null) {
progressBar.setImage(image);
}
frame.setContentPane(panel);
SwingUtilities.invokeLater(new Runnable() {
public void run() {
frame.pack();
frame.show();
}
});
}
}
