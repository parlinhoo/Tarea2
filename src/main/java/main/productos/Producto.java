package main.productos;
/**
 * Productos polimorficos que pueden ser comprados en un expendedor
 * @author Bastián Ceballos Z.
 * @author Fabián González U.
 */
public abstract class Producto {
    /** Entero que almacena la serie del producto */
    private int serie;
    /**  Metodo abstracto que devuelve un String segun el producto*/
    public abstract String consumir();

    /**
     * Getter de la serie del producto
     * @return Entero que representa la serie del producto
     */
    public int getSerie() {return this.serie;}

    /**
     * Constructor por defecto en el que se pasa como parametro la serie del producto
     * @param serie
     */
    public Producto(int serie) {this.serie = serie;}
}
