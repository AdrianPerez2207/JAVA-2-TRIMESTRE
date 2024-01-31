package JUEGO_DEL_AHORCADO.TEST;
import JUEGO_DEL_AHORCADO.JUEGO.Ahorcado;
import java.util.Scanner;
public class TestAhorcado1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Nos creamos el objeto ahorcado.
        Ahorcado ahorcado = new Ahorcado();
        //Para probar pintamos la palabra a adivinar, y debajo la palabra solo con guines.
        System.out.println(ahorcado.getPalabraAdivinar());
        System.out.println(ahorcado.getPalabraIntentada());

        String letra = " ";
        String palabra = " ";
        /**
         * Metemos todo dentro de un while para que el usuario pueda introducir una letra o una palabra hasta acertar o pasar de los intentos máximos.
         */
        try {
            while (true) {
                System.out.println("Menú de opciones: "); //Genermas un menú de opciones
                System.out.println("1. Probar Letra");
                System.out.println("2. Probar Palabra");
                int opcion = Integer.parseInt(sc.nextLine()); //Pedimos la opción por teclado.
                switch (opcion){
                    //En el caso 1 probamos letra a letra
                    case 1:
                        System.out.println("Introduce una letra");
                        letra = sc.nextLine();
                        ahorcado.probarLetras(letra);
                        System.out.println(ahorcado.getPalabraIntentada());
                        System.out.println("Número de fallos: " + ahorcado.getNumFallos());
                        break;
                        //En el caso 2 probamos la palabra si creemos que la podemos acertar,
                    case 2:
                        System.out.println("Introduce la palabra a probar: ");
                        palabra = sc.nextLine();
                        if (ahorcado.probarPalabra(palabra)) {
                            System.out.println(ahorcado.getPalabraAdivinar());
                            System.out.println("ENHORABUENA. HAS ACERTADO LA PALABRA!!");
                        } else {
                            System.out.println(ahorcado.getPalabraAdivinar());
                            System.out.println("Has perdido..");
                        }
                        break;
                }
                //Si nos pasamos de los intentos máximos, perdemos..
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
