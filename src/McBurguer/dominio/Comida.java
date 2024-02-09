package McBurguer.dominio;

public abstract class Comida extends Ingrediente{

    protected  boolean cocinado;

    public Comida() {
        this.cocinado = false;
    }
    public void cocinar() {
        this.cocinado = true;
    }
}
