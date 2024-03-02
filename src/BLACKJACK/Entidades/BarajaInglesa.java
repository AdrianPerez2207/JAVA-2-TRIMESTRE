package BLACKJACK.Entidades;
public class BarajaInglesa extends Baraja{

    private static int[] valorCarta = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 1};
    private static String[] paloCarta = {"Corazones", "Diamantes", "Tréboles", "Picas"};

    //Constructor-----
    public BarajaInglesa() {
        super();
        //Recorremos palo carta y valor carta para crear la carta y añadirla a la baraja.
        for (int i = 0; i < paloCarta.length; i++) {
            for (int j = 0; j < valorCarta.length; j++) {
                baraja.add(new Carta(valorCarta[j], paloCarta[i]));
            }
        }
    }

    public static int[] getValorCarta() {
        return valorCarta;
    }

    public static void setValorCarta(int[] valorCarta) {
        BarajaInglesa.valorCarta = valorCarta;
    }

    public static String[] getPaloCarta() {
        return paloCarta;
    }

    public static void setPaloCarta(String[] paloCarta) {
        BarajaInglesa.paloCarta = paloCarta;
    }


    //Métodos------

    /**
     * @return la primera carta de la baraja.
     */
    @Override
    public Carta repartirCarta() {
        Carta carta = baraja.getFirst();
        baraja.removeFirst();
        return carta;
    }

    /**
     * Generamos una carta, y le damos el valor de una de las cartas de la baraja generada aleatoriamente.
     * @return la carta generada al azar.
     */

    @Override
    public Carta azar() {
        Carta carta = baraja.get(generarNumero(0, baraja.size() - 1 ));
        return carta;
    }

    /**
     * Método para generar números aleatoriamente.
     * @param minimo
     * @param maximo
     * @return el número generado.
     */
    public int generarNumero(int minimo, int maximo){
        return (int) ((Math.random() * (maximo - minimo + 1) + minimo));
    }

    /**
     * Cambiamos el formato del valor de la carta a la baraja inglesa.
     * Lo hacemos estático para que no dependa de este objeto.
     * @param numero de carta
     * @return el valor de la carta pintado de forma de la baraja inglesa
     */
    public static String pintarNumero(Integer numero){
        switch (numero) {
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            case 1:
                return "A";
            default:
                return numero.toString();
        }
    }
}
