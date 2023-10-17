package main.productos.bebidas;

public class Fanta extends Bebida {
    @Override
    public String consumir() {return "fanta";}
    public Fanta(int serie) {super(serie);}
}
