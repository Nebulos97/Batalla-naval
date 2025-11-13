import java.util.Scanner;

public class Juego {

    private Tablero tableroJugador = new Tablero();
    private JugadorCPU cpu = new JugadorCPU();
    private Scanner sc = new Scanner(System.in);

    public void iniciar() {
        System.out.println("=== BATALLA NAVAL ===");
        System.out.println("Portaaviones (5), Acorazado (4), Submarino (3), Destructor (2), Lancha (1)");

        while (!cpu.todosHundidos()) {
            tableroJugador.mostrar();
            int[] coords = leerCoordenada();

            int fila = coords[0];
            int col = coords[1];

            char celda = tableroJugador.getPos(fila, col);
            if (celda == 'X' || celda == 'O') {
                System.out.println("Ya atacaste aquí.");
                continue;
            }

            boolean impacto = cpu.recibirAtaque(fila, col);

            if (impacto) {
                System.out.println("🔥 ¡Impacto!");
                tableroJugador.marcarImpacto(fila, col);
            } else {
                System.out.println("💧 Agua.");
                tableroJugador.marcarFallo(fila, col);
            }
        }

        tableroJugador.mostrar();
        System.out.println("\n🎉 ¡Ganaste! Hundiste todos los barcos.");
    }

    private int[] leerCoordenada() {
        while (true) {
            System.out.print("\nIngresa posición (ej: D4): ");
            String entrada = sc.nextLine().toUpperCase();

            if (entrada.length() < 2) {
                System.out.println("Formato inválido.");
                continue;
            }

            int col = entrada.charAt(0) - 'A';
            int fila = entrada.charAt(1) - '1';

            if (fila < 0 || fila >= 8 || col < 0 || col >= 8) {
                System.out.println("Coordenada fuera del tablero.");
                continue;
            }

            return new int[]{fila, col};
        }
    }
}

