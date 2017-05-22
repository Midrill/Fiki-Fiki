package Prova3;

import java.awt.geom.Area;
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
        super("S"); // + numeroSeriale);
        numeroSeriale++;
    }

    public boolean cheDonnaSei() { // true se sono Spregiudicata, False se Prudente
        return true;
    }

    // chiamata dall'Avventuriero che l'ha estratta dalla coda
    public synchronized void figliamoSpregiudicata(Uomo U) {
        // U.interrupt(); // interrompe il padre

        AreaAccoppiamento.futuriAvventurieri++;
        AreaAccoppiamento.futuriSpregiudicate++;

        /**if (new Random().nextInt(2) <= 1) {
            //Avventuriero A = new Avventuriero();
            //A.start();
            AreaAccoppiamento.futuriAvventurieri++;
        } else {
            //Spregiudicata B = new Spregiudicata();
            //B.start();
            AreaAccoppiamento.futuriSpregiudicate++;
        } */

    }

    // Chiama dal Prudente che l'ha estratta dalla coda
    public synchronized void figliamoSpregiudicataMaConAmore(Uomo U) {

        AreaAccoppiamento.futuriMorigerati++;
        AreaAccoppiamento.futuriSpregiudicate++;

    }

    // deve notificare gli Avventurieri
    public synchronized void run() { // synchronized!

        // this.setName(comeMiChiamo()); // il Thread prende il nome dell'oggetto

        // System.out.println("Sono natA: " + comeMiChiamo()); // mostra il nome del Thread quando nasce

        try {
            for (int i = 0; i < AreaAccoppiamento.spregiudicate; i++) {
                this.setName(comeMiChiamo()+i);

                if (isInterrupted()) throw new InterruptedException();
                AreaAccoppiamento.coda.insert(this);

                //this.interrupt();   // interrompe la donna
            }
        } catch (InterruptedException e) {
            //System.out.println(comeMiChiamo() + " Sono MORTA");

        }
    }


}
