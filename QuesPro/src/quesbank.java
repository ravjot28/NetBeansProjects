import java.io.*;

public class quesbank
{
    String in[]=new String[9];
    String file="Files/ques.txt";
    static int count=0;
    static int c=0;
    public quesbank(String name,String phone,String phone1,String[] info)
    {
        in=info;
        String data;
        String q[]=new String[len()];
        String temp=null;
        try
        {
            BufferedReader b=new BufferedReader(new FileReader(file));
            data=b.readLine();
            while(data!=null)
            {
                if((count%5)==0)
                {
                   temp=temp+data;
                   q[c]=temp;
                   c++;
                   temp=null;
                    count=0;
                }
                else
                {
                    if(temp==null)
                    {
                        temp=data+"$";
                    }
                    else
                    {
                        temp=temp+data+"$";
                    }
                   
                    
                }
                data=b.readLine();
                count++;
            }
            b.close();
        }catch(Exception e)
        {

        }
        new Frames(q,len(),name,phone,phone1,in);
    }

    public int len()
    {
        int l=0;
        String data;
         try
        {
            BufferedReader b=new BufferedReader(new FileReader(file));
            data=b.readLine();
            while(data!=null)
            {
                if(count==4)
                {
                    count=0;
                    l++;
                }
                else
                {
                    count++;
                }
                data=b.readLine();
            }
        }catch(Exception e)
        {

        }
        return l;
    }

}
