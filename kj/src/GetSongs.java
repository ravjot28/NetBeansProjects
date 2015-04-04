
import java.io.File;
import java.io.FileFilter;
import javax.swing.JFileChooser;

public class GetSongs
{
    public String[] getSongs(String name)
    {
             File directory = new File(name);
             File[] files = directory.listFiles(new Filter());
             String songs[] = new String[files.length];
             for (int i = 0; i < files.length; i++)
             {
                 songs[i] =  files[i].toString();
             }
             return songs;
    }

    class Filter implements FileFilter
    {
        public boolean accept(File file)
        {
            return file.getName().endsWith("mp3");
        }
    }

    public static void main(String as[])
    {
        String songs[] = new GetSongs().getSongs("D:\\Music\\Songs\\Hindi");

        for (int i = 0; i < songs.length; i++)
        {
            System.out.println(songs[i]);   //Instead of SOP u store these song location in the file and NOTE follow the same procedure i did in playlist case
            //and the above code was if the user selects the add folder
            //If the user selects add file then just take the file location and store append in the file remember add true in FileWriter to avoid earsing of prev data in the file
            //acha ab ye baat hai jo D:\\Music\\Songs ye kaha se ayega ye question aya hoga tumhare so uska ans neeche hai

            //// String s = ch.getSelectedFile().toString(); and pass this s to the GetSongs's getSongs function
        }
    }
}
