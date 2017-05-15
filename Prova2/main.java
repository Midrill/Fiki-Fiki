package Prova2;

/**
 * Created by utente on 14/05/2017.
 */

public class main {

    public static void main(String[] args) {

        Morigerato gigi = new Morigerato();
        System.out.println(gigi.getAge());
        System.out.println(gigi.identify());
        gigi.makeAge();
        System.out.println(gigi.getAge());
        gigi.makeAge();
        gigi.makeAge();
        System.out.println(gigi.getAge());

        Avventuriero gianpoldo = new Avventuriero();
        System.out.println(gianpoldo.getAge());
        System.out.println(gianpoldo.identify());
        gianpoldo.makeAge();
        System.out.println(gianpoldo.getAge());
        gianpoldo.makeAge();
        gianpoldo.makeAge();
        System.out.println(gianpoldo.getAge());


        Prudente giannella = new Prudente();
        System.out.println(giannella.getAge());
        System.out.println(giannella.identify());
        giannella.makeAge();
        System.out.println(giannella.getAge());
        giannella.makeAge();
        giannella.makeAge();
        System.out.println(giannella.getAge());

        Spregiudicata giacomina = new Spregiudicata();
        System.out.println(giacomina.getAge());
        System.out.println(giacomina.identify());
        giacomina.makeAge();
        System.out.println(giacomina.getAge());
        giacomina.makeAge();
        giacomina.makeAge();
        System.out.println(giacomina.getAge());

    }

}