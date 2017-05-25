package BattagliaDeiSessi;

/**
 * Created by utente on 16/05/2017.
 */
public abstract class Uomo extends Umano {

    // Eredita ed estende Umano. Sarà la base per i "Morigerato" e gli "Avventuriero"

    // Costruttore Base per l'oggeto (fa da collegamento tra Umano e Morigerato e Avventuriero)
     public Uomo(String nome){
         super(nome);
     }

    // metodo che viene eredidato dai figli
     public void gestoreCoppia(Donna D) throws InterruptedException {
         // Implementata in Morigerato e in Avventuriero in modo da gestire ogni caso separatamente
     }

     // L'uomo toglie dalla synchrolista le donne
    public synchronized void run() {
         // Ho inserito il RUN in MORIGERATO e AVVENTURIERO
    }

}
