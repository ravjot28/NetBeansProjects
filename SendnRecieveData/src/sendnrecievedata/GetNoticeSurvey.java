package sendnrecievedata;

public class GetNoticeSurvey
{
    public String[][] process()
    {
        getData gd = new getData("ravmessenger@gmail.com","docomo3401");
        return gd.process();
    }
}
