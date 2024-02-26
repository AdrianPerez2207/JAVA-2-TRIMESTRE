package BLACKJACK.Entidades;

public class Carta {

    private String valorCarta;
    private String paloCarta;

    //Constructor-----

    public Carta(String valorCarta, String paloCarta) {
        this.valorCarta = valorCarta;
        this.paloCarta = paloCarta;
    }
    //Contructor copia
    public Carta(Carta carta){
        this.valorCarta = carta.getValorCarta();
        this.paloCarta = carta.getPaloCarta();
    }
    //Getters and setters

    public String getValorCarta() {
        return valorCarta;
    }

    public void setValorCarta(String valorCarta) {
        this.valorCarta = valorCarta;
    }

    public String getPaloCarta() {
        return paloCarta;
    }

    public void setPaloCarta(String paloCarta) {
        this.paloCarta = paloCarta;
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
                "numeroCarta=" + valorCarta +
                ", paloCarta='" + paloCarta + '\'' +
                '}';
    }
}
