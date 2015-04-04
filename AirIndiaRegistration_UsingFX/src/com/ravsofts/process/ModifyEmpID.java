package com.ravsofts.process;

import com.ravsofts.sendreceievedata.modifyEmpID;

public class ModifyEmpID
{
    public String[] process()
    {
        modifyEmpID gd = new modifyEmpID("ravsoftsairindiaempcheck@gmail.com","docomo3401");
        return gd.process();
    }
}
