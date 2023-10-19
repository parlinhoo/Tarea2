package main.productos;

/** Enumeración con los datos de los productos disponibles en un expendedor */
public enum InfoProducto {
    /** Datos de una CocaCola, con numero 1 en el expendedor y precio 800 */
    COCACOLA(1, 800),
    /** Datos de una Sprite, con numero 2 en el expendedor y precio 800 */
    SPRITE(2, 800),
    /** Datos de una Fanta, con numero 3 en el expendedor y precio 800 */
    FANTA(3, 800),
    /** Datos de un Snickers con numero 4 en el expendedor y precio 1200 */
    SNICKERS(4,1200),
    /** Datos de un Snickers con numero 5 en el expendedor y precio 600 */
    SUPER8(5,600);

    /** Entero que representa el precio del producto */
    private final int precio;
    /** Entero que representa el numero del producto en el expendedor*/
    private final int numMaquina;

    /**
     * Constructor por defecto, recibe el numero del producto en el expendedor y su precio
     * @param numMaquina Numero del producto en el expendedor
     * @param precio Precio del producto
     */
    private InfoProducto(int numMaquina, int precio) {
        this.numMaquina = numMaquina;
        this.precio = precio;

    }

    /**
     * Getter del precio del producto
     * @return Entero equivalente al precio del producto
     */
    public int getPrecio() {
        return precio;
    }
    /**
     * Getter del numero del producto en el expendedor
     * @return Entero que representa el numero del producto en el expendedor
     */
    public int getNum() {
        return numMaquina;
    }
}
