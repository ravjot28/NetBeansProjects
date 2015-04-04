package WithHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Factors
{
    HashMap result  = new HashMap();

    public void getPrimeFactors(int n)
    {
        // for each potential factor i
        for (long i = 2; i <= n / i; i++)
        {
            // if i is a factor of N, repeatedly divide it out
            while (n % i == 0)
            {
                if(result.containsKey(""+i))
                {
                    Integer rav = (Integer) result.get(""+i);
                    result.put(""+i, (rav+1));
                }
                else
                {
                    result.put(""+i,new Integer(1));
                }
                n = (int) (n / i);
            }
        }

        // if biggest factor occurs only once, n > 1
        if (n > 1)
        {
            if(result.containsKey(""+n))
            {
                Integer rav = (Integer) result.get(""+n);
                result.put(""+n, (rav+1));
            }
            else
            {
                result.put(""+n,new Integer(1));
            }
        }
    }

    public int getSumOfFactors(int a)
    {
        //result = new rav().getPrimeFactors(a);
        this.getPrimeFactors(a);
       // for(int i=0;i<result.size();i++)
            //System.out.print(result.get(i)+",");
         
        Set set = result.entrySet();

        Iterator i = set.iterator();

        int counter =1;

        while(i.hasNext())
        {
            Map.Entry me = (Map.Entry)i.next();
            int p = Integer.parseInt(""+ me.getKey());
            int pow = Integer.parseInt(""+ me.getValue());
            counter*=(Math.pow(p, pow+1)-1)/(p-1);
        }
        result  = new HashMap();
            //int p = Integer.parseInt("");
            //int pow =(Integer) result.get("");
            //counter*=(Math.pow(p, pow+1)-1)/(p-1);
            //System.out.println(set+" occurs "+countOccurance(Integer.parseInt(""+set)));

        return(counter - a);
    }

    public void start(int a,int b)
    {
        Factors f = new Factors();
       int s1, s2;
       for (int i = a; i <=b; i++)
       {
           s1 = f.getSumOfFactors(i);
           s2 = (s1 > i) ? f.getSumOfFactors(s1) : 0;
           if (s2 == i)
               System.out.println("Pair --> "+i+","+s1);
       }
    }
}
