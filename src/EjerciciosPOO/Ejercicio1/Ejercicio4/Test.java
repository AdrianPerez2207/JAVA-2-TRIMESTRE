package EjerciciosPOO.Ejercicio1.Ejercicio4;

public class Test {
    public static void main(String[] args) {
        Finanzas.setEuroDolar(1.36);
        System.out.println(Finanzas.dolaresToEuros(100));
        Finanzas.setEuroDolar(1.10);
        System.out.println(Finanzas.eurosToDolares(100));
    }
}
