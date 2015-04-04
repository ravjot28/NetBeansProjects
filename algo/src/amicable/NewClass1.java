package amicable;

public class NewClass1
{
    public static boolean isAmicable(int start, int end)//give the function a range to search
    {
        System.out.println("in isAmicable");
        //220 and 284 are the smallest amicable numbers
        for(int i = start; i <= end; i++)
        {
            for(int j = end; j >= start; j--) //we could make j >= i to cut down processing, but for a small program, not important
            {
                if ((sumFactors(i)==j) && (sumFactors(j)==i) && (i != j)) //last conditional is important other wise it will return a same pair of numbersn
                {
                    System.out.println(i + " and " + j + " are amicable\n");
                }
            }
        }
        //System.out.println("No amicable values found in range: " + start + " - " + end);
        return false;
    }

    //included to show clarity to above snippet
    public static int sumFactors(int number) //Find the sum of the factors of the given number (divisors)
    {
        int factor = 0, sum = 0;
        for (int i = 1; i < number; i++)
        {
            if ((number%i)==0)
            {
                factor = i;
                sum += factor;
            }
        }
        return sum;
    }

    public static void main(String a[])
    {
        isAmicable(200,5000);
    }
}
