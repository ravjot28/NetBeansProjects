/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 *
 * @author Ravjot
 */
public class SideBarRight extends VBox {
    /** @return a control button to hide and show the sidebar */
    public Button getControlButton() { return controlButton; }
    private final Button controlButton;

    /** creates a side bar containing a vertical alignment of the given nodes */
    public SideBarRight(final double expandedWidth, Node... nodes) {
      getStyleClass().add("sidebar");
      this.setPrefWidth(expandedWidth);

      // create a bar to hide and show.
      setAlignment(Pos.CENTER);
      getChildren().addAll(nodes);

      // create a button to hide and show the sidebar.
      controlButton = new Button("Collapse");
      controlButton.getStyleClass().add("hide-left");

      // apply the animations when the button is pressed.
      controlButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent actionEvent) {
          // create an animation to hide sidebar.
          final Animation hideSidebar = new Transition() {
            { setCycleDuration(Duration.millis(350)); }
            protected void interpolate(double frac) {
              final double curWidth = expandedWidth * (1.0 - frac);
              setPrefWidth(curWidth);
              //setTranslateX(-expandedWidth + curWidth);
              setTranslateX(expandedWidth - curWidth);
            }
          };
          hideSidebar.onFinishedProperty().set(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
              setVisible(false);
              controlButton.setText("Show");
              controlButton.getStyleClass().remove("hide-left");
              controlButton.getStyleClass().add("show-right");
            }
          });
  
          // create an animation to show a sidebar.
          final Animation showSidebar = new Transition() {
            { setCycleDuration(Duration.millis(350)); }
            protected void interpolate(double frac) {
              final double curWidth = expandedWidth * frac;
              setPrefWidth(curWidth);
              //setTranslateX(-expandedWidth + curWidth);
              setTranslateX(expandedWidth - curWidth);
            }
          };
          showSidebar.onFinishedProperty().set(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
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
  }
