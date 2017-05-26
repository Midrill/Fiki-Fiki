package BattagliaDeiSessi;



/**
 * Created by utente on 16/05/2017.
 */
public abstract class Umano extends Thread {

    // i dati della tabella che ogni individuo ha in comune senza un valore assegnato
    protected  static int beneficioFiglio = 15;     // a : premio per il successo nella generazione di figli
    protected  static int costoFIglio = 20;         // b : costo del crescere figli
//  si trova solo nelle prudente poichè solo con loro si utilizza questa variabile
//  protected  static int costoCorteggiamento = 3; // c : costo del corteggiamento

     public String nome = "" ;

    // costruttore degli "Umani" è il super costruttore
    protected Umano (String nome) {
        this.nome = nome;
        this.beneficioFiglio = beneficioFiglio;     // per ora non servono a nulla, non guardatele
        this.costoFIglio = costoFIglio;             // per ora non servono a nulla, non guardatele
    }

    // mi restituisce "beneficioFiglio" (a)
    public int A() { return beneficioFiglio; }

    // mi restituisce "costoFiglio" (b)
    public int B() { return costoFIglio; }

    // restitisce il Nome dell'oggetto
    public String comeMiChiamo() { return this.nome; }

    // Qui si descrive cosa fa il THREAD quando viene lanciato
    public synchronized void run(){
        // Ho inserito il RUN in UOMO e DONNA
    }

}