package BattagliaDeiSessi;

/**
 * Created by utente on 16/05/2017.
 */
public class Morigerato extends Uomo {    // Estende Uomo che estende Umano

    // Ogni Morigerato ha un Nome "MorigeratoN" dove N è il numero seriale che ogni volta viene aumentato di 1
    private static int numeroSeriale = 0;

    // Costruttore Base per l'oggeto
    public Morigerato() {
        super("M"); // + numeroSeriale);
        numeroSeriale++;
    }

    public void gestoreCoppia(Donna D) {
        // System.out.println(getName() + ": ce l'ho buttato! " + D.getName()); //stampa la coppia che si è presa
        if (D.cheDonnaSei() == true) {
            D.figliamoMoriSpre(this); // Se Donna è una spregiudicata
            }
        else {
            D.figliamoMoriPrud(this); // Se Donna è una Avventurosa
            }
        }

    // Crea Thread Morigerato e aggiorna il numero dei morigerati
    public synchronized void run() {
        try {
            for (int i = 0; i < AreaAccoppiamento.morigerati; i++) {
                this.setName(comeMiChiamo()+i); // da un nome al thread (la funzione è in umano)

                if (isInterrupted()) throw new InterruptedException();
                if (!AreaAccoppiamento.coda.isEmpty()) { // se la coda non è vuota
                    Donna D = AreaAccoppiamento.coda.extract(); //estrae una donna dalla lista coda
                    gestoreCoppia(D); // accoppia il Thread corrente con la donna D estratta
                }
                else {
                    i = i-1; // mel caso non trova la donna da estrarre , torna indietro il
                             // contatore di 1 e lo fa aspettare 3
                    this.sleep(3);}
            }
        } catch (InterruptedException e) {
            // System.out.println( comeMiChiamo() + " Sono MORTO");   // stampa quando muore il Thread
        }
    }

}
