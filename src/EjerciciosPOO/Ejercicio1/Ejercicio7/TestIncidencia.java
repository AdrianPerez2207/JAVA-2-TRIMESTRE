package EjerciciosPOO.Ejercicio1.Ejercicio7;

public class TestIncidencia {
    public static void main(String[] args) {
        Incidencia i1 = new Incidencia(112, Incidencia.Estado.ABIERTA, "Problema 1", null);
        Incidencia i2 = new Incidencia(234, Incidencia.Estado.ABIERTA, "Problema 2", null);
        Incidencia i3 = new Incidencia(322, Incidencia.Estado.ABIERTA, "Problema 3", null);
        Incidencia i4 = new Incidencia(466, Incidencia.Estado.ABIERTA, "Problema 4", null);
        Incidencia i5 = new Incidencia(555, Incidencia.Estado.ABIERTA, "Problema 5", null);

        System.out.println("El número de incidencias pendientes es: " + Incidencia.getPendientes());

        i1.resuelve("solucion 1");
        i2.resuelve("solucion 2");

        System.out.println(i1);
        System.out.println("El número de incidencias pendientes actual es: " + Incidencia.getPendientes());

    }
}
