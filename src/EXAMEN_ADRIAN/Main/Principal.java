package EXAMEN_ADRIAN.Main;
import EXAMEN_ADRIAN.Entidades.*;
import EXAMEN_ADRIAN.Servicios.*;
public class Principal {
    //Crea un main en el que añadas 1000 vuelos (en un for).
    //Además, para uno de esos vuelos añade 5 reservas con diferentes pasajeros.
    //Imprime el vuelo.
    //Imprime las reservas.
    //Muestra las reservas de un dni.
    //Muestra todos los vuelos a un destino que elijas en una determinada fecha.
    public static void main(String[] args) {
        Atrapame atrapame = new Atrapame();
        for (int i = 0; i < 1000; i++) {
            Vuelo vuelo = new Vuelo("a12r" + i, "Panamá", "Almería", 2024-06-23,22:30:00,
                                        150.0, 180);
            atrapame.addVuelo(vuelo);
        }
        ReservaVuelo reserva = new ReservaVuelo(new Vuelo("a12r", "Panamá", "Almería", "2024-06-23","22:30:00",
                150.0, 180), TipoTarifa.CONFORT, TipoAsiento.BUSINESS);

        for (int i = 0; i < 5; i++) {
            //Long id, String nombre, String apellidos, String dniPasaporte, String email, String direccion,
            //String ciudad, String pais, Integer telefono, String preferenciasComida, String restriccionesMedicas, Asiento asiento
            Pasajero pasajero = new Pasajero(21L +i, "Jose" + i, "Perez", "22435678H" + i, "jaroso@gmail.com", " ", "Cuevas",
                    "España", 678543243, "Pecado", "no", null);
        }
    }
}
