public class Repeatition
{
    public static void main(String as[])
    {
        Repeatition r = new Repeatition();
        long a = System.currentTimeMillis();
        String s = "qwertyuioplkjhgfdsazxcvbnm,./;'[]\\=-0987654321`q";
        if(r.check(s))
        {
            System.out.println("Unique");
        }
        else
        {
            System.out.println("Not Unique");
        }
        System.out.println((a-System.currentTimeMillis()));

    }

    public boolean check(String s)
    {
        for(int i=0;i<s.length();i++)
        {
            for(int j=i+1;j<s.length();j++)
            {
                if(s.charAt(i)==s.charAt(j))
                {
                    return false;
                }
            }
        }
        return true;
    }
}
