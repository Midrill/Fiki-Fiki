package Prova2;

/**
 * Created by utente on 14/05/2017.
 */
public class Spregiudicata extends Donna {

    private final String type = "S";
    private int number = 0;
    private String id = "";
    private int age = 0;


    public Spregiudicata() {
        id = type + number;
        this.id = id;
        number++;
        this.age = 0;
    }

    public String identify(){
        return this.id;
    }

    public int getAge(){
        return this.age;
    }

    public void makeAge(){
        this.age += 1;
    }

}