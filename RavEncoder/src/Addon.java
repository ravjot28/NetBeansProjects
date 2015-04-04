public class Addon
{
    String name;

    public Addon(String n)
    {
        name=n;
    }

    public String get()
    {
        String modified=name;
        modified=modified+"         ";
        return modified;
    }

}
