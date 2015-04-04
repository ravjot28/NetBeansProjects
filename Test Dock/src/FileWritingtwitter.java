public class FileWritingtwitter
{
    String name;
    String data;
    String rav;
    public FileWritingtwitter(String fname,String d)
    {
        name=fname;
        data=d;
        new FileeInputtwitter(name,data);
    }


    public FileWritingtwitter(String fname)
    {
        name=fname;
        FileeOutputtwitter out=new FileeOutputtwitter(name);
        String ddd=out.gett();
       rav=ddd;
    }
    public String get()
    {
        return rav;
    }

}
