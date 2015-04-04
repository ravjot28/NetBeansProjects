import javax.swing.*;
public class file1 extends JFrame
{
    JFrame f;
    JLabel l;
    file1()
    {
        l=new JLabel();
        f=new JFrame("Rav");
        ImageIcon as=new ImageIcon("D:\\My World\\Event\\Posters\\Hackintosh_Wallpaper_v4_by_Jonzy.jpg");
        l.setIcon(as);
        f.add(l);
        f.pack();
        f.setVisible(true);
    }
    public static void main(String ars[])
    {
        new file1();
    }
}