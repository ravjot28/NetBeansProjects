package karaoke;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialogs;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javax.jnlp.FileContents;
import javax.jnlp.FileOpenService;
import javax.jnlp.FileSaveService;
import javax.jnlp.ServiceManager;
import javax.jnlp.UnavailableServiceException;
import static karaoke.Constants.*;

public class Karaoke extends Application {

    static FileOpenService fos;
    static FileSaveService fss;

    private static synchronized void initialize() {

        try {
            fos = (FileOpenService) ServiceManager.lookup("javax.jnlp.FileOpenService");
            fss = (FileSaveService) ServiceManager.lookup("javax.jnlp.FileSaveService");
        } catch (UnavailableServiceException e) {
        }
    }

    @Override
    public void start(Stage primaryStage) throws MalformedURLException {

        initialize();

        primaryStage.setTitle("Media Player");
        Group root = new Group();
        Scene scene = new Scene(root, 540, 241);

        // create media player
        File file = new File(MEDIA_URL);
        Media media = null;
        try {
            if (file.exists()) {

                System.out.println("FILE EXISTS");
                media = new Media(file.toURI().toURL().toExternalForm());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setAutoPlay(false);
                MediaControl mediaControl = new MediaControl(mediaPlayer);
                scene.setRoot(mediaControl);

                primaryStage.setScene(scene);
                primaryStage.show();
            } else {
                Dialogs.showErrorDialog(null, null, "Instrumental file not found. Please contact the administrator.", "ERROR");
            }
        } catch (Exception e) {
            System.out.println("FILE DOES NOT EXIST");
            //FileChooser fileChooser = new FileChooser();

            //Set extension filter
            //FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("MP3 files (*.mp3)", "*.mp3");
            //fileChooser.getExtensionFilters().add(extFilter);

            //Show open file dialog
            //file = fileChooser.showOpenDialog(null);
            //String url = "http://mp3crow.mobi/dl/aHR0cDovL2FwaS5zb3VuZGNsb3VkLmNvbS90cmFja3MvNjg4ODI2OTUvc3RyZWFtP2NsaWVudF9pZD1mZmEwYzc5YmY4YWVkYzBkOWIwYmIwNzQyNzhjZjI1MQ==yFRzUi1GcmVzaCAmIFNjcmF0Y2gtRCBvZiBEeW5hbWl4IElJIC0gUm9ja2luIHRvIHRoZSBCZWF0IHRoYXQgaXMgc28gRnJlc2hoaGhoaGho.mp3";
            //media = new Media(file.toURI().toURL().toExternalForm());
            //MediaPlayer mediaPlayer = new MediaPlayer(media);
            //mediaPlayer.setAutoPlay(false);
            //MediaControl mediaControl = new MediaControl(mediaPlayer);
            //scene.setRoot(mediaControl);

            String content = open();

            
            root.getChildren().add(new Button(content));

            primaryStage.setScene(scene);
            primaryStage.show();
            //Dialogs.showErrorDialog(null, null, "Instrumental file not found. Please contact the administrator.", "ERROR");
        }

    }

    private String open() {
        try {
            FileContents fc = fos.openFileDialog(null, null);
            return readFromFile(fc);
        } catch (IOException ioe) {
            ioe.printStackTrace(System.out);
            return null;
        }
    }
    
    private static String readFromFile(FileContents fc) throws IOException {
        if (fc == null) {
            return null;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(fc.getInputStream()));
        StringBuffer sb = new StringBuffer((int) fc.getLength());
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        br.close();
        return sb.toString();
    }
    
     private static void writeToFile(String txt, FileContents fc) throws IOException {
        int sizeNeeded = txt.length() * 2;
        if (sizeNeeded > fc.getMaxLength()) {
            fc.setMaxLength(sizeNeeded);
        }
        BufferedWriter os = new BufferedWriter(new OutputStreamWriter(fc.getOutputStream(true)));
        os.write(txt);
        os.close();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
