package EXAMEN_ADRIAN.Servicios;

import EXAMEN_ADRIAN.Entidades.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Atrapame {
    private ArrayList<Vuelo> vuelos;
    private ArrayList<ReservaVuelo> reservas;

    public Atrapame() {
        this.vuelos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    public ArrayList<ReservaVuelo> getReservas() {
        return reservas;
    }

    /**
     * Añadimos un vuelo a la colección.
     * @param vuelo
     */
    public void addVuelo(Vuelo vuelo){
        vuelos.add(vuelo);
    }

    /**
     * Comprobamos cuantos asientos del tipo indicado están libres.
     * Comprobamos cuantos pasajeros hay.
     * @param vuelo
     * @param pasajeros
     * @param tipoT
     * @param tipoA
     * @return false si el número de pasajeros es mayor que el número de asientos.
     * En caso contrario, creamos la reserva, le añadimos los pasajeros y añadimos la reserva a la lista de reservas.
     */
    public Boolean crearReserva(Vuelo vuelo, ArrayList<Pasajero> pasajeros, TipoTarifa tipoT, TipoAsiento tipoA){
        Integer asientosDisponibles = 0;
        Integer numeroDePasajeros = 0;
        for (Asiento asiento : vuelo.getAsientos()) {
           if (asiento == null && asiento.equals(tipoA)){
               asientosDisponibles++;
           }
        }
        for(Pasajero pasajero : pasajeros){
            numeroDePasajeros++;
        }
        if (numeroDePasajeros > asientosDisponibles) {
            return false;
        } else {
            ReservaVuelo reserva1 = new ReservaVuelo(vuelo, tipoT, tipoA);
            for (Pasajero pasajero : pasajeros){
                reserva1.addPasajero(pasajero);
            }
            reservas.add(reserva1);
            return true;
        }
    }
    public void cancelarReserva(Long id){
        for (ReservaVuelo reserva : reservas){
            if (reserva.equals(id)){
                reservas.remove(this);
            }
        }
    }

    /**
     * Buscamos vuelos que coincidadn con el destino, lo añadimos a una lista.
     * @param destino
     * @return la lista con los vuelos que se dirigen a ese destino.
     */
    public ArrayList<Vuelo> buscarVuelos(String destino){
        ArrayList<Vuelo> vuelosEncontrados = new ArrayList<>();
        for (Vuelo vuelo : this.vuelos){
            if (vuelo.getDestino().equals(destino)){
                vuelosEncontrados.add(vuelo);
            }
        }
        return vuelosEncontrados;
    }
    /**
     * Buscamos vuelos que coincidadn con la fehca, lo añadimos a una lista.
     * @param fecha
     * @return la lista con los vuelos que salen a esa fecha.
     */
    public ArrayList<Vuelo> buscarVuelos(LocalDate fecha){
        ArrayList<Vuelo> vuelosEncontrados = new ArrayList<>();
        for (Vuelo vuelo : this.vuelos){
            if (vuelo.getFecha().equals(fecha)){
                vuelosEncontrados.add(vuelo);
            }
        }
        return vuelosEncontrados;
    }
    /**
     * Buscamos vuelos que coincidadn con el destino y la fecha, lo añadimos a una lista.
     * @param destino
     * @param fecha
     * @return la lista con los vuelos que se dirigen a ese destino y la fecha.
     */
    public ArrayList<Vuelo> buscarVuelos(LocalDate fecha, String destino){
        ArrayList<Vuelo> vuelosEncontrados = new ArrayList<>();
        for (Vuelo vuelo : this.vuelos){
            if (vuelo.getDestino().equals(destino) && vuelo.getFecha().equals(fecha)){
                vuelosEncontrados.add(vuelo);
            }
        }
        return vuelosEncontrados;
    }

    /**
     * Buscamos las reservas que coincidan con el dni de la persona que la ha generado.
     * @param dni
     * @return todas las reservas creadas por ese pasajero.
     */
    public ArrayList<ReservaVuelo> buscarReservas(String dni){
        ArrayList<ReservaVuelo> reservasEncontradas = new ArrayList<>();
            for (ReservaVuelo reserva : reservas){
                if (reserva.equals(dni)){
                    reservasEncontradas.add(reserva);
                }
            }
            return reservasEncontradas;
    }

}
