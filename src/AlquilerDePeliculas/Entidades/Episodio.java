package AlquilerDePeliculas.Entidades;

public class Episodio {

    private String titulo;
    private int duracion;
    private Temporada temporada;
    //Constructor-------

    public Episodio() {
        this.titulo = "";
        this.duracion = 0;
    }

    public Episodio(String titulo, int duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }
    //Getters and setters-------

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }
    //ToString----------

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Episodio{");
        sb.append("titulo='").append(titulo).append('\'');
        sb.append(", duracion=").append(duracion);
        sb.append(", temporada=").append(temporada);
        sb.append('}');
        return sb.toString();
    }
}
