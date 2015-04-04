/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author Rav
 */
public class ParseFile {

    public static void main(String as[]) throws FileNotFoundException, IOException {
        String projectName = "James Imap";
        File file = new File("C:\\Users\\Rav\\Desktop\\1novfi.txt");
        BufferedReader b = new BufferedReader(new FileReader(file));

        String line = b.readLine();
        String issueId = null;
        String comment = "";
        while (line != null) {
            if (line.startsWith(projectName + ",")) {
                if (issueId != null && comment != null && comment.trim().length() > 0) {
                    if (!isDirectoryAlreadyExisits(projectName)) {
                        createDirectory(projectName);
                    }
                    comment = comment.replaceAll("\\<.*?>", "");
                    comment= comment.replaceAll("&nbsp;", "");

                   /* while (comment.contains("\\")) {
                        comment = comment.substring(0, comment.indexOf("\\")).concat(comment.substring(comment.indexOf("\\") + 1));
                    }*/
                    createFile(projectName + File.separator + issueId + ".txt",comment );
                }
                comment = "";
                issueId = null;
                line = line.replace(projectName + ",", "");
                StringTokenizer token = new StringTokenizer(line, ",");
                issueId = token.nextToken();
                try {
                    comment += token.nextToken();
                } catch (Exception e) {
                    comment = null;
                }
            } else {
                comment = comment + line;
            }
            line = b.readLine();
        }


    }

    private static boolean isDirectoryAlreadyExisits(String name) {
        File f = new File(name);
        return f.exists();
    }

    private static boolean createDirectory(String name) {
        File f = new File(name);
        return f.mkdir();
    }

    private static void createFile(String name, String content) throws IOException {
        File file = new File(name);
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();
        fw.close();
    }
}
