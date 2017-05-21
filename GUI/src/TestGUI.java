import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;


/**
 * Created by Silver on 21/05/2017.
 */
public class TestGUI extends Application {
    public static void main(String[] args){
        launch(args);
    }



    @Override
    public void start(Stage stage){
        Rectangle r = new Rectangle(40, 20, 200, 80);
        // Rettangolo in (40, 20)
        Ellipse e = new Ellipse(120, 70, 80, 60);
        // Ellisse con centro (120, 70)
        e.setFill(Color.rgb(0, 51, 153));
        Group root = new Group(r, e);
        Scene scene = new Scene(root, 400, 200);
        // La radice del grafo di scena
        scene.setFill(Color.rgb(184, 180, 125));
        // Colore di background della scena
        stage.setScene(scene);
        // La scena della finestra
        stage.show();
        // Rende visibile la finestra (o stage) principale

    }




}
