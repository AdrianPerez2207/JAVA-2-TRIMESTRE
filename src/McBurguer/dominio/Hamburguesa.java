package McBurguer.dominio;
import java.time.Period;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Hamburguesa extends Comida{

    private LocalDate fechaCaducidad;

    /**
     * En el constructor le damos formato a la fecha con "DateTimeFormatter"
     * @param fechaCaducidad
     * Le damos el nombre y el tipo de ingrediente
     */


    public Hamburguesa(String fechaCaducidad) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.fechaCaducidad = LocalDate.parse(fechaCaducidad, formatter);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        this.nombre = "Hamburguesa";
        this.tipoIngrediente = "Comida";
    }

    //Métodos-------------------

    /**
     *
     * @return Devuelve en cada caso el precio real o el precio con el descuento
     * Calculamos la diferencia entre la fecha de caducidad y la actual
     * En una variable guardamos la suma de años (en dias), meses(en dias) y dias
     */

    @Override
    public Double obtenerPrecio() {
        Period periodo = Period.between(LocalDate.now(), fechaCaducidad);
        int dias = (periodo.getYears() * 365) + (periodo.getMonths() * 12) + periodo.getDays();

        if (dias == 1){
            return 3.50 * 0.50;
        } else if (dias == 2){
            return 3.50 * 0.40;
        } else if (dias == 3){
            return 3.50 * 0.30;
        } else if (dias == 4){
            return 3.50 * 0.20;
        } else {
            return 3.50;
        }
    }

}
