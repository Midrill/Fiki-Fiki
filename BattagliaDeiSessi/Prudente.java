package BattagliaDeiSessi;

import java.util.Random;

/**
 * Created by utente on 16/05/2017.
 */
public class Prudente extends Donna {

    // Estende Donna che estende Umano

    // Percentuale delle Prudenti Atteso, rispetto alle DONNE
    static double percPrud = (5.0/8.0) *100;

    // dato che serve per le coppie
    protected static int costoCorteggiamento = 3; // c : costo del corteggiamento

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

    // Morigerato e Prudente
    public  void figliamoMoriPrud(Uomo U) {
        if (new Random().nextInt(2) == 1) {
            AreaAccoppiamento.futuriMorigerati += 5;
            AreaAccoppiamento.futuriPrudenti += 5;
        }
        U.interrupt();
    }

    // Avventuriero associato a Prudente
    public void figliamoAvvePrud(Uomo U) {
        AreaAccoppiamento.futuriAvventurieri += 2;
        AreaAccoppiamento.futuriPrudenti += 2;
        U.interrupt();
    }
    public synchronized void run() { // synchronized!
        try {
            this.setName(comeMiChiamo() + numeroSeriale++);
            while (!isInterrupted()) {
                if (isInterrupted()) throw new InterruptedException();


                AreaAccoppiamento.codaPrudenti.insert(this);
                this.interrupt();
                // notifyAll();
            }
            if (isInterrupted()) throw new InterruptedException();
        } catch (InterruptedException e) {
            // System.out.println(comeMiChiamo() + " Sono MORTA");
        }
    }

}
