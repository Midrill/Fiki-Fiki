package Prova3;

import java.text.DecimalFormat;

/**
 * Created by utente on 14/05/2017.
 */
public class AreaAccoppiamento { // Dove si incontrano bulli e pupe
    public static final int tempo = 10; // numero massimo di incontri

    // generazione 0
    public static  int morigerati = 1000;
    public static  int avventurieri = 1000;

    public static  int prudenti = 1000;
    public static  int spregiudicate = 1000;

    // Generazione futura
    public static  int futuriMorigerati = 0;
    public static  int futuriAvventurieri = 0;

    public static  int futuriPrudenti = 0;
    public static  int futuriSpregiudicate = 0;

    public static SynchroCoda<Donna> coda = new SynchroCoda<>(); // Coda delle donne

    public static void waitFor(long millis) {
        long time = System.currentTimeMillis();
        while (System.currentTimeMillis() - time < millis) ;
    }

    public void successioneGenerazioni(int N) {
        this.morigerati = morigerati;
        this.avventurieri = avventurieri;
        this.prudenti = prudenti;
        this.spregiudicate = spregiudicate;

        for (int i = 0; i < N+1; i++) {

            System.out.println("Accoppiamento in corso, SHHHH!!!");

            Morigerato M = new Morigerato();
            Avventuriero A = new Avventuriero();
            Prudente P = new Prudente();
            Spregiudicata S = new Spregiudicata();

            M.start();
            A.start();
            P.start();
            S.start();

            AreaAccoppiamento.waitFor(3000);
            M.interrupt();
            A.interrupt();
            P.interrupt();
            S.interrupt();

            AreaAccoppiamento.coda = new SynchroCoda<>(); // Svuota la coda


            float umanita = morigerati+avventurieri+prudenti+spregiudicate;
            float percM = (morigerati/umanita)*100;
            float percA = (avventurieri/umanita)*100;
            float percP = (prudenti/umanita)*100;
            float percS = (spregiudicate/umanita)*100;


            System.out.println("G:"+i +" M:" + AreaAccoppiamento.morigerati + " A:" + AreaAccoppiamento.avventurieri + " P:" + AreaAccoppiamento.prudenti + " S:" + AreaAccoppiamento.spregiudicate);
            System.out.println("G:"+i +" M:" + (new DecimalFormat("##.##").format(percM)) + " A:" + (new DecimalFormat("##.##").format(percA))+ " P:" + (new DecimalFormat("##.##").format(percP)) + " S:" + (new DecimalFormat("##.##").format(percS)));
            // System.out.println("G:"+(i+1) +" M:" + AreaAccoppiamento.futuriMorigerati + " A:" + AreaAccoppiamento.futuriAvventurieri + " P:" + AreaAccoppiamento.futuriPrudenti + " S:" + AreaAccoppiamento.futuriSpregiudicate);

            AreaAccoppiamento.morigerati = AreaAccoppiamento.futuriMorigerati;
            AreaAccoppiamento.avventurieri = AreaAccoppiamento.futuriAvventurieri;
            AreaAccoppiamento.prudenti = AreaAccoppiamento.futuriPrudenti;
            AreaAccoppiamento.spregiudicate = AreaAccoppiamento.futuriSpregiudicate;

            AreaAccoppiamento.futuriMorigerati = 0;
            AreaAccoppiamento.futuriAvventurieri = 0;
            AreaAccoppiamento.futuriPrudenti = 0;
            AreaAccoppiamento.futuriSpregiudicate = 0;

        }
    }

    public void successioneGenerazioni(int Mo, int Av, int Pr, int Sp, int N) {
        this.morigerati = Mo;
        this.avventurieri = Av;
        this.prudenti = Pr;
        this.spregiudicate = Sp;

        for (int i = 0; i < N+1; i++) {

            Morigerato M = new Morigerato();
            Avventuriero A = new Avventuriero();
            Prudente P = new Prudente();
            Spregiudicata S = new Spregiudicata();

            M.start();
            A.start();
            P.start();
            S.start();

            AreaAccoppiamento.waitFor(3000);
            M.interrupt();
            A.interrupt();
            P.interrupt();
            S.interrupt();

            AreaAccoppiamento.coda = new SynchroCoda<>(); // Svuota la coda

            System.out.println("G:"+i +" M:" + AreaAccoppiamento.morigerati + " A:" + AreaAccoppiamento.avventurieri + " P:" + AreaAccoppiamento.prudenti + " S:" + AreaAccoppiamento.spregiudicate);
            // System.out.println("G:"+(i+1) +" M:" + AreaAccoppiamento.futuriMorigerati + " A:" + AreaAccoppiamento.futuriAvventurieri + " P:" + AreaAccoppiamento.futuriPrudenti + " S:" + AreaAccoppiamento.futuriSpregiudicate);

            AreaAccoppiamento.morigerati = AreaAccoppiamento.futuriMorigerati;
            AreaAccoppiamento.avventurieri = AreaAccoppiamento.futuriAvventurieri;
            AreaAccoppiamento.prudenti = AreaAccoppiamento.futuriPrudenti;
            AreaAccoppiamento.spregiudicate = AreaAccoppiamento.futuriSpregiudicate;

            AreaAccoppiamento.futuriMorigerati = 0;
            AreaAccoppiamento.futuriAvventurieri = 0;
            AreaAccoppiamento.futuriPrudenti = 0;
            AreaAccoppiamento.futuriSpregiudicate = 0;

        }
    }

}