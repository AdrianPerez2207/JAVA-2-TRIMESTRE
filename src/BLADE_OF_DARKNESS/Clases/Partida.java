package BLADE_OF_DARKNESS.Clases;

import java.util.ArrayList;

public class Partida {
    private Jugador1 jugador;
    private ArrayList<Monstruo1> monstruos;
    //Constructor---------


    public Partida(Jugador1 jugador) {
        this.jugador = jugador;
        this.monstruos = new ArrayList<>();
        inicarPartida();
    }
    //Métodos---------

    /**
     * Añadimos al ArrayList 100 monstruos iguales y 2 final nivel
     * Al jugador le equipamos un arma.
     */
    public void inicarPartida() {
        for (int i = 0; i < 100; i++) {
            if (1 <= 97){
                Monstruo1 monstruo = new Monstruo1("Adrián", Monstruo1.Clase.FANTASMA, 100);
                monstruos.add(monstruo);
            } else {
                MonstruoFinalNivel monstruoFinal = new MonstruoFinalNivel("Javier", Monstruo1.Clase.DEMONIO, 200, 150);
            }
        }
        jugador.equipar(jugador.getArmaDerecha());
    }

    /**
     * Recorremos el Array de monstruos y el jugador golpea al primero con vida
     * Si el jugador consigue matar al monstruo lo quitamos del Array de la partida
     * Si el jugador consigue vencer a todos los monstruos, gana la partida.
     * En caso contrario si el jugador se queda sin vida, muere y pierde la partida..
     */
    public boolean turnoJugador(){
        for (Monstruo1 monstruo : monstruos){
            jugador.golpear(monstruo);
            if (monstruo.getSalud() <= 0){
                monstruos.remove(monstruo);
            } else if (monstruos == null) {
               return true;
            }
        }
        return false;
    }

    /**
     * Recorremos el Array de montruos y uno de ellos golpea al jugador.
     * Si el jugador queda sin vida, pierde la partida.
     */
    public boolean turnoEnemigos(){
        for (Monstruo1 monstruo : monstruos){
            monstruo.golpear(jugador);
            if (jugador.getSalud() <= 0){
                return true;
            }
        }
        return false;
    }
}
