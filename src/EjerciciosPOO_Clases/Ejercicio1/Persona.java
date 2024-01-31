package EjerciciosPOO_Clases.Ejercicio1;

import java.util.Objects;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private char sexo;
    private double peso;
    private double altura;

    /*Constructor------------*/

    public Persona() { //Constructor por defecto.
        this.nombre = "";
        this.edad = 0;
        this.dni = "";
        this.sexo ='H';
        this.peso = 0;
        this.altura = 0;
    }
    //Constructor con parámetros, el resto por defecto.
    public Persona(String nombre, int edad, String dni, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
        this.peso = 0;
        this.altura = 0;
    }
    //Constructor con todos los miembros cómo parámetro.
    public Persona(String nombre, int edad, String dni, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }
    //Constructor copia.
    public Persona (Persona persona) {
        this.nombre = persona.nombre;
        this.edad = persona.edad;
        this.dni = persona.dni;
        this.sexo = persona.sexo;
        this.peso = persona.peso;
        this.altura = persona.altura;
    }

    //Getters y Setters------------------
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    //toString-----------------

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Persona{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", edad=").append(edad);
        sb.append(", dni='").append(dni).append('\'');
        sb.append(", sexo=").append(sexo);
        sb.append(", peso=").append(peso);
        sb.append(", altura=").append(altura);
        sb.append('}');
        return sb.toString();
    }
    //equals------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad, dni, sexo, peso, altura);
    }


    //Métodos------------------

    /**
     * Generamos una variable y calculamos el resultado de la división entre el peso y la altura al cuadrado.
     * @return Devuelve 1 si la persona está en su peso ideal.
     * @return Devuelve 0 Si la persona está por debajo de su peso ideal.
     * @return Devuelve -1 Si la persona está con sobrepeso.
     */
    public int calcularIMC() {
        double imc = this.peso / (Math.pow(this.altura, 2));
        if (imc < 20){
            return 1;
        } else if (imc >= 20 && imc <= 25){
            return 0;
        } else if (imc > 25){
            return -1;
        }
        return 0;
    }

    /**
     *
     * @return Devuelve true si la persona es mayor de edad y false en caso contrario.
     */
    public boolean esMayordeEdad(){
        if (this.edad >= 18){
            return true;
        } else {
            return false;
        }
    }
}
