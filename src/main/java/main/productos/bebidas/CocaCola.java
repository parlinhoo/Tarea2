package main.productos.bebidas;
/**
 * Clase heredera de Bebida, representa una bebida Cocacola
 * @author Bastián Ceballos Z.
 * @author Fabián González U.
 * @see Bebida
 */
public class CocaCola extends Bebida {
    /**
     * Implementación de consumir()
     * @return El String "cocacola"
     */
    @Override
    public String consumir() {return "cocacola";}
    /**
     * Constructor por defecto en el que se pasa como parametro la serie del producto
     * @param serie Serie del producto
     */
    public CocaCola(int serie) {super(serie);}
}
