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



    public static void main(String[] args) {
        Avventuriero A0 = new Avventuriero();
        Avventuriero A1 = new Avventuriero();
        Avventuriero A2 = new Avventuriero();
        Avventuriero A3 = new Avventuriero();
        Morigerato M0 = new Morigerato();
        Morigerato M1 = new Morigerato();

        System.out.println(A0.comeMiChiamo());
        System.out.println(A1.comeMiChiamo());
        System.out.println(A1.A());
        System.out.println(A1.B());
        System.out.println(A2.comeMiChiamo());
        System.out.println(A3.comeMiChiamo());
        System.out.println(M0.comeMiChiamo());
        System.out.println(M1.comeMiChiamo());
        System.out.println(M1.A());
        System.out.println(M0.B());
        // System.out.println(A1.C();)
    }
}
