package main.monedas;

/**
 * Monedas polimorficas que sirven como metodo de pago
 * @author Bastián Ceballos Z.
 * @author Fabián González U.
 */

public abstract class Moneda implements Comparable<Moneda> {
    /**
     * Getter de la serie de la moneda
     * @return Dirección en memoria de la moneda
     */
    public Moneda getSerie() {return this;}

    /**
     * Getter del valor de la moneda
     * @return Entero equivalente al valor de la moneda
     */
    public abstract int getValor();

    /**
     * Compara 2 monedas segun su valor
     * @param o moneda con la que comparar
     * @return 0  si son iguales, -1 si "o" es mayor y 1 si "o" es menor
     */
    @Override
    public int compareTo(Moneda o) {
        int ret = 0;
        if (this.getValor() < o.getValor()) {
            ret = -1;
        } else if (this.getValor() > o.getValor()) {
            ret = 1;
        }
        return ret;
    }

    /**
     * Devuelve un String que representa la clase Moneda
     * @return Un String con la serie y el valor de la moneda
     */
    @Override
    public String toString() {
        return String.format("$%d (Serie %s)", this.getValor(), Integer.toHexString(this.hashCode()));
    }

    /** Constructor por defecto */
    public Moneda() {}
}
