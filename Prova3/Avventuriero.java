package Prova3;

import java.util.Random;

/**
 * Created by utente on 16/05/2017.
 */
public class Avventuriero extends Uomo{

    // Estende Uomo che estende Umano

    // Ogni Avventuriero ha un Nome "AvventurieroN" dove N è il numero seriale che ogni volta viene aumentato di 1
    // private String name = "Avventuriero";
    private static int numeroSeriale = 0;

    // Costruttore Base per l'oggeto
    public Avventuriero() {
        super("A" + numeroSeriale);
        numeroSeriale++;
        // this.beneficioFiglio = beneficioFiglio;
        // this.costoFIglio = costoFIglio;
        // this.nascita = nascita;
        // this.quantoVivo = quantoVivo;
    }

    /**
    public void tuaMamma(Donna D) {
        if (new Random().nextInt(20) <= 15){
            System.out.println(getName() + ": mi trombo " + D.getName());
            D.figliamoSpregiudicata();
            D.interrupt();
            this.interrupt();

        }
        else {
            D.interrupt();
            this.interrupt();
        }
    } */

}
