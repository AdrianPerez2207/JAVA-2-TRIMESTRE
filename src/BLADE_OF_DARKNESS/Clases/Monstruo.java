package BLADE_OF_DARKNESS.Clases;

public class Monstruo {
    private String nombre;
    public enum clase{GOBLIN, TROLL, SKRALL, DEMONIO, FANTASMA};
    private clase claseMonstruo;
    private int nivel;
    private int salud;
    private int puntosD; //Puntos de daño que hace el monstruo al golpear.
    /*CONSTRUCTOR------------------------*/

    public Monstruo(String nombre, clase claseMonstruo, int puntosD) {
        this.nombre = nombre;
        this.claseMonstruo = claseMonstruo;
        this.puntosD = puntosD;
        /*Por defecto*/
        this.nivel = 1;
        this.salud = 100;
    }
    /*GETTERS AND SETTERS---------------------*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public clase getClaseMonstruo() {
        return claseMonstruo;
    }

    public void setClaseMonstruo(clase claseMonstruo) {
        this.claseMonstruo = claseMonstruo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
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
    /*MÉTODOS--------------------------------*/
    /**
     * Subimos de nivel hasta un máximo de 10, incluyendo la salud (2 elevado a su nivel).
     */
    public void subirNivel(){
        if (nivel < 10){
            this.nivel++;
            this.salud += Math.pow(2, this.nivel);
        }
    }

    /**
     *
     * @param puntosD Restamos a la salud del Monstruo los puntos de vida que indique la variable.
     * @return Si tras restar la salud del Monstruo es mayor que 0, devuelve false (sigue vivo),
     *          si es menor que 0, ponemos la salud a 0 y devuelve true (muerto).
     */
    public boolean reducirVida(int puntosD){
        this.salud -= puntosD;
        if (this.salud > 0){
            return false;
        } else {
            this.salud = 0;
            return true;
        }
    }

    /**
     *
     * @param jugador Llamamos al método reducir vida de la clase jugador.
     *                Cuando el monstruo golpee, reducirá la vida lo que indique el golpe
     */
    public void golpear(Jugador jugador){
        jugador.reducirVida(this.puntosD);
    }
}
