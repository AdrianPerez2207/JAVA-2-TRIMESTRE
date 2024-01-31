package EjerciciosPOO_Clases.Ejercicio1;
import java.util.Scanner;
public class TestPersona {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese su nombre: ");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese su edad: ");
            int edad= Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese su DNI: ");
            String dni= scanner.nextLine();

            System.out.println("Ingrese su sexo: ");
            char sexo= scanner.nextLine().charAt(0);

            System.out.println("Ingrese su peso: ");
            double peso= Double.parseDouble(scanner.nextLine());

            System.out.println("Ingrese su altura: ");
            double altura= Double.parseDouble(scanner.nextLine());
            /**
             * Creamos un objeto de la clase Persona con los parámetros introducidos por teclado.
             */
            Persona persona= new Persona(nombre, edad, dni, sexo, peso, altura);
            /**
             * Comprobamos si la persona es mayor de edad y pintamos un mensaje.
             */
            if (persona.esMayordeEdad()) {
                System.out.println("Es mayor de edad.");
            } else {
                System.out.println("No es mayor de edad.");
            }
            /**
             * Comprobamos si la persona está en su peso ideal, por debajo o tiene sobrepeso y pintamos un mensaje.
             */
            if (persona.calcularIMC() == 1) {
                System.out.println("Está en su peso ideal.");
            } else if (persona.calcularIMC() == 0) {
                System.out.println("Está por debajo de su peso ideal.");
            } else {
                System.out.println("Está con sobrepeso.");
            }
            /**
             * Pintamos la información del objeto.
             */
            System.out.println("Información de la persona 1: ");
            System.out.println(persona);
            /**
             * Creamos un nuevo objeto y cambiamos todo menos el dni.
             */
            Persona persona2 = new Persona("David", 25, dni , 'M');
            persona2.setAltura(1.75);
            persona2.setPeso(80);
            /**
             * Comprobamos el método equals.
             */
            if (persona.equals(persona2)) {
                System.out.println("Son iguales.");
            } else {
                System.out.println("No son iguales.");
            }
            /**
             *  Pintamos la información del objeto 2.
             */
            System.out.println("Información de la persona 2: ");
            System.out.println(persona2);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
