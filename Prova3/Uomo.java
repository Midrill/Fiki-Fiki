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

    // metodo che viene eredidato dai figli
     public void gestoreCoppia(Donna D) throws InterruptedException {
     }



     // L'uomo toglie dalla synchrolista le donne
    public synchronized void run() {
        this.setName(comeMiChiamo()); // il Thread prende il nome dell'oggetto

        // System.out.println("Sono natO: " + comeMiChiamo()); // mostra il nome del Thread quando nasce

        try {
            for (int i = 0; i < AreaAccoppiamento.tempo; i++) {
                if (isInterrupted()) throw new InterruptedException();
                sleep(5);
                if (!AreaAccoppiamento.coda.isEmpty()) {
                    Donna animaGemella = AreaAccoppiamento.coda.extract();
                    gestoreCoppia(animaGemella);
                }
                else { this.interrupt();}
            }
        } catch (InterruptedException e) {
            // System.out.println( comeMiChiamo() + " Sono MORTO");
        }
    }

}
