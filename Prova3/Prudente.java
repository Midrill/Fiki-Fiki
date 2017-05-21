package Prova3;

import java.awt.geom.Area;
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
        super("P"); // + numeroSeriale);
        numeroSeriale++;
    }

    public boolean cheDonnaSei () { // true se sono Spregiudicata, False se Prudente
        return false;
    }

    // quando chiamata dal Morigerato
    public synchronized void figliamoPrudente(Uomo U) {
        // U.interrupt(); // interrompe il padre
        AreaAccoppiamento.futuriPrudenti++;
        AreaAccoppiamento.futuriMorigerati++;

       /** for (int i = 0; i < new Random().nextInt(6); i++) {
            if (new Random().nextInt(2) == 1) {
                //Morigerato M = new Morigerato();
                //M.start();
                AreaAccoppiamento.futuriMorigerati++;
            } else {
                //Prudente P = new Prudente();
                //P.start();
                AreaAccoppiamento.futuriPrudenti++;
            }
        } */
    }
    public synchronized void run() { // synchronized!
        prudenti++;
        this.setName(comeMiChiamo()); // il Thread prende il nome dell'oggetto

        // System.out.println("Sono natA: " + comeMiChiamo()); // mostra il nome del Thread quando nasce

        try {
            for (int i = 0; i < AreaAccoppiamento.prudenti; i++) {
                this.setName(comeMiChiamo()+i);

                if (isInterrupted()) throw new InterruptedException();
                AreaAccoppiamento.coda.insert(this);
                // this.interrupt();   // interrompe la donna
            }
        } catch (InterruptedException e) {
            //System.out.println(comeMiChiamo() + " Sono MORTA");


        }
    }

}
