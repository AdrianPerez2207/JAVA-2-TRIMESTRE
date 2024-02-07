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
    //Getters and setters---------

    public Jugador1 getJugador() {
        return jugador;
    }

    public void setJugador(Jugador1 jugador) {
        this.jugador = jugador;
    }

    public ArrayList<Monstruo1> getMonstruos() {
        return monstruos;
    }

    public void setMonstruos(ArrayList<Monstruo1> monstruos) {
        this.monstruos = monstruos;
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
     * Si el jugador consigue vencer a todos los monstruos, gana la partida.
     */
    public boolean turnoJugador(Monstruo1 monstruo){
        System.out.println("Turno del Jugador: " + jugador.getNombre() + " con salud: " + jugador.getSalud());
        System.out.println("Monstruo: " + monstruo.getNombre() + " con salud: " + monstruo.getSalud());
        System.out.println();

        jugador.golpear(monstruo);
        if (monstruo.getSalud() <= 0){
            jugador.tomarPocion(800);
            System.out.println("El monstruo ha muerto");
            System.out.println();
            return false;
        }
        System.out.println("Salud del monstruo: " + monstruo.getSalud());
        System.out.println();
        if (monstruos == null) {
            return false;
        }
        return true;
    }

    /**
     * Recorremos el Array de montruos y uno de ellos golpea al jugador.
     * Si el jugador queda sin vida, pierde la partida.
     */
    public boolean turnoEnemigos(Monstruo1 monstruo){

        System.out.println("Turno del Monstruo: " + monstruo.getNombre() + " con salud: " + monstruo.getSalud());
        System.out.println("Jugador: " + jugador.getNombre() + " con salud: " + jugador.getSalud());
        System.out.println();

        monstruo.golpear(jugador);

        System.out.println("Salud del jugador: " + jugador.getSalud());
        System.out.println();
        if (jugador.getSalud() <= 0){
            return false;
        }
        return true;
    }
}
