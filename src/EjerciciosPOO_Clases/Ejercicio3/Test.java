package EjerciciosPOO_Clases.Ejercicio3;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Libro l1 = new Libro(123456789, "Libro 1", "Autor 1", 100, false);
        Libro l2 = new Libro(234567890, "Libro 2", "Autor 2", 200, false);
        Libro l3 = new Libro(345678901, "Libro 3", "Autor 3", 300, false);
        Libro l4 = new Libro(456789012, "Libro 4", "Autor 4", 400, false);
        Libro l5 = new Libro(567890123, "Libro 5", "Autor 5", 500, false);
        Libro l6 = new Libro(678901234, "Libro 6", "Autor 6", 600, false);
        Libro l7 = new Libro(789012345, "Libro 7", "Autor 7", 700, false);
        Libro l8 = new Libro(890123456, "Libro 8", "Autor 8", 800, false);
        Libro l9 = new Libro(901234567, "Libro 9", "Autor 9", 900, false);
        Libro l10 = new Libro(1012345678, "Libro 10", "Autor 10", 1000, false);

        Libreria libreria = new Libreria(new ArrayList<Libro>());

        libreria.adquirir(l1, 20);
        libreria.adquirir(l2, 30);
        libreria.adquirir(l3, 40);
        libreria.adquirir(l4, 50);
        libreria.adquirir(l5, 60);
        libreria.adquirir(l6, 70);
        libreria.adquirir(l7, 80);
        libreria.adquirir(l8, 90);
        libreria.adquirir(l9, 100);
        libreria.adquirir(l10, 110);

        libreria.vender(l1, 30);
        libreria.vender(l3, 55);
        libreria.vender(l6, 88);
        libreria.vender(l9, 107);

        System.out.println(libreria.calcularGanancias());
        for (Libro libro : libreria.getLibros()){
            System.out.println(libro);
        }




    }
}
