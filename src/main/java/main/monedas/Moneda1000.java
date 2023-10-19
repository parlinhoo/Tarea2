package main.monedas;
/**
 * Moneda con valor 1000, sirve como metodo de pago
 * Clase heredera de Moneda
 * @author Bastián Ceballos Z.
 * @author Fabián González U.
 * @see Moneda
 */
public class Moneda1000 extends Moneda {
    /**
     * Getter del valor de la moneda
     * @return 1000
     */
    @Override
    public int getValor() {return 1000;}
    /** Constructor por defecto */
    public Moneda1000() {super();}
}
