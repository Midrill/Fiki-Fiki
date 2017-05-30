package BattagliaDeiSessi;

import java.util.Random;

/**
 * Created by utente on 16/05/2017.
 */
public class Morigerato extends Uomo {    // Estende Uomo che estende Umano

    // Percentuale delle Prudenti Atteso, rispetto alle DONNE
    static double percMori = (5.0/6.0) *100;

    // Ogni Morigerato ha un Nome "MorigeratoN" dove N è il numero seriale che ogni volta viene aumentato di 1
    private static int numeroSeriale = 0;

    // Costruttore Base per l'oggeto
    public Morigerato() {
        super("M"); // + numeroSeriale);
        numeroSeriale++;
    }

    public void morPerPrudente(Donna D) {
        // System.out.println(getName() + ": ce l'ho buttato! " + D.getName()); //stampa la coppia che si è presa
        D.figliamoMoriPrud(this); // Se Donna è una Prudnete
        }

    public void morPerSpregiudicata(Donna D) {
        D.figliamoMoriSpre(this);
    }

    // Crea Thread Morigerato e aggiorna il numero dei morigerati
    public synchronized void run() {
        try {
            this.setName(comeMiChiamo() + numeroSeriale); // da un nome al thread (la funzione è in umano)
            while (!isInterrupted()) {
                if (isInterrupted()) throw new InterruptedException();
                int C = new Random().nextInt(10); // da 0 a 9
                if (C > 5) {
                    if (!AreaAccoppiamento.codaPrudenti.isEmpty()) {
                        Donna D = AreaAccoppiamento.codaPrudenti.extract();
                        morPerPrudente(D);
                    }
                    //else if (!AreaAccoppiamento.codaSpregiudicate.isEmpty()){
                    //    Donna D = AreaAccoppiamento.codaSpregiudicate.extract();
                    //   morPerSpregiudicata(D);
                    //}
                }
                if (C <= 5) {
                    if (!AreaAccoppiamento.codaSpregiudicate.isEmpty()) {
                        Donna D = AreaAccoppiamento.codaSpregiudicate.extract();
                        morPerSpregiudicata(D);
                    } else if (!AreaAccoppiamento.codaPrudenti.isEmpty()) {
                        Donna D = AreaAccoppiamento.codaPrudenti.extract();
                        morPerPrudente(D);
                    }
                }
            }
            if (isInterrupted()) throw new InterruptedException();
        } catch (InterruptedException e) {
           // System.out.println( comeMiChiamo() + " Sono MORTO");   // stampa quando muore il Thread
        }
    }

}
