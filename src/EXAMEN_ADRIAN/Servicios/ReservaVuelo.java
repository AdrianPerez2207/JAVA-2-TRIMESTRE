package EXAMEN_ADRIAN.Servicios;

import EXAMEN_ADRIAN.Entidades.*;

import java.util.ArrayList;

public class ReservaVuelo {

    private Long id;
    private static Long calcularId = 0L;
    private Vuelo vuelo;
    private ArrayList<Pasajero> pasajeros;
    private TipoTarifa tipoT;
    private TipoAsiento tipoA;

    public ReservaVuelo(Vuelo vuelo, TipoTarifa tipoT, TipoAsiento tipoA) {
        this.id = calcularId++;
        this.vuelo = vuelo;
        this.tipoT = tipoT;
        this.tipoA = tipoA;
        this.pasajeros = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public TipoTarifa getTipoT() {
        return tipoT;
    }

    public void setTipoT(TipoTarifa tipoT) {
        this.tipoT = tipoT;
    }

    public TipoAsiento getTipoA() {
        return tipoA;
    }

    public void setTipoA(TipoAsiento tipoA) {
        this.tipoA = tipoA;
    }

    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ReservaVuelo{");
        sb.append("id=").append(id);
        sb.append(", vuelo=").append(vuelo.getCodigo());
        sb.append(", dias para el vuelo=").append(vuelo.diasFaltanVuelo());
        sb.append(", información=").append(imprimirBilletes());
        sb.append('}');
        return sb.toString();
    }
    //Métodos----

    /**
     * Añadimos un pasajero
     * @param pasajero
     */
    public void addPasajero(Pasajero pasajero){
        pasajeros.add(pasajero);
    }
    /**
     * Eliminamos un pasajero
     * @param pasajero
     */
    public void delPasajero(Pasajero pasajero){
        pasajeros.remove(pasajero);
    }

    /**
     * Miramos en la lista de pasajeros y comprobamos los pasajeros que tiene un asiento asignado.
     * Guardamos la información del asiento en una lista.
     * @return la información de los asientos ocupados.
     */
    public ArrayList<Asiento> getPasajero(){
        ArrayList<Asiento> asientos = new ArrayList<>();
        for (Pasajero pasajero : pasajeros){
            if (pasajero.getAsiento() != null){
                asientos.add(pasajero.getAsiento());
            }
        }
        return asientos;
    }

    /**
     * Comprobamos la disponibilidad del asiento indicado, en caso de tener asiento libre, lo ocupamos.
     * En caso de ocuparlo,clonamos al pasajero y lo añadimos a la lista de pasajeros de la reserva.
     * @param pasajero
     */
    public void reservaAsiento(Pasajero pasajero){
        if (vuelo.buscarAsientoDisponible(pasajero.getAsiento().getTipo()) == null){
            Pasajero pasajero1 = new Pasajero(pasajero);
            vuelo.ocuparAsiento(pasajero1, vuelo.buscarAsientoDisponible(pasajero.getAsiento().getTipo()));
            addPasajero(pasajero1);
        }
    }

    /**
     * Calculamos el precio total de los asientos de la reserva.
     * @return el precio según la tarifa de cada asiento.
     */
    public Double calcularPrecioTotal(){
        Double suma = 0.0;
        for (Pasajero pasajero : pasajeros){
            if (tipoT.equals(TipoTarifa.OPTIMA)){
                suma += pasajero.getAsiento().calcularPrecio() * 1.10;
            } else if (tipoT.equals(TipoTarifa.CONFORT)){
                suma += pasajero.getAsiento().calcularPrecio() * 1.15;
            } else if (tipoT.equals(TipoTarifa.FLEXIBLE)) {
                suma += pasajero.getAsiento().calcularPrecio() * 1.30;
            } else {
                suma += pasajero.getAsiento().calcularPrecio();
            }
        }
        return suma;
    }

    public String imprimirBilletes(){
        StringBuffer sb = new StringBuffer();
        for (Pasajero pasajero : pasajeros){
            sb.append(pasajero);
            sb.append(pasajero.getAsiento());
        }
        sb.append(calcularPrecioTotal());
        return sb.toString();
    }
}
