package McBurguer.dominio;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Menu {
    public static int numeroMenus;
    private int numeroIngredientes;
    private ArrayList<Ingrediente> listaIngredientes;

    //Constructor--------------
    public Menu() {
        this.numeroMenus = 0;
        this.numeroIngredientes = 0;
        this.listaIngredientes = new ArrayList<Ingrediente>();
    }
    //Getters and setters---------

    public static int getNumeroMenus() {
        return numeroMenus;
    }

    public static void setNumeroMenus(int numeroMenus) {
        Menu.numeroMenus = numeroMenus;
    }

    public int getNumeroIngredientes() {
        return numeroIngredientes;
    }

    public void setNumeroIngredientes(int numeroIngredientes) {
        this.numeroIngredientes = numeroIngredientes;
    }

    public ArrayList<Ingrediente> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(ArrayList<Ingrediente> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

    //toString----------------

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Menu{");
        sb.append("numeroMenus=").append(numeroMenus);
        sb.append(", numeroIngredientes=").append(numeroIngredientes);
        sb.append(", listaIngredientes=").append(listaIngredientes);
        sb.append('}');
        return sb.toString();
    }

    //Métodos--------------

    /**
     * Recorremos la lista de ingredientes y lo pintamos uno a uno.
     */
    public void imprimirMenu() {
        for (int i = 0; i < this.listaIngredientes.size(); i++) {
            System.out.println(this.listaIngredientes.get(i));

        }
    }

    /**
     * añade una comida o una bebida al menú.
     */
    public void addComida(Comida comida){
        this.listaIngredientes.add(comida);
        this.numeroIngredientes++;
    }
    public void addBebida(Bebida bebida){
        this.listaIngredientes.add(bebida);
        this.numeroIngredientes++;
    }

    /**
     * Creamos una variable para sumar el precio de todos los ingredientes.
     * Recorremos el Array de ingredientes y el precio de cada uno de ellos.
     */

    public Double obtenerPrecioMenu(){
        double precioMenu = 0.0;
        for (Ingrediente ingrediente : this.listaIngredientes){
            precioMenu += ingrediente.obtenerPrecio();
        }
        return precioMenu;
    }
}