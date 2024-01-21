package EjerciciosPOO.Ejercicio1.Ejercicio7;

public class Incidencia {
    enum Estado {abierta, en_proceso, resuelta};
    private int codigo;
    private Estado estado;
    private String problema;
    private String solucion;
    private static int pendientes = 0; //Propiedad estática para llevar el número de incidencias pendientes
    //Constructor

    public Incidencia(int codigo, Estado estado, String problema, String solucion) {
        this.codigo = codigo;
        this.estado = Estado.abierta;
        this.problema = problema;
        this.solucion = solucion;

        //Incrementar el número de incidencias pendientes
        Incidencia.pendientes++;
    }

    //Getters y Setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public static int getPendientes() {
        return pendientes;
    }

    public static void setPendientes(int pendientes) {
        Incidencia.pendientes = pendientes;
    }

    //ToString


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Incidencia{");
        sb.append("codigo=").append(codigo);
        sb.append(", estado=").append(estado);
        sb.append(", problema='").append(problema).append('\'');
        sb.append(", solucion='").append(solucion).append('\'');
        sb.append('}');
        return sb.toString();
    }

    //Métodos
    public static void resuelve(){ //Método para descontar las incidencias que ya están resultas
        if (pendientes > 0){
            pendientes--;
        }
    }
    public static int getPendientesActual() { //Método estático que devuelve el número de incidencias pendientes de resolver
        return Incidencia.pendientes;
    }
}
