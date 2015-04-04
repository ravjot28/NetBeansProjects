package process;

import sendnrecievedata.getAdmin;

public class GetAdmin
{
    public String[] process()
    {
        getAdmin gd = new getAdmin("ravsoftsairindiaadmcheck@gmail.com","docomo3401");
        return gd.process();
    }
}
