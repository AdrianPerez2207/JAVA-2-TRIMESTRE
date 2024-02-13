package AlquilerDePeliculas.MULTIMEDIA;

public class ClientePrimePro extends Cliente{

    private static final double precioMensual = 5;
    //Constructor--------
    /**
     * Llamamos al setPrecioMensal del padre, y le pasamos el parametro estatico de esta clase.
     * @param dni
     * @param nombre
     * @param email
     */

    public ClientePrimePro(String dni, String nombre, String email) {
        super(dni, nombre, email);
        super.setPrecioMensual(precioMensual);
    }

    //Métodos---------
    @Override
    public boolean esPro() {
        return false;
    }

    @Override
    public double getPrecioMensual() {
        return precioMensual;
    }
}
