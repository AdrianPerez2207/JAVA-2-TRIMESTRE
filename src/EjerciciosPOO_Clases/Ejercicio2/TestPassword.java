package EjerciciosPOO_Clases.Ejercicio2;

public class TestPassword {

    public static void main(String[] args) {
        /**
         * Creamos el objeto de la clase con el constructor por defecto.
         * Pintamos la contraseña generada y si cumple la condición, pintamos si es fuerte o no.
         */
        Password p1 = new Password();
        System.out.println(p1);
        if (p1.esFuerte()) {
            System.out.println("LA CONTRASEÑA ES FUERTE");
        } else {
            System.out.println("LA CONTRASEÑA NO ES FUERTE");
        }
        /**
         * Creamos otro objeto y le pasamos la longitud que queremos.
         * Al igual que el otro objeto, si cumple con nuestras condiciones nos pintará si es fuerte o no.
         */
        Password p2 = new Password(6);
        System.out.println(p2);
        if (p2.esFuerte()) {
            System.out.println("LA CONTRASEÑA ES FUERTE");
        } else {
            System.out.println("LA CONTRASEÑA NO ES FUERTE");
        }
    }
}
