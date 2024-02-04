package EjerciciosPOO_Clases.Ejercicio2;

public class Password {

    private String contrasenia;
    private int longitud;

    //Constructores-------------------

    /**
     * Constructor por defecto.
     */
    public Password() {
        this.longitud = 8;
        generarContrasenia();
    }
    /**
     * Constructor con la longitud cómo parámetro.
     */
    public Password(int longitud) {
        this.longitud = longitud;
        generarContrasenia();
    }
    /**
     * Constructor copia.
     */
    public Password(Password password) {
        this.contrasenia = password.contrasenia;
        this.longitud = password.longitud;
    }
    //Getters and Setters-------------------

    /**
     * Solo set de la longitud.
     * @param longitud
     */
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Password{");
        sb.append("contrasenia='").append(contrasenia).append('\'');
        sb.append(", longitud=").append(longitud);
        sb.append('}');
        return sb.toString();
    }
    //Métodos-------------------

    /**
     * Método para generar números aleatorios..
     * @param minimo
     * @param maximo
     * @return Un número aleatorio entre minimo y maximo.
     */
    public int generarNumero(int minimo, int maximo){
        return (int) ((Math.random() * (maximo - minimo + 1) + minimo));
    }

    /**
     * Generamos una contraseña aleatoria. Recorremos la longitud y generamos números de manera aleatoria.
     * Los añadimos al StringBuffer y lo pasamos a carácter.
     * Después pasamos la cadena a String.
     */
    public void generarContrasenia() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.longitud; i++) {
            int letra = generarNumero(33, 122);
                sb.append((char) letra);
        }
        this.contrasenia = sb.toString();
    }

    /**
     * Comprobamos si la contraseña es fuerte, generamos contadores para contar caracteres, mayusculas, etc..
     * Recorremos la contraseña y sumamos a los contadores lo que digan las condiciones.
     * @return Devuelve true si la contraseña cumple con los requisitos, false en caso contrario.
     */
    public boolean esFuerte() {
        int caracteres = 0;
        int cMayuscula = 0;
        int cMinuscula = 0;
        int numero = 0;
        int simbolo = 0;

        for (int i = 0; i < this.contrasenia.length(); i++) {
            caracteres++;
            if (this.contrasenia.charAt(i) >= 65 && this.contrasenia.charAt(i) <= 90) {
                cMayuscula++;
            }
            if (this.contrasenia.charAt(i) >= 97 && this.contrasenia.charAt(i) <= 122) {
                cMinuscula++;
            }
            if (this.contrasenia.charAt(i) >= 48 && this.contrasenia.charAt(i) <= 57) {
                numero++;
            }
            if (this.contrasenia.charAt(i) >= 33 && this.contrasenia.charAt(i) <= 47) {
                simbolo++;
            }
        }
        System.out.println("Caracteres: " + caracteres);
        System.out.println("Mayusculas: " + cMayuscula);
        System.out.println("Minusculas: " + cMinuscula);
        System.out.println("Numeros: " + numero);
        System.out.println("Simbolos: " + simbolo);

        if (caracteres >= 8 && cMayuscula >= 1 && cMinuscula >= 2 && numero >= 2 && simbolo >= 1) {
            return true;
        } else {
            return false;
        }
    }
}
