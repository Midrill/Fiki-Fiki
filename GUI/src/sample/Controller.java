package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;


// campi text utilizzati: TextField    M A P S a b c
// charts utilizzate: PieChart    MAPSStartChart    MAPSEndChart      BarChart    MChart  AChart  PChart  SChart
// pulsante utilizzato:    Button     start


/* pseudocodice dell implementazione dell handleclick
check se maps interi > 0 e abc interi
riempimento della chart iniziale e chiamata per simulazione
cambio testo bottone in "simulating"
riempimento fase by fase dei grafici di popolazione
riempimento della chart finale in base ai valori stabili ottenuti
 */



public class Controller implements Initializable {

    @FXML private TextField M;
    @FXML private TextField A;
    @FXML private TextField P;
    @FXML private TextField S;

    @FXML private TextField a;
    @FXML private TextField b;
    @FXML private TextField c;

    @FXML private Button start;

    @FXML private PieChart MAPSStartChart;
    @FXML private PieChart MAPSEndChart;

    @FXML private BarChart MChart;
    @FXML private BarChart AChart;
    @FXML private BarChart PChart;
    @FXML private BarChart SChart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Application Launched");

    }

    @FXML
    private void LaunchSimulation(int morigerati, int avventurieri, int prudenti, int spregiudicate, int a, int b, int c){
        System.out.println("Simulation started with costants: M=" + morigerati + " A=" + avventurieri + " P=" + prudenti + " S=" + spregiudicate
                + " a= " +  a + " b=" + b + " c=" + c );

        

    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    @FXML
    private void HandleClick(){
        if(Integer.parseInt( M.getText() ) > 0 & Integer.parseInt( A.getText() ) > 0 &
                Integer.parseInt( P.getText() ) > 0 & Integer.parseInt( S.getText() ) > 0 &
                isInteger(a.getText()) & isInteger(b.getText()) & isInteger(c.getText()) ){
            start.setText("Simulating");
            MAPSStartChart.getData().add(new PieChart.Data("Morigerati", Integer.parseInt( M.getText() )) );
            MAPSStartChart.getData().add(new PieChart.Data("Avventurieri", Integer.parseInt( A.getText() )) );
            MAPSStartChart.getData().add(new PieChart.Data("Prudenti", Integer.parseInt( P.getText() )) );
            MAPSStartChart.getData().add(new PieChart.Data("Spregiudicate", Integer.parseInt( S.getText() )) );

            LaunchSimulation(Integer.parseInt( M.getText() ), Integer.parseInt( A.getText() ),
                    Integer.parseInt( P.getText() ), Integer.parseInt( S.getText() ),
                    Integer.parseInt( a.getText() ), Integer.parseInt( b.getText() ), Integer.parseInt( c.getText() ) );

        }
        else{start.setText("Not Valid Data");}
    }

}
