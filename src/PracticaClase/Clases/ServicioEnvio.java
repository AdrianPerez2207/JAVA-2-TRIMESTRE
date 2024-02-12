package PracticaClase.Clases;

import java.time.Period;
import java.util.ArrayList;

public class ServicioEnvio {
    private ArrayList<Envio> envios;

    public ArrayList<Envio> getEnvios() {
        return envios;
    }

    public void setEnvios(ArrayList<Envio> envios) {
        this.envios = envios;
    }

    public ServicioEnvio() {
        this.envios = new ArrayList<>();
    }
    //toString-----------------------------------

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ServicioEnvio{");
        sb.append("envios=").append(envios);
        sb.append('}');
        return sb.toString();
    }

    //Métodos

    /**
     *
     * @param envio Agregamos envios al Array
     */
    public void agregarEnvio(Envio envio) {
        this.envios.add(envio);
    }

    /**
     * Recorremos el Array de envios, pintamos los envios, el costo total de los envios, y los dias transcurridos.
     * Para ello usamos métodos ya escritos en otras clases.
     */
    public void generarInformeEnvios(){
        double costoTotal = 0;
        for (Envio envio : envios) {
            costoTotal += envio.calcularCostoTotalEnvio(envio.isEsInternacional());
            System.out.println("Envio: " + envio.getFechaSalida() + " - " + envio.getFechaLlegada());
            envio.listarProductos();
            System.out.println("Costo total: " + envio.calcularCostoTotalEnvio(envio.isEsInternacional()));
            System.out.println("Días transcurridos: " + envio.diasTranscurridos());
            System.out.println();
        }
        System.out.println("Costo total: " + costoTotal);
    }

}
