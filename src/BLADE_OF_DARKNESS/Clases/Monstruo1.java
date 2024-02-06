package BLADE_OF_DARKNESS.Clases;

import java.util.Objects;

public class Monstruo1 extends Personaje{
    public enum Clase {GOBLIN, TROLL, SKRALL, DEMONIO, FANTASMA};
    protected Clase claseMonstruo;
    protected int puntosD; //Puntos de daño que hace el monstruo al golpear.
    /*CONSTRUCTOR------------------------*/

    public Monstruo1(String nombre, Clase claseMonstruo, int puntosD) {
        super(nombre, 1, 100);
        this.claseMonstruo = claseMonstruo;
        this.puntosD = puntosD;
    }
    /*GETTERS AND SETTERS---------------------*/

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public int getNivel() {
        return super.getNivel();
    }

    @Override
    public void setNivel(int nivel) {
        super.setNivel(nivel);
    }

    @Override
    public int getSalud() {
        return super.getSalud();
    }

    @Override
    public void setSalud(int salud) {
        super.setSalud(salud);
    }

    public Clase getClaseMonstruo() {
        return claseMonstruo;
    }

    public void setClaseMonstruo(Clase claseMonstruo) {
        this.claseMonstruo = claseMonstruo;
    }

    public int getPuntosD() {
        return puntosD;
    }

    public void setPuntosD(int puntosD) {
        this.puntosD = puntosD;
    }
    /*toString---------------------*/

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Monstruo{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", claseMonstruo=").append(claseMonstruo);
        sb.append(", nivel=").append(nivel);
        sb.append(", salud=").append(salud);
        sb.append(", puntosD=").append(puntosD);
        sb.append('}');
        return sb.toString();
    }
    //equals---------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Monstruo1 monstruo1 = (Monstruo1) o;
        return puntosD == monstruo1.puntosD;
    }

    @Override
    public int hashCode() {
        return Objects.hash(puntosD);
    }

    /*MÉTODOS--------------------------------*/

    @Override
    public void subirNivel() {
        super.subirNivel();
    }

    @Override
    public boolean reducirVida(int puntosD) {
        return super.reducirVida(puntosD);
    }

    /**
     *
     * @param personaje Llamamos al método reducir vida de la clase jugador.
     *                Cuando el monstruo golpee, reducirá la vida lo que indique el golpe
     */
    @Override
    public void golpear(Personaje personaje) {
        personaje.reducirVida(this.puntosD);
    }
}
