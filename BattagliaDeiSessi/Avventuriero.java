package BattagliaDeiSessi;

/**
 * Created by utente on 16/05/2017.
 */
public class Avventuriero extends Uomo{    // Estende Uomo che estende Umano

    // Ogni Avventuriero ha un Nome "AvventurieroN" dove N è il numero seriale che ogni volta viene aumentato di 1
    private static int numeroSeriale = 0;

    // Costruttore Base per l'oggeto
    public Avventuriero() {
        super("A"); // + numeroSeriale);
        numeroSeriale++;
    }

    public void gestoreCoppia(Donna D) throws InterruptedException {
        // System.out.println(getName() + ": Ho la ciolla allegra " + D.getName());
        if (D.cheDonnaSei() == true) {
            D.figliamoAvveSpre(this); // Se Donna è una spregiudicata
        }
        else {
            D.figliamoAvvePrud(this); // Se Donna è una Avventurosa
        }

    }

    // Ha il proprio run poichè non deve avere la possibilità di estrarre dalla CODA Prudenti
    public synchronized void run() {
        try {
            for (int i = 0; i < AreaAccoppiamento.avventurieri; i++) {
                this.setName(comeMiChiamo()+i);

                if (isInterrupted()) throw new InterruptedException();
                if (!AreaAccoppiamento.coda.isEmpty()) {
                    Donna D = AreaAccoppiamento.coda.extract();
                    gestoreCoppia(D);
                }
                else {
                    i = i-1;
                    this.sleep(3);
                }
            }
        } catch (InterruptedException e) {
        }
    }
}

