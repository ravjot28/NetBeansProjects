import javazoom.jl.player.*;
import java.io.*;
public class MP3
{
    int i1=0;
    String son;
    MP3()
    {
         go();
    }

    public void go()
    {
        String data=null;
        int i=1;
        String songs[]=new String[getNumberOfLines("list.txt")];
         try
            {
                BufferedReader bb=new BufferedReader(new FileReader("list.txt"));
                data=bb.readLine();
                while(data!=null)
                {
                    songs[i]=data;
                    i++;
                    data=bb.readLine();
                }
                bb.close();
            }catch(Exception sa){}
            Random1 r=new Random1();
            int pp[]=r.m(getNumberOfLines("list.txt"));
            son=songs[pp[0]];
            try
            {
                    FileInputStream s=new FileInputStream(son);
                    Player p=new Player(s);
                    p.play();
                    if(p.isComplete())
                    {
                        son=songs[pp[++i1]];
                    }
            }catch(Exception song){}
            if(i1<=getNumberOfLines("list.txt"))
            {
                go();
            }
    }
    public int getNumberOfLines(String name) {
		int numberOfLines = 0;


		LineNumberReader lineCounter = null;
		try {
			lineCounter = new LineNumberReader(new FileReader(name));
			while ((lineCounter.readLine()) != null) {
				continue;
			}
			numberOfLines = lineCounter.getLineNumber();

		} catch (IOException e)
                {
		}

		return numberOfLines;
	}


}
