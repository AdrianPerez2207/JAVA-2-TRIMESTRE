package EquipoCiclistas;

public class Escalador extends Ciclista{
    private Float aceleracionPromedio; //m/s2
    private Float gradoRampa; //Grados
    //Constructor-------------

    public Escalador(Integer identificador, String nombreCiclista, Float aceleracionPromedio, Float gradoRampa) {
        super(identificador, nombreCiclista);
        this.aceleracionPromedio = aceleracionPromedio;
        this.gradoRampa = gradoRampa;
    }
    //Getters and setters----------
    public Float getAceleracionPromedio() {
        return aceleracionPromedio;
    }

    public void setAceleracionPromedio(Float aceleracionPromedio) {
        this.aceleracionPromedio = aceleracionPromedio;
    }

    public Float getGradoRampa() {
        return gradoRampa;
    }

    public void setGradoRampa(Float gradoRampa) {
        this.gradoRampa = gradoRampa;
    }
    //toString---------------------

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Escalador{");
        sb.append("identificador=").append(identificador);
        sb.append(", nombreCiclista='").append(nombreCiclista).append('\'');
        sb.append(", tiempoAcumulado=").append(tiempoAcumulado);
        sb.append(", aceleracionPromedio=").append(aceleracionPromedio);
        sb.append(", gradoRampa=").append(gradoRampa);
        sb.append('}');
        return sb.toString();
    }
    //Métodos----------
    @Override
    public String imprimirTipo() {
        return "Escalador";
    }
}
