import java.security.SecureRandom;

public class p
{

    public static void main(String[] ar) throws Exception 
    {
        System.out.print("\"");
        for(int j=0;j<100;j++)
        {
        String args[]={"-n","11"};
        int passLength = 0;
        SecureRandom wheel = SecureRandom.getInstance("SHA1PRNG");

        char[] lowerCase = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] upperCase = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] numeric = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

        char[] printableAscii = new char[]{'!', '\"', '#', '$', '%', '(', ')', '*', '+', '-', '.', '/', '\'',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ':', '<', '=', '>', '?', '@',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '[', '\\', ']', '^', '_', '`', '{', '|', '}', '~',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        char[] alphaNumberic = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};


        if (args.length == 2) {
            if (args[0].equals("-l")) {
                passLength = Integer.parseInt(args[1]);
                for (int i = 0; i < passLength; i++) {
                    int random = wheel.nextInt(lowerCase.length);
                    System.out.print(lowerCase[random]);
                }
            } else if (args[0].equals("-u")) {
                passLength = Integer.parseInt(args[1]);
                for (int i = 0; i < passLength; i++) {
                    int random = wheel.nextInt(upperCase.length);
                    System.out.print(upperCase[random]);
                }
            } else if (args[0].equals("-n")) {
                passLength = Integer.parseInt(args[1]);
                for (int i = 0; i < passLength; i++) {
                    int random = wheel.nextInt(numeric.length);
                    System.out.print(numeric[random]);
                }
            } else if (args[0].equals("-a")) {
                passLength = Integer.parseInt(args[1]);
                for (int i = 0; i < passLength; i++) {
                    int random = wheel.nextInt(alphaNumberic.length);
                    System.out.print(alphaNumberic[random]);
                }
            } else if (args[0].equals("-p")) {
                passLength = Integer.parseInt(args[1]);
                for (int i = 0; i < passLength; i++) {
                    int random = wheel.nextInt(printableAscii.length);
                    System.out.print(printableAscii[random]);
                }
            }
            System.out.print("\",\"");
        } 
        }
    }
}