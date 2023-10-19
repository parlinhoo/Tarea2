package main.monedas;
/**
 * Moneda con valor 500, sirve como metodo de pago
 * Clase heredera de Moneda
 * @author Bastián Ceballos Z.
 * @author Fabián González U.
 * @see Moneda
 */
public class Moneda500 extends Moneda {
    /**
     * Getter del valor de la moneda
     * @return 500
     */
    @Override
    public int getValor() {return 500;}
    /** Constructor por defecto */
    public Moneda500() {super();}
}
