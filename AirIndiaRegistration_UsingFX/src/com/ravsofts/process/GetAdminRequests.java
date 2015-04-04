package com.ravsofts.process;

import com.ravsofts.sendreceievedata.getData;

public class GetAdminRequests
{
    public String[][] process()
    {
        getData gd = new getData("ravsoftsairindiaadm@gmail.com","docomo3401");
        return gd.process();
    }
}
