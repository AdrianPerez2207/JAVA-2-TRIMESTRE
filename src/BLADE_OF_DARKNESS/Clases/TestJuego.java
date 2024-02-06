package BLADE_OF_DARKNESS.Clases;

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
         */
        for (int i = 0; i < 30; i++) {
            if (game.turnoJugador()){
                System.out.println("El jugador ha matado a todos los monstruos!! Gana la partida!!");
                break;
            }
            if (game.turnoEnemigos()){
                System.out.println("El Jugador ha muerto.. Pierde la partida..");
                break;
            }
        }
    }
}
