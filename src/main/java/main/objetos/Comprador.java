package main.objetos;

import main.bebidas.Bebida;
import main.monedas.Moneda;

public class Comprador {
    private String sonido;
    private int vuelto = 0;
    public int cuantoVuelto() {return vuelto;}
    public String queBebiste() {return sonido;}
    public Comprador(Moneda m, int cualBebida, Expendedor exp) {
        Bebida bebida = exp.comprarBebida(m, cualBebida);
        if (bebida != null) {this.sonido = bebida.beber();}
        Moneda monedaV = exp.getVuelto();
        while (monedaV != null) {
            this.vuelto += monedaV.getValor();
            monedaV = exp.getVuelto();
        }
    }
}
