package process;

import sendnrecievedata.markData;


public class markAdminRequest
{
    public boolean mark(int a[])
    {
        markData md = new markData("ravsoftsairindiaadm@gmail.com","docomo3401",a);
        return md.process();
    }
}
