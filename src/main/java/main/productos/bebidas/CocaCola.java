package main.productos.bebidas;

public class CocaCola extends Bebida {
    @Override
    public String consumir() {return "cocacola";}
    public CocaCola(int serie) {super(serie);}
}
