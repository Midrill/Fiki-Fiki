package SessoSenzaThread;

import java.util.Random;

/**
 * Created by utente on 22/06/2017.
 */
public class Accopiamento {

    Persone Per;
    PayOff Cost;

    int divisore = new Random().nextInt(3);
    int fortunati = (250) /  (divisore+1);
    int cicli = 50;
    double[] MAPS;
    int indice;

    // Costruttore accoppiamento, prende 7 parametri, i primi 4 sono le persone e gli ultimi 3 sono i payoff
    public Accopiamento(int M,int A,int P,int S, int a, int b, int c){
        this.Per = new Persone(M,A,P,S);
        this.Cost = new PayOff(a,b,c);
    }
    public Accopiamento(int M, int A, int P, int S) {
        this.Per = new Persone(M,A,P,S);
        this.Cost = new PayOff();
    }
    public Accopiamento(){
        this.Per =  new Persone();
        this.Cost = new PayOff();
    }


    // Calcola il bonus di ogni Individuo
    public float bonusMorigerato() {return PayOff.payOffMorigeratoPerPrudente() * Persone.Prudente + PayOff.payOffMorigeratoPerSpregiudicata() * Persone.Spregiudicata;}
    public float bonusAvventuriero() {return PayOff.payOffAvventurieroPerPrudente() * Persone.Prudente + PayOff.payOffAvventurieroPerSpregiudicata() * Persone.Spregiudicata;}
    public float bonusPrudente() {return PayOff.payOffPrudentePerMorigerato() * Persone.Morigerato + PayOff.payOffPrudentePerAvventuriero() * Persone.Avventuriero;}
    public float bonusSpregiudicata() {return PayOff.payOffSpregiudicataPerMorigerato() * Persone.Morigerato + PayOff.payOffSpregiudicataPerAvvemturiero() * Persone.Avventuriero;}


    // Verifica quando si è raggiunta la stabilità
    public void stabilita() {
        if ( (bonusAvventuriero()* 1.1) < bonusMorigerato() && bonusMorigerato() < bonusAvventuriero() * 0.9) {
            if ((bonusMorigerato() * 1.1) < bonusAvventuriero() && bonusAvventuriero() < bonusMorigerato() * 0.9) {
                if ((bonusSpregiudicata() * 1.1) < bonusPrudente() && bonusPrudente() < bonusSpregiudicata() * 0.9) {
                    if ((bonusPrudente() * 1.1) < bonusSpregiudicata() && bonusSpregiudicata() < bonusPrudente() * 0.9) {
                        System.out.println("Stabilità raggiunta");
                    }
                }
            }
        }
    }



    // Funzione che Gestisce l'accoppiamento
    public void centroAccoppiamento(){

        MAPS = new double[cicli*4];
        indice = 0;

        int z = 1;
        int equilibrio = 0;
        for (int n = 0; n < cicli; n++) {

            // rimpicciolisce i numeri dimezzanoli (servono numeri >100)
            if (n == z * 5) {
                z++;
                Persone.Morigerato = Persone.Morigerato / 2;
                Persone.Avventuriero = Persone.Avventuriero / 2;
                Persone.Prudente = Persone.Prudente / 2;
                Persone.Spregiudicata = Persone.Spregiudicata / 2;
            }

            for (int i = 0; i < fortunati; i++) {

                //Gli Uomini
                float bM = bonusMorigerato();
                float bA = bonusAvventuriero();

                // LE DONNE
                float bP = bonusPrudente();
                float bS = bonusSpregiudicata();

                // MORIGERATI Domninano
                if (bM > bA) {
                    Persone.Morigerato += 1;
                    Persone.Avventuriero -= 1;
                    if (bS < bP) coppiaMxP();
                    if (bP < bS) coppiaMxS();
                }
                // AVVENTURIERI Dominano
                if (bM < bA) {
                    Persone.Morigerato -= 1;
                    Persone.Avventuriero += 1;
                    if (bS < bP) coppiaAxP();
                    if (bP < bS) coppiaAxS();
                }
                // PRUDENTI Dominano
                if (bP > bS) {
                    Persone.Prudente += 1;
                    Persone.Spregiudicata -= 1;
                    if (bA < bM) coppiaPxM();
                    if (bM < bA) coppiaPxA();
                }
                // SPREGIUDICATE Dominano
                if (bP < bS) {
                    Persone.Prudente -= 1;
                    Persone.Spregiudicata += 1;
                    if (bA < bM) coppiaSxM();
                    if (bM < bA) coppiaSxA();
                }
            }
            MAPS[indice] = Persone.percMorigerato();
            indice++;
            MAPS[indice] = Persone.percAvventuriero();
            indice++;
            MAPS[indice] = Persone.percPrudente();
            indice++;
            MAPS[indice] = Persone.percSpregiudicata();
            indice++;
        }
    }

    // Figli Morigerato
    public void coppiaMxP(){Persone.Morigerato++; Persone.Prudente ++;}
    public void coppiaMxS(){Persone.Morigerato++; Persone.Spregiudicata ++;}

    // Figli Avventuriero
    public void coppiaAxP(){Persone.Avventuriero++; Persone.Prudente ++;}
    public void coppiaAxS(){Persone.Avventuriero++; Persone.Spregiudicata ++;}

    // Figli Prudente
    public void coppiaPxM(){Persone.Prudente++; Persone.Morigerato++;}
    public void coppiaPxA(){Persone.Prudente++; Persone.Avventuriero++;}


    // Figli Spregiudicata
    public void coppiaSxM(){Persone.Spregiudicata++; Persone.Morigerato++;}
    public void coppiaSxA(){Persone.Spregiudicata++; Persone.Avventuriero++;}


    public double[] output(){
        return MAPS;
    }

}
