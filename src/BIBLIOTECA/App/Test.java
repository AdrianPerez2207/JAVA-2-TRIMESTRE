package BIBLIOTECA.App;

import BIBLIOTECA.ENTIDADES.Documento;
import BIBLIOTECA.ENTIDADES.Libro;
import BIBLIOTECA.ENTIDADES.Revista;
import BIBLIOTECA.ENTIDADES.Usuario;
import BIBLIOTECA.SERVICIOS.Biblioteca;

import java.util.Scanner;

public class Test {

    public static void menu(){
        System.out.println("1. Prestar");
        System.out.println("2. Devolver");
        System.out.println("3. Buscar");
        System.out.println("4. Salir");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();
        Usuario usuario = new Usuario("89325412Y", "Adrian", 3, 15);
        //Añadimos 10 libros a la biblioteca
        for (int i = 0; i < 10; i++) {
            Libro libro = new Libro("87654H" + i, "lIBRO" + i, 130, 2015);
            biblioteca.addDocumento(libro);
        }
        //Creamos y añadimos 5 revistas a la biblioteca
        for (int i = 0; i < 5; i++) {
           Revista revista = new Revista("872329U" + i, "Revista" + i, 24, 22);
            biblioteca.addDocumento(revista);
        }

        Integer opcion = 0;
        do {
            menu();
            System.out.println("Ingrese la opcion: ");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion){
                case 1:
                    System.out.println("Escribe el título del Documento: ");
                    String titulo = sc.nextLine();
                    Documento documento = biblioteca.buscarDocumento(titulo);
                    if (documento != null){
                        System.out.println("Escribe el DNI del Usuario: ");
                        String dni = sc.nextLine();
                        biblioteca.prestaDocumento(documento, dni);
                        System.out.println(documento.toString());
                        System.out.println(usuario.toString());
                    }
                    break;
                case 2:
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Hasta Pronto.");
                    break;
                default:
                    break;
            }

        } while (opcion != 4);



    }
}
