package sample;

import SessoSenzaThread.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;


// campi text utilizzati: TextField    M A P S
//                                     a b c
// charts utilizzate:
// PieChart    MAPSStartChart
//             MAPSEndChart
// BarChart    MChart    MyAxis (Number)    MxAxis (Number)
//             AChart    AyAxis (Number)    AxAxis (Number)
//             PChart    PyAxis (Number)    PxAxis (Number)
//             SChart    SyAxis (Number)    SxAxis (Number)
//             *yAxis indica la % della popolazione
//             *xAxis indica lo stadio nel quale si e presentata
// pulsante utilizzato:
// Button      start


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

    @FXML private BarChart<String, Number> MChart;
    @FXML private BarChart<String, Number> AChart;
    @FXML private BarChart<String, Number> PChart;
    @FXML private BarChart<String, Number> SChart;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Application Launched");

    }

    @FXML
    private double[] LaunchSimulation(int morigerati, int avventurieri, int prudenti, int spregiudicate, int a, int b, int c){
        System.out.println("Simulation started with costants: M=" + morigerati + " A=" + avventurieri + " P=" + prudenti + " S=" + spregiudicate
                + " a= " +  a + " b=" + b + " c=" + c );
        Accoppiamento acc = new Accoppiamento(morigerati, avventurieri, prudenti, spregiudicate, a, b, c);
        acc.centroAccoppiamento();
        double[] evolution = acc.stampaArray();
        return evolution;

    }

    private static boolean isInteger(String s) {
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
        int Mvar = Integer.parseInt( M.getText() );
        int Avar = Integer.parseInt( A.getText() );
        int Pvar = Integer.parseInt( P.getText() );
        int Svar = Integer.parseInt( S.getText() );
        int total = Mvar + Avar + Pvar + Svar;
        if(Mvar > 0 & Avar > 0 & Pvar > 0 & Svar > 0 &
                isInteger(a.getText()) & isInteger(b.getText()) & isInteger(c.getText()) ){
            start.setText("Simulating");
            MAPSStartChart.getData().add(new PieChart.Data("Morigerati", Integer.parseInt( M.getText() )) );
            MAPSStartChart.getData().add(new PieChart.Data("Avventurieri", Integer.parseInt( A.getText() )) );
            MAPSStartChart.getData().add(new PieChart.Data("Prudenti", Integer.parseInt( P.getText() )) );
            MAPSStartChart.getData().add(new PieChart.Data("Spregiudicate", Integer.parseInt( S.getText() )) );
            XYChart.Series zeroMserie = new XYChart.Series();
            XYChart.Series zeroAserie = new XYChart.Series();
            XYChart.Series zeroPserie = new XYChart.Series();
            XYChart.Series zeroSserie = new XYChart.Series();
            zeroMserie.getData().add(new XYChart.Data( "0", Mvar*100/total ) );
            zeroAserie.getData().add(new XYChart.Data( "0", Avar*100/total ) );
            zeroPserie.getData().add(new XYChart.Data( "0", Pvar*100/total ) );
            zeroSserie.getData().add(new XYChart.Data( "0", Svar*100/total ) );
            MChart.getData().add(zeroMserie);
            AChart.getData().add(zeroAserie);
            PChart.getData().add(zeroPserie);
            SChart.getData().add(zeroSserie);


            double[] evolution = LaunchSimulation(Integer.parseInt( M.getText() ), Integer.parseInt( A.getText() ),
                    Integer.parseInt( P.getText() ), Integer.parseInt( S.getText() ),
                    Integer.parseInt( a.getText() ), Integer.parseInt( b.getText() ), Integer.parseInt( c.getText() ) );
            for(int index = 0; index < evolution.length; index = index + 4 ){
                if(index == evolution.length - 4){
                    MAPSEndChart.getData().add(new PieChart.Data("Morigerati", evolution[index] * 100) );
                    MAPSEndChart.getData().add(new PieChart.Data("Avventurieri", evolution[index + 1] * 100) );
                    MAPSEndChart.getData().add(new PieChart.Data("Prudenti", evolution[index + 2] * 100) );
                    MAPSEndChart.getData().add(new PieChart.Data("Spregiudicate", evolution[index + 3] * 100 ) );
                }
                XYChart.Series Mserie = new XYChart.Series();
                XYChart.Series Aserie = new XYChart.Series();
                XYChart.Series Pserie = new XYChart.Series();
                XYChart.Series Sserie = new XYChart.Series();
                Mserie.getData().add(new XYChart.Data( new Integer(index/4 + 1).toString(), evolution[index] * 100  ) );
                Aserie.getData().add(new XYChart.Data( new Integer(index/4 + 1).toString(), evolution[index + 1] * 100 ) );
                Pserie.getData().add(new XYChart.Data( new Integer(index/4 + 1).toString(), evolution[index + 2] * 100 ) );
                Sserie.getData().add(new XYChart.Data( new Integer(index/4 + 1).toString(), evolution[index + 3] * 100 ) );
                MChart.getData().add(Mserie);
                AChart.getData().add(Aserie);
                PChart.getData().add(Pserie);
                SChart.getData().add(Sserie);
            }


        }
        else{start.setText("Not Valid Data");}
    }

    @FXML
    private void HandleClick2(){
        MAPSStartChart.getData().clear();
        MAPSEndChart.getData().clear();
        MChart.getData().clear();
        AChart.getData().clear();
        PChart.getData().clear();
        SChart.getData().clear();
        System.out.println("Data Removed");
    }

}
