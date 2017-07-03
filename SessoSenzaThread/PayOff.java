package SessoSenzaThread;

import BattagliaDeiSessi.Morigerato;
import BattagliaDeiSessi.Spregiudicata;

/**
 * Created by utente on 06/06/2017.
 */
public class PayOff {
    private static int beneficioFiglio;        // a : premio per il successo nella generazione di figli
    private static float costoFiglio;            // b : costo del crescere figli
    private static int costoCorteggiamento ;   // c : costo del corteggiamento

    // Costruttore inizializzo, senza variabile utilizzo DAWKINS sennò li scelgo io
    public PayOff() {
        this.beneficioFiglio = 15;
        this.costoFiglio = 20;
        this.costoCorteggiamento = 3;
    }

    // Costruttore del Payoff con valori scelti in modo arbitrario
    public PayOff(int a, int b, int c) {
        beneficioFiglio = a;
        costoFiglio = b;
        costoCorteggiamento = c;
    }

    // stampa i valori a schermo
    public void stampa() {
        System.out.println("Beneficio figlio = " + beneficioFiglio);
        System.out.println("Costo Figlio = " + costoFiglio);
        System.out.println("Costo Corteggiamento = " + costoCorteggiamento);
    }


    // Morigerato
    public static float payOffMorigeratoPerPrudente(){return beneficioFiglio -costoFiglio/2 -costoCorteggiamento;}
    public static float payOffMorigeratoPerSpregiudicata(){return beneficioFiglio - costoFiglio/2;}


    // Avventuriero
    public static float payOffAvventurieroPerPrudente(){return 0;} // Cotrollare se c'è una formula che fa venire 0
    public static float payOffAvventurieroPerSpregiudicata(){return beneficioFiglio;}

    // Prudente
    public static float payOffPrudentePerMorigerato(){return beneficioFiglio - costoFiglio/2 -costoCorteggiamento;}
    public static float payOffPrudentePerAvventuriero(){return 0;} // Cotrollare se c'è una formula che fa venire 0


    // Spregiudicata
    public static float payOffSpregiudicataPerMorigerato(){return beneficioFiglio - costoFiglio/2;}
    public static float payOffSpregiudicataPerAvvemturiero(){return beneficioFiglio - costoFiglio;}


    //    Esempio con a=15, b=20, c = 3
    //    ##### M ########## A ########
    //    P  (2 , 2)      (0 , 0)
    //    #############################
    //    S  (5 , 5)     (-5 , 15)


    // Stampa i Valori dei Payoff sottoforma di Griglia
    public void payOffASchermo(){
        System.out.println("##### M ########## A ########");
        System.out.println("P  ("+ payOffPrudentePerMorigerato() +" , "+ payOffMorigeratoPerPrudente() + ")   " +
                "   (" + payOffPrudentePerAvventuriero() + " , " + payOffAvventurieroPerPrudente() + ")");
        System.out.println("#############################");
        System.out.println("S  ("+payOffSpregiudicataPerMorigerato()  +" , " + payOffMorigeratoPerSpregiudicata() +
                ")     ("+ payOffSpregiudicataPerAvvemturiero() +" , " + payOffAvventurieroPerSpregiudicata() + ")");
    }      //  Stampa a schermo il payoff secondo la Griglia

    /**
     * Con tali valori il sistema converge a uno stato di stabilita evolutiva in cui i
     * 5/6 delle donne e di tipo P e i 5/8 degli uomini e di tipo M. E
     * facile vericare
     * la stabilita della soluzione: con queste proporzioni, il guadagno medio di una
     * donna prudente, che e di 2  5=8 e lo stesso che per una spregiudicata, che e di
     * 5*5/8 è 5*3/8; dunque a nessuna delle due conviene cambiare strategia evolutiva.
     * Stesso per gli uomini.
     */

}
