public class FileWritingMail
{
    String name;
    String data;
    String rav;
    public FileWritingMail(String fname,String d)
    {
        name=fname;
        data=d;
        new FileeInputMail(name,data);
    }


    public FileWritingMail(String fname)
    {
        name=fname;
        FileeOutputMail out=new FileeOutputMail(name);
        String ddd=out.gett();
       rav=ddd;
    }
    public String get()
    {
        return rav;
    }

}
