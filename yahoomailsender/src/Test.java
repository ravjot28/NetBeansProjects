
public class Test
{
    public static void main(String asdp[])
    {
        String fr= "ravjot_28@yahoo.co.in";
        String msg = "Hi";
        String sub = "Testing yahoo sending";
        String[] fro={"ravjot28@gmail.com"};
        String p="archanaewfadsfdsafadwfsfwa71";
        sendingyahoo s = new sendingyahoo(fr,msg,sub,fro,p);
        System.out.println(s.send());
        /*String fr= "ravjot28@rediffmail.com";
        String msg = "Hi";
        String sub = "Testing yahoo sending";
        String[] fro={"ravjot28@gmail.com"};
        String p="docomo708";
        sendinghotmail s = new sendinghotmail(fr,msg,sub,fro,p);
        System.out.println(s.send());*/
    }
}
