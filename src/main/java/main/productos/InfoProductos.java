package main.productos;

public enum InfoProductos {
    COCACOLA(800),
    SPRITE(800),
    FANTA(800),
    SNICKERS(1200),
    SUPER8(600);

    private int precio;
    private InfoProductos(int precio) {
        this.precio = precio;

    }

    public int getPrecio() {
        return precio;
    }
}
