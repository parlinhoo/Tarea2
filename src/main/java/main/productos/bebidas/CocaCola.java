package main.productos.bebidas;

public class CocaCola extends Bebida {
    @Override
    public String beber() {return "cocacola";}
    public CocaCola(int serie) {super(serie);}
}
