package EquipoCiclistas;

import java.util.ArrayList;
import java.util.Scanner;

public class TestCiclistas {
    /**
     * Creamos un método para imprimir nuestro menú.
     */
    public static void menu(){
        System.out.println("1. Imprimir datos del equipo.");
        System.out.println("2. Añadir ciclista al equipo.");
        System.out.println("3. Calcular el total de tiempos de los ciclistas.");
        System.out.println("4. Listar nombres de los ciclistas.");
        System.out.println("5. Buscar ciclistar (por identificador).");
        System.out.println("6. Salir.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Equipo equipo = new Equipo("Movistar","España");
        int opcion;
        /**
         * Metemos nuestro menú dentro de un bucle, mientras que la opción a elegir no sea "Salir", seguirá funcionando
         */
        do {
            menu();
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion){
                case 1: //Pintamos los datos del equipo por pantalla con el método toString.
                    System.out.println(equipo.toString());
                    break;
                case 2:
                    /**
                     * En el caso 2, como vamos a añadir ciclistas al equipo, necesitamos pedir los datos por teclado
                     * Según qué tipo de ciclista, se les pedirá los datos requeridos de cada clase.
                     */
                    System.out.println("¿Qué tipo de ciclista quieres añadir?");
                    System.out.println("1. Velocista.");
                    System.out.println("2. Escalador.");
                    System.out.println("3. Contrarrelojista.");
                    int tipo = Integer.parseInt(sc.nextLine());
                    switch (tipo){
                        case 1:
                            System.out.println("Identificador: ");
                            int identificador = Integer.parseInt(sc.nextLine());
                            System.out.println("Nombre del ciclista: ");
                            String nombreCiclista = sc.nextLine();
                            System.out.println("Potencia promedio: ");
                            Double potenciaPromedio = Double.parseDouble(sc.nextLine());
                            System.out.println("Velocidad promedio: ");
                            Double velocidadPromedio = Double.parseDouble(sc.nextLine());
                            equipo.añadirCiclista(new Velocista(identificador, nombreCiclista, potenciaPromedio, velocidadPromedio));
                            break;
                        case 2:
                            System.out.println("Identificador del escalador: ");
                            int idenEscalador = Integer.parseInt(sc.nextLine());
                            System.out.println("Nombre del ciclista: ");
                            String nombreEscalador = sc.nextLine();
                            System.out.println("Aceleración promedio: ");
                            Float aceleracionPromedio = Float.parseFloat(sc.nextLine());
                            System.out.println("Grado rampa soportada: ");
                            Float gradoRampa = Float.parseFloat(sc.nextLine());
                            equipo.añadirCiclista(new Escalador(idenEscalador, nombreEscalador, aceleracionPromedio, gradoRampa));
                            break;
                        case 3:
                            System.out.println("Identificador: ");
                            int idenContrarreloj = Integer.parseInt(sc.nextLine());
                            System.out.println("Nombre del ciclista: ");
                            String nombreContrarreloj = sc.nextLine();
                            System.out.println("Velocidad máxima: ");
                            Double velocidadMaxima = Double.parseDouble(sc.nextLine());
                            equipo.añadirCiclista(new Contrarrelojista(idenContrarreloj, nombreContrarreloj, velocidadMaxima));
                            break;
                        default:
                            System.out.println("No es ninguna de las opciones..");
                            break;

                    }
                    break;
                case 3:
                    /**
                     * Aqui calculamos el tiempo total del equipo con el método de la clase "Equipo"
                     * Lo que no he entendido del trabajo, es dón meter el tiempo, ya que el de cada ciclista está en 0 por defecto
                     * Y en ningún caso nos pide que ingresemos el tiempo, asique siempre saldrá 0..
                     * Los ciclistas no han hecho ninguna carrera todavía.. xD
                     */
                    System.out.println("Tiempo total de los ciclistas del equipo: ");
                    equipo.calcularTiempoAcumulado();
                    break;
                case 4:
                    System.out.println("Nombres de los ciclistas: ");
                    equipo.listarCiclistas();
                    break;
                case 5:
                    /**
                     * Pedimos un Identificador por teclado y con el método buscar comparamos el que sea igual,
                     * y pintamos sus datos por pantalla.
                     */
                    System.out.println("Ingresa un identificador para buscar al ciclista: ");
                    int identificador = Integer.parseInt(sc.nextLine());
                    equipo.buscarCiclista(identificador);
                    break;
                case 6:
                    System.out.println("Gracias por participar. ADIOS!!");
                    break;
                default:
                    System.out.println("No es ninguna de las opciones..");
                    break;
            }
        } while (opcion != 6);

    }
}
