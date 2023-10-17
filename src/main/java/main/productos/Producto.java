package main.productos;

public abstract class Producto {
    private int serie;
    public abstract String consumir();
    public int getSerie() {return this.serie;}
    public Producto(int serie) {this.serie = serie;}
}
