package EjerciciosPOO.Ejercicio1.Ejercicio4;

public class Finanzas {
    private static double EuroDolar;

    public static double getEuroDolar() {
        return Finanzas.EuroDolar;
    }

    public static void setEuroDolar(double euroDolar) {
        Finanzas.EuroDolar = euroDolar;
    }
    public static double dolaresToEuros(double dolares) {
        return dolares / Finanzas.EuroDolar;
    }
    public static double eurosToDolares(double euros) {
        return euros * Finanzas.EuroDolar;
    }
}
