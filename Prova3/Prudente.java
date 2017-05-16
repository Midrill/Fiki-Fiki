package Prova3;

/**
 * Created by utente on 16/05/2017.
 */
public class Prudente extends Donna {

    // Estende Donna che estende Umano

    // dato che serve per le coppie
    protected  static int costoCorteggiamento = 3; // c : costo del corteggiamento

    // mi restituisce il "costoCorteggiamento" (c)
    public int C() {
        return costoCorteggiamento;
    }

    // Ogni Prudente ha un Nome "PrevenutaN" dove N è il numero seriale che ogni volta viene aumentato di 1
    // private String nome = "Prudente";
    private static int numeroSeriale = 0;

    // Costruttore Base per l'oggeto
    public Prudente (){
        super("Prudente" + numeroSeriale);
        numeroSeriale++;
    }
}
