package BLACKJACK.Entidades;

import java.util.ArrayList;

public class Jugador {

    protected ArrayList<Carta> mano;
    //Implementar un estado para hacer los turnos

    public Jugador() {
        this.mano = new ArrayList<>();
    }

    public ArrayList<Carta> getMano() {
        return this.mano;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "mano=" + mano +
                '}';
    }

    //Métodos---

    /**
     * Añadimos una nueva carta pasada por parámetro.
     * @param carta
     */
    public void nuevaCarta(Carta carta){
        this.mano.add(carta);
    }

    /**
     * Recorremos la mano del jugador y calculamos la suma de sus valores
     * @return el valor de la suma de la mano.
     */

    public int valorMano(){
        int valor = 0;
        for (Carta carta : this.mano){
            valor += carta.getValorCarta();
        }
        return valor;
    }
}
