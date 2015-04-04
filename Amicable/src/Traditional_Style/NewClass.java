package Traditional_Style;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class NewClass
{
    static NewClass nc;         //Object for the code
    static int first,last;       //Defines Range

    public static void main(String as[])
    {
       nc = new NewClass();
       System.out.println("The range is from "+first+" to "+last);
       nc.start(first,last);
    }

    NewClass()  //initializes the first and last variables
    {
        Scanner s = new Scanner(System.in);
        first = s.nextInt();
        last = s.nextInt();
    }

    public void start(int a, int b) //Finds the amicable numbers
    {
        try
        {
            BufferedWriter bw;
        
            for(int i=a;i<=b;i++)
            {
                int temp = sum_of_divisors(i);
                System.out.println(i+" = "+temp);
                int temp1 = sum_of_divisors(temp);
                System.out.println(temp+" = "+temp1);

                if((temp>0)&&(temp1>0))
                {

                    if((temp == temp1))
                    {
                    
                        if(getOS().equalsIgnoreCase("Win"))
                        {
                            bw = new BufferedWriter(new FileWriter("Bin\\Results.ravs",true));
                            bw.append(i+"  "+temp);
                            bw.newLine();
                            bw.close();
                        }

                        else
                        if(getOS().equalsIgnoreCase("Lin/Mac"))
                        {
                            bw = new BufferedWriter(new FileWriter("Bin/Results.ravs",true));
                            bw.append(i+"  "+temp);
                            bw.newLine();
                            bw.close();
                        }

                        else
                        {
                            bw = new BufferedWriter(new FileWriter("Results.ravs",true));
                            bw.append(i+"  "+temp);
                            bw.newLine();
                            bw.close();
                        }
                    
                    }
                }
                else
                {
                    System.out.println("Error : Sum of Divisors of "+i+" is "+temp);
                }
            
                temp=0;
            }
        }catch(Exception a1)
        {
            System.out.println("Amicalble number function's exception "+a1);
        }
    }

    public int sum_of_divisors(int n)   //Finds the sum of product and waste loops
    {
        int sum=0;
        int count=0;     //No. of waste try
        BufferedWriter bw = null;
        
        for(int i=2;i<n;i++)
        {
            if((n%i)==0)
            {
                sum+=i;     //finding the sum of divisors
            }
            else
            {
                count++;    //checking waste loops
            }
        }
        try
        {
            if(count>0)
            {
                if(getOS().equalsIgnoreCase("Win"))
                {
                    bw = new BufferedWriter(new FileWriter("Bin\\Waste.ravs",true));
                    bw.append("Value:"+n+" Waste Loop:"+count);
                    bw.newLine();
                }

                else
                if(getOS().equalsIgnoreCase("Lin/Mac"))
                {
                    bw = new BufferedWriter(new FileWriter("Bin/Waste.ravs",true));
                    bw.append("Value:"+n+" Waste Loop:"+count);
                    bw.newLine();
                }

                else
                {
                    bw = new BufferedWriter(new FileWriter("Waste.ravs",true));
                    bw.append("Value:"+n+" Waste Loop:"+count);
                    bw.newLine();
                }
            }

            bw.close();

        }catch(Exception ex)
        {
            System.out.println("Waste function's exception: "+ex);
        }

        return sum;
    }

    public String getOS()
    {
        try
        {
            String osName= System.getProperty("os.name");
            if(osName.contains("Win"))
            {
                return "Win";
            }
            else
            {
                return "Lin/Mac";
            }
        }catch (Exception e)
        {
            return "Unknown";
        }
    }
}
