package PracticaClase.Clases;

import PracticaClase.Interfaz.Transportable;

public class Producto implements Transportable {

    protected String nombre;
    protected double peso;
    //Constructor

    public Producto(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }
    //Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    //toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Producto{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", peso=").append(peso);
        sb.append('}');
        return sb.toString();
    }

    /**
     * @param internacional si es internacional, le suma 30€
     * @return devuelve la suma del precio mas el peso del producto * 0,2
     */

    @Override
    public double calcularCostoEnvio(boolean internacional) {
        if (internacional) {
            return (20 + 30) + (this.peso * 0.2);
        } else {
            return 20 + (this.peso * 0.2);
        }
    }
}
