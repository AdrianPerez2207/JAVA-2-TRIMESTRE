package EjerciciosPOO_Clases.Ejercicio3;

import java.util.ArrayList;

public class Libreria {
    private ArrayList<Libro> Libros = new ArrayList<Libro>();
    //Constructor-----------

    public Libreria(ArrayList<Libro> libros) {
        Libros = libros;
    }
    public ArrayList<Libro> getLibros() {
        return Libros;
    }

    //Métodos-----------

    /**
     *
     * @param libro asignará un precio de compra al libro y lo añadimos a la librería
     * @param precioCompra
     */
    public void adquirir(Libro libro, double precioCompra){
        libro.setPrecioCompra(precioCompra);
        Libros.add(libro);
    }

    /**
     *
     * @param libro se le asignará un precio de venta.
     * @param precioVenta el precio de venta se pasará cómo parámetro.
     * @return cambia el estado de 'vendido' a 'true'.
     */
    public boolean vender(Libro libro, double precioVenta){
        libro.setPrecioVenta(precioVenta);
        return libro.isVendido();
    }
    public double calcularGanancias(){
        double ganancias = 0;
        for(Libro libro : Libros){
            if(libro.isVendido()){
                ganancias += libro.getPrecioVenta() - libro.getPrecioCompra();
            }
        }
        return ganancias;
    }
}
