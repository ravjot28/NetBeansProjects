

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RisenFallofPower 
{
    BufferedReader b ;
    public void process(int n,int k)
    {
        System.out.println("n = "+n+"   k = "+k);
        
        int digit = (""+n).length() -1;

        double n1 = n/(Math.pow(10, digit));

        double d1 = Math.log(n1);

        int d = (int) (digit * Math.log(10));

        double result = Math.exp(d1+d);

        System.out.println(d1+"    "+d+"\n"+result);
        
       // String result = ""+Math.round(Math.exp((n*Math.log(n))));       //Computing the value of n^n

        //result = result.substring(0,k)+" "+result.substring(result.length()-(k));       //providing k digits from beginning and end of the result

        //printValue(result);
    }

    public void printValue(String result)
    {
        System.out.println(result);

        try
        {
            b = new BufferedReader(new FileReader("asdfasdsad"));
        }catch(Exception asdwsada){}
        finally{
            try {
                b.close();
            } catch (IOException ex) {
                Logger.getLogger(RisenFallofPower.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String ar[])
    {
        java.util.Scanner s = new java.util.Scanner(System.in);     //For input

        int t = s.nextInt();

        int nkarray[][] = new int[t][2];
        for(int i=0;i<t;i++)
        {
            s = new java.util.Scanner(System.in);     //For input
            String nk = s.nextLine().trim();
            StringTokenizer st = new StringTokenizer(nk," ");
            nkarray[i][0] = Integer.parseInt(st.nextToken());
            nkarray[i][1] = Integer.parseInt(st.nextToken());
        }

        RisenFallofPower p = new RisenFallofPower();
        for(int i=0;i<t;i++)
            p.process(nkarray[i][0], nkarray[i][1]);
    }
}
