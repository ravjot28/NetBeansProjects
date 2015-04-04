package process;

import sendnrecievedata.markData;


public class markEmployeeRequest
{
    public boolean mark(int a[])
    {
        markData md = new markData("ravsoftsairindia@gmail.com","docomo3401",a);
        return md.process();
    }
}
