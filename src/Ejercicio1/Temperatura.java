package Ejercicio1;

public class Temperatura {

    public  static double celsiusToFarenheit(double celsius){
        return (1.8 * celsius + 32);
    }

    public static double FareheitToCelsius(double farenheit){
        return (farenheit - 32) / 1.8;
    }
}
