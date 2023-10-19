package main.monedas;
/**
 * Moneda con valor 1500, sirve como metodo de pago
 * Clase heredera de Moneda
 * @author Bastián Ceballos Z.
 * @author Fabián González U.
 * @see Moneda
 */
public class Moneda1500 extends Moneda {
    /**
     * Getter del valor de la moneda
     * @return 1500
     */
    @Override
    public int getValor() {return 1500;}
    /** Constructor por defecto */
    public Moneda1500() {super();}
}
