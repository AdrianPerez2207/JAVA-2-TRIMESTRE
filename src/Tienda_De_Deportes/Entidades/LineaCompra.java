package Tienda_De_Deportes.Entidades;

import java.util.Objects;

public class LineaCompra {

    private Integer orden;
    private Producto producto;
    private static Integer numeroProductos = 0;
    private Integer cantidad;

    //Constructor---

    public LineaCompra(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.orden = numeroProductos;
    }
    public LineaCompra(LineaCompra lineaCompra) {
        this.producto = lineaCompra.getProducto();
        this.cantidad = lineaCompra.getCantidad();
        this.orden = lineaCompra.getOrden();
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "LineaCompra{" +
                "orden=" + orden +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineaCompra that = (LineaCompra) o;
        return Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producto);
    }
    //Métodos----
    public void incrementarOrden(){
        numeroProductos++;
    }

    /**
     * Calculamos el precio de la linea de compra con la cantidad de productos y los descuentos.
     * @return el total del precio.
     */
    public Double subtotal(){
        Double total = 0.0;
        total = (producto.precio * cantidad) - producto.descuento();
        return total;
    }
}
