package com.ravsofts.process;

import com.ravsofts.sendreceievedata.getAllData;

public class GetAllEmployeeRequest
{
    public String[][] process()
    {
        getAllData gd = new getAllData("amebenevolent@gmail.com","guru1111");
        return gd.process();
    }
}
