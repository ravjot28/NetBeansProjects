public class Open implements Runnable
{
    String s;
    Open(String a)
    {
         s=a;
         Thread aa=new Thread(this);
         aa.start();
    }

    public void run()
    {
        try {
            String cmd = s;
            Process p = Runtime.getRuntime().exec(cmd);
        } catch (Exception ex) {  }
    }

    //Testing
    /*public static void main(String ar[])
    {
        new Open("<File location>");
    }*/
}
