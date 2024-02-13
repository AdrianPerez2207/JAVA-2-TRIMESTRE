package McBurguer.dominio;

public abstract class Comida extends Ingrediente{

    protected  boolean cocinado;

    /**
     * Constructor inicializando la variable en "False", no está copcinada
     */

    public Comida() {
        this.cocinado = false;
    }

    /**
     * Al llamar a este método cambia el estado de la coomida
     */
    public void cocinar() {
        this.cocinado = true;
    }
}
