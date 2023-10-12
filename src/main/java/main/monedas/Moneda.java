package main.monedas;

public abstract class Moneda {
    public Moneda getSerie() {return this;}
    public abstract int getValor();
    public Moneda() {}
}
