package Prova3;

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
        super("Morigerato" + numeroSeriale);
        numeroSeriale++;
    }
}
