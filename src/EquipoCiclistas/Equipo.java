package EquipoCiclistas;

import java.util.ArrayList;

public class Equipo {
    private ArrayList<Ciclista> ciclistas;
    private String nombreEquipo;
    private static Double sumaTiempos;
    private String paisEquipo;

    //Constructor----------

    public Equipo(String nombreEquipo, String paisEquipo) {
        this.ciclistas = new ArrayList<>();
        this.nombreEquipo = nombreEquipo;
        this.paisEquipo = paisEquipo;
        this.sumaTiempos = 0.0;
    }
    //Getters and setters----------
    public ArrayList<Ciclista> getCiclistas() {
        return ciclistas;
    }

    public void setCiclistas(ArrayList<Ciclista> ciclistas) {
        this.ciclistas = ciclistas;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public static Double getSumaTiempos() {
        return sumaTiempos;
    }

    public static void setSumaTiempos(Double sumaTiempos) {
        Equipo.sumaTiempos = sumaTiempos;
    }

    public String getPaisEquipo() {
        return paisEquipo;
    }

    public void setPaisEquipo(String paisEquipo) {
        this.paisEquipo = paisEquipo;
    }
    //toString-------------

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Equipo{");
        sb.append("ciclistas=").append(ciclistas);
        sb.append(", nombreEquipo='").append(nombreEquipo).append('\'');
        sb.append(", paisEquipo='").append(paisEquipo).append('\'');
        sb.append('}');
        return sb.toString();
    }
    //Métodos---------------------

    /**
     *
     * @param ciclista le pasamos un ciclista para añadirlo al ArrayList del equipo.
     */
    public void añadirCiclista(Ciclista ciclista) {
        ciclistas.add(ciclista);
    }
    /**
     * Calculamos la suma de todos los ciclistas del equipo recorriendo el Array y sumando sus tiempos acumulados.
     */
    public Double calcularTiempoAcumulado() {
        for (Ciclista ciclista : ciclistas) {
            sumaTiempos += ciclista.getTiempoAcumulado();
        }
        return sumaTiempos;
    }
    /**
     * Recorremos el ArrayList del equipo y pintamos por pantalla los nombres de los ciclistas
     */
    public void listarCiclistas() {
        for (Ciclista ciclista : ciclistas) {
            System.out.println(ciclista.getNombreCiclista());
        }
    }

    /**
     *
     * @param identificador Le pasamos el identificador pasado por parñametro
     *  Recorremos el ArrayList del equipo y si el identificador coincide con alguno de los ciclistas,
     *  imprimimos sus datos por teclado.
     */
    public void buscarCiclista(Integer identificador) {
        for (Ciclista ciclista : ciclistas) {
            if (ciclista.getIdentificador().equals(identificador)) {
                System.out.println("Nombre del ciclista: " + ciclista.getNombreCiclista());
                System.out.println("Tiempo acumulado: " + ciclista.getTiempoAcumulado());
            } else {
                System.out.println("El identificador no coincide con ninguno de nuestros ciclistas.");
            }
        }
    }
}
