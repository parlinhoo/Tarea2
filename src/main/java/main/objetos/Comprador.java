package main.objetos;

import main.NoHayProductoException;
import main.PagoIncorrectoException;
import main.PagoInsuficienteException;
import main.productos.Producto;
import main.monedas.Moneda;

public class Comprador {
    private String producto;
    private int vuelto = 0;
    public int cuantoVuelto() {return vuelto;}
    public String queConsumiste() {return producto;}
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
