import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Factors
{
    ArrayList<Long> result;
    
    public ArrayList<Long> getPrimeFactors(int n)
    {
        ArrayList <Long> a = new ArrayList();
        // for each potential factor i
        for (long i = 2; i <= n / i; i++)
        {
            // if i is a factor of N, repeatedly divide it out
            while (n % i == 0)
            {
                a.add(i);
                n = (int) (n / i);
            }
        }

        // if biggest factor occurs only once, n > 1
        if (n > 1) a.add(Long.parseLong(""+n));
         //  System.out.println();

        return a;
    }

    public int getSumOfFactors(int a)
    {
        //result = new rav().getPrimeFactors(a);
        result = this.getPrimeFactors(a);
       // for(int i=0;i<result.size();i++)
            //System.out.print(result.get(i)+",");
         Set resultSet = new HashSet(result);

         int counter =1;
        
         for (Object set : resultSet)
         {
            int p = Integer.parseInt(""+set);
            int pow = countOccurance(p);
            counter*=(Math.pow(p, pow+1)-1)/(p-1);  
            //System.out.println(set+" occurs "+countOccurance(Integer.parseInt(""+set)));
        }
        return(counter-a);
    }

    public int countOccurance(int a)
    {
        int count=0;
        for(int i=0;i<result.size();i++)
        {
            if(result.get(i)==a)
                count++;
        }
        return count;
    }

    public void start(int a,int b)
    {
        Factors f = new Factors();
       int s1, s2;
       for (int i = a; i <b; i++)
       {
           s1 = f.getSumOfFactors(i);
           System.out.println("For "+i+" "+s1);//s2 = (s1 > i) ? f.getSumOfFactors(s1) : 0;
           //if (s2 == i)
               //System.out.println("Pair --> "+i+","+s1);
       }
    }
}