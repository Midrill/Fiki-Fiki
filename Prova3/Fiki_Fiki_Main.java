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
        int numMorigerato = 50;
        int numAvventuriero = 50;
        int numPrudente = 50;
        int numSpregiudicata = 50;

        System.out.println("M: "+ numMorigerato + "/ A; " + numAvventuriero + "/ P : " + numPrudente + "/ S: " + numSpregiudicata );

        // Bisogna che ogni tipo di Umano è un SINGOLO THREAD, cosi ne ne gestiscono solo 4, poichè per come
        // è implementata non sfrutta la concorrenza.
        // Bisogna capire come introdurre i LOCK


        // DONNA
        for (int i = 0; i < numPrudente ; i++) {
            Prudente P = new Prudente();
            P.start();
        }

        // DONNA
        for (int i = 0; i < numSpregiudicata ; i++) {
            Spregiudicata S = new Spregiudicata();
            S.start();
        }


        // UOMO
        for (int i = 0; i < numAvventuriero ; i++) {
            Avventuriero A = new Avventuriero();
            A.start();
        }

        // UOMO
        for (int i = 0; i < numMorigerato ; i++) {
            Morigerato M = new Morigerato();
            M.start();
        }



        // Quando un Thread non riesce a formare una coppia non deve interrompersi ma andare in sleep/wait
        // Dopo un Tempo massimo tutti devono Interrompersi e stampare il risultato


        Thread.currentThread().sleep(10);
        //Thread.currentThread().interrupt();
    }
}
/**
        Prudente P = new Prudente();
        Spregiudicata S = new Spregiudicata();

        System.out.println(P.cheDonnaSei()); // stampa false
        System.out.println(S.cheDonnaSei()); // stampa true
    }
} */