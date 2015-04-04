package exeiconextractor;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.filechooser.FileSystemView;

public class NewClass
{
  public static void main(String[] args) throws Exception {
    String s = "D:\\Softwares\\Portable Applications\\Office 07\\WINWORD.EXE";
    File file = new File(s);

    // Get metadata and create an icon
    Icon icon = FileSystemView.getFileSystemView().getSystemIcon(file);

    // show the icon
    JLabel ficon = new JLabel(s, icon, SwingConstants.LEFT);

    JFrame frame = new JFrame();
    frame.getContentPane().add(ficon);
    frame.pack();
    frame.setVisible(true);
  }
}