/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mediaplayer;





import java.util.ArrayList;
import java.util.Random;
import ravmp3.Mp3;


class MP3 implements Runnable
{   
    Thread th = new Thread(this);
    Mp3 player = new Mp3();
    ArrayList<String> songs;
    int i =0;
    boolean change =true;
   boolean h=false;
    static int r;

    public void take(ArrayList<String> s)
    {songs=s;}


    public void play()
    {    r=1;
         th = new Thread(this);
         h=true;
       // songs = s;
         System.out.println(songs);
         th.suspend();
         th.start();
    }

    public void stop()
    {  r=1;
        player.stopSong();
        th.suspend();
    }

    public boolean isComplete()
    {
        return player.isSongComplete();
    }

    public void run()
    {  // while(rep || h)
                 {
       System.out.println(songs.get(i));
        player.playSong(songs.get(i));
        do
        {
            if(!player.isSongComplete())
            {
                change = false;
            }
            else
            {
                change = true;
            }

 
            
            if(change)
            {   System.out.println("inside ++");
               // player.playSong(songs.get(++i));

                if(rep== true)
                 {
                     if(i==songs.size()-1)
                     i=-1;
                 }

                if(shuf)
                {


                            while (true)
                            {
                                Random rm=new Random();
                                int a= (rm.nextInt())/10;
                            //    if(a==0)a=1;
                                a=a%songs.size();
                               System.out.println("m in run is "+m);
                                  System.out.println("No obtaind by randm in i++:"+a);
                                    if (a>=0)
                                    {   if(m!=a)
                                             {
                                                  i=a-1;
                                                   m=a;
                                                     System.out.println("m insyde run insyd if "+m);
                                                  break;}

                                               }

                                    }
                    }

            }
            
 player.playSong(songs.get(++i));
        }while(true);
    }
    
    }




public void next()
    {  System.out.println("NEXT PRESSED");

    if (r==0) {
           System.out.println( "r entrs");
          i=0;      r++;}
   
        else{
          
         stop();

       if(i==songs.size()-1)
           i=0;
                else
                    i++;
    }
    System.out.println(i);
     play();
        }
    
public  void prev()
        {
           if(r==0)
               {
                   i=songs.size()-1;
                   r++;
                   }

    else
            {
               stop();

               if(i==0)
                   i=songs.size()-1;

                else
                        i--;

            }
         play();
    }



int q;
boolean rep,shuf;
int m=999;

public void repeat()
    {   if(r!=0)  stop();
    r++;
       q++;

       if(q%2!=0) rep=true;
       else rep=false;
    play();
}


public void shuffle()
    {   shuf=true;
        if (r!=0)  stop();
        r++;

        boolean b=true;

        {
            while (true)
        {
           Random rm=new Random();
           int a= (rm.nextInt())/10;
           if(a==0)a=1;
           a=a%songs.size();

              System.out.println("No obtaind by randm :"+a);
            if (a>=0)
               {   if(m!=a)
                       {    i=a;
                           play();
                          m=a;
                break;}

            }

}
            }}}
