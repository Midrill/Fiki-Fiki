package Prova3;

/**
 * Created by utente on 14/05/2017.
 */
public class AreaAccoppiamento { // Dove si incontrano bulli e pupe
    public static final int tempo = 10; // numero massimo di incontri

    // generazione 0
    public static  int morigerati = 1000;
    public static  int avventurieri = 1000;

    public static  int prudenti = 1000;
    public static  int spregiudicate = 1000;

    // Generazione futura
    public static  int futuriMorigerati = 0;
    public static  int futuriAvventurieri = 0;

    public static  int futuriPrudenti = 0;
    public static  int futuriSpregiudicate = 0;

    public static SynchroCoda<Donna> coda = new SynchroCoda<>(); // Coda delle donne

    public static void waitFor(long millis) {
        long time = System.currentTimeMillis();
        while (System.currentTimeMillis() - time < millis) ;
    }
}