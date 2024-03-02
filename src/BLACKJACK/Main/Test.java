package BLACKJACK.Main;
import BLACKJACK.Servicios.*;
import BLACKJACK.Entidades.*;
import java.util.Scanner;
public class Test {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        int opcionJugador = 0;
        /**
         * Creamos el jugador, el crupier y la partida.
         */
        JugadorBlack jugador = new JugadorBlack("Adrian");
        Crupier crupier = new Crupier();
        Partida partida = new Partida(jugador, crupier);

        do {
            menuPartida();
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            switch (opcion) {
                case 1:
                    System.out.println("Buena suerte a los jugadores.");
                    comienzoDePartida(partida, jugador);
                    /**
                     * Turno del jugador.
                     */
                    turnoJugador(opcionJugador, jugador, partida);
                    /**
                     * Turno de crupier, juega automáticamente.
                     */
                    juegaElCrupier(crupier, partida);
                    System.out.println();
                    /**
                     * Pintamos al ganador de la partida.
                     */
                    calcularGanador(crupier, jugador);
                    System.out.println();
                    /**
                     * Limpiamos las manos de los jugadores.
                     */
                    jugador.getMano().clear();
                    crupier.getMano().clear();
                    opcionJugador = 0;
                    break;
                case 2:
                    System.out.println("¡Hasta pronto!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }

        } while (opcion != 2);
    }

    /**
     * Función para generar el turno del jugador.
     * @param opcionJugador
     * @param jugador
     * @param partida
     */

    private static void turnoJugador(int opcionJugador, JugadorBlack jugador, Partida partida) {
        while (opcionJugador != 2 && !jugador.isPlantado()) {
            menuJugador();
            try {
                opcionJugador = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            switch (opcionJugador) {
                case 1:
                    partida.asignarCarta(jugador);
                    pintarMano(jugador);
                    if (jugador.valorMano() > 21){
                        jugador.setPlantado(true);
                        System.out.println("El jugador " + jugador.getNombre() + " se ha pasado.");
                        System.out.println();
                        break;
                    }
                    break;
                case 2:
                    jugador.setPlantado(true);
                    System.out.println("El jugador " + jugador.getNombre() + " se planta.");
                    pintarMano(jugador);
                    System.out.println();
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        }
    }

    /**
     * Comprobamos quien es el ganador de la partida.
     * @param crupier
     * @param jugador
     */

    private static void calcularGanador(Crupier crupier, JugadorBlack jugador) {
        if ((crupier.valorMano() > jugador.valorMano() && crupier.valorMano() <= 21) ||
                (crupier.valorMano() < jugador.valorMano() && jugador.valorMano() > 21)){
            System.out.println("El crupier gana la partida.");
        } else if ((jugador.valorMano() > crupier.valorMano() && jugador.valorMano() <= 21) ||
                (jugador.valorMano() < crupier.valorMano() && crupier.valorMano() > 21)){
            System.out.println("El jugador " + jugador.getNombre() + " gana la partida.");
        } else {
            System.out.println("Se anulan las apuestas.");
        }
    }
    //Métodos---

    /**
     * Generamos un método para pintar la mano y el valor de la mano del jugador o crupier.
     * @param jugador
     */

    private static void pintarMano(Jugador jugador) {
        System.out.println(jugador.getMano());
        System.out.println("Valor de la mano: " + jugador.valorMano());
    }

    /**
     * Generamos el juego del crupier aleatoriamente.
     * Si llega al valor de su límite, se planta, si se pasa, se planta y pierde la partida.
     * @param crupier
     * @param partida
     */

    private static void juegaElCrupier(Crupier crupier, Partida partida) {
        System.out.println("--------------------------Turno del Crupier---------------------------");
        while (crupier.valorMano() <= 21 && !crupier.isPlantado()) {
            if (crupier.valorMano() >= crupier.getLimite()) {
                crupier.setPlantado(true);
                System.out.println("El crupier se ha plantado.");
                pintarMano(crupier);
                break;
            }
            partida.asignarCarta(crupier);
            pintarMano(crupier);
            if (crupier.valorMano() == crupier.getLimite()) {
                crupier.setPlantado(true);
                System.out.println("El crupier se ha plantado.");
                break;
            } else if (crupier.valorMano() > crupier.getLimite() && crupier.valorMano() <= 21){
                crupier.setPlantado(true);
                System.out.println("El crupier se ha plantado.");
                break;
            } else if (crupier.valorMano() > 21){
                crupier.setPlantado(true);
                System.out.println("El crupier se ha pasado.");
                break;
            }
        }
    }

    /**
     * Iniciamos la partida, repartimos cartas y pintamos las manos de los jugadores.
     * @param partida
     * @param jugador
     */

    private static void comienzoDePartida(Partida partida, JugadorBlack jugador) {
        partida.iniciarPartida();
        System.out.println(jugador);
        System.out.println(partida.getCrupier());
    }

    /**
     * Pintamos el menú de inicio del juego.
     */
    public static  void menuPartida(){
        System.out.println("Elige la opción deseada: ");
        System.out.println("1. Iniciar nueva partida.");
        System.out.println("2. Salir.");
    }

    /**
     * Pîntamos las opciones que tienen de juego los jugadores.
     */
    public static void menuJugador(){
        System.out.println("Habla el Jugador: ");
        System.out.println("1. Pedir carta.");
        System.out.println("2. Plantarte.");
    }
}
