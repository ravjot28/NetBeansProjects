package Main;

import Support.StopWatch;

public class Test_Main {
    public Test_Main(int initial,int last){
        DS d = new DS(initial,last);
        StopWatch s = new StopWatch();
        s.start();
        new Process().test(initial,last,d);
        //Process.begin(initial,last,d);
        s.stop();
        System.out.println("Main Approach:"+s.getElapsedTime());
    }
}
