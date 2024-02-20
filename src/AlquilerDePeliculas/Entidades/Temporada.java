package AlquilerDePeliculas.Entidades;

import java.util.ArrayList;

public class Temporada {

    private int numero;
    private ArrayList<Episodio> episodios;
    private Serie serie;
    //Constructor-------

    public Temporada() {
        this.numero = 0;
        this.episodios = new ArrayList<>();
    }

    public Temporada(int numero) {
        this.numero = numero;
        this.episodios = new ArrayList<>();
    }
    //Getters and setters-------

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public ArrayList<Episodio> getEpisodios() {
        return episodios;
    }

    //toString--------

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Temporada{");
        sb.append("numero=").append(numero);
        sb.append(", episodios=").append(episodios);
        sb.append(", serie=").append(serie);
        sb.append('}');
        return sb.toString();
    }

    //Métodos----------
    public void addEpisodio(Episodio episodio){
        this.episodios.add(episodio);
        episodio.setTemporada(this);
    }
    public void delEpisodio(Episodio episodio){
        episodio.setTemporada(null);
        this.episodios.remove(episodio);
    }

    /**
     *
     * @return el número de episodios que tiene la temporada
     */

    public int getNumeroEpisodios(){
        return this.episodios.size();
    }
}
