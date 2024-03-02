package BLACKJACK.Entidades;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Baraja {

    protected ArrayList<Carta> baraja;

    public Baraja() {
        this.baraja = new ArrayList<>();
    }

    public ArrayList<Carta> getBaraja() {
        return baraja;
    }
    //Métodos----

    /**
     *
     * @return la primera carta de la baraja y se elimina de la baraja
     */

    public abstract Carta repartirCarta();

    /**
     *
     * @return una carta de la baraja al azar.
     */
    public abstract Carta azar();


    /**
     * Desordena toda la baraja.
     */
    public void barajar(){
        Collections.shuffle(baraja);
    }
    //toString---

    @Override
    public String toString() {
        return "Baraja{" +
                "baraja=" + baraja +
                '}';
    }
}
