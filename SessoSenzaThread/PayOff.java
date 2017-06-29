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

    public PayOff(int a, int b, int c) {
        beneficioFiglio = a;
        costoFiglio = b;
        costoCorteggiamento = c;
    }

    public void stampa() {
        System.out.println("Beneficio figlio = " + beneficioFiglio);
        System.out.println("Costo Figlio = " + costoFiglio);
        System.out.println("Costo Corteggiamento = " + costoCorteggiamento);
    }


    // Morigerato
    private float payOffMorigeratoPerPrudente(){return beneficioFiglio -costoFiglio/2 -costoCorteggiamento;}
    private float payOffMorigeratoPerSpregiudicata(){
        return beneficioFiglio - costoFiglio/2;}


    // Avventuriero
    private float payOffAvventurieroPerPrudente(){return 0;} // Cotrollare se c'è una formula che fa venire 0
    private float payOffAvventurieroPerSpregiudicata(){return beneficioFiglio;}

    // Prudente
    private float payOffPrudentePerMorigerato(){return beneficioFiglio - costoFiglio/2 -costoCorteggiamento;}
    private float payOffPrudentePerAvventuriero(){return 0;} // Cotrollare se c'è una formula che fa venire 0


    // Spregiudicata
    private float payOffSpregiudicataPerMorigerato(){return beneficioFiglio - costoFiglio/2;}
    private float payOffSpregiudicataPerAvvemturiero(){return beneficioFiglio - costoFiglio;}


    //    Esempio con a=15, b=20, c = 3
    //    ##### M ########## A ########
    //    P  (2 , 2)      (0 , 0)
    //    #############################
    //    S  (5 , 5)     (-5 , 15)


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

    private float convenienzaMorigerato(){return Persone.Prudente * payOffMorigeratoPerPrudente() + Persone.Spregiudicata * payOffMorigeratoPerSpregiudicata() ;}
    private float convenienzaAvventuriero(){return Persone.Prudente * payOffAvventurieroPerPrudente() + Persone.Spregiudicata * payOffAvventurieroPerSpregiudicata();}
    private float convenienzaPrudente(){return Persone.Morigerato * payOffPrudentePerMorigerato() + Persone.Avventuriero * payOffPrudentePerAvventuriero() ;}
    private float convenienzaSpregiudicata(){return Persone.Morigerato * payOffSpregiudicataPerMorigerato() + Persone.Avventuriero * payOffSpregiudicataPerAvvemturiero();}


    private float percentualeMorigerato() { // la % Avventuieri è 1-percentualeMorigerato


        float x;
        float y;
        // payOffMorigeratoPerPrudente() * x = payOffMorigeratoPerSpregiudicata() * y;
        // 2*5/6 + 0*1/6 = 5*5/8 + (-5 * 5/8);
        // 2*x + 0*(1 -x) = 5* y + (-5 * (1 -y)


        return 0;
    }

    private float percentualePrudente() {// la % Spregiudicata è 1-percentualePrudente
        float z;
        float w;
        return 0;
    }
}
