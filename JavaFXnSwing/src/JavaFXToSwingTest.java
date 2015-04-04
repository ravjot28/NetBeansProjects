import java.awt.*;
import javax.swing.*;
import org.jfxtras.scene.SceneToJComponent;

package public class JavaFXToSwingTest extends JFrame {

  public static JTextField tf = new JTextField("JavaFX for SWING");

  public JavaFXToSwingTest() {
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("JavaFX in SWING Test");

    Container container = getContentPane();
    container.setLayout(new BorderLayout());

    String sceneClass = "swingtest.MyScene";
    JComponent myScene = SceneToJComponent.loadScene(sceneClass);

    JLabel label = new JLabel(" Below is a JavaFX Animation: ");
    container.add(label, BorderLayout.NORTH);
    container.add(myScene, BorderLayout.CENTER);

    JPanel p = new JPanel();
    p.setLayout(new FlowLayout());

    tf.setColumns(28);
    p.add(tf);
    p.add(new JButton("SWING Button"));

    container.add(p, BorderLayout.SOUTH);
    pack();
  }

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(
      new Runnable() {
        public void run() {
          new JavaFXToSwingTest().setVisible(true);
        }
      });
  }
}
 