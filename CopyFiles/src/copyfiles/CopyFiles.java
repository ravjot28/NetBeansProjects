/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package copyfiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pack1.a;

/**
 *
 * @author Rav
 */
public class CopyFiles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        a a1 = new a();
        a1.setCount(1);
        System.out.println(a1.getCount());
         a1.setCount(2);
        System.out.println(a1.getCount());
        process("D:\\Temp", "D:\\Temp1");
    }

    public static void process(String mainFolder, String destFolder) {
        List<File> fileList = listf(mainFolder);
        for (File f : fileList) {
            if (f.isFile()) {
                String fileName = f.getAbsolutePath();
                //System.out.println(fileName.substring(mainFolder.length() + 1));
                String t = fileName.substring(mainFolder.length() + 1);
                while (t.contains("\\")) {
                    t = t.substring(0, t.indexOf("\\")).concat("$").concat(t.substring(t.indexOf("\\") + 1));
                }
                File file = new File(destFolder + "\\" + t);
                try {
                    Files.copy(f.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }
        }
    }

    public static List<File> listf(String directoryName) {
        File directory = new File(directoryName);

        List<File> resultList = new ArrayList();

        File[] fList = directory.listFiles();
        resultList.addAll(Arrays.asList(fList));
        for (File file : fList) {
            if (file.isDirectory()) {
                resultList.addAll(listf(file.getAbsolutePath()));
            }
        }
        return resultList;
    }
}
