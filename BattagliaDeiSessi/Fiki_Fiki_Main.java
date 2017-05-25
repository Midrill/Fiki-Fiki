package BattagliaDeiSessi;


/**
 * Created by utente on 16/05/2017.
 */
public class Fiki_Fiki_Main {

    /**
    // questa parte dei commenti serviva a me per capire delle cose e non fare avanti e indietro con le specifiche

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

    //    Esempio con a=15, b=20, c = 3
    //    ##### M ########## A ########
    //    P  (8 , 8)      (6 , 6)
    //    #############################
    //    S  (11 , 11 )     (1 , 21)


    // Ragionamenti a caso

    //    Analisi Situazione
    //    ##### M ############################################################### A ####################################
    //    P  (2 , 2) situazione stabile con vantaggi per entrambi uguale a 2   (0 , 0) situazione stabile
    //    ##### M ############################################################### A ####################################
    //    S  (5 , 5) situazione stabile con vantaggi per entrambi uguale a 5  (-5 , 15) forte vantaggio per A 5 volte S

    // 5/8 Morigerati, 3/8 Avventurieri / 30 , 18 = 96 / 31 , 19 = 100
    // 5/6 Prudenti, 1/6 Spregiudicate  / 40 , 8  = 96 / 41 , 9  = 100

    // G:n M:31 A:19 P:41 S:9

    // N valore = N figli
    // -5 = 1 , 0 = 2, 2 = 3/5 2 figli e 2/5 3 figli , 5 = 3, 15 = 5
    // -5 = 0, 0 = 1, 2 = 1, 5 = 2, 15 = 3
*/

    public static void main(String[] args) throws InterruptedException {

        AreaAccoppiamento nuovaArea = new AreaAccoppiamento();
        nuovaArea.successioneGenerazioni(20);
        // nuovaArea.successioneGenerazioni(2);
        // nuovaArea.successioneGenerazioni(50, 50, 50, 50, 20);
        // nuovaArea.successioneGenerazioni(10, 10, 10, 10, 5);
        // nuovaArea.successioneGenerazioni(20000, 20000, 20000, 20000, 5);
    }
}