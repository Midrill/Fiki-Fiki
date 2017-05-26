package BattagliaDeiSessi;

import java.text.DecimalFormat;

/**
 * Created by utente on 14/05/2017.
 */
public class AreaAccoppiamento { // Dove si incontrano bulli e pupe
    public static final int tempo = 10; // numero massimo di incontri

    // generazione 0
    public static  int morigerati;   // Numero base individui Morigerati
    public static  int avventurieri;   // Numero base individui Avventurieri

    public static  int prudenti;   // Numero base individui Prudenti
    public static  int spregiudicate;   // Numero base individui Spregiudicata

    // Generazione futura
    public static  int futuriMorigerati = 0;    // Numero futuro di individui Morigerati
    public static  int futuriAvventurieri = 0;    // Numero futuro di individui Avventurieri

    public static  int futuriPrudenti = 0;    // Numero futuro di individui Prudenti
    public static  int futuriSpregiudicate = 0;    // Numero futuro di individui Spregiudicate

    public static SynchroCoda<Donna> coda = new SynchroCoda<>(); // Coda delle donne, in cui si inseriscono con il thread

    public static void waitFor(long millis) {  // Copiata dal SILVESTRI serve a dare un timeout,
                                               // topo tot millisecondi fa lo shutdown dei Thread
        long time = System.currentTimeMillis();
        while (System.currentTimeMillis() - time < millis) ;
    }

    public void successioneGenerazioni(int N) {  // costruttore base, bisogna dare solo il numero di Generazioni
        this.morigerati = 1000;
        this.avventurieri = 1000;
        this.prudenti = 1000;
        this.spregiudicate = 1000;

        for (int i = 0; i < N+1; i++) {

            //System.out.println("Accoppiamoci SCIOCCO!");

            Morigerato M = new Morigerato();
            Avventuriero A = new Avventuriero();
            Prudente P = new Prudente();
            Spregiudicata S = new Spregiudicata();

            M.start();
            A.start();
            P.start();
            S.start();

            AreaAccoppiamento.waitFor(500);
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

            // stampa i valori a numeri
            System.out.println("G:"+i +" M:" + AreaAccoppiamento.morigerati + " A:" + AreaAccoppiamento.avventurieri + " P:" + AreaAccoppiamento.prudenti + " S:" + AreaAccoppiamento.spregiudicate);

            // stampa i valori a % (percentuale)
            System.out.println("G:"+i +" M:" + (new DecimalFormat("##.##").format(percM)) + "% A:" + (new DecimalFormat("##.##").format(percA))+ "% P:" + (new DecimalFormat("##.##").format(percP)) + "% S:" + (new DecimalFormat("##.##").format(percS))+"%");

            // stampa i valori della generazione futuro
            // System.out.println("G:"+(i+1) +" M:" + Regole.futuriMorigerati + " A:" + Regole.futuriAvventurieri + " P:" + Regole.futuriPrudenti + " S:" + Regole.futuriSpregiudicate);

            // sistema i valori per la generazione futura
            AreaAccoppiamento.morigerati = AreaAccoppiamento.futuriMorigerati;
            AreaAccoppiamento.avventurieri = AreaAccoppiamento.futuriAvventurieri;
            AreaAccoppiamento.prudenti = AreaAccoppiamento.futuriPrudenti;
            AreaAccoppiamento.spregiudicate = AreaAccoppiamento.futuriSpregiudicate;

            // azzerra i valori della prossima generazione
            AreaAccoppiamento.futuriMorigerati = 0;
            AreaAccoppiamento.futuriAvventurieri = 0;
            AreaAccoppiamento.futuriPrudenti = 0;
            AreaAccoppiamento.futuriSpregiudicate = 0;
        }
}

      public void successioneGenerazioni(int Mo, int Av, int Pr, int Sp, int N) { // prende 5 valori,
                                                                                // i primi 4 sono Morigerati, avventurieri
                                                                                // Prudenti e spregiudicate
                                                                                // l'ultimo è il numero di generazioni


        morigerati = Mo;
        avventurieri = Av;
        prudenti = Pr;
        spregiudicate = Sp;

        int intervallo = 10000;
        if (Mo + Av + Pr + Sp <= 8000) intervallo = 5000;
        if (Mo + Av + Pr + Sp <= 6000) intervallo = 4000 ;
        if (Mo + Av + Pr + Sp <= 4000) intervallo = 3000;

        for (int i = 0; i < N+1; i++) {

            //System.out.println("Ti piace farlo strano eh??? sporcaccione!");

            Morigerato M = new Morigerato();
            Avventuriero A = new Avventuriero();
            Prudente P = new Prudente();
            Spregiudicata S = new Spregiudicata();

            M.start();
            A.start();
            P.start();
            S.start();

            AreaAccoppiamento.waitFor(intervallo );
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


            // System.out.println("G:"+i +" M:" + Regole.morigerati + " A:" + Regole.avventurieri + " P:" + Regole.prudenti + " S:" + Regole.spregiudicate);
            System.out.println("G:"+i +" M:" + (new DecimalFormat("##.##").format(percM)) + "% A:" + (new DecimalFormat("##.##").format(percA))+ "% P:" + (new DecimalFormat("##.##").format(percP)) + "% S:" + (new DecimalFormat("##.##").format(percS))+"%");
            // System.out.println("G:"+(i+1) +" M:" + Regole.futuriMorigerati + " A:" + Regole.futuriAvventurieri + " P:" + Regole.futuriPrudenti + " S:" + Regole.futuriSpregiudicate);

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