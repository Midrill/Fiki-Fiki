package Prova3;

import java.awt.geom.Area;
import java.util.Random;

/**
 * Created by utente on 16/05/2017.
 */
public class Prudente extends Donna {

    // Estende Donna che estende Umano

    // dato che serve per le coppie
    protected static int costoCorteggiamento = 3; // c : costo del corteggiamento
    Random random = new Random();

    // mi restituisce il "costoCorteggiamento" (c)
    public int C() {
        return costoCorteggiamento;
    }

    // Ogni Prudente ha un Nome "PrevenutaN" dove N è il numero seriale che ogni volta viene aumentato di 1
    // private String nome = "Prudente";
    private static int numeroSeriale = 0;

    // Costruttore Base per l'oggeto
    public Prudente() {
        super("P"); // + numeroSeriale);
        numeroSeriale++;
    }

    public boolean cheDonnaSei() { // true se sono Spregiudicata, False se Prudente
        return false;
    }

    // quando chiamata dal Morigerato
    public synchronized void figliamoPrudente(Uomo U) {
        int c = random.nextInt(5);
        if (c < 2) {
            AreaAccoppiamento.futuriPrudenti++;
            AreaAccoppiamento.futuriPrudenti++;

            AreaAccoppiamento.futuriMorigerati++;
            AreaAccoppiamento.futuriMorigerati++;
        } else {
            AreaAccoppiamento.futuriPrudenti++;
            AreaAccoppiamento.futuriPrudenti++;
            AreaAccoppiamento.futuriPrudenti++;

            AreaAccoppiamento.futuriMorigerati++;
            AreaAccoppiamento.futuriMorigerati++;
            AreaAccoppiamento.futuriMorigerati++;
        }
    }

    public synchronized void figliamoPrudenteAvventurosa (Uomo U) {
        AreaAccoppiamento.futuriPrudenti++;
        AreaAccoppiamento.futuriPrudenti++;

        AreaAccoppiamento.futuriAvventurieri++;
        AreaAccoppiamento.futuriAvventurieri++;
    }
    public synchronized void run() { // synchronized!

        // this.setName(comeMiChiamo()); // il Thread prende il nome dell'oggetto

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
