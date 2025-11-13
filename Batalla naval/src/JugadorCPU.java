import java.util.ArrayList;
import java.util.Random;

public class JugadorCPU {

    private ArrayList<Barco> barcos = new ArrayList<>();
    Random r = new Random();

    public JugadorCPU() {
        colocarBarcos();
    }

    private void colocarBarcos() {
        colocarBarco(5); // Portaaviones
        colocarBarco(4); // Acorazado
        colocarBarco(3); // Submarino
        colocarBarco(2); // Destructor
        colocarBarco(1); // Lancha
    }

    private void colocarBarco(int tamaño) {
        while (true) {
            boolean horizontal = r.nextBoolean();
            int fila = r.nextInt(8);
            int col = r.nextInt(8);

            // validar límites
            if (horizontal && col + tamaño > 8) continue;
            if (!horizontal && fila + tamaño > 8) continue;

            Barco nuevo = new Barco(fila, col, tamaño, horizontal);

            if (seSuperpone(nuevo)) continue;

            barcos.add(nuevo);
            break;
        }
    }

    private boolean seSuperpone(Barco b) {
        for (Barco otro : barcos) {
            for (int[] pos1 : b.getPosiciones()) {
                for (int[] pos2 : otro.getPosiciones()) {
                    if (pos1[0] == pos2[0] && pos1[1] == pos2[1])
                        return true;
                }
            }
        }
        return false;
    }

    public boolean recibirAtaque(int fila, int col) {
        for (Barco b : barcos) {
            if (b.contiene(fila, col)) {
                b.registrarGolpe(fila, col);
                return true;
            }
        }
        return false;
    }

    public boolean todosHundidos() {
        return barcos.stream().allMatch(Barco::hundido);
    }
}
