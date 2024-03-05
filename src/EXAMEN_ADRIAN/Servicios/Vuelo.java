package EXAMEN_ADRIAN.Servicios;

import EXAMEN_ADRIAN.Entidades.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Objects;

public class Vuelo {

    private String codigo;
    private String origen;
    private String destino;
    private LocalDate fecha;
    private LocalTime hora;
    private Double precioBase;
    private Integer asientosDisponibles;
    private ArrayList<Asiento> asientos;

    public Vuelo(String codigo, String origen, String destino, LocalDate fecha,
                 LocalTime hora, Double precioBase, Integer asientosDisponibles) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.hora = hora;
        this.precioBase = precioBase;
        this.asientosDisponibles = asientosDisponibles;
        this.asientos = new ArrayList<>();
        crearAsientos();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public Integer getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(Integer asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Vuelo{");
        sb.append("codigo='").append(codigo).append('\'');
        sb.append(", origen='").append(origen).append('\'');
        sb.append(", destino='").append(destino).append('\'');
        sb.append(", fecha=").append(fecha);
        sb.append(", hora=").append(hora);
        sb.append(", precioBase=").append(precioBase);
        sb.append(", asientosDisponibles=").append(asientosDisponibles);
        sb.append(", asientos=").append(asientos);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vuelo vuelo = (Vuelo) o;
        return Objects.equals(codigo, vuelo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    /**
     * Creamos todos los asientos y los añadimos a la colección de los asientos del vuelo.
     * Un 30% serán Business y el restante turistas.
     */
    private void crearAsientos(){
        for (int i = 0; i < this.asientosDisponibles; i++) {
            if (i < (this.asientosDisponibles * 0.30)){
                Asiento asientoBusiness = new AsientoBusiness(23L + i, this.precioBase, i, "A+" + i, true);
                asientos.add(asientoBusiness);
            } else {
                Asiento asientoTurista = new AsientoTurista(20L + i, this.precioBase, 31 + i, "T" + i, false);
                asientos.add(asientoTurista);
            }
        }
    }

    /**
     * Buscamos el tipo de asiento y si coincide, verificamos que esté vacío (null).
     * @param tipoAsiento
     * @return el número de asientos disponibles.
     */
    public Integer verificarDisponibilidad(TipoAsiento tipoAsiento){
        Integer disponibles = 0;
        for (Asiento asiento : asientos){
            if (asiento.getTipo().equals(tipoAsiento) && asiento.getPasajero() == null){
                disponibles++;
            }
        }

        return disponibles;
    }

    /**
     * Buscamos el primer asiento libre del tipo indicado.
     * Si no quedan asientos disponibles, nos saltará un mensaje.
     * @param tipoAsiento
     * @return el primer asiento libre de ese tipo. En caso no tener disponibles, devuelve "null".
     */
    public Asiento buscarAsientoDisponible(TipoAsiento tipoAsiento){
        for (Asiento asiento : asientos){
            if (asiento.getTipo().equals(tipoAsiento) && asiento.getPasajero() == null){
                return asiento;
            } else {
                System.out.println("No quedan asientos disponibles.");
                return null;
            }
        }
        return null;
    }

    /**
     * Comprobamos que el asiento pasado por parámetro esté libre.
     * @param pasajero
     * @param asiento
     * @return Si está libre, se le añade el asiento al pasajero, y el pasajero al asiento. Devuelve true.
     * En caso contrario devuelve false.
     */
    public Boolean ocuparAsiento(Pasajero pasajero, Asiento asiento){
        if (asiento.getPasajero() == null){
            pasajero.setAsiento(asiento);
            asiento.setPasajero(pasajero);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Comprobamos que el asiento que queremos liberar no esté ua libre.
     * Devolvemos el asiento a null y al pasajero igual.
     * @param asiento
     * @param pasajero
     */
    public void liberarAsiento(Asiento asiento, Pasajero pasajero){
        if (asiento.getPasajero() != null){
            asiento.setPasajero(null);
            pasajero.setAsiento(null);
        }
    }

    /**
     * Calculamos los días que faltan para que salga el vuelo.
     * @return los días restantes.
     */
    public Integer diasFaltanVuelo(){
        Period periodo = Period.between(LocalDate.now(), fecha);
        return periodo.getDays();
    }

    /**
     * Buscamos los asiento que estén ocupados, y añadimos la información de sus ocupantes.
     * @return la lista de pasajeros del vuelo.
     */
    public ArrayList<Pasajero> getPasajeros(){
        ArrayList<Pasajero> pasajeros = new ArrayList<>();
        for (Asiento asiento : asientos){
            if (asiento.getPasajero() != null){
                pasajeros.add(asiento.getPasajero());
            }
        }
        return pasajeros;
    }
}
