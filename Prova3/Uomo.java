package Prova3;

/**
 * Created by utente on 16/05/2017.
 */
public abstract class Uomo extends Umano {

    // Eredita ed estende Umano. Sarà la base per i "Morigerato" e gli "Avventuriero"

    // Costruttore Base per l'oggeto (fa da collegamento tra Umano e Morigerato e Avventuriero)
     public Uomo(String nome){
         super(nome);
     }
}
