package newpackage;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NameGenerator
{
    public String[] name()
    {
        SecureRandom wheel = null;
        try {
            wheel = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(NameGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        String name[]=new String[3684];
        char[] upperCase = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        String[] surname=new String[]{"Adani","Amroliwallah","Mangesh","Manyam","Matangi","Mati","Nandakumar","Naseer","Narayan","Singh","Sethi","Pal","Kishor","Qamar","Ramanakoppa","Sen","Vaidhyanathan","Vijaykumar","Gordha","Dhaliwal","Chandrasekhar","Biswas","Emankum","Gaekwad","Hazare","Jaffrey","Indrani","Jayasurya","Kapoor","Lakhani","Madan","Nagpal","Omkar","Patel","Rabinder","Raju","Sahni","Tagore","Ullas","Verma","Yamura","Yateen","Zahin","Waman"};
                for (int i = 0; i < 3684; i++)
                {
                    int random = wheel.nextInt(upperCase.length);
                    int random1 = wheel.nextInt(upperCase.length);
                    int random3 = wheel.nextInt(surname.length);
                    name[i]=""+upperCase[random]+"."+upperCase[random1]+" "+surname[random3];
                }
        return name;
    }          
    
}