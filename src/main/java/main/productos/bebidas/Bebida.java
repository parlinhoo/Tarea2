package main.productos.bebidas;

import main.productos.Producto;

public abstract class Bebida extends Producto {
    private int serie;
    public abstract String beber();
    public int getSerie() {return this.serie;}
    public Bebida(int serie) {this.serie = serie;}
}
