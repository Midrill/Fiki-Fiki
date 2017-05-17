package Prova3;



/**
 * Created by utente on 16/05/2017.
 */
public class Umano extends Thread {

    // i dati della tabella che ogni individuo ha in comune senza un valore assegnato
    protected  static int beneficioFiglio = 15;     // a : premio per il successo nella generazione di figli
    protected  static int costoFIglio = 20;         // b : costo del crescere figli
//  si trova solo nelle prudente poichè solo con loro si utilizza questa variabile
//  protected  static int costoCorteggiamento = 3; // c : costo del corteggiamento


    //la "generazione" di nascita e quante "generazioni" vive prima di morire
    public int nascita = 0;
    protected int quantoVivo = 1;

     public String nome = "" ;

    // costruttore degli "Umani" è il super costruttore
    protected Umano (String nome) {
        this.nome = nome;
        this.beneficioFiglio = beneficioFiglio;
        this.costoFIglio = costoFIglio;
        this.nascita = nascita;
        this.quantoVivo = quantoVivo;
    }

    // mi restituisce "beneficioFiglio" (a)
    public int A() { return beneficioFiglio; }

    // mi restituisce "costoFiglio" (b)
    public int B() { return costoFIglio; }

    // restitisce il Nome dell'oggetto
    public String comeMiChiamo() { return this.nome; }

    // Ho inserito il RUN in UOMO e DONNA

    // Qui si descrive cosa fa il THREAD quando viene lanciato
    public synchronized void run(){
    }

}