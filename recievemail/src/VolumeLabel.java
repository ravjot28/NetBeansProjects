import java.io.*;
import javax.swing.filechooser.*;

public class VolumeLabel {
 private VolumeLabel() { }

 public static void main(String[] args) {
  System.out.println("\"" + get(args[0]) + "\"");
 }

 public static String get(String path) {
  FileSystemView view = FileSystemView.getFileSystemView();
  File dir = new File(path);
  String name = view.getSystemDisplayName(dir);
  if (name == null) { return null; }
  name = name.trim();
  if (name == null || name.length() < 1) {
   return null;
  }
  int index = name.lastIndexOf(" (");
  if (index > 0) {
    name = name.substring(0, index);
   }
   return name;
 }
}