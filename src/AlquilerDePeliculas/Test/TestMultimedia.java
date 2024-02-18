package AlquilerDePeliculas.Test;

import AlquilerDePeliculas.MULTIMEDIA.*;

public class TestMultimedia {

    public static void main(String[] args) {

        //Llamamos al constructor de PrimeVideo
        PrimeVideo primeVideo = new PrimeVideo();

        /**
         * Creamos y añadimos a Multimedia 200 películas (30 de ellas son PLus a 10€ cada una)
         */
        for (int i = 0; i < 200; i++) {
            if (i < 30){
                primeVideo.addMultimedia(new Pelicula("Pelicula Plus" + (i + 1), true, 10, 120));
            } else {
                primeVideo.addMultimedia(new Pelicula("Pelicula " + (i + 1), false, 4, 120));
            }
        }
        /**
         * Creamos 1.000.000 de clientes (25% son Pro)
         */
        for (int i = 0; i < 1000000; i++) {
            if (i < (1000000 / 4)){
                Cliente clientePlus = new ClientePrimePro("982387624H" + (i + 1), "ClientePro" + (i + 1), "jaroso@gmail.com");
                primeVideo.addSuscriptor(clientePlus);
            } else {
                Cliente cliente = new ClientePrime("542387624U" + (i + 1), "Cliente" + (i + 1), "casa@gmail.com");
                primeVideo.addSuscriptor(cliente);
            }
        }
        /**
         * Simulamos que los Clientes ven las 40 primeras películas
         */

    }
}
