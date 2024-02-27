package BLACKJACK.Main;
import BLACKJACK.Servicios.*;
import BLACKJACK.Entidades.*;
import java.util.Scanner;
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /**
         * Creamos el jugador y el crupier y la partida.
         */
        JugadorBlack jugador = new JugadorBlack("Adrian");
        Partida partida = new Partida(jugador);
        int opcion = 0;
        try {
            do {
                menuPartida();
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        partida.iniciarPartida();
                        System.out.println(jugador);
                        System.out.println(partida.getCrupier());
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
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Métodos---
    public static  void menuPartida(){
        System.out.println("Elige la opción deseada: ");
        System.out.println("1. Iniciar nueva partida.");
        System.out.println("2. Salir.");
    }
    public static void menuJugador(){
        System.out.println("Habla el Jugador: ");
        System.out.println("1. Pedir carta.");
        System.out.println("2. Plantarte.");
    }
}
