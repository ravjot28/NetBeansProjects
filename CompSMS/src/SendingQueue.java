public class SendingQueue implements Runnable
{
    String to[];
    String message;
    String from;
    String password;
    Thread th = new Thread(this);

    public SendingQueue(String t[],String m,String f,String p)
    {
        this.to = t;
        this.message = m;
        this.from = f;
        this.password = p;
    }

    public void run()
    {
        sending s1 = new sending(this.from,this.message,"Your Secret Code to get Access to Rav SMS Service", this.to, this.password);
        String result = s1.send();
        //System.out.println("result:"+result);
    }

    public void process()
    {
        //System.out.println(this.from+" "+this.message+" "+this.password);
        th.start();
    }
}
