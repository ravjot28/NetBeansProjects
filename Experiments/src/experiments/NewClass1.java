package experiments;
import java.awt.*;
import javax.swing.*;
class Testing extends JFrame
{
  public Testing()
  {
      GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] mydevices = env.getScreenDevices();
      mydevices[0].setFullScreenWindow(this);
    setTitle("JFrame");
    setSize(300,200);
    setLocation(350,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setUndecorated(true);
    getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
    getContentPane().add(new JPanel());
  }
  public static void main(String[] args){new Testing().setVisible(true);}
}