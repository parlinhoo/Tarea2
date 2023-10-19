package main.objetos;

import main.NoHayProductoException;
import main.PagoIncorrectoException;
import main.PagoInsuficienteException;
import main.productos.Producto;
import main.productos.bebidas.*;
import main.monedas.*;

/**
 * Comprador usuario de un Expendedor
 * @author Bastiän Ceballos Z.
 * @author Fabián González U.
 */
public class Comprador {
    /** String para almacenar que compró en el expendedor*/
    private String producto;
    /** Entero para almacenar el vuelto que se recibe al comprar en el expendedor */
    private int vuelto = 0;

    /**
     * Getter del valor del vuelto
     * @return Entero equivalente al valor del uuelto
     */
    public int cuantoVuelto() {return vuelto;}

    /**
     * Getter del String producto
     * @return String propio de lo consumido
     */
    public String queConsumiste() {return producto;}

    /**
     * Constructor en el que se intenta comprar en un expendedor con una moneda, si la compra es exitosa, se consume lo comprado, y se recibe el vuelto, guardando ambas varibales
     * @param m Moneda con la que comprar
     * @param cualProducto Producto a comprar
     * @param exp Expendedor en el que comprar
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     * @throws NoHayProductoException
     * @see Moneda
     * @see Expendedor
     */
    public Comprador(Moneda m, int cualProducto, Expendedor exp) throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException {
        Producto producto = exp.comprarProducto(m, cualProducto);
        if (producto != null) {this.producto = producto.consumir();}
        Moneda monedaV = exp.getVuelto();
        while (monedaV != null) {
            this.vuelto += monedaV.getValor();
            monedaV = exp.getVuelto();
        }
    }
}
