public class Base64Decoder
{
    String result="";
    String result1="";
    Base64Decoder(String b64)
    {
        for(int i=0;i<b64.length();i++)
        {
            int aa=getbase64(""+b64.charAt(i));
            D2B p=new D2B(aa);
            String a=p.by();
            String aaa=a.substring(2);
            result=result+aaa;
        }
        int ii=0;
        for(int i=0;i<(result.length()/8);i++)
        {
            String rav=result.substring(ii, ii+8);
            B2D as=new B2D(rav);
            String ass=as.re();
            int ass1=Integer.parseInt(ass);
            char a=(char)ass1;
            result1=result1+a;
            ii=ii+8;
        }

    }

    public String get()
    {
        return result1;
    }

    public int getbase64(String f)
    {
        int aa=0;
        if(f.equals("A"))
        {
            return 0;
        }
        else
            if(f.equals("B"))
        {
            return 1;
        }else
            if(f.equals("C"))
        {
return 2;
        }else
            if(f.equals("D"))
        {
return 3;
        }else
            if(f.equals("E"))
        {
return 4;
        }else
            if(f.equals("F"))
        {
return 5;
        }else
            if(f.equals("G"))
        {
return 6;
        }else
            if(f.equals("H"))
        {
return 7;
        }else
            if(f.equals("I"))
        {
return 8;
        }else
            if(f.equals("J"))
        {
return 9;
        }else
            if(f.equals("K"))
        {
return 10;
        }else
            if(f.equals("L"))
        {
return 11;
        }else
            if(f.equals("M"))
        {
return 12;
        }else
            if(f.equals("N"))
        {
return 13;
        }else
            if(f.equals("O"))
        {
return 14;
        }else
            if(f.equals("P"))
        {
return 15;
        }else
            if(f.equals("Q"))
        {
return 16;
        }else
            if(f.equals("R"))
        {
return 17;
        }else
            if(f.equals("S"))
        {
return 18;
        }else
            if(f.equals("T"))
        {
return 19;
        }else
            if(f.equals("U"))
        {
return 20;
        }else
            if(f.equals("V"))
        {
return 21;
        }else
            if(f.equals("W"))
        {
return 22;
        }else
            if(f.equals("X"))
        {
return 23;
        }else
            if(f.equals("Y"))
        {
return 24;
        }else
            if(f.equals("Z"))
        {
return 25;
        }else
            if(f.equals("a"))
        {
return 26;
        }else
            if(f.equals("b"))
        {
return 27;
        }else
            if(f.equals("c"))
        {
return 28;
        }else
            if(f.equals("d"))
        {
return 29;
        }else
            if(f.equals("e"))
        {
return 30;
        }else
            if(f.equals("f"))
        {
return 31;
        }else
            if(f.equals("g"))
        {
return 32;
        }else
            if(f.equals("h"))
        {
return 33;
        }else
            if(f.equals("i"))
        {
return 34;
        }else
            if(f.equals("j"))
        {
return 35;
        }else
            if(f.equals("k"))
        {
return 36;
        }else
            if(f.equals("l"))
        {
return 37;
        }else
            if(f.equals("m"))
        {
return 38;
        }else
            if(f.equals("n"))
        {
return 39;
        }else
            if(f.equals("o"))
        {
return 40;
        }else
            if(f.equals("p"))
        {
return 41;
        }else
            if(f.equals("q"))
        {
return 42;
        }else
            if(f.equals("r"))
        {
return 43;
        }else
            if(f.equals("s"))
        {
return 44;
        }else
            if(f.equals("t"))
        {
return 45;
        }else
            if(f.equals("u"))
        {
return 46;
        }else
            if(f.equals("v"))
        {
return 47;
        }else
            if(f.equals("w"))
        {
return 48;
        }else
            if(f.equals("x"))
        {
return 49;
        }else
            if(f.equals("y"))
        {
return 50;
        }else
            if(f.equals("z"))
        {
return 51;
        }else
            if(f.equals("0"))
        {
return 52;
        }else
            if(f.equals("1"))
        {
return 53;
        }else
            if(f.equals("2"))
        {
return 54;
        }else
            if(f.equals("3"))
        {
return 55;
        }else
            if(f.equals("4"))
        {
return 56;
        }else
            if(f.equals("5"))
        {
                return 57;


        }else
            if(f.equals("6"))
        {
return 58;
        }else
            if(f.equals("7"))
        {
return 59;
        }else
            if(f.equals("8"))
        {
return 60;
        }else
            if(f.equals("9"))
        {
return 61;
        }else
            if(f.equals("+"))
        {
return 62;
        }else
            if(f.equals("/"))
        {
return 63;
        }else
            if(f.equals("="))
        {
return 0;
        }
        return aa;
    }
}
