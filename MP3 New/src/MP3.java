import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;


// This class playes the mp3 files.
class MP3 extends Observable implements Runnable
{
     int i1=0;
     int res=0;
    String son="Rav's MP3 Player";
    String source;
    String songs[];
    int pp[];
    int flag=-1;
    int a=-1;
    Thread thread = new Thread(this);
    Boolean rav=true;
    Player p;
    String na;
    // Start Playing.
    MP3(String name)
    {
        na=name;
    }
    void download() throws FileNotFoundException, JavaLayerException
    {
        if(flag==-1)
        {
            String data=null;
        int i=0;
        songs=new String[getNumberOfLines(na)];
         try
            {
                BufferedReader bb=new BufferedReader(new FileReader(na));
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
            pp=r.m(getNumberOfLines(na));
            son=songs[pp[0]];
        }
        if(pp.length==0)
        {
            JOptionPane.showMessageDialog(null,"Please Add the folder to your playlist","Alert",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            thread.setName("rav");
            thread.start();
        }
       
    }

    public void table(int rav)
    {
        if((pp[i1]!=rav)&&(pp[i1+1]!=rav))
        {
        int a[]=new int[getNumberOfLines(na)+1];
        for(int i=0;i<=i1;i++)
        {
            a[i]=pp[i];
        }
        a[i1+1]=rav;
        System.arraycopy(pp,i1+1,a,i1+2,getNumberOfLines(na)-(i1+2));
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }
        pp=new int[getNumberOfLines(na)+1];
        System.arraycopy(a,0,pp,0,a.length);
        i1++;
        }
        p.close();
        son=songs[rav];
        thread=null;
        thread.start();
    }

    public void prev()
    {
         p.close();
         if(i1==0)
         {
             i1=0;
         }
         else
         {
             i1--;
         }
      son=songs[pp[i1]];
      thread=null;
      thread.start();
    }
    public void stopp()
    {
            res=i1;
         p.close();
      son="";
      thread=null;
      thread.start();
        
    }
    public void resume()
    {
        p.close();
      son=songs[pp[res]];
      thread=null;
      thread.start();
    }
    public void next() throws InterruptedException
    {
       p.close();
       if(i1==songs.length)
       {
           i1=songs.length;
       }
       else
       {
           i1++;
       }
      son=songs[pp[i1]];
      thread=null;
      thread.start();

      // p.wait();
    }

   
 

    // Get file name.
    public String getFileName()
    {
        return songs[pp[i1]];

    }

    public int getnum()
    {
        return i1;
    }


//Play file.
    public void run()
    {
        do
        {
            try
            {

                FileInputStream s=new FileInputStream(son);
                p=new Player(s);
                    p.play();
                    if((p.isComplete())||(!rav))
                    {
                        son=songs[pp[++i1]];
                    }
                
            }catch(Exception song){}
            if(i1==pp.length)
            {
                i1=0;
            }
        }while(true);
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


    // Notify observers that this playing status has changed.
    private void stateChanged()
    {
        setChanged();
        notifyObservers();
    }
    
}