package EquipoCiclistas;

import java.util.Objects;

public abstract class Ciclista {
    private Integer identificador;
    private String nombreCiclista;
    private Double tiempoAcumulado;

    //Constructor--------------


    public Ciclista(Integer identificador, String nombreCiclista) {
        this.identificador = identificador;
        this.nombreCiclista = nombreCiclista;
        this.tiempoAcumulado = 0.0;
    }
    //Getters and setters--------------
    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getNombreCiclista() {
        return nombreCiclista;
    }

    public void setNombreCiclista(String nombreCiclista) {
        this.nombreCiclista = nombreCiclista;
    }

    public Double getTiempoAcumulado() {
        return tiempoAcumulado;
    }

    public void setTiempoAcumulado(Double tiempoAcumulado) {
        this.tiempoAcumulado = tiempoAcumulado;
    }
    //toString--------------
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ciclista{");
        sb.append("identificador=").append(identificador);
        sb.append(", nombreCiclista='").append(nombreCiclista).append('\'');
        sb.append(", tiempoAcumulado=").append(tiempoAcumulado);
        sb.append('}');
        return sb.toString();
    }
    //equals--------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ciclista ciclista = (Ciclista) o;
        return Objects.equals(identificador, ciclista.identificador) && Objects.equals(nombreCiclista, ciclista.nombreCiclista) && Objects.equals(tiempoAcumulado, ciclista.tiempoAcumulado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, nombreCiclista, tiempoAcumulado);
    }

    //Método--------------
    public abstract String imprimirTipo();
}
