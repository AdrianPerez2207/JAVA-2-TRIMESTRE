package EquipoCiclistas;

public class Velocista extends Ciclista{
    private Double potenciaPromedio;
    private Double velocidadPromedio;

    //Constructor----------------
    public Velocista(Integer identificador, String nombreCiclista, Double potenciaPromedio, Double velocidadPromedio) {
        super(identificador, nombreCiclista);
        this.potenciaPromedio = potenciaPromedio;
        this.velocidadPromedio = velocidadPromedio;
    }
    //Getters and setters----------
    public Double getPotenciaPromedio() {
        return potenciaPromedio;
    }

    public void setPotenciaPromedio(Double potenciaPromedio) {
        this.potenciaPromedio = potenciaPromedio;
    }

    public Double getVelocidadPromedio() {
        return velocidadPromedio;
    }

    public void setVelocidadPromedio(Double velocidadPromedio) {
        this.velocidadPromedio = velocidadPromedio;
    }
    //toString---------------------
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Velocista{");
        sb.append("identificador=").append(identificador);
        sb.append(", nombreCiclista='").append(nombreCiclista).append('\'');
        sb.append(", tiempoAcumulado=").append(tiempoAcumulado);
        sb.append(", potenciaPromedio=").append(potenciaPromedio);
        sb.append(", velocidadPromedio=").append(velocidadPromedio);
        sb.append('}');
        return sb.toString();
    }
    //Métodos----------
    @Override
    public String imprimirTipo() {
        return "Velocista";
    }
}
