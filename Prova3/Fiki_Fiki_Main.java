package Prova3;


/**
 * Created by utente on 16/05/2017.
 */
public class Fiki_Fiki_Main {

    // le formule per gli accoppiamenti sono :
    //   M x P =  a - b/2 - c  /  a - b/2 - c
    //   M x S =  a - b/2      /  a - b/2
    //   A x P =  0            /  0
    //   A x S =  a            /  a - b

    //                REGOLA GENERALE
    //    ########## M ################ A #####
    //    P (a-b/2-c , a-b/2-c)      (0 , 0)
    //    #####################################
    //    S   (a-b/2 , a-b/2)      (a-b , a)

    //    Esempio con a=15, b=20, c = 3
    //    ##### M ########## A ########
    //    P  (2 , 2)      (0 , 0)
    //    #############################
    //    S  (5 , 5)     (-5 , 15)


    public static void main(String[] args) throws InterruptedException {

        // dati iniziali della popolazione
        int numMorigerato = 10;
        int numAvventuriero = 5;
        int numPrudente = 5;
        int numSpregiudicata = 5;

        // DONNA
        for (int i = 0; i < numPrudente ; i++) {
            Prudente P = new Prudente();
            P.start();
            Thread.currentThread().sleep(100);
            P.interrupt();
        }

        // DONNA
        for (int i = 0; i < numSpregiudicata ; i++) {
            Spregiudicata S = new Spregiudicata();
            S.start();
            Thread.currentThread().sleep(100);
            S.interrupt();
        }

        // UOMO
        for (int i = 0; i < numMorigerato ; i++) {
            Morigerato M = new Morigerato();
            M.start();
            Thread.currentThread().sleep(100);
            M.interrupt();
        }

        // UOMO
        for (int i = 0; i < numAvventuriero ; i++) {
            Avventuriero A = new Avventuriero();
            A.start();
            Thread.currentThread().sleep(100);
            A.interrupt();
        }



        Thread.currentThread().sleep(100);
        //Thread.currentThread().interrupt();

    }
}
