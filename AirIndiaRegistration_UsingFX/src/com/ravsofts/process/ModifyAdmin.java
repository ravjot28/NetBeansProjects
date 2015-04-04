package com.ravsofts.process;

import com.ravsofts.sendreceievedata.modifyAdmin;

public class ModifyAdmin
{
    public String[] process()
    {
        modifyAdmin gd = new modifyAdmin("ravsoftsairindiaadmcheck@gmail.com","docomo3401");
        return gd.process();
    }
}
