package main.productos.dulces;
/**
 * Clase heredera de Dulce, representa un dulce Snickers
 * @author Bastián Ceballos Z.
 * @author Fabián González U.
 * @see Dulce
 */
public class Snickers extends Dulce{
    /**
     * Implementación de consumir()
     * @return El String "snickers"
     */
    @Override
    public String consumir() {return "snickers";}
    /**
     * Constructor por defecto en el que se pasa como parametro la serie del producto
     * @param serie Serie del producto
     */
    public Snickers(int serie) {super(serie);}
}
