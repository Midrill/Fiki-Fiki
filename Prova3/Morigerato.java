package Prova3;

import java.util.Random;

/**
 * Created by utente on 16/05/2017.
 */
public class Morigerato extends Uomo {

    // Estende Uomo che estende Umano

    // Ogni Morigerato ha un Nome "MorigeratoN" dove N è il numero seriale che ogni volta viene aumentato di 1
    // private String nome = "Morigerato";
    private static int numeroSeriale = 0;

    // Costruttore Base per l'oggeto
    public Morigerato() {
        super("M" + numeroSeriale);
        numeroSeriale++;
    }

    /**
    public void tuaMamma(Donna D) {
        if (new Random().nextInt(20) <= 15) {
            System.out.println(getName() + ": mi trombo " + D.getName());
            D.figliamoPrudente();
            D.interrupt();
            this.interrupt();
        }
        else{
            D.interrupt();
            this.interrupt();
        }

    } */
}
