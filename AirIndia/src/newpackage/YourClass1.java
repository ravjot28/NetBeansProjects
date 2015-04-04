package newpackage;
import java.io.*;

public class YourClass1
{

  public static void main(String aArgs[])
  {
        new YourClass1();
  }
  YourClass1()
    {
      String empid[]=new empid().getempid();
        String name[]=new NameGenerator().name();
        String dob[]=new dob().getdate();
        String doj[]=new doj().getdate();
      for(int pq=1;pq<=7;pq++)
      {
      
        int a=0;
        try
                {
                    BufferedWriter bb=new BufferedWriter(new FileWriter("20100"+pq+".txt"));
                    bb.append("00000000000000000020100"+pq+"4");
                    bb.newLine();
        for(int i=1;i<=6;i++)
        {
            for(int j=a;j<a+614;j++)
            {
                if(name[j].length()<20)
                {
                    name[j]=name[j]+space(20-name[j].length());
                }
                
                    bb.append(i+"8000662"+empid[j]+"1"+"   "+name[j]+"110720611070010920101110229002M00000000000701019734          00000000000000000000000000000000000000000     00000{00000{000000000012203200000000063779400000000001200000038165000228290031739000000000000M00000");
                    bb.newLine();
                    bb.append(i+"8000662"+empid[j]+"2"+"001001675000300213560180006310040000030005400022701000000945129000072513300003501390000800151001690015200014301530036062158000270018000007001980136147");
                    bb.newLine();
                    bb.append(i+"8000662"+empid[j]+"3"+"0010004038027000650003600001880670000100093000062009500000101510012788152000038317600009221970136147");
                    bb.newLine();
                
            }
            a=a+614;
        }
                    bb.close();
                    }catch(Exception sdf){}
        
      }
        try
        {
            BufferedWriter bbb=new BufferedWriter(new FileWriter("dob-doj.txt"));
            for(int i=0;i<3684;i++)
            {
                bbb.append(empid[i]+"  "+dob[i]+"  "+doj[i]+" 0500");
                bbb.newLine();
            }
            bbb.close();
        }catch(Exception xzc){}

    }

  String space(int a)
    {
      String p="";
      for(int i=0;i<a;i++)
      {
          p+=" ";
      }
      return p;
  }

}

