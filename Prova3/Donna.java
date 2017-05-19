package Prova3;

import java.util.Random;

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
    public synchronized void figliamoSpregiudicataMaConAmore(Uomo U) {
    }

    // Morigerato si associa con Prudente
    public synchronized void figliamoPrudente(Uomo U) {
        /**
        Avventuriero A = new Avventuriero();
        Spregiudicata B = new Spregiudicata();
        B.start();
        A.start();
        notify();
        */
    }

    // Avventuriero si associa con Spregiudicata
    public synchronized void figliamoSpregiudicata(Uomo U) {
    /**   U.interrupt(); // interrompe il padre
        if (new Random().nextInt(20) <= 10) {
            Avventuriero A = new Avventuriero();
            // notifyAll();
            // this.interrupt();
            A.start();
            // A.interrupt();
        }
        else {
            Spregiudicata B = new Spregiudicata();
            // notifyAll();
            // this.interrupt();
            B.start();
           // B.interrupt(); // non le da abbastanza tempo per mettersi nella lista
        }
     */
    }

    // le donne si inseriscono nella synchrocoda
    public synchronized void run() { // synchronized!
        this.setName(comeMiChiamo()); // il Thread prende il nome dell'oggetto

        // System.out.println("Sono natA: " + comeMiChiamo()); // mostra il nome del Thread quando nasce

        try {
            for (int i = 0; i < AreaAccoppiamento.tempo; i++) {
                if (isInterrupted()) throw new InterruptedException();
                sleep(5);
                AreaAccoppiamento.coda.insert(this);
               // wait();
                this.interrupt();   // interrompe la donna
               //  System.out.println("Me l'ha buttato");
            }
        } catch (InterruptedException e) {
             //System.out.println(comeMiChiamo() + " Sono MORTA");
        }
    }
}
