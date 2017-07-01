package SessoSenzaThread;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by utente on 06/06/2017.
 */
public class MainSessoSenzaThread {
    public static void main(String[] args) {

        int individuo, fortunati, preciso = 0;
        int M, A, P, S;
        float percMaschi, percFemmine,percM, percA,percP,percS;
        int mxP, mxS, axP, axS, pxM, pxA, sxM, sxA;
        int bonusM, bonusA, bonusP, bonusS;

        individuo = 500;
        // M=A=P=S= individuo;
        M = 12;
        A = 65;
        P = 43;
        S = 37;
        M *= 100;
        A *= 100;
        P *= 100;
        S *= 100;
        mxP = pxM = 2;
        mxS = sxM = 5;
        axP = pxA = 0;
        axS = 15;
        sxA = -5;

        int figlio = new Random().nextInt(3);
        fortunati = (individuo /2) /  (figlio+1);

        int z = 1;
        int equilibrio = 0;
        for (int n = 0; n < 100; n++) {

            // rimpicciolisce i numeri rendelo
            if (n == z * 5) {
                z++;
                M = M / 2;
                A = A / 2;
                P = P / 2;
                S = S / 2;
            }
            for (int i = 0; i < fortunati ; i++) {

                //Gli Uomini
                bonusM = mxP * P + mxS * S;
                bonusA = axP * P + axS * S;

                // LE DONNE
                bonusP = pxM * M + pxA * A;
                bonusS = sxM * M + sxA * A;

                if (bonusM < bonusA) {
                    M -= 1;
                    A += 2;
                    if (bonusS < bonusP) P++;
                    if (bonusP < bonusS) S++;
                }
                if (bonusM > bonusA) {
                    M += 2;
                    A -= 1;
                    if (bonusS < bonusP) P++;
                    if (bonusP < bonusS) S++;
                }
                if (bonusP < bonusS) {
                    P -= 1;
                    S += 2;
                    if (bonusA < bonusM) M++;
                    if (bonusM < bonusA) A++;
                }
                if (bonusP > bonusS) {
                    P += 2;
                    S -= 1;
                    if (bonusM < bonusA) A++;
                    if (bonusA < bonusM) M++;
                }
            }

            percMaschi = M + A;
            percFemmine = P + S;
            percM = M / percMaschi;
            percA = A / percMaschi;
            percP = P / percFemmine;
            percS = S / percFemmine;
            System.out.println("G"+(n+1) +"  M:" + (new DecimalFormat("##.##").format(percM)) + "  A;" +  (new DecimalFormat("##.##").format(percA))+"  P:" +  (new DecimalFormat("##.##").format(percP))+ "  S:" +  (new DecimalFormat("##.##").format(percS)));

            if (equilibrio == 0 &&  0.60 <= percM && percM <= 0.64 && 0.36<= percA && percA <= 0.40 && 0.81 <= percP && percP <= 0.85 && 0.15 <= percS && percS <= 0.19){
                equilibrio = n +1;
            }
            if (preciso == 0 &&  0.61 < percM && percM < 0.63 && 0.37< percA && percA < 0.39 && 0.82 < percP && percP < 0.84 && 0.16 < percS && percS < 0.18){
                preciso = n +1;
            }
        }

        System.out.println("L'equilibrio è stato raggiunto all' " + equilibrio+ " accoppiamento");
        if (preciso != 0) System.out.println("Più precisamente al " + preciso+ " accoppiamento, sono stati bravi :)");
    }
}
