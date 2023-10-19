package main;
/**
 * Excepción personalizada para cuando el pago no es el indicado.
 * @author Bastián Ceballos Z.
 * @author Fabián González U.
 */
public class PagoIncorrectoException extends Exception{
    /**
     * Constructor que recibe un String
     * @param errorMessage Mensaje que describe el la razón del error
     */
    public PagoIncorrectoException(String errorMessage){
        super(errorMessage);
    }
}
