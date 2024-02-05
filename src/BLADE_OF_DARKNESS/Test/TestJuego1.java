package BLADE_OF_DARKNESS.Test;
import BLADE_OF_DARKNESS.Clases.Monstruo1;
import BLADE_OF_DARKNESS.Clases.Jugador1;
import BLADE_OF_DARKNESS.Clases.Arma1;

public class TestJuego1 {
    /**
     * Generamos método para el combate, pintamos el nombre del jugador y el monstruo contra el que va a combatir
     * Metemos en un bucle en combate para que luchen hasta que la salud de uno de los 2 sea 0 o menor que 0.
     * @param jugador Le pasamos un jugador a desear.
     * @param monstruo Le ponemos el monstruo con el que queremos que luche.
     */
    public static void combate(Jugador1 jugador, Monstruo1 monstruo){
        System.out.println("Nombre del jugador: " + jugador.getNombre());
        System.out.println("Nombre del monstruo: " + monstruo.getNombre());

        while (jugador.getSalud() > 0 && monstruo.getSalud() > 0){
            jugador.golpear(monstruo);
            System.out.println("Salud del Monstruo: " + monstruo.getSalud());
            monstruo.golpear(jugador);
            System.out.println("Salud del Jugador: " + jugador.getSalud());
        }
        if (monstruo.getSalud() > 0){
            System.out.println("Ha ganado el Monstruo: " + monstruo.getNombre());
            //Si el Jugador gana, toma una poción para regenerar vida.
        } else if (jugador.getSalud() > 0){
            jugador.tomarPocion(100);
            System.out.println("Ha ganado el Jugador: " + jugador.getNombre());
            System.out.println("Nueva salud del jugador: " + jugador.getSalud());
            System.out.println("Nueva experiencia del jugador: " + jugador.getExperiencia());
            System.out.println("Nivel del jugador: " + jugador.getNivel());
        }

    }

    public static void main(String[] args) {
        //Creamos el jugador, le equipamos las armas, y creamos los 4 Monstruos.
        Jugador1 j1 = new Jugador1("Derezord", Jugador1.Clase.MAGO);
        Arma1 a1 = new Arma1(Arma1.Tipo.BASTON, "PaloDelDiablo", 50, false);
        Arma1 a2 = new Arma1(Arma1.Tipo.ESPADA, "ESCALIBUR", 50, false);
        j1.equipar(a1);
        j1.equipar(a2);
        Monstruo1 m1 = new Monstruo1("Gabriel", Monstruo1.Clase.GOBLIN, 80);
        Monstruo1 m2 = new Monstruo1("Alejandro", Monstruo1.Clase.TROLL, 80);
        //Modificamos los niveles para que no sean iguales.
        m2.setNivel(2);
        Monstruo1 m3 = new Monstruo1("Adrian", Monstruo1.Clase.SKRALL, 100);
        m3.setNivel(4);
        Monstruo1 m4 = new Monstruo1("Sobrino", Monstruo1.Clase.FANTASMA, 120);
        m3.setNivel(6);
        //Probamos que todos los métodos funcionen a través del combate.
        System.out.println("Combate número 1: ");
        combate(j1, m1);
        System.out.println();
        System.out.println("Combate número 2: ");
        combate(j1, m2);
        System.out.println();
        System.out.println("Combate número 3: ");
        combate(j1, m3);
        System.out.println();
        System.out.println("Combate número 4: ");
        combate(j1, m4);
    }
}
