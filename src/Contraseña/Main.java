package Contraseña;

public class Main {
    public static void main(String[] args) {
        Password p1 = new Password();
        Password p2 = new Password("12345678");

        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }
}
