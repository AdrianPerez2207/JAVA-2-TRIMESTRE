package BLACKJACK.Entidades;

import java.util.Objects;

public class Carta {

    private int valorCarta;
    private String paloCarta;

    //Constructor-----

    public Carta(int valorCarta, String paloCarta) {
        this.valorCarta = valorCarta;
        this.paloCarta = paloCarta;
    }
    //Contructor copia
    public Carta(Carta carta){
        this.valorCarta = carta.getValorCarta();
        this.paloCarta = carta.getPaloCarta();
    }
    //Getters and setters

    public int getValorCarta() {
        return valorCarta;
    }

    public void setValorCarta(int valorCarta) {
        this.valorCarta = valorCarta;
    }

    public String getPaloCarta() {
        return paloCarta;
    }

    public void setPaloCarta(String paloCarta) {
        this.paloCarta = paloCarta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carta carta = (Carta) o;
        return valorCarta == carta.valorCarta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valorCarta);
    }
    //Métodos----

    /**
     * Cogemos el nombre de la carta y lo cortamos a 1 sola letra.
     * @return el nombre de la figura de la carta.
     */
    public String getNombreCortoCarta(){
        return this.paloCarta.substring(0,1);
    }
    //toString----

    @Override
    public String toString() {
        return "Carta{" +
                BarajaInglesa.pintarNumero(valorCarta) +
                getNombreCortoCarta() +
                '}';
    }
}
