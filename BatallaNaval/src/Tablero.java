public class Tablero {
    private char[][] matriz = new char[8][8];
    private int Tamaño = 8;

    public Tablero() {
        inicializar();
    }

    private void inicializar() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matriz[i][j] = '-';
            }
        }
    }

    public Tablero(int tamaño) {
        this.Tamaño = tamaño;
    }

    public int getTamaño() {
        return Tamaño;
    }
}
