package Prova3;

/**
 * Created by utente on 14/05/2017.
 */
public class AreaAccoppiamento { // Dove si incontrano bulli e pupe
    public static final int tempo = 20; // numero massimo di incontri al ballo
    public static SynchroCoda<Donna> coda = new SynchroCoda<>(); // ...in attesa di bullo
}