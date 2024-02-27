package BLACKJACK.Entidades;

public class Crupier extends Jugador {

    private String nombre;
    private int limite;

    public Crupier() {
        super();
        this.nombre = "Crupier";
        this.limite = 17;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return this.nombre + "{" +
                "mano=" + mano +
                '}';
    }
}
