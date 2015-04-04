public class testingtwitter
{
    String s;

    testingtwitter(String name,String data)
    {
        new FileWritingtwitter(name,data);
    }

    testingtwitter(String name)
    {

        FileWritingtwitter pp=new FileWritingtwitter(name);
        String result=pp.get();
        s=result;
    }

    public String send()
    {
        return s;
    }

}
