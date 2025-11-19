public class Barco {
    private int tipoBarco;
    private int golpe;
    private Posicion posicion;

    public Barco(int tipoBarco, Posicion posicion) {
        this.tipoBarco = tipoBarco;
        this.golpe = 0;
        this.posicion = posicion;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public void recibirGolpe() {
        golpe++;
    }

    public boolean estaHundido() {
        return golpe >= tipoBarco;
    }

    public int getTipoBarco() {
        return tipoBarco;
    }

    public void setTipoBarco(int tipoBarco) {
        this.tipoBarco = tipoBarco;
    }


}
