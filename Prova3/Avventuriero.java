package Prova3;

import java.util.Random;

/**
 * Created by utente on 16/05/2017.
 */
public class Avventuriero extends Uomo{

    // Estende Uomo che estende Umano

    public static int avventurieri = 0;


    // Ogni Avventuriero ha un Nome "AvventurieroN" dove N è il numero seriale che ogni volta viene aumentato di 1
    // private String name = "Avventuriero";
    private static int numeroSeriale = 0;

    // Costruttore Base per l'oggeto
    public Avventuriero() {
        super("A"); // + numeroSeriale);
        numeroSeriale++;
    }

    public void gestoreCoppia(Donna D) throws InterruptedException {
       // System.out.println(getName() + ": Ho la ciolla allegra " + D.getName());
        D.figliamoSpregiudicata(this);
    }

    // Ha il proprio run poichè non deve avere la possibilità di estrarre dalla CODA Prudenti
    public synchronized void run() {
        avventurieri++;

        //this.setName(comeMiChiamo()); // il Thread prende il nome dell'oggetto

        // System.out.println("Sono natO: " + comeMiChiamo()); // mostra il nome del Thread quando nasce

        try {
            for (int i = 0; i < AreaAccoppiamento.avventurieri; i++) {
                this.setName(comeMiChiamo()+i);

                if (isInterrupted()) throw new InterruptedException();
                // sleep(5);
                if (!AreaAccoppiamento.coda.isEmpty()) {
                    Donna D = AreaAccoppiamento.coda.extract();
                    if (D.cheDonnaSei()) {  // se lo donna è Spregiudicata
                        gestoreCoppia(D);
                    }
                    else {
                        i= i-1;
                        AreaAccoppiamento.coda.insert(D);
                        this.sleep(5);}
                }
                else { this.sleep(5);}
            }
        } catch (InterruptedException e) {
            // System.out.println( comeMiChiamo() + " Sono MORTO");

        }
    }
}

