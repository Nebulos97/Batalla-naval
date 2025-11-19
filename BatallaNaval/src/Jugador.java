public class Jugador {
    private String Nombre;
    private Tablero Tablero;

    public Jugador(String nombre) {
        this.Nombre = nombre;
        this.Tablero = new Tablero();
    }

    public Tablero getTablero() {
        return Tablero;
    }
}
