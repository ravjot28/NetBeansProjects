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

public class SlideOut extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("Slide out demo");

        Pane pane = createMainContent();

        final Pane leftPane = createSidebarContent();
        SideBar sidebar = new SideBar(250, leftPane);
        sidebar.init();
        VBox.setVgrow(leftPane, Priority.ALWAYS);

        final BorderPane layout = new BorderPane();
        Pane mainPane = VBoxBuilder.create().spacing(10)
                .children(
                sidebar.getControlButton(),
                pane).build();
        layout.setLeft(sidebar);
        layout.setCenter(mainPane);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("slideout.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    private Pane createSidebarContent() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LeftPaneFXML.fxml"));
        Pane leftPane = (Pane) fxmlLoader.load();

        return leftPane;
    }

    private Pane createMainContent() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainFXML.fxml"));
        Pane leftPane = (Pane) fxmlLoader.load();
        return leftPane;
    }

    class SideBar extends VBox {

        private final Animation hideSidebar;

        public Button getControlButton() {
            return controlButton;
        }
        private final Button controlButton;

        SideBar(final double expandedWidth, Node... nodes) {
            getStyleClass().add("sidebar");
            this.setPrefWidth(expandedWidth);
            this.setMinWidth(0);


            setAlignment(Pos.CENTER);
            getChildren().addAll(nodes);


            controlButton = new Button("Collapse");
            controlButton.getStyleClass().add("hide-left");


            hideSidebar = new Transition() {
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

            controlButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {

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
        }

        public void init() {
            setVisible(false);
            controlButton.setText("Show");
            controlButton.getStyleClass().remove("hide-left");
            controlButton.getStyleClass().add("show-right");
            hideSidebar.play();
        }
    }
}