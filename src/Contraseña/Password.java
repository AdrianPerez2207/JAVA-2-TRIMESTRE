package Contraseña;

public class Password {
    int longitud;
    String texto;
    //Constructor

    public Password() {

    }

    public Password(String texto) {
        this.texto = texto;
        this.longitud = texto.length();
    }
    //Método
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Contraseña.Password{");
        sb.append("longitud=").append(longitud);
        sb.append(", texto='").append(texto).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
