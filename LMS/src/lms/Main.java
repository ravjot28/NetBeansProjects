package lms;

import ravrun.Rav;

public class Main implements Runnable
{
    Thread th = new Thread(this);

    final Rav r = new Rav("http://www.lms.elementfx.com/");

    public static void main(String[] args)
    {
       Main m = new Main();
       m.execute();
    }

    public void execute()
    {
        th.start();
    }

    public void run()
    {
        r.execute();
    }
}
