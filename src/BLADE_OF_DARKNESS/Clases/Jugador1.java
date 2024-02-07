package BLADE_OF_DARKNESS.Clases;

public class Jugador1 extends  Personaje{
    public enum Clase {MAGO, BRUJO, BARBARO, CABALLERO};
    private Clase claseJugador;
    private int experiencia;
    private Arma1 armaDerecha;
    private Arma1 armaIzquierda;
    /*CONSTRUCTOR------------------------*/

    public Jugador1(String nombre, Clase claseJugador) {
        super(nombre, 1, 200);
        this.claseJugador = claseJugador;
        this.experiencia = 0;
        this.armaDerecha = null;
        this.armaIzquierda = null;
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

    public Clase getClaseJugador() {
        return claseJugador;
    }
    public void setClaseJugador(Clase claseJugador) {
        this.claseJugador = claseJugador;
    }
    public int getExperiencia() {
        return experiencia;
    }
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public Arma1 getArmaDerecha() {
        return armaDerecha;
    }

    public void setArmaDerecha(Arma1 armaDerecha) {
        this.armaDerecha = armaDerecha;
    }

    public Arma1 getArmaIzquierda() {
        return armaIzquierda;
    }

    public void setArmaIzquierda(Arma1 armaIzquierda) {
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

    @Override
    public void subirNivel() {
        super.subirNivel();
    }

    /**
     *
     * @param arma Si el jugador tiene las manos vacías (null), equipamos un arma en cualquier mano
     *             Si tiene alguna mano ocupada, llevamos ese arma a la otra mano.
     * @return Devuelve true si el jugador ha sido equipado, false en caso contrario.
     */
    public boolean equipar(Arma1 arma){
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
            this.salud += puntosSalud;
        if (this.salud + puntosSalud > 10000){
            this.salud = 10000;
        }
        return this.salud;
    }

    @Override
    public boolean reducirVida(int puntosD) {
        return super.reducirVida(puntosD);
    }
    /**
     *
     * @param personaje Llamamos al método reducir vida de la clase Monstruo.
     *                Cuando el jugador golpee, reducirá la vida lo que indique el golpe del arma que posee.
     *                Si el jugador tiene un arma de 2 manos, quitará el daño de una de las manos.
     *                 Comprobamos la mano que tiene ocupada.
     */
    @Override
    public void golpear(Personaje personaje) {
        if (this.getArmaDerecha() != null) {
            personaje.reducirVida(this.getArmaDerecha().getPuntosD());
            if (!this.getArmaDerecha().isDosManos()) {
                if (this.getArmaIzquierda() != null) {
                    personaje.reducirVida(this.getArmaDerecha().getPuntosD());
                }
            }
        }
        /**
         * Si matamos al monstruo, subimos la experiencia del jugador en 10 * nivel del monstruo
         */
        if (personaje.reducirVida(this.getArmaIzquierda().getPuntosD())) {
            this.experiencia += (10 * personaje.getNivel());
        }
        /**
         * El máximo de experiencia es 1000. Si sobrepasamos ese nivel volvemos la experiencia a 1000.
         */
        if (this.experiencia >= 1000) {
            this.experiencia = 1000;
        }
        /**
         * Calculamos la centena de la experiencia, si es mayor que el nivel, subimos nivel.
         * Empezamos en el nivel 1, si subimos de experiencia al 100, subimos de nivel.
         * El jugador terminaría en el nivel 11.
         */
        int centena = this.experiencia / 100;
        if (centena > this.nivel - 1){
            subirNivel();
        }

    }
}
