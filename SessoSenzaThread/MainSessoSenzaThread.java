package SessoSenzaThread;

import java.text.DecimalFormat;

/**
 * Created by utente on 06/06/2017.
 */
public class MainSessoSenzaThread {
    public static void main(String[] args) {
        int M = 10, A = 10, P = 10, S = 10;
        int m, a, p, s, unterzo, dueterzi;
        int sMezzi, cita = 1, tarzan = 1;
        float percMaschi, percFemmine,percM, percA,percP,percS;
        for (int i = 0; i < 100; i++) {
            unterzo = S/3;
            dueterzi = S - unterzo;
            // Avv X Spre
            a = dueterzi * 8;
            p = dueterzi * 2;

            // Mori X Spre
            m = unterzo * 5;
            M = M - unterzo;
            s = unterzo * 5;

            // Mori x Prud
            if ( M >= P ) {
                p = p + P * 2;
                m = m + P * 2;
            } else {
                p = p + M * 2;
                m = m + M * 2;
            }


            if (i == cita*10 ) {
                cita++;
                m = m / 5;
                a = a /5;
                p = p / 5;
                s = s /5;
            }
            M = m/2; A = a/2; P = p/2; S = s/2;
            percMaschi = M + A;
            percFemmine = P + S;
            percM = M / percMaschi;
            percA = A / percMaschi;
            percP = P / percFemmine;
            percS = S / percFemmine;
            System.out.println("G"+i +"  M:" + (new DecimalFormat("##.##").format(percM)) + "  A;" +  (new DecimalFormat("##.##").format(percA))+"  P:" +  (new DecimalFormat("##.##").format(percP))+ "  S:" +  (new DecimalFormat("##.##").format(percS)));
        }

        /** Persone P = new Persone();
        PayOff O = new PayOff();

        P.stampa();
        O.stampa();
        new Persone(3,2,5,10).stampa();
        O.payOffASchermo();
        */
    }
}
