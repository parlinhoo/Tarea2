package main.productos.dulces;
/**
 * Clase heredera de Dulce, representa un dulce Super8
 * @author Bastián Ceballos Z.
 * @author Fabián González U.
 * @see Dulce
 */
public class Super8 extends Dulce{
    /**
     * Implementación de consumir()
     * @return El String "super8"
     */
    @Override
    public String consumir() {return "super8";}
    /**
     * Constructor por defecto en el que se pasa como parametro la serie del producto
     * @param serie Serie del producto
     */
    public Super8(int serie) {super(serie);}
}
