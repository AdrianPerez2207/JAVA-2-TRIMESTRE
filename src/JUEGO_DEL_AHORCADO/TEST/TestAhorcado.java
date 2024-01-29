package JUEGO_DEL_AHORCADO.TEST;
import JUEGO_DEL_AHORCADO.JUEGO.Ahorcado;
import java.util.Scanner;
public class TestAhorcado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Ahorcado ahorcado = new Ahorcado();
        System.out.println(ahorcado.getPalabraAdivinar());
        System.out.println(ahorcado.getPalabraIntentada());

        String letra = " ";
        String palabra = " ";

        try {
            while (true) {
                System.out.println("Introduce una letra");
                letra = sc.nextLine();
                System.out.println("Menú de opciones: ");
                System.out.println("1. Probar Letra");
                System.out.println("2. Probar Palabra");
                int opcion = Integer.parseInt(sc.nextLine());
                switch (opcion){
                    case 1:
                        ahorcado.probarLetras(letra);
                        System.out.println(ahorcado.getPalabraIntentada());
                        System.out.println("Número de fallos: " + ahorcado.getNumFallos());
                        break;
                    case 2:
                        System.out.println("Introduce la palabra a probar: ");
                        palabra = sc.nextLine();
                        if (ahorcado.probarPalabra(palabra)) {
                            System.out.println(ahorcado.getPalabraAdivinar());
                            System.out.println("ENHORABUENA. HAS ACERTADO LA PALABRA!!");
                            break;
                        } else {
                            System.out.println(ahorcado.getPalabraAdivinar());
                            System.out.println("Has perdido..");
                            break;
                        }
                }
                if (ahorcado.getNumFallos() > ahorcado.getPalabraIntentada().length()) {
                    System.out.println("Te has pasado de intentos.. Has perdido..");
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        
    }
}
