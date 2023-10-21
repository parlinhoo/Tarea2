package maintest;

import main.objetos.Deposito;
import main.productos.bebidas.Bebida;
import main.productos.bebidas.Fanta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DepositoTest {

    @Test
    @DisplayName("Test Vacio")
    public void PruebaVacio() {
        System.out.println("Intentar sacar una bebida de un deposito vacio");
        Deposito<Bebida> deposito = new Deposito<>();
        assertNull(deposito.get());
        System.out.println("Resultado esperado: null");
        System.out.println("Resultado recibido: " + deposito.get());
    }

    @Test
    @DisplayName("Test de Agregado y vaciado")
    public void PruebaRellenoVaciado() {
        System.out.println("Agregar 2 bebidas e intentar sacar 3");
        Deposito<Bebida> deposito = new Deposito<>();
        Fanta fanta1 = new Fanta(1);
        Fanta fanta2 = new Fanta(2);
        deposito.add(fanta1);
        deposito.add(fanta2);

        assertEquals(fanta1, deposito.get());
        assertEquals(fanta2, deposito.get());
        assertNull(deposito.get());
        System.out.println("Resultado esperado: null");
        System.out.println("Resultado recibido: " + deposito.get());
    }


}
