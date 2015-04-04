public class testingMail
{
    String s;

    testingMail(String name,String data)
    {
        new FileWritingMail(name,data);
    }

    testingMail(String name)
    {

        FileWritingMail pp=new FileWritingMail(name);
        String result=pp.get();
        s=result;
    }

    public String send()
    {
        return s;
    }

}
