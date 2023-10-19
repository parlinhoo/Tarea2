package main.productos.bebidas;
/**
 * Clase heredera de Bebida, representa una bebida Sprite
 * @author Bastián Ceballos Z.
 * @author Fabián González U.
 * @see Bebida
 */
public class Sprite extends Bebida {
    /**
     * Implementación de consumir()
     * @return El String "sprite"
     */
    @Override
    public String consumir() {return "sprite";}
    /**
     * Constructor por defecto en el que se pasa como parametro la serie del producto
     * @param serie Serie del producto
     */
    public Sprite(int serie) {super(serie);}
}
