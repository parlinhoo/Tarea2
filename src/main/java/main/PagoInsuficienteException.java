package main;
/**
 * Excepción personalizada para cuando el pago es insuficiente
 * @author Bastián Ceballos Z.
 * @author Fabián González U.
 */
public class PagoInsuficienteException extends Exception{
    /**
     * Constructor que recibe un String
     * @param errorMessage Mensaje que describe el la razón del error
     */
    public PagoInsuficienteException(String errorMessage) {
        super(errorMessage);
    }
}
