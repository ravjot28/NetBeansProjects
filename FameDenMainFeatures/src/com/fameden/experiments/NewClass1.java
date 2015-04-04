/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fameden.experiments;

/**
 *
 * @author ravjotsingh
 */
import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewClass1 extends Application {

  @Override
  public void start(Stage stage) {
    Group g = new Group();
    final Scene scene = new Scene(g, 300, 250);
    scene.setFill(null);

    Light.Spot light = new Light.Spot();
    light.setX(0);
    light.setY(100);
    light.setZ(50);
    light.setPointsAtX(400);
    light.setPointsAtY(0);
    light.setPointsAtZ(0);
    light.setSpecularExponent(2);

    Lighting l = new Lighting();
    l.setLight(light);
    l.setSurfaceScale(5.0);

    Text t = new Text();
    t.setText("Spot");
    t.setFill(Color.RED);
    t.setFont(Font.font(null, FontWeight.BOLD, 90));
    t.setX(10.0);
    t.setY(10.0);
    t.setTextOrigin(VPos.TOP);

    t.setEffect(l);

    Rectangle r = new Rectangle();
    r.setFill(Color.BLACK);


    g.getChildren().add(r);
    g.getChildren().add(t);

    r.setWidth(t.getLayoutBounds().getWidth() + 30);
    r.setHeight(t.getLayoutBounds().getHeight() + 20);

    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}