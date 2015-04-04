import java.applet.*;
import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author Administrator
 */
public class MovingBanner extends Applet implements Runnable {
String msg;
Thread t=null;
int state;
boolean stopflag;

    public void init()
    {
    setBackground(Color.BLACK);
    setForeground(Color.WHITE);
    }

     public void start() {
        msg=getParameter("msg");
        t = new Thread(this);
        stopflag=false;
        t.start();
    }

    public void run(){
        char ch;
        for(;;){
            try{
            repaint();
            Thread.sleep(250);
            ch=msg.charAt(0);
            msg=msg.substring(1,msg.length());
            msg+=ch;
            if(stopflag){
                break;
            }
            }catch(InterruptedException e){
                System.out.print("Error:"+e);
            }
        }
    }
    public void stop(){
        stopflag=true;
        t=null;
    }

    public void paint(Graphics g)
    {
        g.drawString(msg,10,30);
    }

}