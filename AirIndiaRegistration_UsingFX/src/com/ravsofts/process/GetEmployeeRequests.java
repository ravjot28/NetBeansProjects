package com.ravsofts.process;

import com.ravsofts.sendreceievedata.getData;

public class GetEmployeeRequests
{
    public String[][] process()
    {
        getData gd = new getData("ravsoftsairindia@gmail.com","docomo3401");
        return gd.process();
    }
}
