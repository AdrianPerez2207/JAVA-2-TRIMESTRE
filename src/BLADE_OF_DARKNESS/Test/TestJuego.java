package BLADE_OF_DARKNESS.Test;

import BLADE_OF_DARKNESS.Clases.Jugador1;
import BLADE_OF_DARKNESS.Clases.Monstruo1;
import BLADE_OF_DARKNESS.Clases.Partida;

public class TestJuego {

    public static void main(String[] args) {
        //Creamos un objeto jugador
        Jugador1 jugador = new Jugador1("Radantolf", Jugador1.Clase.CABALLERO);
        //Creamos un objeto partida y le introducimos el jugador cómo parámetro
        Partida game = new Partida(jugador);
        //Iniciamos la partida
        game.iniciarPartida();
        /**
         * Simulamos 30 turnos de una partida
         * Crear combate por turnos, pelear contra el primer monstruo, si el Jugador gana, eliminamos al Monstruo el Array
         * El jugador pelea siempre con el monstruo en la posicion '0'.
         * Generar condición para que cuando no queden Monstruos en el Array deje de luchar
         */
        for (int i = 0; i < 30; i++) {
            Monstruo1 m = game.getMonstruos().getFirst();
            if (game.turnoJugador(m)){
                System.out.println("El jugador ha matado a todos los monstruos!! Gana la partida!!");
                break;
            }
            if (m.getSalud() <= 0){
                game.getMonstruos().remove(m);
                System.out.println("Experiencia del jugador: " + jugador.getExperiencia());
                System.out.println("Nivel del jugador: " + jugador.getNivel());
                System.out.println();
                m = game.getMonstruos().getFirst();
            }
            if (!game.turnoEnemigos(m)){
                System.out.println("El Jugador ha muerto.. Pierde la partida..");
                break;
            }
        }
        System.out.println(game.getMonstruos());
    }
}
