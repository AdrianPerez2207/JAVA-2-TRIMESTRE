package McBurguer.dominio;

public class Cola extends Bebida{
    /**
     * Creamos solo el constructor, y le ponemos nombre y el tipo de ingrediente que es (lo hereda de bebida)
     */
    public Cola() {
        this.nombre = "Cola";
        this.tipoIngrediente = "Bebida";
    }
}
