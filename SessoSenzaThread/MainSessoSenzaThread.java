package SessoSenzaThread;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by utente on 06/06/2017.
 */
public class MainSessoSenzaThread {
    public static void main(String[] args) {

        int M,A,P,S;
        int a,b,c;

        M=A=P=S=500;

        Accopiamento Acc = new Accopiamento(M, A, P, S);
        Acc.centroAccoppiamento();

    }
}
