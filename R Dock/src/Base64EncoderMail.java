public class Base64EncoderMail
{
    String result="";
    String result1="";
    Base64EncoderMail(String a)
    {
        for(int i=0;i<a.length();i++)
        {
            char c = a.charAt(i);
            int j = (int) c;
            D2BMail bb=new D2BMail(j);
            String r=bb.by();
            result=result+r;
        }
        if((result.length()%6)!=0)
        {
            while((result.length()%6)!=0)
            {
                result=result+"00000000";
            }
        }
        if((result.length()%6)==0)
        {
            int rav=0;
            String temp="";
            while(rav<result.length())
            {
                for(int r=rav;r<rav+6;r++)
                {
                    temp=temp+result.charAt(r);
                }
                B2DMail as=new B2DMail(temp);
                String t=as.re();
                int f=Integer.parseInt(t);
                char aa=getbase64(f);
                 if((12>=(result.length()-rav))&&(f==0))
                {
                    result1=result1+"=";
                }
                 else
                 {
                    result1=result1+aa;
                 }
                temp="";
                rav=rav+6;
            }
        }


    }

    public String get()
    {
        return result1;
    }

    public char getbase64(int f)
    {
        char aa='a';
        switch(f)
        {
            case 0:aa='A';
                break;
                case 1:aa='B';
                break;
                case 2:aa='C';
                break;
                case 3:aa='D';
                break;
                case 4:aa='E';
                break;
                case 5:aa='F';
                break;
                case 6:aa='G';
                break;
                case 7:aa='H';
                break;
                case 8:aa='I';
                break;
                case 9:aa='J';
                break;
                case 10:aa='K';
                break;
                case 11:aa='L';
                break;
                case 12:aa='M';
                break;
                case 13:aa='N';
                break;
                case 14:aa='O';
                break;
                case 15:aa='P';
                break;
                case 16:aa='Q';
                break;
                case 17:aa='R';
                break;
                case 18:aa='S';
                break;
                case 19:aa='T';
                break;
                case 20:aa='U';
                break;
                case 21:aa='V';
                break;
                case 22:aa='W';
                break;
                case 23:aa='X';
                break;
                case 24:aa='Y';
                break;
                case 25:aa='Z';
                break;
                case 26:aa='a';
                break;
                case 27:aa='b';
                break;
                case 28:aa='c';
                break;
                case 29:aa='d';
                break;
                case 30:aa='e';
                break;
                case 31:aa='f';
                break;
                case 32:aa='g';
                break;
                case 33:aa='h';
                break;
                case 34:aa='i';
                break;
                case 35:aa='j';
                break;
                case 36:aa='k';
                break;
                case 37:aa='l';
                break;
                case 38:aa='m';
                break;
                case 39:aa='n';
                break;
                case 40:aa='o';
                break;
                case 41:aa='p';
                break;
                case 42:aa='q';
                break;
                case 43:aa='r';
                break;
                case 44:aa='s';
                break;
                case 45:aa='t';
                break;
                case 46:aa='u';
                break;
                case 47:aa='v';
                break;
                case 48:aa='w';
                break;
                case 49:aa='x';
                break;
                case 50:aa='y';
                break;
                case 51:aa='z';
                break;
                case 52:aa='0';
                break;
                case 53:aa='1';
                break;
                case 54:aa='2';
                break;
                case 55:aa='3';
                break;
                case 56:aa='4';
                break;
                case 57:aa='5';
                break;
                case 58:aa='6';
                break;
                case 59:aa='7';
                break;
                case 60:aa='8';
                break;
                case 61:aa='9';
                break;
                case 62:aa='+';
                break;
            case 63:aa='/';
                break;
            default :break;

        }

        return aa;
    }
}
