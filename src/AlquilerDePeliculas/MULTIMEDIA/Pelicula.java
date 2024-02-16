package AlquilerDePeliculas.MULTIMEDIA;

public class Pelicula extends Multimedia{

    private int duracion; //En minutos.

    //Constructor-------

    public Pelicula(String titulo, boolean plus, double precio, int duracion) {
        super(titulo, plus, precio);
        this.duracion = duracion;
    }
    //Getters and setters-------

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    //ToString----------

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pelicula{");
        sb.append("codigo=").append(codigo);
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", esPlus=").append(esPlus);
        sb.append(", precio=").append(precio);
        sb.append(", genero=").append(genero);
        sb.append(", duracion=").append(duracion);
        sb.append('}');
        return sb.toString();
    }
}
