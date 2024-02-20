package AlquilerDePeliculas.Test;

import AlquilerDePeliculas.Servicios.PrimeVideo;
import AlquilerDePeliculas.Entidades.*;

public class TestSeries {

    public static void main(String[] args) {
        //Llamamos al constructor de PrimeVideo
        PrimeVideo primeVideo = new PrimeVideo();

        /**
         * Creamos una serie de 10 temporadas y 10 episodios por temporada.
         * Añadimos 10 series al catálogo Multimedia
         * Con el primer for creamos las series, con el segundo las temporadas, y con el tercero, los episodios
         */
        for (int i = 0; i < 10; i++) {
            Serie serie = new Serie("Better Call Saul" + i, true, 5);
            for (int j = 0; j < 10; j++) {
                Temporada t = new Temporada(j);
                for (int k = 0; k < 10; k++) {
                    t.addEpisodio(new Episodio("Episodio " + k, 55));
                }
                serie.addTemporada(t);

            }
            primeVideo.addMultimedia(serie);
            System.out.println(serie);
        }

        /**
         * Creamos 1000 clientes (25% son Pro)
         */
        for (int i = 0; i < 1000; i++) {
            if (i < 250){
                Cliente clientePlus = new ClientePrimePro("982387624H" + (i + 1), "ClientePro" + (i + 1), "jaroso@gmail.com");
                primeVideo.addSuscriptor(clientePlus);
            } else {
                Cliente cliente = new ClientePrime("542387624U" + (i + 1), "Cliente" + (i + 1), "casa@gmail.com");
                primeVideo.addSuscriptor(cliente);
            }
        }
        /**
         * Pasamos por todos los clientes, y simulamos que ven 5 series cada uno
         * Calculamos las ganancias llamando al método getGanancias().
         */
        for (Cliente cliente : primeVideo.getSuscriptores()) {
            for (int i = 0; i < 5; i++) {
                primeVideo.ver(primeVideo.getCatalogo().get(i), cliente);
            }
        }
        System.out.println("Ganancias: ");
        System.out.println(primeVideo.getGanancias() + "€");
    }
}
