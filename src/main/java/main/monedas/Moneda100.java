package main.monedas;
/**
 * Moneda con valor 100, sirve como metodo de pago
 * Clase heredera de Moneda
 * @author Bastián Ceballos Z.
 * @author Fabián González U.
 * @see Moneda
 */
public class Moneda100 extends Moneda {
    /**
     * Getter del valor de la moneda
     * @return 100
     */
    @Override
    public int getValor() {return 100;}

    /** Constructor por defecto */
    public Moneda100() {super();}
}
