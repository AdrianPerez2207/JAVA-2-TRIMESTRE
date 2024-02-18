package AlquilerDePeliculas.MULTIMEDIA;

public class ClientePrime extends Cliente{

    private static final double precioMensual = 3;

    /**
     * Llamamos al setPrecioMensal del padre, y le pasamos el parametro estatico de esta clase.
     * @param dni
     * @param nombre
     * @param email
     */

    public ClientePrime(String dni, String nombre, String email) {
        super(dni, nombre, email);
        super.setPrecioMensual(precioMensual);
    }

    //Métodos--------------

    @Override
    public boolean esPro() {
        return false;
    }

    @Override
    public double getPrecioMensual() {
        return this.precioMensual;
    }
}