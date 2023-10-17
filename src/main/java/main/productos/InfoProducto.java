package main.productos;

public enum InfoProducto {
    COCACOLA(1, 800),
    SPRITE(2, 800),
    FANTA(3, 800),
    SNICKERS(4,1200),
    SUPER8(5,600);

    private final int precio;
    private final int numMaquina;
    private InfoProducto(int numMaquina, int precio) {
        this.numMaquina = numMaquina;
        this.precio = precio;

    }
    public int getPrecio() {
        return precio;
    }

    public int getNum() {
        return numMaquina;
    }
}
