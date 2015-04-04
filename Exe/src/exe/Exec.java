package exe;
public class Exec
{
    //static String WIN_PROGRAMFILES = System.getenv("programfiles");
    //static String FILE_SEPARATOR   = System.getProperty("file.separator");

    public static void main(String[] args) throws Exception {
    Runtime rt= Runtime.getRuntime();
Process p= rt.exec("cmd /c start winword.exe \"E:\\SSI ENGG SELECTION ORDER.doc\"");
    }
}
