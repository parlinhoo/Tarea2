package main.productos.bebidas;
/**
 * Clase heredera de Bebida, representa una bebida Fanta
 * @author Bastián Ceballos Z.
 * @author Fabián González U.
 * @see Bebida
 */
public class Fanta extends Bebida {
    /**
     * Implementación de consumir()
     * @return El String "fanta"
     */
    @Override
    public String consumir() {return "fanta";}
    /**
     * Constructor por defecto en el que se pasa como parametro la serie del producto
     * @param serie Serie del producto
     */
    public Fanta(int serie) {super(serie);}
}
