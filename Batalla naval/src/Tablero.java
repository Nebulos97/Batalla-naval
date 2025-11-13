public class Tablero {

    private char[][] matriz = new char[8][8];

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

    public void marcarImpacto(int fila, int col) {
        matriz[fila][col] = 'X';
    }

    public void marcarFallo(int fila, int col) {
        matriz[fila][col] = 'O';
    }

    public char getPos(int fila, int col) {
        return matriz[fila][col];
    }

    public void mostrar() {
        System.out.println("\n    A B C D E F G H");
        System.out.println("  -------------------");

        for (int fila = 0; fila < 8; fila++) {
            System.out.print((fila + 1) + " | ");
            for (int col = 0; col < 8; col++) {
                System.out.print(matriz[fila][col] + " ");
            }
            System.out.println("|");
        }
        System.out.println("  -------------------");
    }
}
