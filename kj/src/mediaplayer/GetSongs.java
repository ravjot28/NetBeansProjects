package mediaplayer;



import java.io.File;
import java.io.FileFilter;

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
/*
    class Filter implements FileFilter
    {
        public boolean accept(File file)
        {
            return file.getName().endsWith("mp3");
        }
    }*/

  class Filter implements FileFilter
   {
       public boolean accept(File file)
       {
           return (file.getName().endsWith("mp3") || file.getName().endsWith("MP3"));
       }
   }

}