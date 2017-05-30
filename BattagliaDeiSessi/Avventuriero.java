package BattagliaDeiSessi;

import java.util.Random;

/**
 * Created by utente on 16/05/2017.
 */
public class Avventuriero extends Uomo{    // Estende Uomo che estende Umano


    // Percentuale delle Prudenti Atteso, rispetto alle DONNE
    static double percAvve = (1.0/6.0) *100;

    // Ogni Avventuriero ha un Nome "AvventurieroN" dove N è il numero seriale che ogni volta viene aumentato di 1
    private static int numeroSeriale = 0;

    // Costruttore Base per l'oggeto
    public Avventuriero() {
        super("A"); // + numeroSeriale);
        numeroSeriale++;
    }

    public void avvPerPrudente(Donna D) throws InterruptedException {
        // System.out.println(getName() + ": Ho la ciolla allegra " + D.getName());
        D.figliamoAvvePrud(this); // Se Donna è una Prudente
    }

    public void avvPerSpregiudicata(Donna D) throws InterruptedException {
        // System.out.println(getName() + ": Ho la ciolla allegra " + D.getName());
        D.figliamoAvveSpre(this); // Se Donna è una Prudente
    }

    // Ha il proprio run poichè non deve avere la possibilità di estrarre dalla CODA Prudenti
    public synchronized void run() {
        try {
            this.setName(comeMiChiamo() + numeroSeriale++);

            for (int i = 0; i < 1; i++) {
                if (isInterrupted()) throw new InterruptedException();

                int C = new Random().nextInt(10); // da 0 a 9
                if (C <= 6) {
                    if (!AreaAccoppiamento.codaSpregiudicate.isEmpty()) {
                        Donna D = AreaAccoppiamento.codaSpregiudicate.extract();
                        avvPerSpregiudicata(D);
                    }
                }
                if (C == 9){
                    this.interrupt();
                }

                if (C > 6) {
                    if (!AreaAccoppiamento.codaSpregiudicate.isEmpty()) {
                        Donna D = AreaAccoppiamento.codaSpregiudicate.extract();
                        i = 0;
                    }
                }
            }
            this.interrupt();
            if (isInterrupted()) throw new InterruptedException();
        } catch (InterruptedException e) {
            // System.out.println(comeMiChiamo() + " Sono MORTO");
        }
    }
}

