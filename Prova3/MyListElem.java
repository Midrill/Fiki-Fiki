package Prova3;

/**
 * Created by utente on 14/05/2017.
 */

public class MyListElem<E> {  // preso da BulliEPupe
    // i soliti elementi di linked list

    public E value;
    public MyListElem<E> next = null;

    MyListElem(E value) {
        this.value = value;
    }
}
