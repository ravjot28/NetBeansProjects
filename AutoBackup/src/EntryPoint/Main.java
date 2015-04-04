/*
 *  Entry point of the project calls the package related to the First Run operation
    and
    then executes the background application
 */

package EntryPoint;

import BackSupport.Cleaner;
import BackgroundApplication.ActivateSystemTrayIndicator;
import FirstRun.FirstRunFile;
import javax.swing.UIManager;

public class Main       //Entry Class from here the code begins
{
    static
    {
        try
         {
             UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");     //Loads theme
         }catch(Exception e){}
    }

    public Main(boolean t)
    {
        Cleaner.clean();
        
        FirstRunFile frf = new FirstRunFile();      //Checks the need for First Run process

            if(frf.process(t))                      //First Run process not required
            {
                //System.out.println("All Clear");
                ActivateSystemTrayIndicator ast = new ActivateSystemTrayIndicator();
                ast.process();
            }
            else                                    //First Run required or Some exception occured during First Run process
            {
                //System.out.println("Resolving Problem");
            }

        
    }

    public static void main(String arp[])       //The only public static void main in complete project
    {
        Main m = new Main(true);
    }
}
