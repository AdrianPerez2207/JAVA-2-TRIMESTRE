package EquipoCiclistas;

public class Contrarrelojista extends Ciclista{
    private Double velocidadMaxima;
    //Condtructor---------
    public Contrarrelojista(Integer identificador, String nombreCiclista, Double velocidadMaxima) {
        super(identificador, nombreCiclista);
        this.velocidadMaxima = velocidadMaxima;
    }
    //Getters and setters----------
    public Double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(Double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
    //toString---------------------

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Contrarrelojista{");
        sb.append("identificador=").append(identificador);
        sb.append(", nombreCiclista='").append(nombreCiclista).append('\'');
        sb.append(", tiempoAcumulado=").append(tiempoAcumulado);
        sb.append(", velocidadMaxima=").append(velocidadMaxima);
        sb.append('}');
        return sb.toString();
    }
    //Métodos-----------

    @Override
    public String imprimirTipo() {
        return "Contrarrelojista";
    }
}
