package PracticaClase.Clases;

import PracticaClase.Interfaz.Transportable;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Envio {

    private ArrayList<Transportable> envios;
    private LocalDate fechaSalida;
    private LocalDate fechaLlegada;
    private boolean esInternacional;
    //Constructor

    public Envio() {
        this.envios = new ArrayList<>();
        this.fechaSalida = LocalDate.now();
        this.fechaLlegada = null;
        this.esInternacional = false;
    }
    //Getters and setters

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public boolean isEsInternacional() {
        return esInternacional;
    }

    public void setEsInternacional(boolean esInternacional) {
        this.esInternacional = esInternacional;
    }

    public ArrayList<Transportable> getEnvios() {
        return envios;
    }

    public void setEnvios(ArrayList<Transportable> envios) {
        this.envios = envios;
    }
    //toString-----------------------------------

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Envio{");
        sb.append("envios=").append(envios);
        sb.append(", fechaSalida=").append(fechaSalida);
        sb.append(", fechaLlegada=").append(fechaLlegada);
        sb.append(", esInternacional=").append(esInternacional);
        sb.append('}');
        return sb.toString();
    }

    //Métodos

    /**
     *
     * @param item le pasamos un producto (item) y lo añadimos al Array.
     */
    public void agregarTransportable(Transportable item){
        this.envios.add(item);
    }

    /**
     * Para calcular el costo total, generamos una variable inicializada en 0.
     * Recorremos el Array de Envios y le vamos sumando el coste de cada producto, llamando al método de su clase.
     * @return Nos devuelve el costo total de todos los productos.
     */

    public double calcularCostoTotalEnvio(boolean esInternacional){
        double costoTotal = 0;
        if (!esInternacional) {
            for (Transportable envio : envios) {
                costoTotal += envio.calcularCostoEnvio(false);
            }
        } else {
            for (Transportable envio : envios) {
                costoTotal += envio.calcularCostoEnvio(true);
            }
        }
        return costoTotal;
    }

    /**
     * Pintamos todos los prodcutos dentro del Array
     */

    public void listarProductos(){
        for (Transportable envio : envios) {
            System.out.println(envio);
            System.out.println(envio.calcularCostoEnvio(false));
        }
    }

    /**
     * @return Calculamos los dias con la clase "Period", calculamos solo los dias que han transcurrido.
     */
    public int diasTranscurridos(){
        Period periodo = Period.between(this.fechaSalida, this.fechaLlegada);
        return periodo.getDays();
    }
}
