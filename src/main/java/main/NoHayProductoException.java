package main;
/**
 * Excepción personalizada para cuando no hay un producto disponible.
 * @author Bastián Ceballos Z.
 * @author Fabián González U.
 */
public class NoHayProductoException extends Exception{
    /**
     * Constructor que recibe un String
     * @param errorMessage Mensaje que describe el la razón del error
     */
    public NoHayProductoException(String errorMessage) {
        super(errorMessage);
    }
}
