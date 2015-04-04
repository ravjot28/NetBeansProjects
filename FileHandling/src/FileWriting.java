public class FileWriting
{
    String name;
    String data;
    public FileWriting(String fname,String d)
    {
        name=fname;
        data=d;
        new FileeInput(name,data);
    }


    public FileWriting(String fname)
    {
        name=fname;
        FileeOutput out=new FileeOutput(name);
        String ddd=out.gett();
        System.out.println(ddd);
    }

}
