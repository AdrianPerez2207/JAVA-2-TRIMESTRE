package AlquilerDePeliculas.MULTIMEDIA;

import java.util.Objects;

public class Multimedia {

    protected long codigo;
    protected static long autoincremento = 1;
    protected String titulo;
    protected boolean esPlus;
    protected double precio;
    protected Genero genero;

    //Constructor------

    public Multimedia() {
    }

    public Multimedia(String titulo, boolean plus, double precio) {
        this.titulo = titulo;
        this.esPlus = plus;
        this.precio = precio;
        this.codigo = autoincremento++;
    }

    //Getters and setters------

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public static long getAutoincremento() {
        return autoincremento;
    }

    public static void setAutoincremento(long autoincremento) {
        Multimedia.autoincremento = autoincremento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isEsPlus() {
        return esPlus;
    }

    public void setEsPlus(boolean esPlus) {
        this.esPlus = esPlus;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    //ToString------

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Multimedia{");
        sb.append("codigo=").append(codigo);
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", esPlus=").append(esPlus);
        sb.append(", precio=").append(precio);
        sb.append(", genero=").append(genero);
        sb.append('}');
        return sb.toString();
    }
    //Equals------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Multimedia that = (Multimedia) o;
        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
