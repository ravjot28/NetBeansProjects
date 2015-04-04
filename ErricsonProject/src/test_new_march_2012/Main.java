package test_new_march_2012;

public class Main {

    public static void main(String as[]){
        apg_ssh a = new apg_ssh("MSSIND4");
        Thread t = new Thread(a);
        t.start();
    }
}
