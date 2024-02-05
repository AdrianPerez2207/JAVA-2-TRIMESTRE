package BLADE_OF_DARKNESS.Clases;

public class MonstruoFinalNivel extends Monstruo1{
    private int golpeEspecial;
    private int usosGolpeEspacial;
    //Constructor--------------------
    public MonstruoFinalNivel(String nombre, Clase claseMonstruo, int puntosD, int golpeEspecial) {
        super(nombre, claseMonstruo, puntosD);
        this.golpeEspecial = golpeEspecial;
        this.usosGolpeEspacial = 3;
    }
    //Getters y Setters--------------------

    public int getGolpeEspecial() {
        return golpeEspecial;
    }

    public void setGolpeEspecial(int golpeEspecial) {
        this.golpeEspecial = golpeEspecial;
    }

    public int getUsosGolpeEspacial() {
        return usosGolpeEspacial;
    }

    public void setUsosGolpeEspacial(int usosGolpeEspacial) {
        this.usosGolpeEspacial = usosGolpeEspacial;
    }

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

    @Override
    public Clase getClaseMonstruo() {
        return super.getClaseMonstruo();
    }

    @Override
    public void setClaseMonstruo(Clase claseMonstruo) {
        super.setClaseMonstruo(claseMonstruo);
    }

    @Override
    public int getPuntosD() {
        return super.getPuntosD();
    }

    @Override
    public void setPuntosD(int puntosD) {
        super.setPuntosD(puntosD);
    }
    //toString------------------------
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Monstruo{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", claseMonstruo=").append(claseMonstruo);
        sb.append(", nivel=").append(nivel);
        sb.append(", salud=").append(salud);
        sb.append(", puntosD=").append(puntosD);
        sb.append(", golpeEspecial=").append(golpeEspecial);
        sb.append(", usosGolpeEspecial=").append(usosGolpeEspacial);
        sb.append('}');
        return sb.toString();
    }
    //Métodos-----------------------------
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
     *                Cuando el monstruo golpee,
     *                  reducirá la vida lo que indique el golpe y le sumamos el golpe especial.
     */

    @Override
    public void golpear(Personaje personaje) {
        if (usosGolpeEspacial > 3){
            personaje.reducirVida(puntosD + golpeEspecial);
        } else {
            super.golpear(personaje);
        }
    }
}
