package PracticaClase.Clases;

public class ProductoRefrigerado extends Producto{

    private int nivelRefrigeracion;
    //Constructor

    public ProductoRefrigerado(String nombre, double peso, int nivelRefrigeracion) {
        super(nombre, peso);
        this.nivelRefrigeracion = nivelRefrigeracion;
    }
    //Getters and setters

    public int getNivelRefrigeracion() {
        return nivelRefrigeracion;
    }

    public void setNivelRefrigeracion(int nivelRefrigeracion) {
        this.nivelRefrigeracion = nivelRefrigeracion;
    }

    /**
     *
     * @param internacional
     * @return Si el producto es refrigerado, se le suman 10€, si necesita una refrigeracion especial, le sumamos 30€
     */

    @Override
    public double calcularCostoEnvio(boolean internacional) {
        if (this.nivelRefrigeracion == 1){
            return super.calcularCostoEnvio(internacional) + 10;
        } else if (this.nivelRefrigeracion == 2) {
            return super.calcularCostoEnvio(internacional) + 30;
        } else {
            return super.calcularCostoEnvio(internacional);
        }

    }
}
