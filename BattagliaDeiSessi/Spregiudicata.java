package BattagliaDeiSessi;

import java.util.Random;

/**
 * Created by utente on 16/05/2017.
 */
public class Spregiudicata extends Donna {    // Estende Donna che estende Umano

    // Percentuale delle Prudenti Atteso, rispetto alle DONNE
    static double percSpre = (3/8)*100;


    // Ogni Spregiudicata ha un Nome "SpregiudicataN" dove N è il numero seriale che ogni volta viene aumentato di 1
    private static int numeroSeriale = 0;

    // Costruttore Base per l'oggeto
    public Spregiudicata() {
        super("S"); // + numeroSeriale);
        numeroSeriale++;
    }

    public boolean cheDonnaSei() { // true se sono Spregiudicata, False se Prudente
        return true;
    }  // ritorna True se Spregiudicata e Flase se Prudente

    // Avventuriero e Spregiudicata
    public void figliamoAvveSpre(Uomo U) {
        AreaAccoppiamento.futuriAvventurieri += 2;
        AreaAccoppiamento.futuriSpregiudicate += 2;

        U.interrupt();
    }


    // Morigerato e Spregiudicata
    public void figliamoMoriSpre(Uomo U) {
        AreaAccoppiamento.futuriMorigerati += 2;
        AreaAccoppiamento.futuriSpregiudicate += 2;
        U.interrupt();
    }

    public synchronized void run() { // synchronized!
        try {
            this.setName(comeMiChiamo() + numeroSeriale++);
            while (!isInterrupted()) {
                if (isInterrupted()) throw new InterruptedException();


                AreaAccoppiamento.codaSpregiudicate.insert(this);
                this.interrupt();
                // notifyAll();
            }
            if (isInterrupted()) throw new InterruptedException();
        } catch (InterruptedException e) {
           // System.out.println(comeMiChiamo() + " Sono MORTA");
        }
    }


}
