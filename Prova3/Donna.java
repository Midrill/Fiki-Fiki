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

    //
    public synchronized void figliamo() {
        notify();
    }

    // le donne si inseriscono nella synchrocoda
    public synchronized void run() { // synchronized!
        try {
            for (int i = 0; i < AreaAccoppiamento.tempo; i++) {
                if (isInterrupted()) throw new InterruptedException();
                sleep(new Random().nextInt(20));
                AreaAccoppiamento.coda.insert(this);
                wait();
                System.out.println("Me l'ha buttato");
            }
        } catch (InterruptedException e) {
            System.out.println("Donne Roll out!");
        }
    }
}
