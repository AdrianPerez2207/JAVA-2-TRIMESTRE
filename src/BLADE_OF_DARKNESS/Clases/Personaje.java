package BLADE_OF_DARKNESS.Clases;

public abstract class Personaje {
    protected String nombre;
    protected int nivel;
    protected int salud;
    //Constructor---------------------
    public Personaje(String nombre, int nivel, int salud) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.salud = salud;
    }
    //Getters y Setters---------------------

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    //Métodos-------------------------
    /**
     * Subimos de nivel hasta un máximo de 10, incluyendo la salud.
     */
    public void subirNivel(){
        if (nivel < 10){
            this.nivel++;
            this.salud += Math.pow(2.5, this.nivel);
        }
    }
    /**
     *
     * @param puntosD Restamos a la salud del jugador y los puntos de vida que indique la variable.
     * @return Si tras restar la salud del jugador es mayor que 0, devuelve false (sigue vivo),
     *        si es menor que 0, devuelve true (muerto).
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
     * Método para golpear
     */
    public abstract void golpear(Personaje personaje);
}
