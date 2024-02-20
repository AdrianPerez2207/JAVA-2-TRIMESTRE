package AlquilerDePeliculas.Entidades;

import EjerciciosPOO.Ejercicio1.Temperatura;

import java.util.ArrayList;

public class Serie extends Multimedia{

    private ArrayList<Temporada> temporadas;

    //Constructor-----

    public Serie(String titulo, boolean plus, double precio) {
        super(titulo, plus, precio);
        this.temporadas = new ArrayList<>();
    }

    //Getters-----
    public ArrayList<Temporada> getTemporadas() {
        return temporadas;
    }

    //toString-----

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Serie{");
        sb.append(", codigo=").append(codigo);
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", esPlus=").append(esPlus);
        sb.append(", precio=").append(precio);
        sb.append(", genero=").append(genero);
        sb.append('}');
        return sb.toString();
    }


    //Métodos------------

    /**
     * @return Devolvemos el número de temporadas de cada serie
     */
    public int getNumeroTemporadas(){
        return this.temporadas.size();
    }

    /**
     * Añadimos temporadas al Array y se le pone a la Temporada la sere que ha estado añadiendo como "this"
     * @param temporada
     */
    public void addTemporada(Temporada temporada){
        this.temporadas.add(temporada);
        temporada.setSerie(this);
    }
    /**
     * Borramos temporadas del Array
     */
    public void delTemporadas(Temporada temporada){
        this.temporadas.remove(temporada);
    }
}
