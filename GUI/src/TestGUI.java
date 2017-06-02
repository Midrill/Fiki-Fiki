import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
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


        // creazione della finestra di immissione dati
        Text t1 = new Text("Fiki-Fiki Simulator");
        VBox vb = new VBox(t1);
        vb.setAlignment(Pos.TOP_LEFT);
        Text textm = new Text("Numero Morigerati");
        Text texta = new Text("Numero Avventurieri");
        Text textp = new Text("Numero Prudenti");
        Text texts = new Text("Numero Spregiudicate");
        HBox hb = new HBox(textm, texta, textp, texts);
        hb.setAlignment(Pos.BOTTOM_CENTER);
        hb.setSpacing(50);

        // creazione della finestra di simulazione
        Rectangle graphic = new Rectangle(0, 0, 600, 400);
        graphic.setFill(Color.rgb(0, 83, 255));
        // allocazione di area in alto sx per disegnare i grafici

        Rectangle chart = new Rectangle(0, 400, 600, 200);
        chart.setFill(Color.rgb(255, 34, 54));
        // allocazione di area per i grafici a torta

        Rectangle data = new Rectangle(600, 0, 200, 600);
        data.setFill(Color.grayRgb(0));
        // allocazione di area per i print delle variazioni nello stadio

        Group simulation = new Group(graphic, chart, data); // gruppo di oggetti di simulazione
        Group menu = new Group(vb, hb); // gruppo di oggetti del menu iniziale

        Scene simulationscene = new Scene(simulation, 800, 600);
        simulationscene.setFill(Color.grayRgb(255));
        // creazione di scena contenente oggetti simulazione

        Scene menuscene = new Scene(menu, 800, 600);
        menuscene.setFill(Color.grayRgb(255));
        // creazione di scena contenente oggetti menu

        stage.setScene(menuscene);
        // inizialmente verra mostrata la finestra di menu per immissione dati

        stage.show();
        // Rende visibile la finestra (o stage) principale








    }




}
