package facerecognition;

import ravrun.Rav;

public class Main implements Runnable
{
    Thread th = new Thread(this);

    final Rav r = new Rav("http://www.gizmostore.somee.com/apps/face_recognition.zip");

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