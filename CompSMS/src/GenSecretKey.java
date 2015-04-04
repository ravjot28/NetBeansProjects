public class GenSecretKey
{
    public String key()
    {
        long random;
        final long MAX = 9999,
        MIN = 1000;
        random = (long)(Math.floor(Math.random() * (MAX - MIN + 1)) + MIN);
        return ""+random;
    }
}
