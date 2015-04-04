package com.ravsofts.process;

import com.ravsofts.sendreceievedata.getAdmin;

public class GetAdmin
{
    public String[] process()
    {
        getAdmin gd = new getAdmin("ravsoftsairindiaadmcheck@gmail.com","docomo3401");
        return gd.process();
    }
}
