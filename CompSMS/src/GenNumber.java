public class GenNumber 
{
    String prefix;

    GenNumber(String loc)
    {
        this.prefix = loc;
    }

    public String getlast4()
    {
        long random;
        final long MAX = 9999,
        MIN = 1000;
        random = (long)(Math.floor(Math.random() * (MAX - MIN + 1)) + MIN);
        return prefix+random;
    }
}
