package BLACKJACK.Servicios;

import BLACKJACK.Entidades.*;

public class Partida {

    private JugadorBlack jugador;
    private Crupier crupier;
    private BarajaInglesa baraja;

    public Partida(JugadorBlack jugador) {
        this.jugador = jugador;
        this.crupier = new Crupier();
        this.baraja = new BarajaInglesa();
    }

    public JugadorBlack getJugador() {
        return jugador;
    }

    public void setJugador(JugadorBlack jugador) {
        this.jugador = jugador;
    }

    public Crupier getCrupier() {
        return crupier;
    }

    public void setCrupier(Crupier crupier) {
        this.crupier = crupier;
    }

    public BarajaInglesa getBaraja() {
        return baraja;
    }

    public void setBaraja(BarajaInglesa baraja) {
        this.baraja = baraja;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "jugador=" + jugador +
                ", crupier=" + crupier +
                ", baraja=" + baraja +
                '}';
    }
    //Métodos---------

    /**
     * Repartimos cartas a los jugadores.
     * Cuando la hemos repartido, la eliminamos de la baraja
     * @param jugador
     */
    public void asignarCarta(Jugador jugador){
        Carta carta = baraja.repartirCarta();
        jugador.nuevaCarta(carta);
    }

    /**
     * Al iniciar la partida, se baraja la baraja.
     * Se le asignan 2 cartas cada a cada jugador y al crupier.
     */
    public void iniciarPartida(){
        baraja.barajar();
        asignarCarta(jugador);
        asignarCarta(crupier);
        asignarCarta(jugador);
        asignarCarta(crupier);
    }


}
