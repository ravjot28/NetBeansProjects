package com.ravsofts.sendreceievedata;

public class SendEmployeeRequest
{
    private String subject;
    private String body;

    public SendEmployeeRequest(String heading,String data)
    {
        this.subject = heading;
        this.body = data;
    }

    public boolean process()
    {
        String to[] = {"ravsoftsairindia@gmail.com"};
        sending sm = new sending("ravsoftsairindia@gmail.com","docomo3401",subject,body,to);
        /*String to[] = {"ravjot28@gmail.com"};
        sending sm = new sending("ravjot28@gmail.com","rypsqvmaxpbtflgf",subject,body,to);*/
        return sm.send();
    }
}
