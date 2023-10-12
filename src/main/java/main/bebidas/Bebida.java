package main.bebidas;

public abstract class Bebida {
    private int serie;
    public abstract String beber();
    public int getSerie() {return this.serie;}
    public Bebida(int serie) {this.serie = serie;}
}
