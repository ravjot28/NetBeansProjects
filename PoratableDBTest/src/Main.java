import Support.SendCommand;

public class Main {

    public static void main(String args[]){
        SendCommand s = new SendCommand("insert into login values ('ravjot','9876')");
        s.process();
        /*GetCommand g = new GetCommand();
        String st[] = g.process();
        if(st != null){
            for(String temp:st)
                new DBOperation(temp).process();
        }*/
    }
}
