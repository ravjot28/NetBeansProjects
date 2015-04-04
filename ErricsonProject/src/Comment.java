
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Comment {

    public static ArrayList<String> getFileContentList(String fileName) {
        ArrayList<String> data = new ArrayList<String>();
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(fileName));
            String line = null;
            while ((line = input.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException ex) {
            data = new ArrayList<String>();
        } finally {
            if (null != input) {
                try {
                    input.close();
                } catch (Exception e) {
                    data = new ArrayList<String>();
                }
            }
        }
        return data;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> add_cmt = getFileContentList("add_cmt.txt");

        int start_ind = 0;
        for (String st : add_cmt) {
            if (st.trim().startsWith("These computer resources")) {
                start_ind = add_cmt.indexOf(st);
                break;
            }
        }

        for (int i = start_ind; i <= start_ind + 10; i++) {
            add_cmt.set(i,"#"+add_cmt.get(i));
        }


        BufferedWriter b = new BufferedWriter(new FileWriter("cmt_file.txt"));
        for(String temp:add_cmt){
            b.append(temp);
            b.newLine();
        }
        b.close();
    }
}
