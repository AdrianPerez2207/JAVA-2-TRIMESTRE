package PracticaClase.Clases;

public class ProductoFragil extends Producto{

    private int nivelFragil;


    public ProductoFragil(String nombre, double peso, int nivelFragil) {
        super(nombre, peso);
        this.nivelFragil = 0;
    }

    public int getNivelFragil() {
        return nivelFragil;
    }

    public void setNivelFragil(int nivelFragil) {
        this.nivelFragil = nivelFragil;
    }

    /**
     * Llamamos al método de la clase padre, comprobamos si el producto es Fragil o Muy Fragil
     * @param internacional
     * @return si el producto es fragil, se le suman 20€
     * Si es muy fragil, 30€
     */

    @Override
    public double calcularCostoEnvio(boolean internacional) {
        if (this.nivelFragil == 1){
            return super.calcularCostoEnvio(internacional) + 20;
        } else if (this.nivelFragil == 2) {
            return super.calcularCostoEnvio(internacional) + 50;
        }
        return super.calcularCostoEnvio(internacional);
    }
}
