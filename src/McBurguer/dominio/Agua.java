package McBurguer.dominio;

public class Agua extends Bebida{
    /**
     * Creamos solo el constructor, y le ponemos nombre y el tipo de ingrediente que es (lo hereda de bebida)
     */
    public Agua() {
        this.nombre = "Agua";
        this.tipoIngrediente = "Bebida";
    }
}
