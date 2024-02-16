package AlquilerDePeliculas.MULTIMEDIA;

import java.util.ArrayList;

public class PrimeVideo {

    private ArrayList<Multimedia> catalogo;
    private ArrayList<Cliente> suscriptores;
    private double ganancias;

    //Constructor---------

    public PrimeVideo() {
        this.catalogo = new ArrayList<>();
        this.suscriptores = new ArrayList<>();
        this.ganancias = 0;
    }

    //Métodos--------

    /**
     *
     * @param cliente
     * Le añadimos suscriptores al ArrayList
     */
    public void addSuscriptor(Cliente cliente) {
        if (!this.suscriptores.contains(cliente)){
            this.suscriptores.add(cliente);
        }
    }

    /**
     * Le añadimos peliculas al catálogo, primero comprobamos que no esté dentro.
     * @param multimedia
     */
    public void addMultimedia(Multimedia multimedia) {
        if (!this.catalogo.contains(multimedia)) {
            this.catalogo.add(multimedia);
        }
    }

    /**
     *
     * @param m
     * @param c
     * Comprobamos que el cliente no es Pro, si no lo es
     * Se le añade a a las ganancias el precio de la película.
     */
    public void ver(Multimedia m, Cliente c) {
        if (!c.esPro()) {
            this.ganancias += m.getPrecio();
        }
    }

    /**
     * Recorremos el Array de Suscriptores, generamos una variable para calcular el precio total.
     * A esa variable le vamos sumando el precio mensual de cadad suscriptor multiplicado por los 12 meses del año.
     * @return el total de todas las ganancias anuales.
     */
    public double getGanancias() {
        double gananciasTotales = 0;
        for (Cliente cliente : this.suscriptores) {
            gananciasTotales += cliente.getPrecioMensual() * 12;
        }
        return gananciasTotales;
    }

}
