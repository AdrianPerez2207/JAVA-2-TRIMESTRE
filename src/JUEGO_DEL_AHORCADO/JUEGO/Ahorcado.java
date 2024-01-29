package JUEGO_DEL_AHORCADO.JUEGO;

public class Ahorcado {
    private static String[] Palabras = {"TECLADO", "RATON", "ORDENADOR", "TELEFONO", "MONITOR", "ALFOMBRILLA", "PROGRAMACION", "MOCHILA",
            "AGUA", "MANOS", "PALABRA", "GATO", "SILLA", "PROYECTOR"};
    private String palabraAdivinar;
    private StringBuffer palabraIntentada;
    private int numFallos;
    private String letras[];

    //Constructor-----------------------------------
    public Ahorcado() {
        //Buscamos una palabra aleatoria para adivinar y la guardamos en la variable "palabraAdivinar"
        this.palabraAdivinar = Palabras[generarNumero(0, Palabras.length - 1 )];
        //Inicialimos la variable "palabraIntentada" con "-"
        palabraIntentada = new StringBuffer("-".repeat(palabraAdivinar.length()));
        //Inicializamos el número de fallos en 0
        this.numFallos = 0;
        //Inicializamos la variable "letras" con el número de fallos
        this.letras = new String[7];
    }
    //Getters and setters--------------------------------

    public String getPalabraAdivinar() {
        return palabraAdivinar;
    }

    public void setPalabraAdivinar(String palabraAdivinar) {
        this.palabraAdivinar = palabraAdivinar;
    }

    public String getPalabraIntentada() {
        return palabraIntentada.toString();
    }

    public void setPalabraIntentada(StringBuffer palabraIntentada) {
        this.palabraIntentada = palabraIntentada;
    }

    public int getNumFallos() {
        return numFallos;
    }

    public void setNumFallos(int numFallos) {
        this.numFallos = numFallos;
    }

    //Métodos----------------------------------------
    public int generarNumero(int minimo, int maximo){ /*Método para generar números aleatoriamente*/
        return (int) ((Math.random() * (maximo - minimo + 1) + minimo));
    }
    public boolean buscarLetras(String letra){ /*Método para buscar una letra en la palabraAdivinar*/
        boolean encontrado = false;
        for (int i = 0; i < this.letras.length; i++) {
            if (letras[i] == null){
                return false;
            } else if (letras[i].equals(letra)) { /*Comrpobamos que la letra esté o no usada*/
                encontrado = true;
            }
        }
        return encontrado;
    }
    public void incrementarLetras(String letra){ /*Recorremos el Array y añadimos las letras ya usadas*/
        int posicion = 0;
        for (int i = 0; i < this.letras.length; i++) {
            if (letras[i] == null){
                posicion = i;
                break;
            }
        }
        //Metemos la letra en el Array
        this.letras[posicion] = letra;
    }
    public boolean probarLetras(String letra){
        int intentos = 0; /*Inicializamos los intentos y el índice en 0*/
        int index = 0;
       /*Llamamos al método para buscar letras y probar que no estén repetidas*/
        if (buscarLetras(letra)) {
            System.out.println("Ya has usado la letra: " + letra);
            return false;
        }
        while (true) {
            index = palabraAdivinar.indexOf(letra, index);
            if (intentos == 0 && index < 0) {
                this.numFallos++;
                break;
            } else if (index < 0){
                return true;
            } else {
                /*Cambiuamos el caracter en el índice dónde se encuentre*/
                palabraIntentada.setCharAt(index, letra.charAt(0));
            }
            intentos++; /*Incrementamos el número de intentos y del índice para no generar un bucle infinito*/
            index++;
        }
        incrementarLetras(letra); /*Llamamos al método para añadir al Array la letra ya usada*/
        return false;
    }
    public boolean probarPalabra(String palabra){ /*Método para verificar si la palabraIntentada es la palabraAdivinar*/

        return palabra.equals(palabraAdivinar);
    }
}
