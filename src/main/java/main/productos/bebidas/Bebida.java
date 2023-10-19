package main.productos.bebidas;

import main.productos.Producto;

/**
 * Bebida polimorfica
 * @author Bastián Ceballos Z.
 * @author Fabián González U.
 */
public abstract class Bebida extends Producto {
    /**
     * Constructor por defecto en el que se pasa como parametro la serie del producto
     * @param serie Serie del producto
     */
    public Bebida(int serie) {super(serie);}
}
