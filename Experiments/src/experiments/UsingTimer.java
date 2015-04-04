package experiments;
import java.util.Timer;
import java.util.TimerTask;
public class UsingTimer
{
    int m;
    public UsingTimer(int min)
    {
        final int m=min;
        new Timer().schedule(new TimerTask()
        {
            int a=0;

            public void run() 
            {
                System.out.println(a);
                a++;
            }
        }, 0, 1000);
    }

    public static void main(String... args) {
        new UsingTimer(2);
    }
}