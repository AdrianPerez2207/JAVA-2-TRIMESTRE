package Tienda_De_Deportes.Entidades;

public class Ropa extends Producto{

    public enum Talla {XS, S, M, L, XL, XLL};
    private Talla talla;
    private String color;
    public enum TipoRopa{SUDADERA, PANTALON, CAMISETA, CHAQUETA};
    private TipoRopa tipoRopa;

    //Constructor----
    public Ropa(String nombre, String descripcion, Double precio, Integer unidadesStock, Talla talla, String color, TipoRopa tipoRopa) {
        super(nombre, descripcion, precio, unidadesStock);
        this.talla = talla;
        this.color = color;
        this.tipoRopa = tipoRopa;
    }

    public Ropa(Ropa ropa){
        super(ropa);
        this.talla = ropa.talla;
        this.color = ropa.color;
        this.tipoRopa = ropa.tipoRopa;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TipoRopa getTipoRopa() {
        return tipoRopa;
    }

    public void setTipoRopa(TipoRopa tipoRopa) {
        this.tipoRopa = tipoRopa;
    }
    //toString-----------------------------------
    @Override
    public String toString() {
        return "Ropa{" +
                "talla=" + talla +
                ", color='" + color + '\'' +
                ", tipoRopa=" + tipoRopa +
                ", codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", unidadesStock=" + unidadesStock +
                '}';
    }

    //Métodos----
    @Override
    public Double descuento() {
        Double descuentoTotal = 0.03;
        if (this.talla.equals(Talla.XS) || this.talla.equals(Talla.XLL)){
            descuentoTotal = 0.05;
        }
        return this.precio * descuentoTotal;
    }
}
