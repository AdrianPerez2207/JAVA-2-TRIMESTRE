package PruebaClase_10_1;

public class Jugador {

    private String nombre;
    private String nick;
    private String email;
    private int edad;
    private int ranking;
    private String juegoFavorito;

    //Constructor

    public Jugador() {
        this.nombre = "Sin nombre";
        this.nick = "Sin nick";
        this.email = "Sin email";
        this.edad = 0;
        this.ranking = 0;
        this.juegoFavorito = "No tiene";
    }

    public Jugador(String nombre, String nick, String email, int edad, int ranking, String juegoFavorito) {
        this.nombre = nombre;
        this.nick = nick;
        this.email = email;
        this.edad = edad;
        this.ranking = ranking;
        this.juegoFavorito = juegoFavorito;
    }

    //Getter and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getJuegoFavorito() {
        return juegoFavorito;
    }

    public void setJuegoFavorito(String juegoFavorito) {
        this.juegoFavorito = juegoFavorito;
    }

}
