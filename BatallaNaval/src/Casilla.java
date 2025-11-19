public class Casilla {
    private EstadoCasilla estado;
    private Barco barco;

    public Casilla() {
        this.estado = EstadoCasilla.AGUA;
    }

    public EstadoCasilla getEstado() { return estado; }
    public Barco getBarco() { return barco; }

    public void colocarBarco(Barco barco) throws CasillaOcupada {
        if (this.barco != null) {
            throw new CasillaOcupada("La casilla ya está ocupada.");
        }
        this.barco = barco;
        this.estado = EstadoCasilla.BARCO;
    }
    public void recibirAtaque() {
        if (barco == null) {
            estado = EstadoCasilla.FALLO;
        } else {
            barco.recibirGolpe();
            estado = EstadoCasilla.GOLPEADO;
            if (barco.estaHundido()) {
                estado = EstadoCasilla.HUNDIDO;
            }
        }
    }
}
