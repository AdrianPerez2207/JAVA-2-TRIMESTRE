package BLACKJACK.Entidades;

import java.util.ArrayList;

public class Jugador {

    protected ArrayList<Carta> mano;
    private boolean plantado;

    public Jugador() {
        this.mano = new ArrayList<>();
        this.plantado = false;
    }

    public ArrayList<Carta> getMano() {
        return this.mano;
    }

    public boolean isPlantado() {
        return plantado;
    }

    public void setPlantado(boolean plantado) {
        this.plantado = plantado;
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
     * Recorremos la mano del jugador y calculamos la suma de sus valores.
     * Si el valor de la mano es menor a 21, el AS sumará 11, en caso contrario, el AS sumará 1.
     * @return el valor de la suma de la mano.
     */

    public int valorMano(){
        int valor = 0;
            for (Carta carta : this.mano){
                if (carta.getValorCarta() > 1 && carta.getValorCarta() <= 10){
                    valor += carta.getValorCarta();
                } else if (carta.getValorCarta() > 10 && carta.getValorCarta() <= 13){
                    valor += 10;
                } else {
                    valor += 11;
                }
            }
            if (valor > 21){
                valor = 0;
                for (Carta carta : this.mano){
                    if (carta.getValorCarta() > 1 && carta.getValorCarta() <= 10){
                        valor += carta.getValorCarta();
                    } else if (carta.getValorCarta() > 10 && carta.getValorCarta() <= 13){
                        valor += 10;
                    } else {
                        valor += 1;
                    }
                }
            }
        return valor;
    }
    /**
     * Cambiamos el estado del jugador para cuando se plante.
     */
    public void cambiarEstado(){
        this.plantado = true;
    }
}
