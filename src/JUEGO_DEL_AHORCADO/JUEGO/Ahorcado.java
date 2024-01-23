package JUEGO_DEL_AHORCADO.JUEGO;

public class Ahorcado {
    private static String[] Palabras = {"TECLADO", "RATON", "ORDENADOR", "TELEFONO", "MONITOR", "ALFOMBRILLA", "PROGRAMACION", "MOCHILA",
            "AGUA", "MANOS", "PALABRA", "GATO", "SILLA", "PROYECTOR"};
    private String palabraAdivinar;
    private String palabraIntentada;
    private int numFallos;
    private String letras[];

    //Constructor-----------------------------------
    public Ahorcado() {
        //Buscamos una palabra aleatoria para adivinar y la guardamos en la variable "palabraAdivinar"
        this.palabraAdivinar = Palabras[generarNumero(Palabras.length - 1, 0)];
        //Inicialimos la variable "palabraIntentada" con "-"
        this.palabraIntentada = new String("-".repeat(palabraAdivinar.length()));
        //Inicializamos el número de fallos en 0
        this.numFallos = 0;
        //Inicializamos la variable "letras" con el número de letras de la palabra adivinar
        this.letras = new String[palabraAdivinar.length()];
    }
    //Getters and setters--------------------------------

    public String getPalabraAdivinar() {
        return palabraAdivinar;
    }

    public void setPalabraAdivinar(String palabraAdivinar) {
        this.palabraAdivinar = palabraAdivinar;
    }

    public String getPalabraIntentada() {
        return palabraIntentada;
    }

    public void setPalabraIntentada(String palabraIntentada) {
        this.palabraIntentada = palabraIntentada;
    }

    public int getNumFallos() {
        return numFallos;
    }

    public void setNumFallos(int numFallos) {
        this.numFallos = numFallos;
    }

    //Métodos----------------------------------------
    public int generarNumero(int maximo, int minimo){ /*Método para generar números aleatoriamente*/
        return (int) ((Math.random() * (maximo - minimo + 1) + minimo));
    }
    public boolean probarLetras(String letra){
        for (int i = 0; i < palabraAdivinar.length(); i++) {
            /*Recorremos la palabraAdivinar carácter a carácter, si aparece la
              letra parámetro del método en palabraIntentada cambiamos “-“ por la letra en cada aparición de la
              misma y devolvemos true.*/
            if (palabraAdivinar.charAt(i) == letra.charAt(i)) {
                palabraIntentada = palabraIntentada.replace(letra, "-");
                letras[i] = letra;
                return true;
            } else { /*Si no aparece la letra incrementamos el número de fallos y devolvemos false*/
                numFallos++;
                return false;
            }
        }
        return true;
    }
    /*Comprueba toda la palabra parámetro del método con
      palabraAdivinar, si son iguales (equals) devuelve true (has ganado), sino devuelve false (has perdido).*/
    public boolean probarPalabra(String palabra){
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == palabraAdivinar.charAt(i)) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}
