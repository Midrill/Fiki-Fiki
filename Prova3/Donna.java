package Prova3;

/**
 * Created by utente on 16/05/2017.
 */
public abstract class Donna extends Umano{

    // Eredita ed estende Umano. Sarà la base per le "Prudente" e le "Spregiudicata"

    // Costruttore Base per l'oggeto (fa da collegamento tra Umano e Spregiudicata e Prudente)
    public Donna(String nome) {
        super(nome);
    }
}
