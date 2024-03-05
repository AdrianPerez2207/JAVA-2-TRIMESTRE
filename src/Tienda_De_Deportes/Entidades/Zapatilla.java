package Tienda_De_Deportes.Entidades;

public class Zapatilla extends Producto{

    public enum Numero {n35, n36, n37, n38, n39, n40, n41, n42, n43, n44, n45, n46, n47, n48, n49, n50};
    private Numero numero;
    public enum Categoria{RUNNING, WALKING, FUTBOL, GIMNASIO, CHANCLAS, TRAIL, BALONCESTO, GOLF};
    private Categoria categoria;

    public Zapatilla(String nombre, String descripcion, Double precio, Integer unidadesStock, Numero numero, Categoria categoria) {
        super(nombre, descripcion, precio, unidadesStock);
        this.numero = numero;
        this.categoria = categoria;
    }
    public Zapatilla(Zapatilla zapatilla) {
        super(zapatilla);
        this.numero = zapatilla.numero;
        this.categoria = zapatilla.categoria;
    }

    public Numero getNumero() {
        return numero;
    }

    public void setNumero(Numero numero) {
        this.numero = numero;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Zapatilla{" +
                "numero=" + numero +
                ", categoria=" + categoria +
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
        if (this.numero.equals(Numero.n35) || this.numero.equals(Numero.n47) || this.numero.equals(Numero.n48) ||
                this.numero.equals(Numero.n49) || this.numero.equals(Numero.n50)){
            descuentoTotal = 0.05;
        }
        return this.precio * descuentoTotal;
    }
}
