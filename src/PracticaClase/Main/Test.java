package PracticaClase.Main;
import PracticaClase.Clases.*;
import PracticaClase.Interfaz.*;

import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {
        // Creamos 3 objetos de la case fragil.
        ProductoFragil p1 = new ProductoFragil("Clarinete", 3.4,2);
        ProductoFragil p2 = new ProductoFragil("Movil", 0.4,1);
        ProductoFragil p3 = new ProductoFragil("Ordenador portátil", 5.3,2);
        //Creamos 3 objetos de la clase refrigerada
        ProductoRefrigerado p4 = new ProductoRefrigerado("Solomillo de ternera", 150, 2);
        ProductoRefrigerado p5 = new ProductoRefrigerado("Leche", 100, 1);
        ProductoRefrigerado p6 = new ProductoRefrigerado("Queso", 25, 1);

        //Creamos un envio, le pasamos la fecha de salida y le sumamos 12 días.
        Envio envio1 = new Envio();
        envio1.setFechaLlegada(LocalDate.now().plusDays(12));
        //Agregamos objetos al envio
        envio1.agregarTransportable(p1);
        envio1.agregarTransportable(p5);
        envio1.agregarTransportable(p2);
        //Creamos un segundo envío y le pasamos la fecha de salida más 10 días.
        Envio envio2 = new Envio();
        envio2.setFechaLlegada(LocalDate.now().plusDays(10));
        //Agregamos objetos al segundo envío
        envio2.agregarTransportable(p3);
        envio2.agregarTransportable(p4);
        envio2.agregarTransportable(p6);
        //Creamos un servicio de envíos
        ServicioEnvio servicio = new ServicioEnvio();
        //Agregamos envios al servicio de envios
        servicio.agregarEnvio(envio1);
        servicio.agregarEnvio(envio2);
        //Pintamos el informe de todos los envios.
        servicio.generarInformeEnvios();

    }
}
