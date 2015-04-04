
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXScene;


public class Main
{
    Main()
    {
        JFrame f = new JFrame("Hello World");
        JPanel mainPanel = new JPanel();
        JXScene scene = new JXScene(); // create a new JXScene
        scene.setScript("MyScene"); // the name of your main JavaFX class
        mainPanel.add(scene); // add the scene your swing scene
        f.add(mainPanel);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String s[])
    {
        new Main();
    }
}
