public class Barco {
    private int fila;
    private int col;
    private int tamaño;
    private boolean horizontal;
    private boolean[] golpes;

    public Barco(int fila, int col, int tamaño, boolean horizontal) {
        this.fila = fila;
        this.col = col;
        this.tamaño = tamaño;
        this.horizontal = horizontal;
        this.golpes = new boolean[tamaño];
    }

    public int getTamaño() {
        return tamaño;
    }

    public boolean contiene(int f, int c) {
        for (int i = 0; i < tamaño; i++) {
            int ff = horizontal ? fila : fila + i;
            int cc = horizontal ? col + i : col;
            if (ff == f && cc == c) return true;
        }
        return false;
    }

    public void registrarGolpe(int f, int c) {
        for (int i = 0; i < tamaño; i++) {
            int ff = horizontal ? fila : fila + i;
            int cc = horizontal ? col + i : col;
            if (ff == f && cc == c) {
                golpes[i] = true;
            }
        }
    }

    public boolean hundido() {
        for (boolean golpe : golpes) {
            if (!golpe) return false;
        }
        return true;
    }

    public int[][] getPosiciones() {
        int[][] pos = new int[tamaño][2];
        for (int i = 0; i < tamaño; i++) {
            pos[i][0] = horizontal ? fila : fila + i;
            pos[i][1] = horizontal ? col + i : col;
        }
        return pos;
    }
}

