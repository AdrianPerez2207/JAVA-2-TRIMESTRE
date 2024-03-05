package EXAMEN_ADRIAN.Entidades;

public class AsientoBusiness extends Asiento{

    private Boolean comida;

    public AsientoBusiness(Long id, Double precioBase, Integer fila, String letra, Boolean comida) {
        super(id, precioBase, fila, letra);
        this.comida = comida;
        super.tipo = TipoAsiento.BUSINESS;
    }

    public Boolean getComida() {
        return comida;
    }

    public void setComida(Boolean comida) {
        this.comida = comida;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AsientoBusiness{");
        sb.append("comida=").append(comida);
        sb.append(", id=").append(id);
        sb.append(", pasajero=").append(pasajero.dniPasaporte);
        sb.append(", precioBusiness=").append(calcularPrecio());
        sb.append(", tipo=").append(tipo);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Precio base para el Business sería del precio normal, más el 25%.
     * @return el precio del asiento. Si incluye comida, se le suman 30€.
     */

    @Override
    public Double calcularPrecio() {
        Double precioBusiness = precioBase + (precioBase * 1.25);
        if (this.comida){
            return precioBusiness + 30;
        }
        return precioBusiness;
    }
}
