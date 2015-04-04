package process;

import sendnrecievedata.modifyAdmin;

public class ModifyAdmin
{
    public String[] process()
    {
        modifyAdmin gd = new modifyAdmin("ravsoftsairindiaadmcheck@gmail.com","docomo3401");
        return gd.process();
    }
}
