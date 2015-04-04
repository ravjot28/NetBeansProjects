package process;

import sendnrecievedata.getEmpID;

public class GetEmpID
{
    public String[] process()
    {
        getEmpID gd = new getEmpID("ravsoftsairindiaempcheck@gmail.com","docomo3401");
        return gd.process();
    }
}
