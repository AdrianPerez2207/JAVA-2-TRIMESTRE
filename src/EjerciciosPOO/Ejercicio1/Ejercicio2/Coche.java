package EjerciciosPOO.Ejercicio1.Ejercicio2;

public class Coche {
    private int velocidad; //Atributo
    Coche() {velocidad = 0;} //Constructor

    public int getVelocidad() {
        return velocidad;
    }
    public void acelera(int mas){
        velocidad += mas;
    }
    public void frena(int menos){
        velocidad -= menos;
    }
}
