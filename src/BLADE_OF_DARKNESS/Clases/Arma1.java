package BLADE_OF_DARKNESS.Clases;

public class Arma1 {
    public enum tipo{ESPADA, HACHA, BASTON, ARCO};
    private tipo tipoArma;
    private String nombre;
    private int puntosD; //Puntos de daño
    private boolean dosManos;
    /*CONSTRUCTOR-------------------------*/
    public Arma1(tipo tipoArma, String nombre, int puntosD, boolean dosManos) {
        this.tipoArma = tipoArma;
        this.nombre = nombre;
        this.puntosD = puntosD;
        this.dosManos = dosManos;
    }
    /*GETTERS AND SETTERS----------------------*/
    public tipo getTipoArma() {
        return tipoArma;
    }

    public void setTipoArma(tipo tipoArma) {
        this.tipoArma = tipoArma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntosD() {
        return puntosD;
    }

    public void setPuntosD(int puntosD) {
        this.puntosD = puntosD;
    }

    public boolean isDosManos() {
        return dosManos;
    }

    public void setDosManos(boolean dosManos) {
        this.dosManos = dosManos;
    }
    /*toString---------------------*/
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Arma{");
        sb.append("tipoArma=").append(tipoArma);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", puntosD=").append(puntosD);
        sb.append(", dosManos=").append(dosManos);
        sb.append('}');
        return sb.toString();
    }
}
