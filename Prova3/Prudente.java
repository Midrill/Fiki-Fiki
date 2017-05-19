package Prova3;

import java.util.Random;

/**
 * Created by utente on 16/05/2017.
 */
public class Prudente extends Donna {

    // Estende Donna che estende Umano

    public static int prudenti = 0;

    // dato che serve per le coppie
    protected  static int costoCorteggiamento = 3; // c : costo del corteggiamento

    // mi restituisce il "costoCorteggiamento" (c)
    public int C() {
        return costoCorteggiamento;
    }

    // Ogni Prudente ha un Nome "PrevenutaN" dove N è il numero seriale che ogni volta viene aumentato di 1
    // private String nome = "Prudente";
    private static int numeroSeriale = 0;

    // Costruttore Base per l'oggeto
    public Prudente (){
        super("P" + numeroSeriale);
        numeroSeriale++;
    }

    public boolean cheDonnaSei () { // true se sono Spregiudicata, False se Prudente
        return false;
    }

    // quando chiamata dal Morigerato
    public synchronized void figliamoPrudente(Uomo U) {
        U.interrupt(); // interrompe il padre
        for (int i = 0; i < new Random().nextInt(6); i++) {
            if (new Random().nextInt(2) == 1) {
                Morigerato M = new Morigerato();
                M.start();
            } else {
                Prudente P = new Prudente();
                P.start();
            }
        }
    }
    public synchronized void run() { // synchronized!
        prudenti++;
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
