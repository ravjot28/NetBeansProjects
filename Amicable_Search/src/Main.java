import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class Main
{
    ArrayList <Integer> list;
    int initial_list;
    int last_list;

    public Main()
    {
        list = new ArrayList<Integer>();

        if(new File("rav.ravs").exists())
        {
            try
            {
                BufferedReader b = new BufferedReader(new FileReader("rav.ravs"));
                String data = b.readLine();
                while(data!=null)
                {
                    list.add(Integer.parseInt(data));
                    data = b.readLine();
                }
            }catch(Exception e){}

            HashSet hashSet = new HashSet(list);
            ArrayList<Integer> arrayList2 = new ArrayList(hashSet);
            Collections.sort(arrayList2);
            initial_list = arrayList2.get(0);
            last_list = arrayList2.get(list.size()-1);
        }
    }

    public long process(int a,int b)
    {
        StopWatch s = new StopWatch();
        s.start();
        int s1, s2;

        /*if(a<220)
        {
            a=220;
        }

        System.out.println(initial_list+"  "+last_list+" "+a+" "+b);
        
        if(a>=initial_list && a<b && b<=last_list)
        {
            for(int i = getIndex(a,list) ;i<getIndex(b,list);i++)
            {
                System.out.println("("+list.get(i)+","+list.get(++i)+")");
            }
        }
        else
            if(a>=initial_list && a<last_list && b>last_list)
            {
                for(int i =getIndex(a,list) ;i<list.size();i++)
                {
                    System.out.println("("+list.get(i)+","+list.get(++i)+")");
                }
                
                for (int i = list.get(list.size()-1); i <b; i++)
                {
                    s1 = getSumOfFactors(i);
                    s2 = (s1 > i) ? getSumOfFactors(s1) : 0;
                    if (s2 == i)
                    {
                        System.out.println("("+i+","+s1+")");
                        list.add(i);
                        list.add(s1);
                    }
                }
            }
            else
            if(a<initial_list && a<b && b<=last_list)
            {
                for(int i =0 ;i<getIndex(b,list);i++)
                {
                    System.out.println("("+list.get(i)+","+list.get(++i)+")");
                }

                for (int i = 220; i <=a; i++)
                {
                    s1 = getSumOfFactors(i);
                    s2 = (s1 > i) ? getSumOfFactors(s1) : 0;
                    if (s2 == i)
                    {
                        System.out.println("("+i+","+s1+")");
                        list.add(i);
                        list.add(s1);
                    }
                }
            }
        else
        {
            if(a<=220)
            {
                for (int i = 220; i <=b; i++)
                {
                    s1 = getSumOfFactors(i);
                    s2 = (s1 > i) ? getSumOfFactors(s1) : 0;
                    if (s2 == i)
                    {
                        System.out.println("("+i+","+s1+")");
                        list.add(i);
                        list.add(s1);
                    }
                }
            }
            else
            {
                for (int i = a; i <=b; i++)
                {
                    s1 = getSumOfFactors(i);
                    s2 = (s1 > i) ? getSumOfFactors(s1) : 0;
                    if (s2 == i)
                    {
                        System.out.println("("+i+","+s1+")");
                        list.add(i);
                        list.add(s1);
                    }
                }
            }
        }*/
        for (int i = a; i <=b; i++)
                {
                    s1 = getSumOfFactors(i);
                    s2 = (s1 > i) ? getSumOfFactors(s1) : 0;
                    if (s2 == i)
                    {
                        System.out.println("("+i+","+s1+")");
                        list.add(i);
                        list.add(s1);
                    }
                }
        s.stop();

        startLearning();

        return s.getElapsedTime();
    }
    
    private int getSumOfFactors(int number)
    {
        int temp = 1;
        int limit = (int)Math.sqrt(number) +1;
       
        for (int i = 2; i <= limit; i++)
            if ((number%i) == 0)
                temp = temp + i + number / i;
        
        return temp;
    }

    public int getIndex(int a,ArrayList<Integer> l)
    {
        for(int i=0;i<l.size();i++)
        {
            if(a<=list.get(i))
            {
                return i;
            }
        }
        return -1;
    }

    public void startLearning()
    {
         HashSet hashSet = new HashSet(list);
         ArrayList arrayList2 = new ArrayList(hashSet);

         try
         {
             BufferedWriter b = new BufferedWriter(new FileWriter("rav.ravs"));
             Iterator it = arrayList2.iterator();
             while(it.hasNext())
             {
                 b.append(""+it.next());
                 b.newLine();
             }
             b.close();
         }catch(Exception e){}
    }

    public static void main(String args[])
    {
        int a = 1;
        int b = 100000;
        Main t = new Main();
        System.out.println("Time Elapsed: "+t.process(a,b));
    }
}