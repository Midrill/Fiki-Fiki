package BattagliaDeiSessi;

/**
 * Created by utente on 16/05/2017.
 */
public abstract class Donna extends Umano{

    // Eredita ed estende Umano. Sarà la base per le "Prudente" e le "Spregiudicata"

    // Costruttore Base per l'oggeto (fa da collegamento tra Umano e Spregiudicata e Prudente)
    public Donna(String nome) {
        super(nome);
    }

    // restituisce il tipo della signorina con un booleano
    public boolean cheDonnaSei () { // true se sono Spregiudicata, False se Prudente
        return true;
    }


    // Morigerato si associa a Spregiudicata
    public synchronized void figliamoMoriSpre(Uomo U) {
    }

    // Avventuriero si associa con Spregiudicata
    public synchronized void figliamoAvveSpre(Uomo U) {
    }


    // Morigerato si associa con Prudente
    public synchronized void figliamoMoriPrud(Uomo U) {
    }

    // Avventuriero si accosia con Prudente
    public synchronized void figliamoAvvePrud(Uomo U) {

    }


    // le donne si inseriscono nella synchrocoda
    public synchronized void run() { // synchronized!
        // Ho inserito il RUN in PRUDENTE e SPREGIUDICATA
    }
}
