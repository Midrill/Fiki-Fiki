package BattagliaDeiSessi;

/**
 * Created by utente on 16/05/2017.
 */
public class Spregiudicata extends Donna {    // Estende Donna che estende Umano

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
    public synchronized void figliamoAvveSpre(Uomo U) {

        // 15 = 5
        AreaAccoppiamento.futuriAvventurieri += 1;

        // -5 = 1
        AreaAccoppiamento.futuriSpregiudicate += 1;

    }

    // Morigerato e Spregiudicata
    public synchronized void figliamoMoriSpre(Uomo U) {

        // 5 = 3
        AreaAccoppiamento.futuriMorigerati += 1;

        // 5 = 3
        AreaAccoppiamento.futuriSpregiudicate += 1;
    }

    public synchronized void run() { // synchronized!

        try {
            for (int i = 0; i < AreaAccoppiamento.spregiudicate; i++) {
                this.setName(comeMiChiamo()+i);
                if (isInterrupted()) throw new InterruptedException();
                AreaAccoppiamento.coda.insert(this);
            }
        } catch (InterruptedException e) {
            //System.out.println(comeMiChiamo() + " Sono MORTA");
        }
    }


}
