package process;

import sendnrecievedata.getData;

public class GetEmployeeRequests
{
    public String[][] process()
    {
        getData gd = new getData("ravsoftsairindia@gmail.com","docomo3401");
        return gd.process();
    }
}
