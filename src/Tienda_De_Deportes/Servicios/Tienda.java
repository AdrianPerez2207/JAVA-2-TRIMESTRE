package Tienda_De_Deportes.Servicios;

import Tienda_De_Deportes.Entidades.*;

import java.util.ArrayList;

public class Tienda {
    private ArrayList<Producto> inventario;
    private ArrayList<Compra> listaDeCompra;

    public Tienda() {
        this.inventario = new ArrayList<>();
        this.listaDeCompra = new ArrayList<>();
    }

    public ArrayList<Producto> getInventario() {
        return inventario;
    }

    public ArrayList<Compra> getListaDeCompra() {
        return listaDeCompra;
    }

    public String mostrarInventario() {
        return "Tienda{" +
                "inventario=" + inventario +
                '}';
    }

    public String mostrarCompras(){
        return "Tienda{" +
                "listaDeCompra=" + listaDeCompra +
                '}';
    }
    //Métodos----
    public void addProducto(Producto producto) {
        inventario.add(producto);
    }
    public void delProducto(Producto producto) {
        inventario.remove(producto);
    }

    /**
     * Primero, comprobamos que tenemos productos suficientes, si no, nos salta una excepcion y no nos deja añadir la compra.
     * Si tenemos de todos los productos, decrementamos el stock y despues añadimos la compra.
     * @param compra
     * @throws Exception
     */
    public void addCompra(Compra compra) throws Exception {
        for (LineaCompra linea : compra.getLineas()) {
            Producto productoInventario = inventario.get(inventario.indexOf(linea.getProducto()));
            if (productoInventario.getUnidadesStock() < linea.getCantidad()) {
                throw new Exception("No se puede realizar la compra, productos insuficientes");
            }
        }
        for (LineaCompra linea : compra.getLineas()) {
            Producto productoInventario = inventario.get(inventario.indexOf(linea.getProducto()));
            productoInventario.setUnidadesStock(productoInventario.getUnidadesStock() - linea.getCantidad());

        }
        listaDeCompra.add(compra);
    }
    public void delCompra(Compra compra) {
        listaDeCompra.remove(compra);
    }

    /**
     * Buscamos en el inventario el producto que coincida con el texto.
     * Si coincide, lo añade los guarda y los añade a una nueva lista.
     * @param nombre
     * @return
     */
    public ArrayList<Producto> buscarProductos(String nombre) {
        ArrayList<Producto> productos = new ArrayList<>();
        for (Producto producto : inventario) {
            if (producto.getNombre().contains(nombre)) {
                productos.add(producto);
            }
        }
        return productos;
    }
}
