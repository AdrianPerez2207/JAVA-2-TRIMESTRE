package EjerciciosPOO_Clases.Ejercicio3;

import java.util.Objects;

public class Libro {
    private int ISBN;
    private String titulo;
    private String autor;
    private int numPaginas;
    private double precioCompra;
    private double precioVenta;
    private boolean vendido;

    //Constructor----------------------------
    public Libro(int ISBN, String titulo, String autor, int numPaginas, boolean vendido) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.precioCompra = 0;
        this.precioVenta = 0;
        this.vendido = vendido;
    }
    //Getters and setters--------------------------------
    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }
    //toString-----------------------
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Libro{");
        sb.append("ISBN=").append(ISBN);
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", autor='").append(autor).append('\'');
        sb.append(", numPaginas=").append(numPaginas);
        sb.append('}');
        return sb.toString();
    }
    //equals---------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return ISBN == libro.ISBN && numPaginas == libro.numPaginas && Double.compare(precioCompra, libro.precioCompra) == 0 && Double.compare(precioVenta, libro.precioVenta) == 0 && vendido == libro.vendido && Objects.equals(titulo, libro.titulo) && Objects.equals(autor, libro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN, titulo, autor, numPaginas, precioCompra, precioVenta, vendido);
    }
}
