package BLADE_OF_DARKNESS.Clases;

import java.util.ArrayList;

public class Partida {
    private Jugador1 jugador;
    private ArrayList<Monstruo1> monstruos;
    //Constructor---------


    public Partida(Jugador1 jugador) {
        this.jugador = jugador;
        this.monstruos = new ArrayList<>();
        iniciarPartida();
    }
    //Métodos---------

    /**
     * Añadimos al ArrayList 100 monstruos iguales y 2 final nivel
     * Al jugador le equipamos un arma.
     */
    public void iniciarPartida() {
        for (int i = 0; i < 100; i++) {
            if (i <= 97){
                Monstruo1 monstruo = new Monstruo1("Adrián" + i, Monstruo1.Clase.FANTASMA, 50 + i);
                monstruos.add(monstruo);
            } else {
                /**
                 * Quitar el remove del FOR y llevarlo al combate por turnos, no se puede eliminar nada de ArrayList mientras recorres el mismo Array
                 */
                MonstruoFinalNivel monstruoFinal = new MonstruoFinalNivel("Javier" + i, Monstruo1.Clase.DEMONIO, 200 + i, 150);
                monstruos.add(monstruoFinal);
            }
        }
        jugador.equipar(new Arma1(Arma1.Tipo.ARCO,"Legolas", 175,true));
    }

    /**
     * Recorremos el Array de monstruos y el jugador golpea al primero con vida
     * Si el jugador consigue matar al monstruo lo quitamos del Array de la partida
     * Si el jugador consigue vencer a todos los monstruos, gana la partida.
     * En caso contrario si el jugador se queda sin vida, muere y pierde la partida..
     */
    public boolean turnoJugador(){
        for (Monstruo1 monstruo : monstruos){
            System.out.println("Turno del Jugador: " + jugador.getNombre() + " con salud: " + jugador.getSalud());
            System.out.println("Monstruo: " + monstruo.getNombre() + " con salud: " + monstruo.getSalud());

            jugador.golpear(monstruo);
            System.out.println("Salud del monstruo: " + monstruo.getSalud());
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
            System.out.println("Turno del Monstruo: " + monstruo.getNombre() + " con salud: " + monstruo.getSalud());
            System.out.println("Jugador: " + jugador.getNombre() + " con salud: " + jugador.getSalud());

            monstruo.golpear(jugador);
            System.out.println("salud del jugador: " + jugador.getSalud());
            if (jugador.getSalud() <= 0){
                return true;
            }
        }
        return false;
    }
}
