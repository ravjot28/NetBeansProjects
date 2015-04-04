import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import javax.swing.*;

public class SheetTest extends Object implements PropertyChangeListener
{
    JOptionPane optionPane;
    AniSheetableJFrame frame;
    public static final String i = "img/1.jpg";
    URL image=getClass().getClassLoader().getResource(i);

    public static void main(String ar[])
    {
        new SheetTest();
    }

    public SheetTest()
    {
        frame = new AniSheetableJFrame("Sheet Test");
        ImageIcon icon = new ImageIcon(image);
        JLabel label = new JLabel(icon);
        frame.getContentPane().add(label);
        optionPane = new JOptionPane("Do you want to save?",JOptionPane.QUESTION_MESSAGE,JOptionPane.YES_NO_OPTION);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        optionPane.addPropertyChangeListener(this);
        try
        {
            Thread.sleep(1000);
        }catch(Exception as){}
         JDialog dialog = optionPane.createDialog(frame,"irrelevant");
        frame.showJDialogAsSheet(dialog);
    }

    public void propertyChange(PropertyChangeEvent pce)
    {
        if(pce.getPropertyName().equals(JOptionPane.VALUE_PROPERTY))
        {
                frame.hideSheet();
        }
    }
}
