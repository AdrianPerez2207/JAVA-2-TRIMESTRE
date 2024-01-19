package EjerciciosPOO.Ejercicio1.Ejercicio5;

public class Satelite {
    private double meridiano;
    private double paralelo;
    private double distancia_tierra;
    Satelite (double m, double p, double d) {
        meridiano = m;
        paralelo = p;
        distancia_tierra = d;
    }
    Satelite () {
        meridiano = paralelo = distancia_tierra = 0;
    }
    public void setPosicion(double m, double p, double d) {
        meridiano = m;
        paralelo = p;
        distancia_tierra = d;
    }
    public void printPosicion() {
        System.out.print("El satélite se encuentra en ");
        System.out.print("el paralelo " + paralelo + " meridiano "+ meridiano);
        System.out.print(" a una distancia de la Tierra de" + distancia_tierra + " kms.");
    }
    public void variaAltura(double desplazamiento){
    distancia_tierra += desplazamiento;
    }
    public boolean enOrbita(){
        if (distancia_tierra <= 0) {
            return false;
        } else {
            return true;
        }
    }
    public void variaPosicion(double variap, double variam){
    meridiano += variap;
    paralelo += variam;
    }

}
