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
    public void buscarLetras(String letra){ /*Método para buscar una letra en la palabraAdivinar*/
        boolean encontrado = false;
        for (int i = 0; i < this.palabraAdivinar.length(); i++) {
            if (letra.equals(this.palabraAdivinar.charAt(i))) { /*Comrpobamos que la letra esté o no usada*/
                encontrado = true;
            }
            letras[i] = letra; /*En caso de acertar o no, se añade la letra al Array*/
        }
    }
    public boolean probarLetras(String letra){
        for (int i = 0; i < palabraAdivinar.length(); i++) {
            /*Recorremos la palabraAdivinar carácter a carácter, si aparece la
              letra parámetro del método en palabraIntentada cambiamos “-“ por la letra en cada aparición de la
              misma y devolvemos true.*/
            if (this.palabraAdivinar.charAt(i) == letra.charAt(0)) {
                this.palabraIntentada.setCharAt(i, this.palabraAdivinar.charAt(i));
                letras[i] = letra;
            } else if (this.palabraAdivinar.charAt(i) != letra.charAt(0)){ /*Si no aparece la letra incrementamos el número de
                                                                            fallos y devolvemos false*/
                numFallos++;
                return false;
            }
        }
        return true;
    }
    public boolean probarPalabra(String palabra){ /*Método para verificar si la palabraIntentada es la palabraAdivinar*/
        for (int i = 0; i < palabraIntentada.length(); i++) {
            if (palabra.charAt(i) == palabraIntentada.charAt(i)) { /*Cromprobamos que palabra y palabraIntentada son iguales "Has ganado" */
                return true;
            } else { /*Si son diferentes, "Has perdido"*/
                return false;
            }
        }
        return true;
    }
}
