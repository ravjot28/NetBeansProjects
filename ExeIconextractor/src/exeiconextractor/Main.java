package exeiconextractor;
import java.io.*;
import javax.swing.*;

public class Main
{
  public static void main(String[] args) throws Exception
  {
    String s = "D:\\Softwares\\Portable Applications\\Office 07\\WINWORD.EXE";
    File file = new File(s);
    sun.awt.shell.ShellFolder sf =sun.awt.shell.ShellFolder.getShellFolder(file);
    Icon icon = new ImageIcon(sf.getIcon(true));
    System.out.println("type = " + sf.getFolderType());
    JLabel ficon = new JLabel(s, icon, SwingConstants.LEFT);
    JFrame frame = new JFrame();
    frame.getContentPane().add(ficon);
    frame.pack();
    frame.setVisible(true);
  }
}