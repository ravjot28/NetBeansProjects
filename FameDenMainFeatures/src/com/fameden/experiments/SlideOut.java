/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fameden.experiments;

/**
 *
 * @author Rav
 */
import java.io.IOException;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Example of a sidebar that slides in and out of view
 */
public class SlideOut extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("Slide out demo");

        Pane pane = new Pane();

        final Pane leftPane = createSidebarContent();
        SideBar sidebar = new SideBar(250, leftPane);
        VBox.setVgrow(leftPane, Priority.ALWAYS);

        final BorderPane layout = new BorderPane();
        Pane mainPane = VBoxBuilder.create().spacing(10)
                .children(
                sidebar.getControlButton(),
                pane).build();
        layout.setLeft(sidebar);
        layout.setCenter(mainPane);

        Scene scene = new Scene(layout);
        scene.setFill(null);
        scene.getStylesheets().add(getClass().getResource("slideout.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    private Pane createSidebarContent() throws IOException {// create some content to put in the sidebar.
        /*final Text lyric = new Text();
         lyric.getStyleClass().add("lyric-text");
         final Button changeLyric = new Button("New Song");
         changeLyric.getStyleClass().add("change-lyric");
         changeLyric.setMaxWidth(Double.MAX_VALUE);
         changeLyric.setOnAction(new EventHandler<ActionEvent>() {
         int lyricIndex = 0;

         @Override
         public void handle(ActionEvent actionEvent) {
         System.out.println("Button Pressed");
         }
         });
         changeLyric.fire();
         final BorderPane lyricPane = new BorderPane();
         lyricPane.setCenter(lyric);
         lyricPane.setBottom(changeLyric);*/
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LeftPaneFXML.fxml"));
        Pane leftPane = (Pane) fxmlLoader.load();

        return leftPane;
    }

    /**
     * Animates a node on and off screen to the left.
     */
    class SideBar extends VBox {

        /**
         * @return a control button to hide and show the sidebar
         */
        public Button getControlButton() {
            return controlButton;
        }
        private final Button controlButton;

        /**
         * creates a sidebar containing a vertical alignment of the given nodes
         */
        SideBar(final double expandedWidth, Node... nodes) {
            getStyleClass().add("sidebar");
            this.setPrefWidth(expandedWidth);
            this.setMinWidth(0);

            // create a bar to hide and show.
            setAlignment(Pos.CENTER);
            getChildren().addAll(nodes);

            // create a button to hide and show the sidebar.
            controlButton = new Button("Collapse");
            controlButton.getStyleClass().add("hide-left");

            // create an animation to hide sidebar.
            final Animation hideSidebar = new Transition() {
                {
                    setCycleDuration(Duration.millis(250));
                }

                @Override
                protected void interpolate(double frac) {
                    final double curWidth = expandedWidth * (1.0 - frac);
                    setPrefWidth(curWidth);
                    setTranslateX(-expandedWidth + curWidth);
                }
            };
            hideSidebar.onFinishedProperty().set(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    setVisible(false);
                    controlButton.setText("Show");
                    controlButton.getStyleClass().remove("hide-left");
                    controlButton.getStyleClass().add("show-right");
                }
            });
            // apply the animations when the button is pressed.
            controlButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {


                    // create an animation to show a sidebar.
                    final Animation showSidebar = new Transition() {
                        {
                            setCycleDuration(Duration.millis(250));
                        }

                        @Override
                        protected void interpolate(double frac) {
                            final double curWidth = expandedWidth * frac;
                            setPrefWidth(curWidth);
                            setTranslateX(-expandedWidth + curWidth);
                        }
                    };
                    showSidebar.onFinishedProperty().set(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            controlButton.setText("Collapse");
                            controlButton.getStyleClass().add("hide-left");
                            controlButton.getStyleClass().remove("show-right");
                        }
                    });

                    if (showSidebar.statusProperty().get() == Animation.Status.STOPPED && hideSidebar.statusProperty().get() == Animation.Status.STOPPED) {
                        if (isVisible()) {
                            hideSidebar.play();
                        } else {
                            setVisible(true);
                            showSidebar.play();
                        }
                    }
                }
            });
            setVisible(false);
            controlButton.setText("Show");
            controlButton.getStyleClass().remove("hide-left");
            controlButton.getStyleClass().add("show-right");
            hideSidebar.play();
        }
    }
}