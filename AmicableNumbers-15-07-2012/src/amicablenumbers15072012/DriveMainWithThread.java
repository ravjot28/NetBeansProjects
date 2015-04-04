package amicablenumbers15072012;

public class DriveMainWithThread {
    public static void main(String as[]){
        int a =1;
        int b = 50000;

        int count = b/1000;

        for(int i =1;i<count;i++){
            MainWithThread mwt = new MainWithThread(((i-1)*1000)+a,i*1000);
            Thread th = new Thread(mwt);
            th.start();
        }
    }
}
