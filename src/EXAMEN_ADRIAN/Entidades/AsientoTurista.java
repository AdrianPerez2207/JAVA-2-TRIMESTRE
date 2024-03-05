package EXAMEN_ADRIAN.Entidades;

public class AsientoTurista extends Asiento{

    private Boolean ventana;

    public AsientoTurista(Long id, Double precioBase, Integer fila, String letra, Boolean ventana) {
        super(id, precioBase, fila, letra);
        this.ventana = ventana;
        super.tipo = TipoAsiento.TURISTA;
    }

    public Boolean getVentana() {
        return ventana;
    }

    public void setVentana(Boolean ventana) {
        this.ventana = ventana;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AsientoTurista{");
        sb.append("ventana=").append(ventana);
        sb.append(", id=").append(id);
        sb.append(", pasajero=").append(pasajero.dniPasaporte);
        sb.append(", precioTurista=").append(calcularPrecio());
        sb.append(", tipo=").append(tipo);
        sb.append('}');
        return sb.toString();
    }

    /**
     *
     * @return el precio del asiento, si no tiene ventana sería el precio base.
     * Si tiene ventana se le añaden 10€ al asiento.
     */

    @Override
    public Double calcularPrecio() {
        if (this.ventana){
            return precioBase + 10;
        }
        return precioBase;
    }
}
