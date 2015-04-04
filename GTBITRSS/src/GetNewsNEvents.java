public class GetNewsNEvents
{
    GTBITWebsiteNews gwn;
    GTBITWebsiteEvents gwe;

    String events[];
    String news[];

    public GetNewsNEvents()
    {
         gwe = new GTBITWebsiteEvents("http://www.gtbit.org");
         gwn = new GTBITWebsiteNews("http://www.gtbit.org");
    }

    public String[] getNews()
    {
        return this.news = gwn.getNews();
        
    }

    public String[] getEvents()
    {
        return this.events = gwe.getEvents();

    }
}
