public class NewClass
{
    public static void  main(String ar[])
    {
        int i=0;
        for(i=0;i<10000;i++)
        {
            if(i==500)
            {
                System.out.println("Wait for 1 sec");
                new Wait().oneSec();
            }
            else
                if(i==999)
                {
                    System.out.println("Wait for many sec");
                    new Wait().manySec(1000000);
                }
            System.out.println("Value of i-->"+i);

        }
    }

}
