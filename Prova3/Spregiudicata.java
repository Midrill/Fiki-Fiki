package Prova3;

import java.util.Random;

/**
 * Created by utente on 16/05/2017.
 */
public class Spregiudicata extends Donna {

    // Estende Donna che estende Umano

    // Ogni Spregiudicata ha un Nome "SpregiudicataN" dove N è il numero seriale che ogni volta viene aumentato di 1
    // private String nome = "Spregiudicata";
    private static int numeroSeriale = 0;

    // Costruttore Base per l'oggeto
    public Spregiudicata() {
        super("S" + numeroSeriale);
        numeroSeriale++;
    }

    /**
    public synchronized void figliamoSpregiudicata() {

        if (new Random().nextInt(20) <= 10) {
            Avventuriero A = new Avventuriero();
            notifyAll();
            this.interrupt();
            A.start();

        }
        else {
            Spregiudicata B = new Spregiudicata();
            notifyAll();
            this.interrupt();
            B.start();
        }
    } */
}
