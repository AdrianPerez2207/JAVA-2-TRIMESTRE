package PruebaClase_10_1.PruebaClase_ArrayList;

public class TestTienda {

    public static void main(String[] args) {
        Producto p1 = new Producto("p1", 10.0);
        Producto p2 = new Producto("p2", 20.0);
        Producto p3 = new Producto("p3", 30.0);
        Tienda t1 = new Tienda("t1");
        t1.agregarProducto(p1);
        t1.agregarProducto(p2);
        t1.agregarProducto(p3);
        System.out.println(t1.getProductos());

        for (Producto pr : t1.getProductos()) {
            System.out.println("Nombre del producto: " + pr.getNombre() + " " +  pr.getPrecio());
        }
    }
}
