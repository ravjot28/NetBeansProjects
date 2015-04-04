import javax.swing.*;

public class IconifyAndMaximizeFrm{
  public static void main(String[] args){
    JFrame frame = new JFrame("Iconifying and Maximizing a Frame");
    frame.setUndecorated(false);
    frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  //Maximizing the frame
    frame.setExtendedState(JFrame.ICONIFIED | frame.getExtendedState());
  //Minimizing or Iconifing the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}