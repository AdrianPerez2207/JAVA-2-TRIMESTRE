package McBurguer.dominio;

import McBurguer.interfaces.Cocinable;

public class Patata extends Comida implements Cocinable {
    private int estado;

    public Patata() {
        super();
        this.estado = CRUDA;
        this.nombre = "Patata";
        this.tipoIngrediente = "Comida";
    }

    //Getters y Setters---------------------

    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }

    //Métodos---------------------

    /**
     *
     * Implementamos los métodos de la interfaz cocinable
     * En cada uno de ellos, cuando llamamos al método, cambiamos la variable estado.
     */
    @Override
    public void freir() {

        this.estado = FRITA;
    }

    @Override
    public void cocer() {
        this.estado = COCIDA;
    }

    @Override
    public void asar() {
        this.estado = ASADA;
    }

    /**
     * Calculamos el precio de la patata según el estado que tenga
     * @return El precio de la forma de ser cocinada
     */

    @Override
    public Double obtenerPrecio() {
        if (this.estado == FRITA ){
            return 1.10;
        } else if (this.estado == COCIDA) {
            return 0.80;
        } else {
            return 0.90;
        }
    }
}
