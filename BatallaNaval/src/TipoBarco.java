
public enum TipoBarco {
    GALEON_REAL(5, 1 ),       // barco pirata enorme
    BRIGANTIN(4, 2),         // barco veloz y resistente
    CORBETA(3, 3),           // nave ligera de combate
    BALANDRA(2,4);         // pequeña embarcación armada


    private final int tamaño;
    private final int id;

    TipoBarco(int tamaño, int id) {
        this.tamaño = tamaño;
        this.id = id;

    }

    public int getTamaño() {
        return tamaño;
    }

    public int getId() {
        return id;
    }
}
