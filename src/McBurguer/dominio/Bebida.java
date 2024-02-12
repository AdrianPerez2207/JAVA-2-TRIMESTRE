package McBurguer.dominio;

public abstract class Bebida extends Ingrediente{
    private boolean refrigerada;

    public Bebida() {

        this.refrigerada = false;
    }

    public boolean isRefrigerada() {
        return refrigerada;
    }

    public void setRefrigerada(boolean refrigerada) {
        this.refrigerada = refrigerada;
    }

    //Métodos---------

    /**
     * Si la bebida la quieren refrigerada la metemos en la nevera
     */
    public void meterEnNevera(){
        this.refrigerada = true;
    }
    /**
     * Si la bebida no la quieren refrigerada la sacamos de la nevera
     */
    public void sacarDeNevera(){
        this.refrigerada = false;
    }
    /**
     * Le ponemos precio a las bebidas
     */
    @Override
    public Double obtenerPrecio() {
        if (this.refrigerada){
            return 1.50; //Si está refrigerada el precio será de 1,50€
        } else {
            return 1.00; //Si no está refrigerada el precio será de 1€
        }
    }
}
