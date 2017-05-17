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

     //
     public void tuaMamma(Donna D) {
         System.out.println( getName() + ": mi trombo " + D.getName());
         D.figliamo();
     }

     // L'uomo toglie dalla synchrolista le donne
    public void run() {
        try {
            for (int i = 0; i < AreaAccoppiamento.tempo; i++) {
                if (isInterrupted()) throw new InterruptedException();
                sleep(new Random().nextInt(20));
                Donna animaGemella = AreaAccoppiamento.coda.extract();
                tuaMamma(animaGemella);
            }
        } catch (InterruptedException e) {
            System.out.println("GG WP EAZY");
        }
    }

}
