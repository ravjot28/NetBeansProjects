package sendnrecievedata;

public class GetSurveyResponse
{
    public String[][] process()
    {
        getData gd = new getData("ravmessengerstudent@gmail.com","docomo3401");
        return gd.process();
    }
}
