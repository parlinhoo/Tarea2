package main.productos.bebidas;

public class Sprite extends Bebida {
    @Override
    public String beber() {return "sprite";}
    public Sprite(int serie) {super(serie);}
}