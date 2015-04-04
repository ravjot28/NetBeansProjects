/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Ravjot
 */
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ParallelTransitionTest extends Application
{
    public static void main( String[] args )
    {
        launch( args );
    }

    @Override
    public void start( Stage primaryStage ) throws Exception
    {
        init( primaryStage );
        primaryStage.show();
    }

    private void init( Stage primaryStage )
    {
        primaryStage.setTitle( "Parallel Transition" );
        primaryStage.setResizable( true );

        // Create the scene
        BorderPane root = new BorderPane();
        Scene scene = new Scene( root, 800, 600, true );
        scene.setFill( Color.BLACK );
        primaryStage.setScene( scene );

        Rectangle rect = RectangleBuilder.create()
                .width( 100 ).height( 100 )
                .x( 350 ).y( 250 )
                .fill( Color.BLUE )
                .build();

        RotateTransition rotationY = new RotateTransition();
        rotationY.setAxis( Rotate.Y_AXIS );
        rotationY.setDuration( Duration.seconds( 5 ) );
        rotationY.setByAngle( 360 );
        rotationY.setNode( rect );
        rotationY.setAutoReverse( true );
        rotationY.setCycleCount( Animation.INDEFINITE );

        RotateTransition rotationX = new RotateTransition();
        rotationX.setAxis( Rotate.X_AXIS );
        rotationX.setDuration( Duration.seconds( 5 ) );
        rotationX.setByAngle( 360 );
        rotationX.setNode( rect );
        rotationX.setAutoReverse( true );
        rotationX.setCycleCount( Animation.INDEFINITE );

        FadeTransition fade = new FadeTransition();
        fade.setDuration( Duration.seconds( 5 ) );
        fade.setToValue( 0.2 );
        fade.setNode( rect );
        fade.setAutoReverse( true );
        fade.setCycleCount( Animation.INDEFINITE );

        ParallelTransition transition = new ParallelTransition( rect,
                rotationX, rotationY, fade );
        transition.setAutoReverse( true );
        transition.play();

        root.getChildren().add( rect );
    }
}