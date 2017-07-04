package SessoSenzaThread;

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
        System.out.println(Acc.MAPS);
        for (int i= 0; i < 200; i++){
            System.out.println(Acc.MAPS[i]);
        }
    }
}
