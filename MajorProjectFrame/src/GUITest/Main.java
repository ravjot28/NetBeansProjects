package GUITest;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main
{
        public boolean process1()
        {
            try
            {
                BufferedWriter b = new BufferedWriter(new FileWriter("Bin\\Data\\tags.ravs",true));
                b.close();

                BufferedWriter b1 = new BufferedWriter(new FileWriter("Bin\\Data\\totalapps.ravs",true));
                b1.close();

                return true;
            }catch(Exception as){}
            return false;
        }
}