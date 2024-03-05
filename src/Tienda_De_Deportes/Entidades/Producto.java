package Tienda_De_Deportes.Entidades;

import java.util.DuplicateFormatFlagsException;
import java.util.Objects;

public abstract class Producto implements Descontable{

    protected Integer codigo;
    protected static Integer numeroCodigos = 1;
    protected String nombre;
    protected String descripcion;
    protected Double precio;
    protected Integer unidadesStock;

    //Constructor----


    public Producto(String nombre, String descripcion, Double precio, Integer unidadesStock) {
        this.codigo = numeroCodigos++;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.unidadesStock = unidadesStock;
    }

    public Producto(Producto producto) {
        this.codigo = producto.getCodigo();
        this.nombre = producto.getNombre();
        this.descripcion = producto.getDescripcion();
        this.precio = producto.getPrecio();
        this.unidadesStock = producto.getUnidadesStock();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getUnidadesStock() {
        return unidadesStock;
    }

    public void setUnidadesStock(Integer unidadesStock) {
        this.unidadesStock = unidadesStock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", unidadesStock=" + unidadesStock +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(codigo, producto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    //Métodos----
    @Override
    public abstract Double descuento();
}
