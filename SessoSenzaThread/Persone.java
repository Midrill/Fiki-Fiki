package SessoSenzaThread;

import BattagliaDeiSessi.Morigerato;

import java.text.DecimalFormat;

/**
 * Created by utente on 06/06/2017.
 */
public class Persone {
    public static int Morigerato;
    public static int Avventuriero;
    public static int Prudente;
    public static int Spregiudicata;

    public Persone() {
        this.Morigerato = 500;
        this.Avventuriero = 500;
        this.Prudente = 500;
        this.Spregiudicata = 500;
    }
    public Persone(int a, int b, int c, int d) {
        if (a < 250 || b < 250 || c < 250 || d < 250) {
            this.Morigerato = a * 100;
            this.Avventuriero = b * 100;
            this.Prudente = c * 100;
            this.Spregiudicata = d * 100;
        } else {
            this.Morigerato = a;
            this.Avventuriero = b;
            this.Prudente = c;
            this.Spregiudicata = d;

        }
    }

    // Ritorna il numero dei tipi
    public int Morigerato() {return Morigerato;}
    public int Avventuriero() {return Avventuriero;}
    public int Prudente() {return Prudente;}
    public int Spregiudicata() {return Spregiudicata;}

    // Stampa i numeri delle popolazioni
    public void stampa() {
        System.out.println("M;"+ Morigerato + " - A:" + Avventuriero + " - P:" + Prudente + " - S:" +Spregiudicata);
    }

    // Percentuali degli individui sulla popolazione Maschile - Femminile
    public static double percMorigerato(){return (0.0 + Morigerato) / (Morigerato+Avventuriero);}
    public static double percAvventuriero(){return (0.0 + Avventuriero) / (Morigerato+Avventuriero);}
    public static double percPrudente() {return (0.0 + Prudente) / (Prudente + Spregiudicata);}
    public static double percSpregiudicata() {return (0.0 + Spregiudicata) / (Prudente + Spregiudicata);}

    public static void stampaPerc(){
        System.out.println("M:" + (new DecimalFormat("##.##").format(percMorigerato())) + "  A;" +  (new DecimalFormat("##.##").format(percAvventuriero()))+"  P:" +  (new DecimalFormat("##.##").format(percPrudente()))+ "  S:" +  (new DecimalFormat("##.##").format(percSpregiudicata())));
    }
}
