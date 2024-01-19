package EjerciciosPOO.Ejercicio1.Ejercicio6;

public class SteamJuego {
    private String nombre;
    private String descripcionCorta;
    private double mediaJugadoresDiarios;
    private int diasDesdeSalida;
    private double precio;
    private int puestoMasVendidos;

    //Constructor
    public SteamJuego(String nombre, String descripcionCorta, double mediaJugadoresDiarios, int diasDesdeSalida, double precio, int puestoMasVendidos) {
        this.nombre = nombre;
        this.descripcionCorta = descripcionCorta;
        this.mediaJugadoresDiarios = mediaJugadoresDiarios;
        this.diasDesdeSalida = diasDesdeSalida;
        this.precio = precio;
        this.puestoMasVendidos = puestoMasVendidos;
    }
    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    public double getMediaJugadoresDiarios() {
        return mediaJugadoresDiarios;
    }

    public void setMediaJugadoresDiarios(double mediaJugadoresDiarios) {
        this.mediaJugadoresDiarios = mediaJugadoresDiarios;
    }

    public int getDiasDesdeSalida() {
        return diasDesdeSalida;
    }

    public void setDiasDesdeSalida(int diasDesdeSalida) {
        this.diasDesdeSalida = diasDesdeSalida;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getPuestoMasVendidos() {
        return puestoMasVendidos;
    }

    public void setPuestoMasVendidos(int puestoMasVendidos) {
        this.puestoMasVendidos = puestoMasVendidos;
    }
    //Métodos
    public void jugadoresDia(int jugadoresHoy){
        double jugadoresActualizados;
        jugadoresActualizados = ((mediaJugadoresDiarios * diasDesdeSalida) + jugadoresHoy) / (diasDesdeSalida + 1);
    }
}
