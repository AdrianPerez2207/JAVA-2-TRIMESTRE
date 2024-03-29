package McBurguer.dominio;

public abstract class Ingrediente {
    protected String nombre; //Ingrediente concreto
    protected String tipoIngrediente; //Si es comida o bebida

    //Constructor-----------------------------------

    public Ingrediente() {

    }

    //Getters and setters---------------
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoIngrediente() {
        return tipoIngrediente;
    }

    public void setTipoIngrediente(String tipoIngrediente) {
        this.tipoIngrediente = tipoIngrediente;
    }
    //toString-----------------------------------

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ingrediente{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", tipoIngrediente='").append(tipoIngrediente).append('\'');
        sb.append('}');
        return sb.toString();
    }
    //Métodos----------------
    public abstract  Double obtenerPrecio();
}
