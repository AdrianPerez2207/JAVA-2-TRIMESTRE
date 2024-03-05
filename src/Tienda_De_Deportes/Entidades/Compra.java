package Tienda_De_Deportes.Entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public class Compra implements Enviable{

    private ArrayList<LineaCompra> lineas;
    private LocalDate fecha;
    private Double precioTotal;

    //Constructor----
    public Compra(LocalDate fecha) {
        this.fecha = fecha;
        this.lineas = new ArrayList<>();
        this.precioTotal = 0.0;
    }

    public ArrayList<LineaCompra> getLineas() {
        return lineas;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "lineas=" + lineas +
                ", fecha=" + fecha +
                ", precioTotal=" + precioTotal +
                '}';
    }

    //Métodos----

    /**
     * Cuando agregamos una Línea de compra, comprobamos que exista o no dentro.
     * Si existe, aumentamos la cantidad de esa línea y calculamos el precio total.
     * Si no existe, añadimos la línea a la lista, y calculamos el precio total.
     * @param lineaDeCompra
     */
    public void agregarLinea(LineaCompra lineaDeCompra) {
        if (lineas.contains(lineaDeCompra)){
            LineaCompra productoRepetido = lineas.get(lineas.indexOf(lineaDeCompra));
            productoRepetido.setCantidad(productoRepetido.getCantidad() + lineaDeCompra.getCantidad());
            this.precioTotal += productoRepetido.subtotal();
        } else {
            this.lineas.add(lineaDeCompra);
            lineaDeCompra.incrementarOrden();
            this.precioTotal += lineaDeCompra.subtotal();
        }
    }
    /**
     * Eliminamos una línea de compra.
     * @param lineaDeCompra
     */
    public void delLinea(LineaCompra lineaDeCompra) {
        this.lineas.remove(lineaDeCompra);
        this.precioTotal -= lineaDeCompra.subtotal();
    }

    /**
     * Buscamos en la lista de la compra y pintamos toda la información de la lista.
     * @return La información de la lista.
     */
    @Override
    public String crearEmail() {
        StringBuffer sb = new StringBuffer();
        for (LineaCompra linea : this.lineas) {
            sb.append("Nombre: " + linea.getProducto().getNombre() + " Cantidad: " + linea.getCantidad() + "\n");
            sb.append("Precio: " + linea.getProducto().getPrecio() + "\n");
            sb.append("Orden: " + linea.getOrden() + "\n");
        }
        return sb.toString();
    }
}
