package Prova3;

import java.util.Random;

/**
 * Created by utente on 16/05/2017.
 */
public class Morigerato extends Uomo {

    // Estende Uomo che estende Umano

    public static int morigerati = 0;


    // Ogni Morigerato ha un Nome "MorigeratoN" dove N è il numero seriale che ogni volta viene aumentato di 1
    // private String nome = "Morigerato";
    private static int numeroSeriale = 0;

    // Costruttore Base per l'oggeto
    public Morigerato() {
        super("M" + numeroSeriale);
        numeroSeriale++;
    }

    public void gestoreCoppia(Donna D) {
        System.out.println(getName() + ": Ho scelto " + D.getName());
        if (D.cheDonnaSei() == true) {
            D.figliamoSpregiudicataMaConAmore(this); // se la coda non è vuota // c'è una donna
            }
        else {
            D.figliamoPrudente(this);
            }
        }

    // Crea Thread Morigerato e aggiorna il numero dei morigerati
    public synchronized void run() {
        morigerati++;
        this.setName(comeMiChiamo()); // il Thread prende il nome dell'oggetto

        // System.out.println("Sono natO: " + comeMiChiamo()); // mostra il nome del Thread quando nasce

        try {
            for (int i = 0; i < AreaAccoppiamento.tempo; i++) {
                if (isInterrupted()) throw new InterruptedException();
                sleep(5);
                if (!AreaAccoppiamento.coda.isEmpty()) {
                    Donna animaGemella = AreaAccoppiamento.coda.extract();
                    gestoreCoppia(animaGemella);
                }
                else { this.interrupt();}
            }
        } catch (InterruptedException e) {
            // System.out.println( comeMiChiamo() + " Sono MORTO");
        }
    }

}
