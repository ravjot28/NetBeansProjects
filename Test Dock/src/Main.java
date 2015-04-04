public class Main implements Runnable
{
    Thread t=new Thread(this);

    public static void main(String r[])
    {
        new Main();
    }

    Main()
    {
        t.start();
    }

    public void run()
    {
        try {
            new MyMain(1);
        } catch (Exception ex) {
        }
    }

}
