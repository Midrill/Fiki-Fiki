package SessoSenzaThread;

import BattagliaDeiSessi.Morigerato;

/**
 * Created by utente on 06/06/2017.
 */
public class Persone {
    public static int Morigerato;
    public static int Avventuriero;
    public static int Prudente;
    public static int Spregiudicata;

    public Persone() {
        this.Morigerato = 10;
        this.Avventuriero = 10;
        this.Prudente = 10;
        this.Spregiudicata = 10;
    }
    public Persone(int a, int b, int c, int d) {
        this.Morigerato= a;
        this.Avventuriero = b;
        this.Prudente = c;
        this.Spregiudicata = d;
    }

    public int Morigerato() {return Morigerato;}
    public int Avventuriero() {return Avventuriero;}
    public int Prudente() {return Prudente;}
    public int Spregiudicata() {return Spregiudicata;}

    public void stampa() {
        System.out.println("M;"+ Morigerato + " - A:" + Avventuriero + " - P:" + Prudente + " - S:" +Spregiudicata);
    }
}
