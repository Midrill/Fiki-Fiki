package Prova3;

import java.util.Random;

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
     public void tuaMamma(Donna D) {
         System.out.println(getName() + ": mi trombo " + D.getName());
         if (!AreaAccoppiamento.coda.isEmpty()) D.figliamoSpregiudicata(this); // se la coda non è vuota // c'è una donna
         else this.interrupt();  // non ci arriva e quindi non si interrompe
     }



     // L'uomo toglie dalla synchrolista le donne
    public synchronized void run() {
        this.setName(comeMiChiamo()); // il Thread prende il nome dell'oggetto

       // System.out.println("Sono natO: " + comeMiChiamo()); // mostra il nome del Thread quando nasce

        try {
            for (int i = 0; i < AreaAccoppiamento.tempo; i++) {
                if (isInterrupted()) throw new InterruptedException();
                sleep(20);
                Donna animaGemella = AreaAccoppiamento.coda.extract();
                tuaMamma(animaGemella);
            }
        } catch (InterruptedException e) {
            // System.out.println( comeMiChiamo() + " Sono MORTO");
        }
    }

}
