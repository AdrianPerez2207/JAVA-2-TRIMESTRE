package PruebaClase_10_1.PruebaClase;
import java.util.ArrayList;
import java.util.Objects;

public class Tienda {
    private String nombre;
    private ArrayList<Producto> productos;
    //Constructor-----------------------------------
    public Tienda(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<Producto>();
    }
    //Getters and setters--------------------------------
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //toString-----------------------------------
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Tienda{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", productos=").append(productos);
        sb.append('}');
        return sb.toString();
    }
    //equals-----------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tienda tienda = (Tienda) o;
        return Objects.equals(nombre, tienda.nombre) && Objects.equals(productos, tienda.productos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, productos);
    }
    //Métodos----------------------------------------
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
}
