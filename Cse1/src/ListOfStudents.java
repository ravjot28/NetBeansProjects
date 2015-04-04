public class ListOfStudents
{

    String students[][] = new String[63][2];

    String enrollno;

    public ListOfStudents()
    {
        String stu[] = {"Chetan JB Singh","Chitwan Singh","Harpreet Singh","Prabhjot Singh","Jaipreet Singh","Ramandeep Singh Soni","Jandeep Singh"
                ,"Amrita Kaur","Guryash Kaur Bahra","Gagandeep Singh","Guneet Singh","Tajinder Singh","Mandeep Singh"
                ,"Rajanpreet Singh Sidhu","Sharanbir Kaur","Harmeet Singh","Jaspreet Singh","Pawandeep Singh","Baljeet Singh"
                ,"Jasleen Kaur Lamba","Kushalpreet Kaur","Rajvinder Singh Rai","Simranpreet Kaur","Bhavleen Kaur Anand ","Jaspreet Singh"
                ,"Bishneet Kaur","Harjot Singh","Maneeet Singh Kohli","Gurdeep Singh","Gaganmeet Kaur Awal","Nupur Kaur Kohli","Ivneet Kaur"
                ,"Tanpreet Singh Vasudev","Bhuwan Deep Singh","Jasmeen Kaur","Amrit Pal Singh","Amanjot Singh","Jasneet Singh Puri"
                ,"Manmeet Singh","Harman Singh","Abhijit Singh","Bandeep Singh","Sukhmeet Singh Khokha","Jagmeet Singh Bhatia","Harshdeep Singh Mendiratta"
                ,"Karanjot Singh Bhasin","Jayant Singh","Harneet Singh Nanda","Hardrisht Singh Chawla","Jatinpreet Singh","Gundeep Singh  Bhamra"
                ,"Vishavjit Singh","Ravjot Singh","Amandeep Singh","Anamdeep Singh","Guneet Walia","Ashmeet Singh Manocha","Bisret Narula"
                ,"Gurjeet Singh","Amandeep Kaur","Jasmeet Singh","Ribhu Bholowalia","Jasminder Singh"};

        String en[] = {"0041322707","0051322707","0061322707","0081322707","0091322707","0101322707","0111322707","0121322707","0131322707","0141322707"
                ,"0151322707","0161322707","0171322707","0191322707","0201322707","0211322707","0221322707","0231322707","0241322707","0251322707"
                ,"0261322707","0271322707","0281322707","0291322707","0301322707","0311322707","0321322707","0331322707","0341322707","0351322707"
                ,"0361322707","0371322707","0381322707","0391322707","0401322707","0411322707","0421322707","0431322707","0441322707","0451322707"
                ,"0461322707","0471322707","0481322707","0491322707","0501322707","0511322707","0521322707","0531322707","0541322707","0551322707"
                ,"0571322707","0581322707","0591322707","0601322707","0611322707","0621322707","0641322707","0011327208","0021327208","0031327208","0041327208"
                ,"0061327208","0071327208"};

        for(int i=0;i<en.length;i++)
        {
            students[i][0] = en[i];
            students[i][1] = stu[i];
        }
    }

    public boolean check(String e)
    {
        for(int i=0;i<students.length;i++)
            if(students[i][0].trim().equalsIgnoreCase(e))
                return true;
        return false;
    }

    public void setData(String e)
    {
        this.enrollno = e;
    }

    public String[] getData()
    {
        if(check(enrollno))
        {
            String data[] = new String[62];
            int count=0;
            for(int i=0;i<students.length;i++)
            {
                if(!students[i][0].trim().equalsIgnoreCase(enrollno.trim()))
                {
                    data[count] = (students[i][1]);
                    count++;
                }
            }
            return data;
        }
        else
        {
            String data[] = new String[63];
            for(int i=0;i<students.length;i++)
                    data[i] = (students[i][1]);
            return data;
        }
    }
}
