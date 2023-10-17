package main.productos;

public abstract class Producto {
    private int serie;
    public abstract String comsumir();
    public int getSerie() {return this.serie;}
    public Producto(int serie) {this.serie = serie;}
}
