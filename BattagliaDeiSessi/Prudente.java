package BattagliaDeiSessi;

/**
 * Created by utente on 16/05/2017.
 */
public class Prudente extends Donna {

    // Estende Donna che estende Umano

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
    public synchronized void figliamoMoriPrud(Uomo U) {

        AreaAccoppiamento.futuriPrudenti += 1;


        AreaAccoppiamento.futuriMorigerati += 1;
    }

    // Avventuriero associato a Prudente
    public synchronized void figliamoAvvePrud(Uomo U) {
        AreaAccoppiamento.futuriPrudenti += 1;

        AreaAccoppiamento.futuriAvventurieri += 1;
    }
    public synchronized void run() { // synchronized!
        try {
            for (int i = 0; i < AreaAccoppiamento.prudenti; i++) {
                this.setName(comeMiChiamo()+i);

                if (isInterrupted()) throw new InterruptedException();

                AreaAccoppiamento.coda.insert(this);
            }
        } catch (InterruptedException e) {
            //System.out.println(comeMiChiamo() + " Sono MORTA");
        }
    }

}
