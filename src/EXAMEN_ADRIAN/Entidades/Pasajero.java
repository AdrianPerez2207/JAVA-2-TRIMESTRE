package EXAMEN_ADRIAN.Entidades;

public class Pasajero extends Persona{

    private String preferenciasComida;
    private String restriccionesMedicas;
    private Asiento asiento;

    public Pasajero(Long id, String nombre, String apellidos, String dniPasaporte, String email, String direccion,
                    String ciudad, String pais, Integer telefono, String preferenciasComida, String restriccionesMedicas, Asiento asiento) {
        super(id, nombre, apellidos, dniPasaporte, email, direccion, ciudad, pais, telefono);
        this.preferenciasComida = preferenciasComida;
        this.restriccionesMedicas = restriccionesMedicas;
        this.asiento = asiento;
    }
    public Pasajero(Pasajero pasajero){
        super.id = pasajero.id;
        super.nombre = pasajero.nombre;
        super.apellidos = pasajero.apellidos;
        super.dniPasaporte = pasajero.dniPasaporte;
        super.email = pasajero.email;
        super.direccion = pasajero.direccion;
        super.ciudad = pasajero.ciudad;
        super.pais = pasajero.pais;
        super.telefono = pasajero.telefono;
        this.preferenciasComida = pasajero.preferenciasComida;
        this.restriccionesMedicas = pasajero.restriccionesMedicas;
        this.asiento = pasajero.asiento;
    }

    public String getPreferenciasComida() {
        return preferenciasComida;
    }

    public void setPreferenciasComida(String preferenciasComida) {
        this.preferenciasComida = preferenciasComida;
    }

    public String getRestriccionesMedicas() {
        return restriccionesMedicas;
    }

    public void setRestriccionesMedicas(String restriccionesMedicas) {
        this.restriccionesMedicas = restriccionesMedicas;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pasajero{");
        sb.append("preferenciasComida='").append(preferenciasComida).append('\'');
        sb.append(", restriccionesMedicas='").append(restriccionesMedicas).append('\'');
        sb.append(", asiento=").append(asiento);
        sb.append(", id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellidos='").append(apellidos).append('\'');
        sb.append(", dniPasaporte='").append(dniPasaporte).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", direccion='").append(direccion).append('\'');
        sb.append(", ciudad='").append(ciudad).append('\'');
        sb.append(", pais='").append(pais).append('\'');
        sb.append(", telefono=").append(telefono);
        sb.append('}');
        return sb.toString();
    }
}
