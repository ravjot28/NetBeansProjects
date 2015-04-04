public class testing
{
    String s;
    
    testing(String name,String data)
    {
        new FileWriting(name,data);
    }

    testing(String name)
    {

        FileWriting pp=new FileWriting(name);
        String result=pp.get();
        s=result;
    }

    public String send()
    {
        return s;
    }

}
