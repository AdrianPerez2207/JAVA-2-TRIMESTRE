package EquipoCiclistas;

import java.util.Objects;

public abstract class Ciclista {
    protected Integer identificador;
    protected String nombreCiclista;
    protected Double tiempoAcumulado;

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
    //Métodos--------------
    public abstract String imprimirTipo();
}
