/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fameden;

import com.ravsofts.fxml.ScreenController;
import com.ravsofts.util.SideBarLeft;
import com.ravsofts.util.SideBarRight;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author Ravjot
 */
public class FameDen extends Application {

    private static final String[] lyrics = {
        "And in the end,\nthe love you take,\nis equal to\nthe love\nyou make.",
        "She came in through\nthe bathroom window\nprotected by\na silver\nspoon.",
        "I've got to admit\nit's getting better,\nA little better\nall the time."
    };
    private static final String[] locs = {
        "http://www.youtube.com/watch?v=osAA8q86COY&feature=player_detailpage#t=367s",
        "http://www.youtube.com/watch?v=IM2Ttov_zR0&feature=player_detailpage#t=30s",
        "https://www.facebook.com"//"http://www.youtube.com/watch?v=Jk0dBZ1meio&feature=player_detailpage#t=25s",
    };
    WebView webView;

    @Override
    public void start(Stage stage) {

        ScreenController screenController = new ScreenController();
        screenController.loadScreen("sideBar", "SideBar.fxml");
        Node s = screenController.getNodeScreen("sideBar");
        SideBarRight sidebarright = new SideBarRight(250, s);
        SideBarLeft sidebarleft = new SideBarLeft(250, s);

        webView = new WebView();
        webView.setPrefSize(800, 600);

        final BorderPane layout = new BorderPane();
        Pane mainPane = VBoxBuilder.create().spacing(10)
                .children(
                sidebarleft.getControlButton(),
                webView).build();
        layout.setLeft(sidebarleft);
        //layout.setRight(sidebarright);
        layout.setCenter(mainPane);


        Group root = new Group();
        root.getChildren().addAll(layout);
        root.autosize();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("slideout.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Yo Yo Honey Singh");
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
