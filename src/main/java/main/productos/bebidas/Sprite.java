package main.productos.bebidas;

public class Sprite extends Bebida {
    @Override
    public String consumir() {return "sprite";}
    public Sprite(int serie) {super(serie);}
}
