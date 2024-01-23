package PruebaClase_10_1.PruebaClase;

import java.util.Objects;

public class Producto {
    private String nombre;
    private double precio;
    //Constructor parametrizado-----------------------------------
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    //Constructor copia-----------------------------------
    public Producto(Producto producto) {
        this.nombre = producto.getNombre();
        this.precio = producto.getPrecio();
    }
    //Getters and setters--------------------------------
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    //ToString----------------------------------------
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Producto1{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", precio=").append(precio);
        sb.append('}');
        return sb.toString();
    }
    //Equals----------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto1 = (Producto) o;
        return Double.compare(precio, producto1.precio) == 0 && Objects.equals(nombre, producto1.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, precio);
    }
}
