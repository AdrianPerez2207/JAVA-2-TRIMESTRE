package BLADE_OF_DARKNESS.Clases;

public class Jugador {
    private String nombre;
    public enum clase{MAGO, BRUJO, BARBARO, CABALLERO};
    private clase claseJugador;
    private int nivel;
    private int experiencia;
    private int salud;
    private Arma armaDerecha;
    private Arma armaIzquierda;
    /*CONSTRUCTOR------------------------*/
    public Jugador(String nombre, clase claseJugador) {
        this.nombre = nombre;
        this.claseJugador = claseJugador;
        /*Por defecto*/
        this.nivel = 1;
        this.salud = 200;
        this.experiencia = 0;
        this.armaDerecha = null;
        this.armaIzquierda = null;

    }
    /*GETTERS AND SETTERS---------------------*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public clase getClaseJugador() {
        return claseJugador;
    }

    public void setClaseJugador(clase claseJugador) {
        this.claseJugador = claseJugador;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public Arma getArmaDerecha() {
        return armaDerecha;
    }

    public void setArmaDerecha(Arma armaDerecha) {
        this.armaDerecha = armaDerecha;
    }

    public Arma getArmaIzquierda() {
        return armaIzquierda;
    }

    public void setArmaIzquierda(Arma armaIzquierda) {
        this.armaIzquierda = armaIzquierda;
    }
    /*toString---------------------*/

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Jugador{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", claseJugador=").append(claseJugador);
        sb.append(", nivel=").append(nivel);
        sb.append(", experiencia=").append(experiencia);
        sb.append(", salud=").append(salud);
        sb.append(", armaDerecha=").append(armaDerecha);
        sb.append(", armaIzquierda=").append(armaIzquierda);
        sb.append('}');
        return sb.toString();
    }
    /*MÉTODOS--------------------------------*/

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
     * @param arma Si el jugador tiene las manos vacías (null), equipamos un arma en cualquier mano
     *             Si tiene alguna mano ocupada, llevamos ese arma a la otra mano.
     * @return Devuelve true si el jugador ha sido equipado, false en caso contrario.
     */
    public boolean equipar(Arma arma){
        if (this.armaIzquierda == null && this.armaDerecha == null){
            this.armaIzquierda = arma;
            return true;
        } else if (this.armaIzquierda!= null && this.armaDerecha == null){
            this.armaDerecha = arma;
            return true;
        } else {
            return false;
        }
    }
    /**
     *
     * @param puntosSalud Subimos la salud del jugador tanto como puntosSalud indique,
     *                    hasta un máximo de 10000.
     * @return Devuelve la suma de la salud del jugador y y los puntos de salud de la poción.
     */
    public int tomarPocion(int puntosSalud){
        if (this.salud < 10000){
            this.salud += puntosSalud;
        }
        return this.salud;
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
     *
     * @param monstruo Llamamos al método reducir vida de la clase Monstruo.
     *                Cuando el jugador golpee, reducirá la vida lo que indique el golpe del arma que posee.
     *                Si el jugador tiene un arma de 2 manos, quitará el daño de una de las manos.
     *                 Comprobamos la mano que tiene ocupada.
     */
    public void golpear(Monstruo monstruo){
        if (this.getArmaDerecha() != null){
            monstruo.reducirVida(this.getArmaDerecha().getPuntosD());
            if (! this.getArmaDerecha().isDosManos()){
                if (this.getArmaIzquierda() != null){
                    /**
                     * Si matamos al monstruo, subimos la experiencia del jugador en 10 * nivel del monstruo
                     */
                   if (monstruo.reducirVida(this.getArmaIzquierda().getPuntosD())){
                       this.experiencia += (10 * monstruo.getNivel());
                   }
                }
            }
        }
        /**
         * El máximo de experiencia es 1000. Si sobrepasamos ese nivel volvemos la experiencia a 1000.
         */
        if (this.experiencia >= 1000){
            this.experiencia = 1000;
        }
        /**
         * Cada vez que pasamos la experiencia de la centena subimos de nivel.
         */
        if (this.experiencia % 100 == 0){
            subirNivel();
        }
    }
}
