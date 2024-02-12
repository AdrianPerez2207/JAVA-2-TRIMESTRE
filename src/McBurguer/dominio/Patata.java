package McBurguer.dominio;

import McBurguer.interfaces.Cocinable;

public class Patata extends Comida implements Cocinable {
    private int estado;

    public Patata() {
        super();
        this.estado = CRUDA;
    }
    //Getters y Setters---------------------

    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }

    //Métodos---------------------
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
